package com.greenhouse.greenhouse.services;

import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    private final PlantRepository plantRepository;
    @Autowired
    public PlantService(PlantRepository plantRepository){
        this.plantRepository = plantRepository;
    }
    public Plant getPlantById(Long id){
        return plantRepository.findById(id).orElseThrow(()->new RuntimeException("Plant not found"));
    }
    public void addPlant(){
        Plant plant = new Plant();
        plant.setName("Fikus");
        plantRepository.save(plant);
    }
}
