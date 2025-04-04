package com.example.controller;


import com.example.model.Guard;
import com.example.service.GuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guards")
@CrossOrigin(origins = "http://localhost:5173/") 
public class GuardController {

    private final GuardService guardService;

    @Autowired
    public GuardController(GuardService guardService) {
        this.guardService = guardService;
    }

    // Get All Guards
    @GetMapping
    public List<Guard> getAllGuards() {
        return guardService.getAllGuards();
    }

    // Add a New Guard
    @PostMapping
    public Guard addGuard(@RequestBody Guard guard) {
        return guardService.addGuard(guard);
    }

    // Get Guard by ID
    @GetMapping("/{id}")
    public ResponseEntity<Guard> getGuardById(@PathVariable String id) {
        Optional<Guard> guard = guardService.getGuardById(id);
        return guard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Guard by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuard(@PathVariable String id) {
        guardService.deleteGuard(id);
        return ResponseEntity.ok("Guard deleted successfully.");
    }
}
