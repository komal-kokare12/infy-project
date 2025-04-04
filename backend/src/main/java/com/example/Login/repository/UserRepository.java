package com.example.Login.repository;

import com.example.Login.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    List<User> findAll();
    List<User> findByRole(String role);
    List<User> findByRoleIgnoreCase(String role);

    // Remove this unless you've added @DocumentReference or proper mapping
    // List<User> findByRoleAndResidentDetailsBlock(String role, String block);

    // Or implement with @Query if needed
    @Query("{ 'role': ?0, 'residentDetails.block': ?1 }")
    List<User> findByRoleAndBlock(String role, String block);
}