package repository;

import dto.response.SubscriberResponse;
import model.Subscriber;
import utils.DBConnection;
import utils.Mapper.SubsciberMapper;
import utils.dbStatements.SubscriberStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepo {
    public Subscriber findSubscriberByNumber(String  subscriberNumber) {

          try(Connection connection = DBConnection.getConnection()) {
              PreparedStatement ps = connection.prepareStatement(SubscriberStatements.FIND_SUBSCRIBER_BY_NUMBER);
              ps.setString(1, subscriberNumber);
            ResultSet  rs= ps.executeQuery();
             Subscriber subscriber = SubsciberMapper.mapResultSetToSubscriber(rs);
             return subscriber;

          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
    }



}
