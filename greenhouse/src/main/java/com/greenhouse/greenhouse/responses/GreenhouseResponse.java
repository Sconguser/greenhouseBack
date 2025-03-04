package com.greenhouse.greenhouse.responses;

import com.greenhouse.greenhouse.models.Greenhouse;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseResponse {
    private final Long id;
    private final String name;
    private final String location;
    private final String ipAddress;
    private final List<PlantResponse> plantResponses = new ArrayList<>();
    private final GreenhouseStatusResponse greenhouseStatusResponse;

    public GreenhouseResponse (Long id, String name, String location, String ipAddress,
                               GreenhouseStatusResponse greenhouseStatusResponse)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        this.ipAddress = ipAddress;
        this.greenhouseStatusResponse = greenhouseStatusResponse;
    }

    public GreenhouseResponse (Long id, String name, String location, String ipAddress,
                               GreenhouseStatusResponse greenhouseStatusResponse, List<PlantResponse> plantResponses)
    {
        this(id, name, location, ipAddress, greenhouseStatusResponse);
        this.plantResponses.addAll(plantResponses);
    }

    public GreenhouseResponse (Greenhouse greenhouse) {
        this(greenhouse.getId(), greenhouse.getName(), greenhouse.getLocation(), greenhouse.getIpAddress(),
                new GreenhouseStatusResponse(greenhouse.getStatus()));
    }

    public Long getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getLocation () {
        return location;
    }

    public String getIpAddress () {
        return ipAddress;
    }

    public List<PlantResponse> getPlantResponses () {
        return plantResponses;
    }

    public GreenhouseStatusResponse getGreenhouseStatusResponse () {
        return greenhouseStatusResponse;
    }
}
