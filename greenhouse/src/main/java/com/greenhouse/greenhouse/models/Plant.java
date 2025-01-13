package com.greenhouse.greenhouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Plant(){}

    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
}
