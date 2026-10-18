package service.Impl;

import Exceptions.InvalidRole;
import dto.response.LedgerDto;
import jakarta.servlet.http.HttpSession;
import model.Ledger;
import repository.LedgerRepo;
import service.LedgerInterface;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LedgerService implements LedgerInterface {
   final private LedgerRepo ledgerRepo;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public LedgerService(LedgerRepo ledgerRepo) {
        this.ledgerRepo = ledgerRepo;
    }

    @Override
    public List<LedgerDto> getTransactionStatement(HttpSession session, String fromStr, String toStr){

       Object roleAttr =session.getAttribute("role");
       if(roleAttr ==null || !"Sub".equals(roleAttr.toString())){
           throw new InvalidRole("not auth");
       }
        String msisdn = (String) session.getAttribute("msisdn");
        if (msisdn == null) {
            throw new RuntimeException("Subscriber session required");
        }
        Timestamp from;
        Timestamp to;
        try {
            LocalDate fromDate = LocalDate.parse(fromStr, DATE_FORMAT);
            LocalDate toDate = LocalDate.parse(toStr, DATE_FORMAT);

            from = Timestamp.valueOf(fromDate.atStartOfDay());
            to = Timestamp.valueOf(toDate.atTime(23, 59, 59, 999_000_000));

        } catch (Exception e) {
            throw new RuntimeException("Invalid date format, expected dd/MM/yyyy");
        }

        if (from.after(to)) {
            throw new RuntimeException("'from' date must be before 'to' date");
        }

        List<Ledger> ledgers = ledgerRepo.findTransactionsByMsisdnAndDateRange(msisdn, from, to);
        List<LedgerDto> result =new ArrayList<>();
        for( Ledger led : ledgers){
            result.add( toDto(led));
        }
        return  result ;
    }
    private LedgerDto toDto(Ledger ledger){
        LedgerDto ledgerDto =new LedgerDto();
        ledgerDto.setTxnId(ledger.getTxnId());
        ledgerDto.setTxnTs(ledger.getTxnTs().toLocalDateTime().format(TIMESTAMP_FORMAT));
        ledgerDto.setTxnType(String.valueOf(ledger.getTxnType()));
        ledgerDto.setAmountPiasters(ledger.getAmountPiasters());
        ledgerDto.setBalanceAfter(ledger.getBalanceAfter());
        ledgerDto.setRefNo(ledger.getRefNo());
        ledgerDto.setReason(ledger.getReason());
        return ledgerDto;

    }
}
