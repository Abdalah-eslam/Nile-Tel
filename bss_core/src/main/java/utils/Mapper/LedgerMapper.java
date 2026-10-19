package utils.Mapper;

import model.Ledger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedgerMapper {

    public static Ledger mapResultSetToLedger(ResultSet rs) throws SQLException {
        Ledger ledger = new Ledger();

        ledger.setTxnId(rs.getLong("ledger_id"));
        ledger.setSubscriberId(rs.getLong("subscriber_id"));
        ledger.setTxnTs(rs.getTimestamp("created_at"));
        ledger.setTxnType(rs.getString("entry_type").charAt(0));
        ledger.setAmountPiasters(rs.getLong("amount_piasters"));
        ledger.setBalanceAfter(rs.getLong("balance_after_piasters"));
        ledger.setRefNo(rs.getString("ref_no"));
        ledger.setReason(rs.getString("reason"));

        return ledger;
    }
}

