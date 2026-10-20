package model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Voucher {
    private Long voucherId;
    private String voucherCode;
    private BigInteger valuePiasters;
    private LocalDateTime createdAt;
    private Integer createdByOperatorId;
    private LocalDateTime usedAt;
    private Long usedBySubscriberId;

    public Voucher() {
    }

    public Voucher(Long voucherId, String voucherCode, BigInteger valuePiasters, LocalDateTime createdAt, Integer createdByOperatorId, LocalDateTime usedAt, Long usedBySubscriberId) {
        this.voucherId = voucherId;
        this.voucherCode = voucherCode;
        this.valuePiasters = valuePiasters;
        this.createdAt = createdAt;
        this.createdByOperatorId = createdByOperatorId;
        this.usedAt = usedAt;
        this.usedBySubscriberId = usedBySubscriberId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public BigInteger getValuePiasters() {
        return valuePiasters;
    }

    public void setValuePiasters(BigInteger valuePiasters) {
        this.valuePiasters = valuePiasters;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedByOperatorId() {
        return createdByOperatorId;
    }

    public void setCreatedByOperatorId(Integer createdByOperatorId) {
        this.createdByOperatorId = createdByOperatorId;
    }

    public LocalDateTime getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }

    public Long getUsedBySubscriberId() {
        return usedBySubscriberId;
    }

    public void setUsedBySubscriberId(Long usedBySubscriberId) {
        this.usedBySubscriberId = usedBySubscriberId;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public boolean isUsed() { return usedAt != null; }
}

