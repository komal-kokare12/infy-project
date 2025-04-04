package com.example.service;

import com.example.model.Complaint;
import java.util.List;

public interface ComplaintService {
    List<Complaint> getAllComplaints();
    Complaint createComplaint(Complaint complaint);
    List<Complaint> getComplaintsByUserEmail(String email);
    Complaint updateComplaintStatus(String id, String status);
    long countSolvedComplaints();
    long countPendingComplaints();
    long countComplaintsByBlock(String block);
}