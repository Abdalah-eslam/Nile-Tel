package repository;

import model.Subscriber;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

public interface SubscriberRepo {
    Long findSubscriberId(Connection con, String msisdn) ;
    BigInteger addBalance(Connection con, String msisdn, BigInteger amount) ;
}
