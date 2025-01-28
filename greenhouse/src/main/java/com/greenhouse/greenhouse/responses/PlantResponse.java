package com.greenhouse.greenhouse.responses;

public class PlantResponse {
    private Long id;
    private String name;
    private String description;
    private int required_temperature;
    private int required_humidity;
    private String image_data_base64;

    public PlantResponse(Long id, String name, String description, int required_temperature, int required_humidity,
                         String image_data_base64)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.required_temperature = required_temperature;
        this.required_humidity = required_humidity;
        this.image_data_base64 = image_data_base64;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getImage_data_base64() {
        return image_data_base64;
    }

    public void setImage_data_base64(String image_data_base64) {
        this.image_data_base64 = image_data_base64;
    }

}
