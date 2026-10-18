package servlet;


import dto.response.LedgerDto;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.LedgerRepo;
import service.Impl.LedgerService;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/subscriber/me/transactions")
public class SubscriberTransactionsServlet extends HttpServlet {


    private LedgerService ledgerService;

    @Override
    public void init() {
        this.ledgerService = new LedgerService(new LedgerRepo());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK); // legacy bss-core: always HTTP 200, even on FAIL

        HttpSession session = req.getSession(false);
        String from = req.getParameter("from");
        String to = req.getParameter("to");

        Jsonb jsonb = JsonbBuilder.create();
        Map<String, Object> envelope = new LinkedHashMap<>();

        try {
            if (session == null) {
                throw new RuntimeException("Subscriber session required");
            }

            List<LedgerDto> transactions = ledgerService.getTransactionStatement(session, from, to);

            envelope.put("RESULT", "SUCCESS");
            envelope.put("DATA", transactions);

        } catch (Exception e) {
            envelope.put("RESULT", "FAIL");
            envelope.put("DATA", null);
            envelope.put("REASON", e.getMessage());
        }

        resp.getWriter().write(jsonb.toJson(envelope));
    }

}
