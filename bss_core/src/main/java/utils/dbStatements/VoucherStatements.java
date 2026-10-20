package utils.dbStatements;

public class VoucherStatements {
    public static final String FIND_BY_CODE_FOR_UPDATE =
            "SELECT voucher_id, code, value_piasters, created_at, "
                    + "created_by_operator_id, used_at, used_by_subscriber_id "
                    + "FROM voucher  WHERE code = ? FOR UPDATE";


    public static final String MARK_USED =
            "UPDATE voucher  SET used_by_subscriber_id = ?, used_at = now() "
                    + "WHERE voucher_id = ? AND used_at IS NULL";
}
