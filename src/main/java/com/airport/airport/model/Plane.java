package com.airport.airport.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {

    @Id
    private String id;

    private String model;
    private int capacity;
    private String manufacturer;
    private int year;
    private String status;
    private int rangeKm;

    @ManyToMany
    @JoinTable(
            name = "plane_airport",
            joinColumns = @JoinColumn(name = "plane_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;
}
