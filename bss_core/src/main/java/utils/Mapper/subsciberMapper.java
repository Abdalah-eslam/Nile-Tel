package utils.Mapper;

import model.Subscriber;

import java.sql.ResultSet;
import java.sql.SQLException;

public class subsciberMapper {

    public static Subscriber MapResultSetToSubsciber(ResultSet rs)  throws SQLException {
         Subscriber subscriber = new Subscriber();
        while (rs.next()) {


            subscriber.setMsisdn(rs.getInt("msisdn"));
            subscriber.setFullName(rs.getString("full_name"));
            subscriber.setStatus(rs.getString("status").charAt(0));
            subscriber.setTariff_code(rs.getInt("tariff_id"));
            subscriber.setBalance_piasters(rs.getBigDecimal("balance_piasters").toBigInteger());
            subscriber.setHashedPin(rs.getString("pin_hash"));
            subscriber.setActivation_at(rs.getTimestamp("activated_at"))    ;
        }
return subscriber;
    }
}
