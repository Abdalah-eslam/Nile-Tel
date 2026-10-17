package servlet;

import dao.SubscriberDAO;
import dto.response.SubscriberResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import utils.ApiUtil;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/api/subscriber/me")
public class SubscriberMeServlet extends HttpServlet {

    private final SubscriberDAO subscriberDAO = new SubscriberDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            ApiUtil.error(response, 401, "AUTH001");
            return;
        }

        String role = (String) session.getAttribute("role");

        if (!"SUB".equals(role)) {
            ApiUtil.error(response, 403, "SEC001");
            return;
        }

        Object sessionMsisdn = session.getAttribute("msisdn");

        if (sessionMsisdn == null) {
            ApiUtil.error(response, 401, "AUTH001");
            return;
        }

        String msisdn = sessionMsisdn.toString();

        if (!ApiUtil.validMsisdn(msisdn)) {
            ApiUtil.error(response, 401, "AUTH001");
            return;
        }

        try {
            SubscriberResponse subscriber =
                subscriberDAO.findByMsisdn(msisdn);

            if (subscriber == null) {
                ApiUtil.error(response, 404, "SUB404");
                return;
            }

            ApiUtil.writeJson(
                response,
                ApiUtil.subscriberJson(subscriber)
            );

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}