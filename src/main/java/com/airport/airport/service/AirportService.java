package com.airport.airport.service;

import com.airport.airport.model.Airport;
import com.airport.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(String id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteAirport(String id) {
        airportRepository.deleteById(id);
    }

    public boolean existsById(String id) {
        return airportRepository.existsById(id);
    }


    public Airport updateAirport(String id, Airport airportDetails) {
        airportDetails.setId(id);
        return airportRepository.save(airportDetails);
    }
}
