package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plants")
public class PlantController {
    @Autowired
    PlantService plantService;
    public PlantController(PlantService plantService){
        this.plantService = plantService;
    }
    @GetMapping("/{id}")
    public Plant getPlant(@PathVariable Long id){
        return plantService.getPlantById(id);
    }

    @PostMapping("/addPlant")
    public void addPlant(){
        plantService.addPlant();
    }
}
