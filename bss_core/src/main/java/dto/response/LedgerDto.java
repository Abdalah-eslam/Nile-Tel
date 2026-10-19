package dto.response;

import jakarta.json.bind.annotation.JsonbProperty;

public class LedgerDto {

    @JsonbProperty("TXN_ID")
    private Long txnId;

    @JsonbProperty("TXN_TS")
    private String txnTs;

    @JsonbProperty("TXN_TYPE")
    private String txnType;

    @JsonbProperty("AMOUNT_PIASTERS")
    private long amountPiasters;

    @JsonbProperty("BALANCE_AFTER")
    private long balanceAfter;

    @JsonbProperty("REF_NO")
    private String refNo;

    @JsonbProperty("REASON")
    private String reason;

    public LedgerDto() {
    }

    public LedgerDto(Long txnId, String txnTs, String txnType, long amountPiasters,
                     long balanceAfter, String refNo, String reason) {
        setTxnId(txnId);
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

    public String getTxnTs() {
        return txnTs;
    }

    public void setTxnTs(String txnTs) {
        this.txnTs = txnTs;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
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