package utils.dbStatements;

public class LedgerStatements {
    public static final String INSERT =
            "INSERT INTO ledger (subscriber_id, entry_type, amount_piasters, "
                    + "balance_after_piasters, ref_no, reason, created_at) "
                    + "VALUES (?, ?, ?, ?, ?, ?, now()) "
                    + "RETURNING ledger_id";
}
