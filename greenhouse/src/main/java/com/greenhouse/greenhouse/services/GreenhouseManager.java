package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.models.Greenhouse;
import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.requests.GreenhouseStatusRequest;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseManager {
    private final GreenhouseService greenhouseService;

    public GreenhouseManager (GreenhouseService greenhouseService) {
        this.greenhouseService = greenhouseService;
    }

    public boolean checkPlantRequirements (Long greenhouseId, GreenhouseStatusRequest statusRequest) {
        Greenhouse greenhouse = greenhouseService.getGreenhouseEntity(greenhouseId);
        Double temperature = statusRequest.getTemperature();
        Double humidity = statusRequest.getHumidity();
        for (Plant plant : greenhouse.getPlants()) {
            if (temperature > plant.getMaxTemperature() || temperature < plant.getMinTemperature() || humidity > plant.getMaxHumidity() || humidity < plant.getMinHumidity()) {
                composeErrorMessageForGreenhouse(greenhouse, plant.getName(), "temperature too high " +)
            }
        } return false;
    }

    private String composeErrorMessageForGreenhouse (Greenhouse greenhouse, String plantName, String errorType) {
        return "There is a problem in greenhouse " + greenhouse.getName() + " located at" + greenhouse.getLocation() + " with plant " + plantName + " " + errorType;
    }

    private String composeErrorMessage (Greenhouse greenhouse, GreenhouseStatusRequest greenhouseStatusRequest,
                                        Plant plant)
    {
        return "There is a problem in greenhouse " + greenhouse.getName() + " located at " +greenhouse.getLocation() + " current status of Greenhouse"
    }
}
