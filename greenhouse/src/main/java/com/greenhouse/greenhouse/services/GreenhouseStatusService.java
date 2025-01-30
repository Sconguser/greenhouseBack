package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.exceptions.GreenhouseStatusNotFoundException;
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

    public GreenhouseStatusResponse getGreenhouseStatus (Long id) {
        return greenhouseStatusRepository.findById(id)
                .map(GreenhouseStatusService::getGreenhouseStatusResponse)
                .orElseThrow(() -> new GreenhouseStatusNotFoundException("Greenhouse status not found in database"));
    }

    public void setTemperature (Long id, double temperature) {
        GreenhouseStatus greenhouseStatus = fetchGreenhouseStatus(id);
        greenhouseStatus.setTemperature(temperature);
        greenhouseStatusRepository.save(greenhouseStatus);
    }

    public void setHumidity (Long id, double humidity) {
        GreenhouseStatus greenhouseStatus = fetchGreenhouseStatus(id);
        greenhouseStatus.setHumidity(humidity);
        greenhouseStatusRepository.save(greenhouseStatus);
    }

    public void setStatus (Long id, Status status) {
        GreenhouseStatus greenhouseStatus = fetchGreenhouseStatus(id);
        greenhouseStatus.setStatus(status);
        greenhouseStatusRepository.save(greenhouseStatus);
    }

    private GreenhouseStatus fetchGreenhouseStatus (Long id) {
        return greenhouseStatusRepository.findById(id)
                .orElseThrow(() -> new GreenhouseStatusNotFoundException("Greenhouse status not found in database"));
    }
}
