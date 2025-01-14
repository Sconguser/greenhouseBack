package com.greenhouse.greenhouse.requests;

public class PlantRequest {
    private String name;
    private String description;
    private int required_temperature;
    private int required_humidity;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequired_temperature() {
        return required_temperature;
    }

    public void setRequired_temperature(int required_temperature) {
        this.required_temperature = required_temperature;
    }

    public int getRequired_humidity() {
        return required_humidity;
    }

    public void setRequired_humidity(int required_humidity) {
        this.required_humidity = required_humidity;
    }
}
