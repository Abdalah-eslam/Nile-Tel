package dao;

import dto.response.SubscriberResponse;
import utils.DBConnection;

import java.sql.*;
import java.math.BigInteger;

public class SubscriberDAO {

    public SubscriberResponse findByMsisdn(String msisdn)
            throws SQLException {

        String sql =
            "SELECT s.msisdn, s.full_name, s.status, " +
            "s.tariff_code, t.tariff_name, " +
            "s.balance_piasters, s.activation_dt " +
            "FROM subscribers s " +
            "JOIN tariffs t ON s.tariff_code = t.tariff_code " +
            "WHERE s.msisdn = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, msisdn);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                BigInteger balance =
                    rs.getBigDecimal("balance_piasters")
                      .toBigIntegerExact();

                Date activationDate =
                    rs.getDate("activation_dt");

                return new SubscriberResponse(
                    rs.getString("msisdn"),
                    rs.getString("full_name"),
                    rs.getString("status"),
                    rs.getString("tariff_code"),
                    rs.getString("tariff_name"),
                    balance,
                    activationDate == null
                        ? null
                        : new java.text.SimpleDateFormat("dd/MM/yyyy")
                            .format(activationDate)
                );
            }
        }
    }
}