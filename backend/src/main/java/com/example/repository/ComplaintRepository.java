package com.example.repository;

import com.example.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ComplaintRepository extends MongoRepository<Complaint, String> {
    List<Complaint> findByEmailOrderByCreatedAtDesc(String email);
    List<Complaint> findAllByOrderByCreatedAtDesc();
    long countByStatus(String status);
    long countByBlock(String block);
}