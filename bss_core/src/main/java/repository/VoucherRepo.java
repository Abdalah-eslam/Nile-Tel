package repository;

import model.Voucher;

import java.sql.Connection;
import java.sql.SQLException;

public interface VoucherRepo {
    Voucher findByCodeForUpdate(Connection con, String code) ;
    boolean markUsed(Connection con, long voucherId, long subscriberId) ;
}
