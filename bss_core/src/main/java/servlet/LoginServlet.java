package servlet;

import java.io.IOException;

import dto.request.SubscriberLoginRequest;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Impl.LoginServiceImpl;
import service.LoginService;

@WebServlet("/api/auth/login")
public class LoginServlet extends HttpServlet {

    private LoginService LoginService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        this.LoginService = new LoginServiceImpl();
            }


    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String phoneNumber =  req.getParameter("PhoneNumber");
      String pin =  req.getParameter("pin");
       SubscriberLoginRequest reqbody = new SubscriberLoginRequest(phoneNumber , pin);
        LoginService.subscriberLogin(reqbody);
        resp.getWriter().write("Login successful");
        resp.getWriter().close();

    }


}
