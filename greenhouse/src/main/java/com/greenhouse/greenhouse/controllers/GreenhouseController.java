package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.responses.GreenhouseResponse;
import com.greenhouse.greenhouse.services.GreenhouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greenhouse")
public class GreenhouseController {
    private final GreenhouseService greenhouseService;
    public GreenhouseController(GreenhouseService greenhouseService){
        this.greenhouseService = greenhouseService;
    }
    @GetMapping("/{id}")
    public GreenhouseResponse getGreenhouse(@PathVariable Long id){
        return greenhouseService.getGreenhouse(id);
    }
}
