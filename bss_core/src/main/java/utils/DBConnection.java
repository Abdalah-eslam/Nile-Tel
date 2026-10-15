package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private static final String URL =
            dotenv.get("AIVEN_JDBC_URL");

    private static final String USER =
            dotenv.get("AIVEN_DB_USER");

    private static final String PASSWORD =
            dotenv.get("AIVEN_DB_PASSWORD");

    public static Connection getConnection() throws SQLException {

        if (URL == null || USER == null || PASSWORD == null) {
            throw new IllegalStateException(
                    "Database settings are missing. Check your .env file."
            );
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    }



