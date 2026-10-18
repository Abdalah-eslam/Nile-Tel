package servlet;

import java.io.IOException;

import dto.request.SubscriberLoginRequest;
import dto.response.SubscriberResponse;
import exception.InvalidCredentialsException;
import exception.NotActiveCustomException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Subscriber;
import service.Impl.LoginServiceImpl;
import service.LoginService;
import utils.ApiUtil;
import utils.Mapper.SubsciberMapper;

@WebServlet("/api/auth/login")
public class SubscriberLoginServlet extends HttpServlet {

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
      String phoneNumber =  req.getParameter("msisdn");
      String pin =  req.getParameter("pin");
       SubscriberLoginRequest reqbody = new SubscriberLoginRequest(phoneNumber , pin);

       try{
          Subscriber subscriber = LoginService.subscriberLogin(reqbody);

          //TODO: add session
           HttpSession old = req.getSession(false);
           if (old != null) old.invalidate();

           HttpSession s = req.getSession(true);
           s.setMaxInactiveInterval(10 * 60);
           s.setAttribute("msisdn", subscriber.getMsisdn());
           s.setAttribute("role", "SUB");

           System.out.println("new session id for subscriber = " + s.getId());

           SubscriberResponse subscriberResponse = SubsciberMapper.ConvertSubscriberToSubscriberResponse(subscriber );
           resp.setStatus(HttpServletResponse.SC_OK);
           ApiUtil.writeJson(resp,ApiUtil.subscriberLoginJson(subscriberResponse ,s.getId()) );
       } catch(InvalidCredentialsException e) {
           ApiUtil.error(resp, HttpServletResponse.SC_OK, e.getMessage());
       } catch(NotActiveCustomException e) {
           ApiUtil.error(resp, HttpServletResponse.SC_OK,e.getMessage() );
       }


    }


}
