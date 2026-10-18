package model;

import java.sql.Timestamp;

public class Ledger {
    private Long txnId;
    private Long subscriberId;
    private Timestamp txnTs;
    private char txnType;
    private long amountPiasters;
    private long balanceAfter;
    private String refNo;
    private String reason;

    public Ledger() {
    }

                  long amountPiasters, long balanceAfter, String refNo, String reason) {
    }

    public Long getTxnId() {
        return txnId;
    }

    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
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