package com.airport.airport.controller;

import com.airport.airport.model.Plane;
import com.airport.airport.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneRepository planeRepository;

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plane getPlaneById(@PathVariable String id) {
        return planeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeRepository.save(plane);
    }

    @PutMapping("/{id}")
    public Plane updatePlane(@PathVariable String id, @RequestBody Plane plane) {
        if (!planeRepository.existsById(id)) {
            return null;
        }
        plane.setId(id);
        return planeRepository.save(plane);
    }

    @DeleteMapping("/{id}")
    public String deletePlane(@PathVariable String id) {
        if (planeRepository.existsById(id)) {
            planeRepository.deleteById(id);
            return "Plane deleted";
        }
        return "Plane not found";
    }

    @DeleteMapping
    public String deleteAllPlanes() {
        planeRepository.deleteAll();
        return "All planes deleted";
    }
}
