package model;

public class TariffPlan {

    private Long tariffId;
    private String code;
    private String name;
    private int pricePerMinutePiasters;
    private char isActive;

    public TariffPlan() {
    }

    public TariffPlan(Long tariffId, String code, String name,
                      int pricePerMinutePiasters, char isActive) {
        setTariffId(tariffId);
        setCode(code);
        setName(name);
        setPricePerMinutePiasters(pricePerMinutePiasters);
        setIsActive(isActive);
    }

    public Long getTariffId() {
        return tariffId;
    }

    public void setTariffId(Long tariffId) {
        this.tariffId = tariffId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerMinutePiasters() {
        return pricePerMinutePiasters;
    }

    public void setPricePerMinutePiasters(int pricePerMinutePiasters) {
        this.pricePerMinutePiasters = pricePerMinutePiasters;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }
}