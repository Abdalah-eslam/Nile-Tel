package servlet;

import dto.request.RechargeRequest;
import dto.response.RechargeResponse;
import exception.VoucherAlreadyUsedException;
import exception.VoucherNotFoundException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.impl.LedgerRepoImpl;
import repository.impl.SubscriberRepoImpl;
import repository.impl.VoucherRepoImpl;
import service.Impl.RechargeServiceImpl;
import utils.ApiUtil;

import java.io.IOException;


@WebServlet("/api/subscriber/me/recharge")
public class RechargeServlet extends HttpServlet {

    private static final int STATUS_VAL001 = 400;
    private static final int STATUS_VCH001 = 404;
    private static final int STATUS_VCH002 = 409;

    private RechargeServiceImpl rechargeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.rechargeService = new RechargeServiceImpl(
                new VoucherRepoImpl(),
                new SubscriberRepoImpl(),
                new LedgerRepoImpl()
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null){
            ApiUtil.error(resp, 401, "AUTH001");
            return;
        }

        if (!"SUB".equals(session.getAttribute("role"))) {
            ApiUtil.error(resp,403, "SEC001");
            return;
        }

        Object sessionMsisdn  = session.getAttribute("msisdn");
        if (sessionMsisdn == null) {
            ApiUtil.error(resp, 401, "AUTH001");
            return;
        }
        String msisdn = sessionMsisdn.toString();

        RechargeRequest body = new RechargeRequest(req.getParameter("voucherCode"));
        if (body.voucherCode() == null || body.voucherCode().trim().isEmpty()) {
            ApiUtil.error(resp, STATUS_VAL001, "VAL001");
            return;
        }
        try{
            RechargeResponse result = rechargeService.recharge(msisdn,body);
            ApiUtil.writeJson(resp,ApiUtil.rechargeJson(result));
        }catch (VoucherNotFoundException e){
            ApiUtil.error(resp ,404, "VCH001");
        }catch (VoucherAlreadyUsedException e) {
            ApiUtil.error(resp, 409, "VCH002");
        }

    }
}
