package servlet;

import dto.response.TariffDto;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.TariffRepo;
import service.Impl.TariffService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/tariffs")
public class TariffPlansServlet extends HttpServlet {

    private TariffService tariffService;

    @Override
    public void init() {
        this.tariffService = new TariffService(new TariffRepo());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK); // legacy bss-core: always HTTP 200, even on FAIL


        Jsonb jsonb = JsonbBuilder.create();
        Map<String, Object> envelope = new LinkedHashMap<>();

        try {
            List<TariffDto> tariffs = tariffService.getTariffs();

            envelope.put("RESULT", "SUCCESS");
            envelope.put("DATA", tariffs);

        } catch (Exception e) {
            envelope.put("RESULT", "FAIL");
            envelope.put("DATA", null);
            envelope.put("REASON", e.getMessage());
        }

        resp.getWriter().write(jsonb.toJson(envelope));
    }
}