package service.Impl;

import repository.HealthRepo;

public class HealthService {

    private HealthRepo healthRepo;

    public HealthService() {
        this.healthRepo = new HealthRepo();
    }

    public boolean checkHealth() {
        return healthRepo.isUp();
    }
}
