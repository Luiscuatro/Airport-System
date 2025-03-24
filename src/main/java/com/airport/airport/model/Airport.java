package com.airport.airport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    private String id;

    private String name;
    private String location;
    private String city;
    private String country;
    private String code;

    @OneToMany(mappedBy = "current_airport")
    @JsonIgnore
    private Set<Plane> planes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "airport_passenger",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    @JsonIgnore
    private Set<Passenger> passengers = new HashSet<>();
}
