package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import utils.ApiUtil;
@WebServlet("/api/auth/logout")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doPost(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response)
            throws ServletException, java.io.IOException {

        jakarta.servlet.http.HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.setStatus(200);
        response.setContentType("application/json");
        ApiUtil.writeJson(
                response,
                "{\"RESULT\":\"OK\",\"DATA\":{}}"
        );
    }

}

