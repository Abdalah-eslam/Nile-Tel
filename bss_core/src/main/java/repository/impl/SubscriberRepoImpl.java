package repository.impl;

import repository.SubscriberRepo;
import utils.dbStatements.SubscriberStatements;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriberRepoImpl implements SubscriberRepo {
    @Override
    public Long findSubscriberId(Connection con, String msisdn){
        try (PreparedStatement ps = con.prepareStatement(SubscriberStatements.FIND_SUBSCRIBER_BY_NUMBER)) {
            ps.setString(1, msisdn);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                return rs.getLong("subscriber_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can not find Subscriber with number : " ,e);
        }
    }

    @Override
    public BigInteger addBalance(Connection con, String msisdn, BigInteger amount){
        try (PreparedStatement ps = con.prepareStatement(SubscriberStatements.ADD_BALANCE)) {
            ps.setLong(1, amount.longValueExact());
            ps.setString(2, msisdn);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                return BigInteger.valueOf(rs.getLong("balance_piasters"));
            }
            }catch (SQLException e) {
            throw new RuntimeException( "can not add balance",e);
        }
    }
    }

