package com.example.lab1_s2.repo;

import com.example.lab1_s2.model.AllocationRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationRuleRepository extends JpaRepository<AllocationRule, Long> {
    // Custom query to find allocation rules by userId
    List<AllocationRule> findByUserId(Long userId);  // Find all AllocationRules associated with a userId
}
