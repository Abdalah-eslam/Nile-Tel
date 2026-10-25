package service.Impl;

import Cache.TariffCache;
import dto.response.TariffDto;
import model.TariffPlan;
import repository.TariffRepo;
import service.TariffInterface;
import java.util.ArrayList;
import java.util.List;

public class TariffService implements TariffInterface {
    private final TariffRepo tariffRepo ;

    public TariffService(TariffRepo tariffRepo) {
        this.tariffRepo = tariffRepo;
    }

    @Override
    public List<TariffDto> getTariffs(){
        List<TariffPlan> tariffs = TariffCache.get();

        if(tariffs==null){
            tariffs =tariffRepo.findAllTariffs();
            TariffCache.set(tariffs);
        }

        List<TariffDto> result =new ArrayList<>();
        for (TariffPlan t : tariffs){
            result.add(toDto(t));
        }
        return result;

    }

    private TariffDto toDto (TariffPlan tariffPlan ){
        TariffDto dto = new TariffDto();
        dto.setTariffCode(tariffPlan.getCode());
        dto.setTariffName(tariffPlan.getName());
        dto.setRatePerMinPiasters(tariffPlan.getPricePerMinutePiasters());
        dto.setActiveFlag(String.valueOf(tariffPlan.getIsActive()));

        return dto;
    }
}
