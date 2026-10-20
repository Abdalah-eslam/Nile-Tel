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

        if (!rs.next()) {
            return null;
        }

        Subscriber subscriber = new Subscriber();

        subscriber.setMsisdn(rs.getString("msisdn"));
        subscriber.setFullName(rs.getString("full_name"));
        subscriber.setStatus(rs.getString("status").charAt(0));
        subscriber.setTariffCode(rs.getInt("tariff_id"));
        subscriber.setBalancePiasters(
                rs.getBigDecimal("balance_piasters").toBigInteger()
        );
        subscriber.setHashedPin(rs.getString("pin_hash"));
        subscriber.setActivation_at(rs.getTimestamp("activated_at"));

        return subscriber;
    }

    public static SubscriberResponse ConvertSubscriberToSubscriberResponse(Subscriber subscriber) {
        SubscriberResponse subscriberResponse = new SubscriberResponse();
        subscriberResponse.setMsisdn(subscriber.getMsisdn());
        subscriberResponse.setStatus(String.valueOf(subscriber.getStatus()));
        subscriberResponse.setFullName(subscriber.getFullName());
        subscriberResponse.setTariffCode(String.valueOf(subscriber.getTariffCode()));
        subscriberResponse.setBalancePiasters(subscriber.getBalancePiasters());
        subscriberResponse.setActivationDt(subscriber.getActivation_at().toString());

        return subscriberResponse;


    }
}
