package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.models.Plant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/greenhouse")
public class GreenhouseController {
    @GetMapping("/")
    public String index() {
        return "Greenhouse controller";
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Greenhouse controller initialized");
        };
    }

}
