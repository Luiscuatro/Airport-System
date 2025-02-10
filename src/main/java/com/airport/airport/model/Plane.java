package com.airport.airport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plane {
    @Id
    private String id;
    private String model;
    private int capacity;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}

