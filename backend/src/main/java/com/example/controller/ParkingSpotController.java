package com.example.controller;

import com.example.model.ParkingSpot;
import com.example.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
@CrossOrigin(origins = "http://localhost:5173") // Enable for React Frontend
public class ParkingSpotController {
    private final ParkingSpotService service;

    @Autowired
    public ParkingSpotController(ParkingSpotService service) {
        this.service = service;
    }

    // Get All Parking Spots
    @GetMapping
    public List<ParkingSpot> getAllParkingSpots() {
        return service.getAllParkingSpots();
    }

    // Add New Parking Spot
    @PostMapping
    public ParkingSpot addParkingSpot(@RequestBody ParkingSpot spot) {
        return service.addParkingSpot(spot);
    }

    // Get Parking Spot by ID
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpot> getParkingSpotById(@PathVariable String id) {
        Optional<ParkingSpot> spot = service.getParkingSpotById(id);
        return spot.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Parking Spot by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParkingSpot(@PathVariable String id) {
        service.deleteParkingSpot(id);
        return ResponseEntity.ok("Parking spot deleted successfully.");
    }
}
