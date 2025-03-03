package com.airport.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {
    @Id
    private String id;
    private String name;
    private String passportNumber;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
}