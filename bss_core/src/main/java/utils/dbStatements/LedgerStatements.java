package utils.dbStatements;

public class LedgerStatements {

    public static final String FIND_TRANSACTIONS_BY_MSISDN_AND_DATE_RANGE =
            "SELECT l.ledger_id, l.subscriber_id, l.created_at, l.entry_type, " +
                    "       l.amount_piasters, l.balance_after_piasters, l.ref_no, l.reason " +
                    "FROM ledger l " +
                    "JOIN subscriber s ON l.subscriber_id = s.subscriber_id " +
                    "WHERE s.msisdn = ? AND l.created_at BETWEEN ? AND ? " +
                    "ORDER BY l.created_at DESC, l.ledger_id DESC";
}