package com.airport.airport.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public Plane getPlane() { return plane; }
    public void setPlane(Plane plane) { this.plane = plane; }
}