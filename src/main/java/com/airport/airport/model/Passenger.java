package com.airport.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Passenger {
    @Id
    private String id;
    private String name;
    private String passportNumber;

    @ManyToMany(mappedBy = "passengers")
    private Set<Plane> planes = new HashSet<>();



    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public Set<Plane> getPlanes() {
        return planes;
    }
    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }

}