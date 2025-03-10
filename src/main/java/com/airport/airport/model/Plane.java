package com.airport.airport.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Plane {
    @Id
    private String id;
    private String model;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "CURRENT_AIRPORT_FK")
    private Airport current_airport;

    @ManyToMany(mappedBy = "planes")
    private Set<Passenger> passengers = new HashSet<>();



    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Airport getAirport() {
        return current_airport;
    }

    public void setAirport(Airport airport) {
        this.current_airport = airport;
    }

    public Set<Passenger> getPassengers() { return passengers; }
    public void setPassengers(Set<Passenger> passengers) { this.passengers = passengers; }

}
