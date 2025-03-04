package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.exceptions.GreenhouseNotFoundException;
import com.greenhouse.greenhouse.models.Greenhouse;
import com.greenhouse.greenhouse.repositories.GreenhouseRepository;
import com.greenhouse.greenhouse.responses.GreenhouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreenhouseService {
    private final GreenhouseRepository greenhouseRepository;

    @Autowired
    public GreenhouseService (GreenhouseRepository greenhouseRepository) {
        this.greenhouseRepository = greenhouseRepository;
    }

    private static GreenhouseResponse getGreenhouseResponse (Greenhouse greenhouse) {
        return new GreenhouseResponse(greenhouse);
    }

    public GreenhouseResponse getGreenhouse (Long id) {
        return getGreenhouseResponse(greenhouseRepository.findById(id)
                .orElseThrow(() -> new GreenhouseNotFoundException(
                        "Requested greenhouse with ID = " + id + "was not found")));
    }
}
