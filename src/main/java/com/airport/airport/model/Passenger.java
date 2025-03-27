package com.airport.airport.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String passportNumber;
    private String email;
    private String phoneNumber;
    private String nationality;
    private LocalDate birthDate;
    private String gender;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "passengers")
    private Set<Plane> planes = new HashSet<>();
}
