package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.ApiUtil;

import java.io.IOException;
@WebFilter(urlPatterns = {"/api/subscriber/*", "/api/operator/*"})
public class SessionFilter extends HttpFilter{
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        if (session == null) {
            ApiUtil.error(response, 200, "AUTH001");
            return;
        }

        String role = (String) session.getAttribute("role");

        if (role == null || (!"SUB".equals(role) && !"OPR".equals(role) && !"SYS".equals(role))) {
            ApiUtil.error(response, 200, "SEC001");
            return;
        }

        chain.doFilter(request, response);
    }




}
