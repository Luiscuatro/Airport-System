package com.airport.airport.controller;

import com.airport.airport.model.Airport;
import com.airport.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String id) {
        if (airportService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.saveAirport(airport));
    }

    @PutMapping
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport) {
        if (!airportService.existsById(airport.getId())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airportService.updateAirport(airport));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable String id) {
        if (airportService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        airportService.deleteAirport(id);
        return ResponseEntity.ok("Airport deleted");
    }
}
