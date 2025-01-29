package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.models.Status;
import com.greenhouse.greenhouse.responses.GreenhouseStatusResponse;
import com.greenhouse.greenhouse.services.GreenhouseStatusService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greenhouseStatus")
public class GreenhouseStatusController {
    private final GreenhouseStatusService greenhouseStatusService;

    public GreenhouseStatusController (GreenhouseStatusService greenhouseStatusService) {
        this.greenhouseStatusService = greenhouseStatusService;
    }

    @GetMapping("/{id}")
    public GreenhouseStatusResponse getGreenhouseStatus (@PathVariable Long id) {
        return greenhouseStatusService.getGreenhouseStatus(id);
    }

    @PatchMapping("/setStatus/{id}")
    public void setGreenhouseStatus (@PathVariable Long id, @RequestParam Status status) {
        greenhouseStatusService.setStatus(id, status);
    }

    @PatchMapping("/setTemperature/{id}")
    public void setGreenhouseTemperature (@PathVariable Long id, @RequestParam double temperature) {
        greenhouseStatusService.setTemperature(id, temperature);
    }

    @PatchMapping("/setHumidity/{id}")
    public void setGreenhouseHumidity (@PathVariable Long id, @RequestParam double humidity) {
        greenhouseStatusService.setHumidity(id, humidity);
    }

    @Bean
    public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
        return args -> {
            System.out.println("Greenhouse controller initialized");
        };
    }

}
