package dto.response;

import jakarta.json.bind.annotation.JsonbProperty;

public class TariffDto {

    @JsonbProperty("TARIFF_CODE")
    private String tariffCode;

    @JsonbProperty("TARIFF_NAME")
    private String tariffName;

    @JsonbProperty("RATE_PER_MIN_PIASTERS")
    private int ratePerMinPiasters;

    @JsonbProperty("ACTIVE_FLAG")
    private String activeFlag;

    public TariffDto() {
    }

    public TariffDto(String tariffCode, String tariffName, int ratePerMinPiasters, String activeFlag) {
        setTariffCode(tariffCode);
        setTariffName(tariffName);
        setRatePerMinPiasters(ratePerMinPiasters);
        setActiveFlag(activeFlag);
    }


    public String getTariffCode() {
        return tariffCode;
    }

    public void setTariffCode(String tariffCode) {
        this.tariffCode = tariffCode;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public int getRatePerMinPiasters() {
        return ratePerMinPiasters;
    }

    public void setRatePerMinPiasters(int ratePerMinPiasters) {
        this.ratePerMinPiasters = ratePerMinPiasters;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
}
