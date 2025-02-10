package com.airport.airport.controller;

import com.airport.airport.model.Passenger;
import com.airport.airport.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable String id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable String id, @RequestBody Passenger passenger) {
        if (!passengerRepository.existsById(id)) {
            return null;
        }
        passenger.setId(id);
        return passengerRepository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable String id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return "Passenger deleted";
        }
        return "Passenger not found";
    }

    @DeleteMapping
    public String deleteAllPassengers() {
        passengerRepository.deleteAll();
        return "All passengers deleted";
    }
}
