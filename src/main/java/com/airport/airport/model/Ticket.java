package com.airport.airport.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String seatNumber;
    private String flightNumber;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String gate;
    private String boardingGroup;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;
}
