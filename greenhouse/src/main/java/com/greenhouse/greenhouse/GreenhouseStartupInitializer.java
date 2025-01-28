package com.greenhouse.greenhouse;

import com.greenhouse.greenhouse.models.GreenhouseStatus;
import com.greenhouse.greenhouse.models.Status;
import com.greenhouse.greenhouse.repositories.GreenhouseStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GreenhouseStartupInitializer implements CommandLineRunner {
    @Autowired
    private GreenhouseStatusRepository greenhouseStatusRepository;

    @Override
    public void run (String... args) {
        if (greenhouseStatusRepository.count() == 0) {
            double temperature = 100; /// TODO: fetch from RaspberryPI
            double humidity = 100; /// TODO: fetch from Raspberry
            Status status = Status.ON; /// TODO: fetch from Raspberry
            GreenhouseStatus greenhouseStatus = new GreenhouseStatus();
            greenhouseStatus.setTemperature(temperature);
            greenhouseStatus.setHumidity(humidity);
            greenhouseStatus.setStatus(status);
            greenhouseStatusRepository.save(greenhouseStatus);
            System.out.println("Greenhouse status initialized");
        }
    }
}
