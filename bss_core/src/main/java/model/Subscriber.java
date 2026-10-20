package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Subscriber {
    private Long subscriberId;
    private  String msisdn;
    private  String fullName;
    private Character status;
    private int tariffCode;
    private String hashedPin;
    private BigInteger balancePiasters;
    private Timestamp activation_at;

    public Subscriber(Long subscriberId, String msisdn, String fullName, Character status, int tariffCode, String hashedPin, BigInteger balancePiasters, Timestamp activation_at) {
        this.subscriberId = subscriberId;
        this.msisdn = msisdn;
        this.fullName = fullName;
        this.status = status;
        this.tariffCode = tariffCode;
        this.hashedPin = hashedPin;
        this.balancePiasters = balancePiasters;
        this.activation_at = activation_at;
    }

    public Timestamp getActivation_at() {
        return activation_at;
    }

    public void setActivation_at(Timestamp activation_at) {
        this.activation_at = activation_at;
    }



    public Subscriber() {
    }

    public String getMsisdn() {
        return msisdn;
    }

    public String getFullName() {
        return fullName;
    }

    public Character getStatus() {
        return status;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getTariffCode() {
        return tariffCode;
    }

    public void setTariffCode(int tariffCode) {
        this.tariffCode = tariffCode;
    }

    public BigInteger getBalancePiasters() {
        return balancePiasters;
    }

    public void setBalancePiasters(BigInteger balancePiasters) {
        this.balancePiasters = balancePiasters;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHashedPin() {
        return hashedPin;
    }

    public void setHashedPin(String hashedPin) {
        this.hashedPin = hashedPin;
    }
}
