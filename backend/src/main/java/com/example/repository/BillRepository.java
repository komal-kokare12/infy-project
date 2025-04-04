package com.example.repository;//package com.example.repository;
//
//import com.example.model.Bill;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import java.util.List;
//
//public interface BillRepository extends MongoRepository<Bill, String> {
//    List<Bill> findByResidentId(String residentId);
//    List<Bill> findByResidentIdAndPaid(String residentId, boolean paid);
//}

import com.example.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BillRepository extends MongoRepository<Bill, String> {
    List<Bill> findByResidentId(String residentId);
    List<Bill> findByResidentIdAndPaid(String residentId, boolean paid);
}