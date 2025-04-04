package com.example.repository;

import com.example.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {
    List<Vendor> findAllByOrderBySerialNoAsc(); // Fetch vendors in serial order
    List<Vendor> findByService(String service); // Find vendors by service
}
