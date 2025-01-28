package com.greenhouse.greenhouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GreenhouseStatus {
    @Id
    private Long id = 1L;
    private double temperature;
    private double humidity;
    private Status status;

    public GreenhouseStatus () {
    }

    public Status getStatus () {
        return status;
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    public double getTemperature () {
        return temperature;
    }

    public void setTemperature (double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity () {
        return humidity;
    }

    public void setHumidity (double humidity) {
        this.humidity = humidity;
    }

}
