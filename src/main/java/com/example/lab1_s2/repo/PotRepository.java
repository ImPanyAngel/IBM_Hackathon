package com.example.lab1_s2.repo;

import com.example.lab1_s2.model.Pot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PotRepository extends JpaRepository<Pot, Long> {
    // Custom query to find pots by userId
    List<Pot> findByUserId(Long userId);  // Finds all pots associated with a specific user ID
}
