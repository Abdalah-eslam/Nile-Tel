package dto.response;

import java.math.BigInteger;

public class SubscriberResponse {
    private String msisdn;
    private String fullName;
    private String status;
    private String tariffCode;
    private String tariffName;
    private BigInteger balancePiasters;
    private String activationDt;

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTariffCode(String tariffCode) {
        this.tariffCode = tariffCode;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public void setBalancePiasters(BigInteger balancePiasters) {
        this.balancePiasters = balancePiasters;
    }

    public void setActivationDt(String activationDt) {
        this.activationDt = activationDt;
    }

    public SubscriberResponse() {}
    public SubscriberResponse(
            String msisdn,
            String fullName,
            String status,
            String tariffCode,
            String tariffName,
            BigInteger balancePiasters,
            String activationDt) {

        this.msisdn = msisdn;
        this.fullName = fullName;
        this.status = status;
        this.tariffCode = tariffCode;
        this.tariffName = tariffName;
        this.balancePiasters = balancePiasters;
        this.activationDt = activationDt;
    }

    public String getMsisdn() { return msisdn; }
    public String getFullName() { return fullName; }
    public String getStatus() { return status; }
    public String getTariffCode() { return tariffCode; }
    public String getTariffName() { return tariffName; }
    public BigInteger getBalancePiasters() { return balancePiasters; }
    public String getActivationDt() { return activationDt; }
}