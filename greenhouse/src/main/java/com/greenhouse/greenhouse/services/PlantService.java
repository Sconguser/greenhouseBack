package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.exceptions.PlantNotFoundException;
import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.repositories.PlantRepository;
import com.greenhouse.greenhouse.requests.PlantRequest;
import com.greenhouse.greenhouse.responses.PlantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    @Autowired
    public PlantService (PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    private static PlantResponse getPlantResponse (Plant plant) {
        return new PlantResponse(plant.getId(), plant.getName(), plant.getDescription(), plant.getMinTemperature(),
                plant.getMinHumidity(), plant.getImageData() != null ? Base64.getEncoder()
                .encodeToString(plant.getImageData()) : null);
    }

    public PlantResponse getPlantById (Long id) {
        return plantRepository.findById(id)
                .map(PlantService::getPlantResponse)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found"));
    }

    public List<PlantResponse> getAllPlants () {
        return plantRepository.findAll()
                .stream()
                .map(PlantService::getPlantResponse)
                .collect(Collectors.toList());
    }

    public void addPlant (PlantRequest plantRequest) {
        Plant plant = new Plant();
        plant.setName(plantRequest.getName());
        plant.setDescription(plantRequest.getDescription());
        plant.setMinHumidity(plantRequest.getRequired_humidity());
        if (plantRequest.getImage_data() != null) {
            plant.setImageData(Base64.getDecoder()
                    .decode(plantRequest.getImage_data()));
        }
        plantRepository.save(plant);
    }

    public void deletePlant (Long id) {
        plantRepository.deleteById(id);
    }

    public void updatePlant (Long id, PlantRequest plantRequest) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found"));

        if (plantRequest.getName() != null) {
            plant.setName(plantRequest.getName());
        }
        if (plantRequest.getDescription() != null) {
            plant.setDescription(plantRequest.getDescription());
        }
        if (plantRequest.getRequired_temperature() != null) {
            plant.setMinTemperature(plantRequest.getRequired_temperature());
        }
        if (plantRequest.getRequired_humidity() != null) {
            plant.setMinHumidity(plantRequest.getRequired_humidity());
        }
        if (plantRequest.getImage_data() != null) {
            plant.setImageData(Base64.getDecoder()
                    .decode(plantRequest.getImage_data()));
        }

        plantRepository.save(plant);
    }

}
