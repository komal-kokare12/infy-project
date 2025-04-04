package com.example.Login.service;

import com.example.Login.model.*;
import com.example.Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User details cannot be null");
        }
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.filter(user -> user.getPassword().equals(password)).orElse(null);
    }

    public User saveAdminDetails(String email, AdminDetails adminDetails) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    user.setAdminDetails(adminDetails);
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    public User saveResidentDetails(String email, ResidentDetails residentDetails) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    user.setResidentDetails(residentDetails);
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRoleIgnoreCase(role);
    }

    public List<User> getResidentsByBlock(String block) {
        return userRepository.findByRoleAndBlock("RESIDENT", block);
    }

    public User updateResidentDetails(String email, ResidentDetailsUpdateRequest updateRequest) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ResidentDetails details = user.getResidentDetails();
        if (details == null) {
            details = new ResidentDetails();
            user.setResidentDetails(details);
        }

        if (updateRequest.getName() != null) {
            details.setName(updateRequest.getName());
        }
        if (updateRequest.getBlock() != null) {
            details.setBlock(updateRequest.getBlock());
        }
        if (updateRequest.getFlatNo() != null) {
            details.setFlatNo(updateRequest.getFlatNo());
        }
        if (updateRequest.getPhone() != null) {
            details.setPhone(updateRequest.getPhone());
        }

        return userRepository.save(user);
    }

    // Add these methods to your UserService class
    public User getResidentByEmail(String email) {
        return userRepository.findByEmail(email)
                .filter(user -> "RESIDENT".equals(user.getRole()))
                .orElseThrow(() -> new RuntimeException("Resident not found with email: " + email));
    }

}