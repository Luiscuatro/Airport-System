package com.airport.airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Airport {
    @Id
    private String id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "current_airport")
    private Set<Plane> planes;

    @ManyToMany
    @JoinTable(
            name = "airport_passenger",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private Set<Passenger> passengers = new HashSet<>();



    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }
}