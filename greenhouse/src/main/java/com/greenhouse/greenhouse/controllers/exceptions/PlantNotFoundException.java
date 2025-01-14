package com.greenhouse.greenhouse.controllers.exceptions;

public class PlantNotFoundException extends RuntimeException{
    public PlantNotFoundException(String message){
        super(message);
    }
}
