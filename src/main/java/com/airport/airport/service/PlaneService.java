package com.airport.airport.service;

import com.airport.airport.model.Plane;
import com.airport.airport.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public Optional<Plane> getPlaneById(String id) {
        return planeRepository.findById(id);
    }

    public Plane savePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public void deletePlane(String id) {
        planeRepository.deleteById(id);
    }
}