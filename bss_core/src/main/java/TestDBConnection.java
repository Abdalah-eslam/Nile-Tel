
import utils.DBConnection;

import java.sql.*;

public class TestDBConnection {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT current_database(), current_user")) {

            if (rs.next()) {
                System.out.println("Database connected successfully!");
                System.out.println("Database: " + rs.getString(1));
                System.out.println("User: " + rs.getString(2));
            }

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        try (Connection con = DBConnection.getConnection()) {

            System.out.println("Connected successfully!");

            DatabaseMetaData metaData = con.getMetaData();

            try (ResultSet tables = metaData.getTables(
                    con.getCatalog(),
                    "public",
                    "%",
                    new String[]{"TABLE"})) {

                while (tables.next()) {
                    System.out.println(
                            "Table: " + tables.getString("TABLE_NAME"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM subscriber LIMIT 5";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Connected successfully!");
            System.out.println("Reading subscriber data...\n");

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }

            System.out.println("\n" + "-".repeat(80));

            // Print rows
            int rowCount = 0;

            while (rs.next()) {
                rowCount++;

                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }

                System.out.println();
            }

            System.out.println("\nRows retrieved: " + rowCount);

        } catch (Exception e) {
            System.out.println("Error while reading subscriber data:");
            e.printStackTrace();
        }
    }
    }
