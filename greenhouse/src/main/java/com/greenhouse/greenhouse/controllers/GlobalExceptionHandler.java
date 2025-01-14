package com.greenhouse.greenhouse.controllers;

import com.greenhouse.greenhouse.controllers.exceptions.ErrorMessage;
import com.greenhouse.greenhouse.controllers.exceptions.PlantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PlantNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePlantNotFoundException(PlantNotFoundException plantNotFoundException, WebRequest request) {
        return composeResponse(plantNotFoundException, request, HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ErrorMessage> composeResponse(Exception ex, WebRequest request, HttpStatus status) {
        ErrorMessage message = new ErrorMessage(
                status.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(message, status);
    }

}
