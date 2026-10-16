package repository;

import model.Subscriber;
import utils.DBConnection;
import utils.Mapper.subsciberMapper;
import utils.dbStatements.SubscriberStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepo {
    public Subscriber findSubscriberbyNumber(String  subscriberNumber) {

          try(Connection connection = DBConnection.getConnection()) {
              PreparedStatement ps = connection.prepareStatement(SubscriberStatements.FIND_SUBSCRIBER_BY_NUMBER);
              ps.setString(1, subscriberNumber);
            ResultSet  rs= ps.executeQuery();
             Subscriber subscriber = subsciberMapper.MapResultSetToSubsciber(rs);
             return subscriber;

          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
    }



}
