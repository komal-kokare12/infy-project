package com.example.repository;

import com.example.model.ParkingSpot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends MongoRepository<ParkingSpot, String> {
}
