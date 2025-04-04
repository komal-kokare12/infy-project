package com.example.repository;

import com.example.model.Guard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardRepository extends MongoRepository<Guard, String> {
}
