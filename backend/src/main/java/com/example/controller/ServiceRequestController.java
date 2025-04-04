package com.example.controller;

import com.example.model.ServiceRequest;
import com.example.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service-requests")
@CrossOrigin(origins = "http://localhost:5173/") // Adjust if needed

public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    // Create a new service request
    @PostMapping("/add-services")
    public ServiceRequest addServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return serviceRequestService.saveServiceRequest(serviceRequest);
    }

    // Fetch all service requests
    @GetMapping("/all-services")
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestService.getAllServiceRequests();
    }

    // Fetch a service request by ID
    @GetMapping("/{id}")
    public Optional<ServiceRequest> getServiceRequestById(@PathVariable String id) {
        return serviceRequestService.getServiceRequestById(id);
    }

    // Fetch service requests by service type
    @GetMapping("/type/{serviceType}")
    public List<ServiceRequest> getServiceRequestsByType(@PathVariable String serviceType) {
        return serviceRequestService.getServiceRequestsByType(serviceType);
    }

    // 🔹 Fetch service request by name
    @GetMapping("/name/{name}")
    public List<ServiceRequest> getServiceRequestsByName(@PathVariable String name) {
        return serviceRequestService.getServiceRequestsByName(name);
    }

    // Add this new endpoint for approving requests
    @PatchMapping("/{id}/approve")
    public ResponseEntity<ServiceRequest> approveServiceRequest(
            @PathVariable String id,
            @RequestParam(required = false) String adminNotes) {

        ServiceRequest approvedRequest = serviceRequestService.approveServiceRequest(id, adminNotes);
        return ResponseEntity.ok(approvedRequest);
    }

    // Add this endpoint for rejecting requests
    @PatchMapping("/{id}/reject")
    public ResponseEntity<ServiceRequest> rejectServiceRequest(
            @PathVariable String id,
            @RequestParam(required = false) String rejectionReason) {

        ServiceRequest rejectedRequest = serviceRequestService.rejectServiceRequest(id, rejectionReason);
        return ResponseEntity.ok(rejectedRequest);
    }

}
