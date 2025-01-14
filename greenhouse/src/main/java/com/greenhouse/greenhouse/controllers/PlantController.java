package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.models.Plant;
import com.greenhouse.greenhouse.requests.PlantRequest;
import com.greenhouse.greenhouse.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addPlant")
    public void addPlant(@RequestBody PlantRequest plantRequest){
        plantService.addPlant(plantRequest);
    }

    @Bean
    public CommandLineRunner plantCommandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Plant controller initialized");
        };
    }
}
