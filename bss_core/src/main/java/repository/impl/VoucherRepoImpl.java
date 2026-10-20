package repository.impl;

import model.Voucher;
import repository.VoucherRepo;
import utils.Mapper.VoucherMapper;
import utils.dbStatements.VoucherStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoucherRepoImpl implements VoucherRepo {
    @Override
    public Voucher findByCodeForUpdate(Connection con, String code)  {
        try (PreparedStatement ps = con.prepareStatement(VoucherStatements.FIND_BY_CODE_FOR_UPDATE)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                return VoucherMapper.mapResultSetToVoucher(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can not find voucher " ,e);
        }
    }

    @Override
    public boolean markUsed(Connection con, long voucherId, long subscriberId) {
        try (PreparedStatement ps = con.prepareStatement(VoucherStatements.MARK_USED)) {
            ps.setLong(1, subscriberId);
            ps.setLong(2, voucherId);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot mark voucher as used", e);
        }
    }

}
