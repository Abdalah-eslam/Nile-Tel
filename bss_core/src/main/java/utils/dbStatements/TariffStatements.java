package utils.dbStatements;

public class TariffStatements {
    public static final String FIND_ALL_TARIFFS =
            "Select  t.tariff_Id, t.code, t.name, " +
                     "t.price_Per_Minute_Piasters," +
                     "t.is_active " +
                     "from tariff_Plan t " +
                     "order by t.price_Per_Minute_Piasters ";

}
