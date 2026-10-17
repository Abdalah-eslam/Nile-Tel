package utils;

import dto.response.SubscriberResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

public class ApiUtil {

    public static void writeJson(
            HttpServletResponse response,
            String json) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    public static String escape(String value) {
        if (value == null) return "";

        return value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
    }

    public static String subscriberJson(SubscriberResponse s) {
        return "{"
            + "\"RESULT\":\"OK\","
            + "\"DATA\":{"
            + "\"MSISDN\":\"" + escape(s.getMsisdn()) + "\","
            + "\"FULL_NAME\":\"" + escape(s.getFullName()) + "\","
            + "\"STATUS\":\"" + escape(s.getStatus()) + "\","
            + "\"TARIFF_CODE\":\"" + escape(s.getTariffCode()) + "\","
            + "\"TARIFF_NAME\":\"" + escape(s.getTariffName()) + "\","
            + "\"BALANCE_PIASTERS\":" + s.getBalancePiasters() + ","
            + "\"ACTIVATION_DT\":\""
            + (s.getActivationDt() == null
                ? ""
                : escape(s.getActivationDt())) + "\""
            + "}}";
    }

    public static void error(
            HttpServletResponse response,
            int status,
            String code) throws IOException {

        response.setStatus(status);

        writeJson(response,
            "{\"RESULT\":\"ERROR\",\"ERROR\":{\"CODE\":\""
            + escape(code) + "\"}}");
    }

    public static boolean validMsisdn(String msisdn) {
        return msisdn != null && msisdn.matches("\\d{11}");
    }
}