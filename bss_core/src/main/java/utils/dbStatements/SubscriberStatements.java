package utils.dbStatements;

public class SubscriberStatements {
    public static final String FIND_SUBSCRIBER_BY_NUMBER =
            "SELECT * FROM subscriber WHERE msisdn = ?";

    public static final String ADD_BALANCE =
            "UPDATE subscriber SET balance_piasters = balance_piasters + ? "
                    + "WHERE msisdn = ? "
                    + "RETURNING balance_piasters";
}
