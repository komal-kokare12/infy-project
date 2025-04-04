package com.example.service;
import com.example.model.Guard;
import com.example.repository.GuardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardService {

    private final GuardRepository guardRepository;

    @Autowired
    public GuardService(GuardRepository guardRepository) {
        this.guardRepository = guardRepository;
    }

    // Get All Guards
    public List<Guard> getAllGuards() {
        return guardRepository.findAll();
    }

    // Add a New Guard
    public Guard addGuard(Guard guard) {
        return guardRepository.save(guard);
    }

    // Get Guard by ID
    public Optional<Guard> getGuardById(String id) {
        return guardRepository.findById(id);
    }

    // Delete Guard by ID
    public void deleteGuard(String id) {
        guardRepository.deleteById(id);
    }
}
