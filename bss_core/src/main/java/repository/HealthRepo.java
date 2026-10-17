package repository;

import jakarta.servlet.http.HttpServletResponse;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HealthRepo {
    public Boolean isUp(){
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement("SELECT 1");
             ResultSet rs = ps.executeQuery()) {

            return rs.next() && rs.getInt(1) == 1;

        } catch (SQLException e) {
            return false;
        }

    }
}
