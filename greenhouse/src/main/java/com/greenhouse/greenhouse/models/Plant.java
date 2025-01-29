package com.greenhouse.greenhouse.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int requiredTemperature;
    private int requiredHumidity;

    @Lob
    @Column
    private byte[] imageData;
    @ManyToMany(mappedBy = "plants")
    private List<Greenhouse> greenhouses;


    public Plant() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequiredTemperature () {
        return requiredTemperature;
    }

    public void setRequiredTemperature (int requiredTemperature) {
        this.requiredTemperature = requiredTemperature;
    }

    public int getRequiredHumidity () {
        return requiredHumidity;
    }

    public void setRequiredHumidity (int requiredHumidity) {
        this.requiredHumidity = requiredHumidity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageData () {
        return imageData;
    }

    public void setImageData (byte[] imageData) {
        this.imageData = imageData;
    }
}
