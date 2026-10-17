package repository;

import model.Operator;
import model.Subscriber;
import utils.DBConnection;
import utils.Mapper.OperatorMapper;
import utils.Mapper.SubsciberMapper;
import utils.dbStatements.OperatorStatements;
import utils.dbStatements.SubscriberStatements;

import java.sql.*;

public class OperatorRepo {
    public Operator findOperatorByUsername(String username) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(OperatorStatements.OPERATOR_LOGIN);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            Operator operator = OperatorMapper.mapResultSetToOperator(rs);
            return operator;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
