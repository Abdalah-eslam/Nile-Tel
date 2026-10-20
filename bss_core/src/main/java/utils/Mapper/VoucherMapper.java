package utils.Mapper;

import model.Voucher;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class VoucherMapper {
    public static Voucher mapResultSetToVoucher(ResultSet rs) throws SQLException {
        if ( ! rs.next()){
            return null;
        }

        Voucher voucher = new Voucher();

        voucher.setVoucherId(rs.getLong("voucher_id"));
        voucher.setVoucherCode(rs.getString("code"));
        voucher.setValuePiasters(BigInteger.valueOf(rs.getLong("value_piasters")));
        Timestamp createdAt = rs.getTimestamp("created_at");
        voucher.setCreatedAt(createdAt == null ? null : createdAt.toLocalDateTime());

        int operatorId = rs.getInt("created_by_operator_id");
        voucher.setCreatedByOperatorId(rs.wasNull() ? null : operatorId);

        Timestamp usedAt = rs.getTimestamp("used_at");
        voucher.setUsedAt(usedAt == null ? null : usedAt.toLocalDateTime());

        long usedBy = rs.getLong("used_by_subscriber_id");
        voucher.setUsedBySubscriberId(rs.wasNull() ? null : usedBy);

        return voucher;
    }


}
