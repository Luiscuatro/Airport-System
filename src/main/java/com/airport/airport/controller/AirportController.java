package com.airport.airport.controller;

import com.airport.airport.model.Airport;
import com.airport.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable String id) {
        return airportRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable String id, @RequestBody Airport airport) {
        if (!airportRepository.existsById(id)) {
            return null;
        }
        airport.setId(id);
        return airportRepository.save(airport);
    }

    @DeleteMapping("/{id}")
    public String deleteAirport(@PathVariable String id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return "Airport deleted";
        }
        return "Airport not found";
    }

    @DeleteMapping
    public String deleteAllAirports() {
        airportRepository.deleteAll();
        return "All airports deleted";
    }
}
