package com.example.Login.controller;

import com.example.Login.model.*;
import com.example.Login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin-details")
    public ResponseEntity<?> saveAdminDetails(@RequestParam String email, @RequestBody AdminDetails adminDetails) {
        try {
            User updatedUser = userService.saveAdminDetails(email, adminDetails);
            return updatedUser != null ?
                    ResponseEntity.ok(updatedUser) :
                    ResponseEntity.badRequest().body("User not found");
        } catch (Exception e) {
            return errorResponse("Error saving admin details", e);
        }
    }

    @PostMapping("/resident-details")
    public ResponseEntity<?> saveResidentDetails(@RequestParam String email, @RequestBody ResidentDetails residentDetails) {
        try {
            User updatedUser = userService.saveResidentDetails(email, residentDetails);
            return updatedUser != null ?
                    ResponseEntity.ok(updatedUser) :
                    ResponseEntity.badRequest().body("User not found");
        } catch (Exception e) {
            return errorResponse("Error saving resident details", e);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return errorResponse("Error fetching users", e);
        }
    }

    @GetMapping("/residents")
    public ResponseEntity<?> getResidents() {
        try {
            return ResponseEntity.ok(userService.getUsersByRole("RESIDENT"));
        } catch (Exception e) {
            return errorResponse("Error fetching residents", e);
        }
    }

    @GetMapping("/residents/block/{block}")
    public ResponseEntity<?> getResidentsByBlock(@PathVariable String block) {
        try {
            return ResponseEntity.ok(userService.getResidentsByBlock(block));
        } catch (Exception e) {
            return errorResponse("Error fetching residents by block", e);
        }
    }

    private ResponseEntity<String> errorResponse(String message, Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message + ": " + e.getMessage());
    }

    @GetMapping("/resident")
    public ResponseEntity<?> getResident(@RequestParam String email) {
        try {
            User resident = userService.getResidentByEmail(email);
            return ResponseEntity.ok(resident);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/resident-details")
    public ResponseEntity<?> updateResidentDetails(
            @RequestParam String email,
            @RequestBody ResidentDetailsUpdateRequest residentDetails) {  // Changed parameter type
        try {
            User updatedUser = userService.updateResidentDetails(email, residentDetails);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}