package com.airport.airport.controller;

import com.airport.airport.model.Plane;
import com.airport.airport.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    public ResponseEntity<List<Plane>> getAllPlanes() {
        List<Plane> planes = planeService.getAllPlanes();
        return ResponseEntity.ok(planes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable String id) {
        return planeService.getPlaneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
        Plane created = planeService.savePlane(plane);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlane(@PathVariable String id) {
        boolean deleted = planeService.deletePlane(id);
        if (deleted) {
            return ResponseEntity.ok("Plane deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
