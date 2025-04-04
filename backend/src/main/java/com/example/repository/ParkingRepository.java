package com.example.repository;

import com.example.model.ParkingSpace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParkingRepository extends MongoRepository<ParkingSpace, String> {
    List<ParkingSpace> findByBlock(String block);
    List<ParkingSpace> findByParkingIdContainingOrResidentNameContaining(String parkingId, String residentName);
}