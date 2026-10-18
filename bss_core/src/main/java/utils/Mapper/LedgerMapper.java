package utils.Mapper;

import model.Ledger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedgerMapper {

    public static Ledger mapResultSetToLedger(ResultSet rs) throws SQLException {
        Ledger ledger = new Ledger();

        ledger.setTxnId(rs.getLong("txn_id"));
        ledger.setMsisdn(rs.getString("msisdn"));
        ledger.setTxnTs(rs.getTimestamp("txn_ts"));
        ledger.setTxnType(rs.getString("txn_type").charAt(0));
        ledger.setAmountPiasters(rs.getLong("amount_piasters"));
        ledger.setBalanceAfter(rs.getLong("balance_after"));
        ledger.setRefNo(rs.getString("ref_no"));
        ledger.setReason(rs.getString("reason"));

        return ledger;
    }
}