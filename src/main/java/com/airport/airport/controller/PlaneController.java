
package com.airport.airport.controller;

import com.airport.airport.model.Plane;
import com.airport.airport.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @GetMapping("/{id}")
    public Plane getPlaneById(@PathVariable String id) {
        return planeService.getPlaneById(id).orElse(null);
    }

    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.savePlane(plane);
    }

    @DeleteMapping("/{id}")
    public String deletePlane(@PathVariable String id) {
        planeService.deletePlane(id);
        return "Plane deleted";
    }
}
