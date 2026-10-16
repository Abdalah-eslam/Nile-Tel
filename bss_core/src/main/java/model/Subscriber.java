package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Subscriber {
  private  int msisdn;
  private  String fullName;
  private Character status;
  private int tariff_code ;
  private String hashedPin;
  private BigInteger balance_piasters;

    public Subscriber(int msisdn, String fullName, Character status, int tariff_code, String hashedPin, BigInteger balance_piasters, Timestamp activation_at) {
        this.msisdn = msisdn;
        this.fullName = fullName;
        this.status = status;
        this.tariff_code = tariff_code;
        this.hashedPin = hashedPin;
        this.balance_piasters = balance_piasters;
        this.activation_at = activation_at;
    }

    public Timestamp getActivation_at() {
        return activation_at;
    }

    public void setActivation_at(Timestamp activation_at) {
        this.activation_at = activation_at;
    }

    private Timestamp activation_at;


    public Subscriber() {
    }



    public int getMsisdn() {
        return msisdn;
    }

    public String getFullName() {
        return fullName;
    }

    public Character getStatus() {
        return status;
    }

    public int getTariff_code() {
        return tariff_code;
    }

    public BigInteger getBalance_piasters() {
        return balance_piasters;
    }


    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }



    public void setBalance_piasters(BigInteger balance_piasters) {
        this.balance_piasters = balance_piasters;
    }

    public void setTariff_code(int tariff_code) {
        this.tariff_code = tariff_code;
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
