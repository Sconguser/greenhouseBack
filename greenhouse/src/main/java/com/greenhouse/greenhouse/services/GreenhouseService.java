package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.exceptions.GreenhouseNotFoundException;
import com.greenhouse.greenhouse.models.Greenhouse;
import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.repositories.GreenhouseRepository;
import com.greenhouse.greenhouse.repositories.PlantRepository;
import com.greenhouse.greenhouse.requests.PlantRequest;
import com.greenhouse.greenhouse.responses.GreenhouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class GreenhouseService {
    private final GreenhouseRepository greenhouseRepository;
    private final PlantRepository plantRepository;

    @Autowired
    public GreenhouseService (GreenhouseRepository greenhouseRepository, PlantRepository plantRepository) {
        this.greenhouseRepository = greenhouseRepository;
        this.plantRepository = plantRepository;
    }

    private static GreenhouseResponse getGreenhouseResponse (Greenhouse greenhouse) {
        return new GreenhouseResponse(greenhouse);
    }

    public GreenhouseResponse getGreenhouse (Long id) {
        return getGreenhouseResponse(greenhouseRepository.findById(id)
                .orElseThrow(() -> new GreenhouseNotFoundException(
                        "Requested greenhouse with ID = " + id + "was not found")));
    }

    public boolean addPlantToGreenhouse (Long greenhouseId, Long plantId) {
        Optional<Greenhouse> greenhouseOpt = greenhouseRepository.findById(greenhouseId);
        Optional<Plant> plantOpt = plantRepository.findById(plantId);

        if (greenhouseOpt.isPresent() && plantOpt.isPresent()) {
            Greenhouse greenhouse = greenhouseOpt.get();
            Plant plant = plantOpt.get();

            greenhouse.getPlants()
                    .add(plant);
            greenhouseRepository.save(greenhouse);
            return true;
        }
        return false;
    }

    public Plant createOrFetchPlant (PlantRequest plantRequest) {
        return plantRepository.findByName(plantRequest.getName())
                .orElseGet(() -> {
                    Plant plant = new Plant();
                    plant.setName(plantRequest.getName());
                    plant.setDescription(plantRequest.getDescription());
                    plant.setRequiredHumidity(plantRequest.getRequired_humidity());
                    if (plantRequest.getImage_data() != null) {
                        plant.setImageData(Base64.getDecoder()
                                .decode(plantRequest.getImage_data()));
                    }
                    plantRepository.save(plant);
                    return plant;
                });
    }
}
