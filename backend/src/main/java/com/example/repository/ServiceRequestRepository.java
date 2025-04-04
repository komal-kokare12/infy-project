package com.example.repository;

import com.example.model.ServiceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
    List<ServiceRequest> findByServiceType(String serviceType);
    List<ServiceRequest> findByName(String name); // 🔹 Fetch service requests by name
}
