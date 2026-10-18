package model;

import java.sql.Timestamp;

public class Ledger {
    private Long txnId;
    private String msisdn;
    private Timestamp txnTs;
    private char txnType;
    private long amountPiasters;
    private long balanceAfter;
    private String refNo;
    private String reason;

    public Ledger() {
    }

    public Ledger(Long txnId, String msisdn, Timestamp txnTs, char txnType,
                  long amountPiasters, long balanceAfter, String refNo, String reason) {
        setTxnId(txnId);
        setMsisdn(msisdn);
        setTxnTs(txnTs);
        setTxnType(txnType);
        setAmountPiasters(amountPiasters);
        setBalanceAfter(balanceAfter);
        setRefNo(refNo);
        setReason(reason);
    }

    public Long getTxnId() {
        return txnId;
    }

    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Timestamp getTxnTs() {
        return txnTs;
    }

    public void setTxnTs(Timestamp txnTs) {
        this.txnTs = txnTs;
    }

    public char getTxnType() {
        return txnType;
    }

    public void setTxnType(char txnType) {
        this.txnType = txnType;
    }

    public long getAmountPiasters() {
        return amountPiasters;
    }

    public void setAmountPiasters(long amountPiasters) {
        this.amountPiasters = amountPiasters;
    }

    public long getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(long balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
