package com.example.controller;

import com.example.model.ParkingSpace;
import com.example.model.ParkingStats;
import com.example.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingRepository parkingRepository;

    @GetMapping
    public ResponseEntity<List<ParkingSpace>> getAllParkingSpaces() {
        return ResponseEntity.ok(parkingRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ParkingSpace> addParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        return ResponseEntity.ok(parkingRepository.save(parkingSpace));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpace(@PathVariable String id) {
        parkingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, ParkingStats>> getParkingStats() {
        List<ParkingSpace> allSpaces = parkingRepository.findAll();
        Map<String, ParkingStats> stats = new HashMap<>();

        // Calculate stats per block
        allSpaces.stream()
                .map(ParkingSpace::getBlock)
                .distinct()
                .forEach(block -> {
                    List<ParkingSpace> blockSpaces = allSpaces.stream()
                            .filter(space -> space.getBlock().equals(block))
                            .collect(Collectors.toList());

                    long occupied = blockSpaces.stream().filter(ParkingSpace::isOccupied).count();
                    stats.put(block, new ParkingStats(
                            blockSpaces.size(),
                            (int) occupied,
                            (int) (blockSpaces.size() - occupied),
                            (int) ((occupied * 100) / blockSpaces.size())
                    ));
                });

        // Calculate overall stats
        long totalOccupied = allSpaces.stream().filter(ParkingSpace::isOccupied).count();
        stats.put("all", new ParkingStats(
                allSpaces.size(),
                (int) totalOccupied,
                (int) (allSpaces.size() - totalOccupied),
                (int) ((totalOccupied * 100) / allSpaces.size())
        ));

        return ResponseEntity.ok(stats);
    }
}