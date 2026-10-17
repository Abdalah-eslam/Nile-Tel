package servlet;

import dto.request.OperatorLoginReqest;
import dto.response.OperatorResponse;
import exception.InvalidCredentialsException;
import exception.NotActiveCustomException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Operator;
import repository.OperatorRepo;
import service.Impl.LoginServiceImpl;
import service.Impl.OperatorServiceImpl;
import service.LoginService;
import service.OperatorService;
import utils.ApiUtil;
import utils.Mapper.OperatorMapper;

import java.io.IOException;
@WebServlet("/api/auth/operator-login")
public class OperatorLoginServlet extends HttpServlet {
    private OperatorService operatorService;
    private OperatorRepo operatorRepo;
    @Override
    public void init(ServletConfig config) throws ServletException {
        operatorService = new OperatorServiceImpl();
        operatorRepo = new OperatorRepo();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            OperatorLoginReqest loginRequest = new OperatorLoginReqest(username, password);

            Operator operator = operatorService.OperatorLogin(loginRequest);


            //TODO: add session
            HttpSession old = req.getSession(false);
            if (old != null) old.invalidate();

            HttpSession s = req.getSession(true);
            s.setMaxInactiveInterval(10 * 60);
            s.setAttribute("username", operator.getUsername());
            s.setAttribute("full_name", operator.getFull_name());
            s.setAttribute("role", operator.getRole());

            System.out.println("new session id for operator = " + s.getId());

            OperatorResponse operatorResponse = OperatorMapper.toOperatorResponse(operator , s.getId());
            resp.setStatus(200);
            ApiUtil.writeJson(resp, ApiUtil.operatorLoginJson(operator ,s.getId()));

        } catch (InvalidCredentialsException e) {
            ApiUtil.error(resp ,200 ,e.getMessage());
        }
        catch (NotActiveCustomException e) {
            ApiUtil.error(resp ,200 ,e.getMessage());
        }

    }
}
