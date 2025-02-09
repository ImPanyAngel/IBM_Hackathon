package com.example.lab1_s2.service;


import com.example.lab1_s2.model.AllocationRule;
import com.example.lab1_s2.repo.AllocationRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationRuleService {

    @Autowired
    private AllocationRuleRepository allocationRuleRepository;

    // Create a new allocation rule
    public AllocationRule createAllocationRule(AllocationRule allocationRule) {
        return allocationRuleRepository.save(allocationRule);
    }

    // Get all allocation rules
    public List<AllocationRule> getAllAllocationRules() {
        return allocationRuleRepository.findAll();
    }

    // Fetch allocation rules by userId
    public List<AllocationRule> getAllocationRulesByUser(Long userId) {
        return allocationRuleRepository.findByUserId(userId);  // Using the custom repository method
    }

    // Update allocation rule
    public AllocationRule updateAllocationRule(Long id, AllocationRule allocationRuleDetails) {
        AllocationRule allocationRule = allocationRuleRepository.findById(id).orElseThrow();
        allocationRule.setPercentage(allocationRuleDetails.getPercentage());
        allocationRule.setPot(allocationRuleDetails.getPot());
        return allocationRuleRepository.save(allocationRule);
    }

    // Delete allocation rule
    public void deleteAllocationRule(Long id) {
        allocationRuleRepository.deleteById(id);
    }
}
