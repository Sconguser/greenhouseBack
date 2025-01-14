package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.controllers.exceptions.PlantNotFoundException;
import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.repositories.PlantRepository;
import com.greenhouse.greenhouse.requests.PlantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).orElseThrow(() -> new PlantNotFoundException("Plant not found"));
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public void addPlant(PlantRequest plantRequest) {
        Plant plant = new Plant();
        plant.setName(plantRequest.getName());
        plant.setDescription(plantRequest.getDescription());
        plant.setRequired_humidity(plantRequest.getRequired_humidity());
        plantRepository.save(plant);
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
}
