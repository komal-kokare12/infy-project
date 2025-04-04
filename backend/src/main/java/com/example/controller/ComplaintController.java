package com.example.controller;

import com.example.model.Complaint;
import com.example.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class ComplaintController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        return ResponseEntity.ok(complaintService.createComplaint(complaint));
    }

    @GetMapping("/user")
    public ResponseEntity<List<Complaint>> getUserComplaints(@RequestParam String email) {
        return ResponseEntity.ok(complaintService.getComplaintsByUserEmail(email));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Complaint> updateComplaintStatus(
            @PathVariable String id,
            @RequestBody Map<String, String> statusUpdate) {
        return ResponseEntity.ok(
                complaintService.updateComplaintStatus(id, statusUpdate.get("status"))
        );
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getComplaintStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("total", (long) complaintService.getAllComplaints().size());
        stats.put("solved", complaintService.countSolvedComplaints());
        stats.put("pending", complaintService.countPendingComplaints());
        stats.put("blockA", complaintService.countComplaintsByBlock("A"));
        stats.put("blockB", complaintService.countComplaintsByBlock("B"));

        return ResponseEntity.ok(stats);
    }

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/**")
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }

}