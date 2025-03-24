package com.airport.airport.controller;

import com.airport.airport.model.Passenger;
import com.airport.airport.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable String id) {
        if (!passengerService.ExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        return ResponseEntity.ok(passengerService.savePassenger(passenger));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable String id, @RequestBody Passenger passenger) {
        if (!passengerService.ExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerService.updatePassenger(id, passenger));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable String id) {
        if (!passengerService.ExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        passengerService.deletePassenger(id);
        return ResponseEntity.ok("Passenger deleted");
    }
}
