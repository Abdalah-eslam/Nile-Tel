package utils.Mapper;

import dto.response.OperatorResponse;
import model.Operator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorMapper {

    public static Operator mapResultSetToOperator(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }

            Operator operator = new Operator();
            operator.setUsername(rs.getString("username"));
            operator.setHashedpassword(rs.getString("password_hash"));
            operator.setFull_name(rs.getString("full_name"));
            operator.setRole(rs.getString("role"));
            operator.setIs_active(rs.getString("is_active").charAt(0));

        System.out.println(rs.getString("username"));
            return operator;



    }

    public static OperatorResponse toOperatorResponse(Operator operator ,String sessionId) {
        OperatorResponse operatorResponse = new OperatorResponse();
        operatorResponse.setUsername(operator.getUsername());
        operatorResponse.setFull_name(operator.getFull_name());
        operatorResponse.setRole(operator.getRole());
        operatorResponse.setSessionId(sessionId);
        return operatorResponse;
    }
}
