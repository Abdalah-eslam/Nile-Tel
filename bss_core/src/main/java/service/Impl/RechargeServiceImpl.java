package service.Impl;

import dto.request.RechargeRequest;
import dto.response.RechargeResponse;
import exception.VoucherAlreadyUsedException;
import exception.VoucherNotFoundException;
import model.Ledger;
import model.Voucher;
import repository.LedgerRepo;
import repository.SubscriberRepo;
import repository.VoucherRepo;
import service.RechargeService;
import utils.DBConnection;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RechargeServiceImpl implements RechargeService {

    private final VoucherRepo voucherRepo;
    private final SubscriberRepo subscriberRepo;
    private final LedgerRepo ledgerRepo;

    public RechargeServiceImpl(VoucherRepo voucherRepo, SubscriberRepo subscriberRepo, LedgerRepo ledgerRepo) {
        this.voucherRepo = voucherRepo;
        this.subscriberRepo = subscriberRepo;
        this.ledgerRepo = ledgerRepo;
    }

    @Override
    public RechargeResponse recharge(String msisdn, RechargeRequest request) {

        String code = request.voucherCode().trim();
        if (!code.matches("\\d{14}")) {
            throw new VoucherNotFoundException("Invalid voucher code format: " + code);
        }

       try(Connection connection = DBConnection.getConnection()){
           connection.setAutoCommit(false);
           try{
               Voucher voucher = voucherRepo.findByCodeForUpdate(connection, code);
               if (voucher == null){
                   throw new VoucherNotFoundException("Voucher not found: " + code);
               }
               if (voucher.isUsed()){
                   throw new VoucherAlreadyUsedException("Voucher already used: " + code);
               }

               Long subscriberId = subscriberRepo.findSubscriberId(connection, msisdn);
               if (subscriberId == null) {
                   throw new IllegalStateException("Subscriber not found: " + msisdn);
               }

               BigInteger amount = voucher.getValuePiasters();
               BigInteger newBalance = subscriberRepo.addBalance(connection, msisdn,amount);
               voucherRepo.markUsed(connection, voucher.getVoucherId(), subscriberId);

               Ledger ledger = new Ledger(subscriberId, 'R', amount, newBalance,
                       "", "VOUCHER RECHARGE", LocalDateTime.now());

               long txnId = ledgerRepo.insert(connection, ledger);
               connection.commit();
               return new RechargeResponse(txnId, amount, newBalance);
           }catch (SQLException | RuntimeException e) {
               connection.rollback();
               throw e;
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }
}
