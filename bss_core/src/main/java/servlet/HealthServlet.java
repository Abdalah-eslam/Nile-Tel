package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import service.Impl.HealthService;
import utils.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/health")
public class HealthServlet extends HttpServlet {

    private HealthService healthService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        healthService = new HealthService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        boolean result = healthService.checkHealth();

        if (result) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("UP");
        }else {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            response.getWriter().write("DOWN");
        }


    }
}