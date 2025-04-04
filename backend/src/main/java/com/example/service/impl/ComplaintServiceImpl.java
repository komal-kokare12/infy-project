package com.example.service.impl;

import com.example.model.Complaint;
import com.example.repository.ComplaintRepository;
import com.example.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Complaint createComplaint(Complaint complaint) {
        complaint.setStatus("Pending"); // Default status
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsByUserEmail(String email) {
        return complaintRepository.findByEmailOrderByCreatedAtDesc(email);
    }

    @Override
    public Complaint updateComplaintStatus(String id, String status) {
        return complaintRepository.findById(id)
                .map(complaint -> {
                    complaint.setStatus(status);
                    return complaintRepository.save(complaint);
                })
                .orElseThrow(() -> new RuntimeException("Complaint not found with id: " + id));
    }

    @Override
    public long countSolvedComplaints() {
        return complaintRepository.countByStatus("Solved");
    }

    @Override
    public long countPendingComplaints() {
        return complaintRepository.countByStatus("Pending");
    }

    @Override
    public long countComplaintsByBlock(String block) {
        return complaintRepository.countByBlock(block);
    }
}