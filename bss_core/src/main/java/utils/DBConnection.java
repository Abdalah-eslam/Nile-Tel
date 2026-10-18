package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final Dotenv dotenv = Dotenv.configure()

            .directory("E:\\Nile-Tel\\bss_core")
            .ignoreIfMissing()
            .load();

    private static final String URL =
            dotenv.get("AIVEN_JDBC_URL");

    private static final String USER =
            dotenv.get("AIVEN_DB_USER");

    private static final String PASSWORD =
            dotenv.get("AIVEN_DB_PASSWORD");

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL driver not found", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}



