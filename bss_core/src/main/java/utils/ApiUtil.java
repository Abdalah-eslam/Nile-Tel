package utils;

import dto.response.RechargeResponse;
import dto.response.SubscriberResponse;
import jakarta.servlet.http.HttpServletResponse;
import model.Operator;

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
    public static String subscriberLoginJson(SubscriberResponse s, String sessionId) {
        return "{"
                + "\"RESULT\":\"OK\","
                + "\"DATA\":{"
                + "\"MSISDN\":\"" + escape(s.getMsisdn()) + "\","
                + "\"FULL_NAME\":\"" + escape(s.getFullName()) + "\","
                + "\"STATUS\":\"" + escape(s.getStatus()) + "\","
                + "\"TARIFF_CODE\":\"" + escape(s.getTariffCode()) + "\","
                + "\"BALANCE_PIASTERS\":" + s.getBalancePiasters() + ","
                + "\"ACTIVATION_DT\":\""
                + (s.getActivationDt() == null
                ? ""
                : escape(s.getActivationDt())) + "\""
                + ","
                + "\"SESSION_ID\":\"" + escape(sessionId) + "\""
                + "}}";
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
    public static String rechargeJson(RechargeResponse r) {
        return "{"
                + "\"RESULT\":\"OK\","
                + "\"DATA\":{"
                + "\"TXN_ID\":" + r.txnId() + ","
                + "\"AMOUNT_PIASTERS\":" + r.amountPiasters() + ","
                + "\"BALANCE_PIASTERS\":" + r.balancePiasters()
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

    public static String operatorLoginJson(Operator operator, String id) {
        return "{"
                + "\"RESULT\":\"OK\","
                + "\"DATA\":{"
                + "\"USERNAME\":\"" + escape(operator.getUsername()) + "\","
                + "\"FULL_NAME\":\"" + escape(operator.getFull_name()) + "\","
                + "\"ROLE\":\"" + escape(operator.getRole()) + "\","
                + "\"SESSION_ID\":\"" + escape(id) + "\""
                + "}}";
    }
}