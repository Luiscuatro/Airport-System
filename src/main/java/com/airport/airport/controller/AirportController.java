package com.airport.airport.controller;

import com.airport.airport.model.Airport;
import com.airport.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable String id) {
        return airportService.getAirportById(id).orElse(null);
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.saveAirport(airport);
    }

    @DeleteMapping("/{id}")
    public String deleteAirport(@PathVariable String id) {
        airportService.deleteAirport(id);
        return "Airport deleted";
    }
}