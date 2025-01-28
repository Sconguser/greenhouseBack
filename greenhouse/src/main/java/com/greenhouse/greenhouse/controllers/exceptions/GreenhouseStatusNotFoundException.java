package com.greenhouse.greenhouse.controllers.exceptions;

public class GreenhouseStatusNotFoundException extends RuntimeException{
    public GreenhouseStatusNotFoundException(String message){
        super(message);
    }
}
