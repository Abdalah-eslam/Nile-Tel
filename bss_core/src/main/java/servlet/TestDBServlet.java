package servlet;

import utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/test-db")
public class TestDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // ---------- Test 1: connection + current db/user ----------
        out.println("===== Test 1: Connection =====");
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT current_database(), current_user")) {

            if (rs.next()) {
                out.println("Database connected successfully!");
                out.println("Database: " + rs.getString(1));
                out.println("User: " + rs.getString(2));
            }
        } catch (Exception e) {
            out.println("Database connection failed!");
            e.printStackTrace(out);
            e.printStackTrace();
        }

        // ---------- Test 2: list tables ----------
        out.println("\n===== Test 2: Tables =====");
        try (Connection con = DBConnection.getConnection()) {

            DatabaseMetaData metaData = con.getMetaData();

            try (ResultSet tables = metaData.getTables(
                    con.getCatalog(), "public", "%", new String[]{"TABLE"})) {

                while (tables.next()) {
                    out.println("Table: " + tables.getString("TABLE_NAME"));
                }
            }
        } catch (Exception e) {
            out.println("Failed to list tables!");
            e.printStackTrace(out);
            e.printStackTrace();
        }

        // ---------- Test 3: read subscriber data ----------
        out.println("\n===== Test 3: Subscriber data =====");
        String sql = "SELECT * FROM subscriber LIMIT 5";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                out.print(metaData.getColumnName(i) + "\t");
            }
            out.println("\n" + "-".repeat(80));

            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                for (int i = 1; i <= columnCount; i++) {
                    out.print(rs.getString(i) + "\t");
                }
                out.println();
            }

            out.println("\nRows retrieved: " + rowCount);

        } catch (Exception e) {
            out.println("Error while reading subscriber data:");
            e.printStackTrace(out);
            e.printStackTrace();
        }
    }
}