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

    @GetMapping("/")
    public GreenhouseStatusResponse getGreenhouseStatus () {
        return greenhouseStatusService.getGreenhouseStatus();
    }

    @PatchMapping("/setStatus")
    public void setGreenhouseStatus (@RequestParam Status status) {
        greenhouseStatusService.setStatus(status);
    }

    @PatchMapping("/setTemperature")
    public void setGreenhouseTemperature (@RequestParam double temperature) {
        greenhouseStatusService.setTemperature(temperature);
    }

    @PatchMapping("/setHumidity")
    public void setGreenhouseHumidity (@RequestParam double humidity) {
        greenhouseStatusService.setHumidity(humidity);
    }

    @Bean
    public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
        return args -> {
            System.out.println("Greenhouse controller initialized");
        };
    }

}
