package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dto.request.subscriberLoginReq;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Impl.loginService;
import service.loginInterface;

@WebServlet("/api/auth/login")
public class LoginServlet extends HttpServlet {

    private loginInterface loginInterface;


    @Override
    public void init(ServletConfig config) throws ServletException {
        this.loginInterface = new loginService();
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
       subscriberLoginReq reqbody = new subscriberLoginReq(phoneNumber , pin);
        loginInterface.Subscriberlogin(reqbody);
        resp.getWriter().write("Login successful");
        resp.getWriter().close();

    }


}
