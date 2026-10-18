package utils.dbStatements;

public class LedgerStatements {

    public static final String FIND_TRANSACTIONS_BY_MSISDN_AND_DATE_RANGE =
            "SELECT txn_id, msisdn, txn_ts, txn_type, amount_piasters, balance_after, ref_no, reason " +
                    "FROM ledger " +
                    "WHERE msisdn = ? AND txn_ts BETWEEN ? AND ? " +
                    "ORDER BY txn_ts DESC, txn_id DESC";
}