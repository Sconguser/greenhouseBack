package com.greenhouse.greenhouse.requests;

public class PlantRequest {
    private String name;
    private String description;
    private Integer required_temperature;
    private Integer required_humidity;
    private String image_data_base64;


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

    public Integer getRequired_temperature() {
        return required_temperature;
    }

    public void setRequired_temperature(int required_temperature) {
        this.required_temperature = required_temperature;
    }

    public Integer getRequired_humidity() {
        return required_humidity;
    }

    public void setRequired_humidity(int required_humidity) {
        this.required_humidity = required_humidity;
    }

    public String getImage_data() {
        return image_data_base64;
    }

    public void setImage_data(String image_data_base64) {
        this.image_data_base64 = image_data_base64;
    }
}
