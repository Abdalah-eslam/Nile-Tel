package utils.Mapper;

import dto.response.SubscriberResponse;
import model.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubsciberMapper {

    public static SubscriberResponse mapResultSetToSubscriberResponse(ResultSet rs) throws SQLException {
        SubscriberResponse subscriber = new SubscriberResponse();
        while (rs.next()) {
            subscriber.setMsisdn(rs.getString("msisdn"));
            subscriber.setFullName(rs.getString("full_name"));
            subscriber.setStatus(rs.getString("status"));
            subscriber.setTariffCode(rs.getString("tariff_id"));
            subscriber.setBalancePiasters(rs.getBigDecimal("balance_piasters").toBigInteger());
            subscriber.setActivationDt(rs.getString("activated_at"));
        }
        return subscriber;
    }

    public static Subscriber mapResultSetToSubscriber(ResultSet rs) throws SQLException {
        Subscriber subscriber = new Subscriber();
        while (rs.next()) {
            subscriber.setMsisdn(rs.getInt("msisdn"));
            subscriber.setFullName(rs.getString("full_name"));
            subscriber.setStatus(rs.getString("status").charAt(0));
            subscriber.setTariff_code(rs.getInt("tariff_id"));
            subscriber.setBalance_piasters(rs.getBigDecimal("balance_piasters").toBigInteger());
            subscriber.setHashedPin(rs.getString("pin_hash"));
            subscriber.setActivation_at(rs.getTimestamp("activated_at"));
        }
        return subscriber;
    }
}
