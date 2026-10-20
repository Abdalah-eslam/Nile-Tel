package model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Ledger {
    Long subscriberId;
    Character entryType;
    BigInteger amountPiasters;
    BigInteger balanceAfterPiasters;
    String referenceNumber;
    String reason;
    LocalDateTime createdAt;

    public Ledger() {
    }

    public Ledger(Long subscriberId, Character entryType, BigInteger amountPiasters, BigInteger balanceAfterPiasters, String referenceNumber, String reason, LocalDateTime createdAt) {
        this.subscriberId = subscriberId;
        this.entryType = entryType;
        this.amountPiasters = amountPiasters;
        this.balanceAfterPiasters = balanceAfterPiasters;
        this.referenceNumber = referenceNumber;
        this.reason = reason;
        this.createdAt = createdAt;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Character getEntryType() {
        return entryType;
    }

    public void setEntryType(Character entryType) {
        this.entryType = entryType;
    }

    public BigInteger getAmountPiasters() {
        return amountPiasters;
    }

    public void setAmountPiasters(BigInteger amountPiasters) {
        this.amountPiasters = amountPiasters;
    }

    public BigInteger getBalanceAfterPiasters() {
        return balanceAfterPiasters;
    }

    public void setBalanceAfterPiasters(BigInteger balanceAfterPiasters) {
        this.balanceAfterPiasters = balanceAfterPiasters;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
