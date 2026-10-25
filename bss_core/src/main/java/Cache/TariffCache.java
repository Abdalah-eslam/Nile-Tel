package Cache;
import model.TariffPlan;
import java.util.List;

public class TariffCache {
    private static List<TariffPlan> cachedTariffs;

    public static List<TariffPlan> get() {
        return cachedTariffs;

    }
    public static void set(List<TariffPlan> tariffs) {
        cachedTariffs = tariffs;
    }
}
