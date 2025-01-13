package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.services.PlantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {
    PlantService plantService;
    public PlantController(PlantService plantService){
        this.plantService = plantService;
    }
    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable Long id){
        return plantService.getPlantById(id);
    }
}
