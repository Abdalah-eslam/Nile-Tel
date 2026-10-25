package utils.Mapper;

import model.Ledger;
import model.TariffPlan;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffMapper {
public static TariffPlan mapResultSetToTariffPlan (ResultSet rs) throws SQLException {
    TariffPlan tariffPlan = new TariffPlan();

    tariffPlan.setTariffId(rs.getLong("tariff_Id"));
    tariffPlan.setCode(rs.getString("code"));
    tariffPlan.setName(rs.getString("name"));
    tariffPlan.setPricePerMinutePiasters(rs.getInt("price_Per_Minute_Piasters"));
    tariffPlan.setIsActive(rs.getString("is_Active").charAt(0));

    return tariffPlan;


   }
}

