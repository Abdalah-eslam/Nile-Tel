package repository;

import model.TariffPlan;
import utils.DBConnection;
import utils.Mapper.TariffMapper;
import utils.dbStatements.TariffStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TariffRepo {

    public List<TariffPlan> findAllTariffs() {

        List<TariffPlan> tariffs = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(TariffStatements.FIND_ALL_TARIFFS)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tariffs.add(TariffMapper.mapResultSetToTariffPlan(rs));
                }
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tariffs;
    }
}
