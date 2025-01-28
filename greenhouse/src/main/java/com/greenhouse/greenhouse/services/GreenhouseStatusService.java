package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.controllers.exceptions.GreenhouseStatusNotFoundException;
import com.greenhouse.greenhouse.models.GreenhouseStatus;
import com.greenhouse.greenhouse.models.Status;
import com.greenhouse.greenhouse.repositories.GreenhouseStatusRepository;
import com.greenhouse.greenhouse.responses.GreenhouseStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseStatusService {
    private final GreenhouseStatusRepository greenhouseStatusRepository;

    @Autowired
    public GreenhouseStatusService (GreenhouseStatusRepository greenhouseStatusRepository) {
        this.greenhouseStatusRepository = greenhouseStatusRepository;
    }

    private static GreenhouseStatusResponse getGreenhouseStatusResponse (GreenhouseStatus greenhouseStatus) {
        return new GreenhouseStatusResponse(greenhouseStatus.getTemperature(), greenhouseStatus.getHumidity(),
                greenhouseStatus.getStatus());
    }

    public GreenhouseStatusResponse getGreenhouseStatus () {
        return greenhouseStatusRepository.findById(1L)
                .map(GreenhouseStatusService::getGreenhouseStatusResponse)
                .orElseThrow(() -> new GreenhouseStatusNotFoundException(
                        "Greenhouse status not found in database," + " this is a critical error." + " Status might not have been initialized properly," + " or requested machine is, in fact, a teapot"));
    }

    public void setTemperature (double temperature) {
        GreenhouseStatus greenhouseStatus = fetchGreenhouseStatus();
        greenhouseStatus.setTemperature(temperature);
        greenhouseStatusRepository.save(greenhouseStatus);
    }

    public void setHumidity (double humidity) {
        GreenhouseStatus greenhouseStatus = fetchGreenhouseStatus();
        greenhouseStatus.setHumidity(humidity);
        greenhouseStatusRepository.save(greenhouseStatus);
    }

    public void setStatus (Status status) {
        GreenhouseStatus greenhouseStatus = fetchGreenhouseStatus();
        greenhouseStatus.setStatus(status);
        greenhouseStatusRepository.save(greenhouseStatus);
    }

    private GreenhouseStatus fetchGreenhouseStatus () {
        return greenhouseStatusRepository.findById(1L)
                .orElseThrow(() -> new GreenhouseStatusNotFoundException(
                        "Greenhouse status not found in database," + " this is a critical error." + " Status might not have been initialized properly," + " or requested machine is, in fact, a teapot"));
    }
}
