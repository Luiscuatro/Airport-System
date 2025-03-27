package com.airport.airport.service;

import com.airport.airport.model.Passenger;
import com.airport.airport.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(String id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(String id) {
        passengerRepository.deleteById(id);
    }

    public boolean existsById(String id) {
        return passengerRepository.existsById(id);
    }

    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

}
