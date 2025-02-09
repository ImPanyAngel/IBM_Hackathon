package com.example.lab1_s2.controller;


import com.example.lab1_s2.model.AllocationRule;
import com.example.lab1_s2.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class AllocationRuleController {
    @Autowired
    private AllocationRuleService allocationRuleService;

    // Get all allocation rules for a user
    @GetMapping
    public List<AllocationRule> getAllocations(@RequestParam Long userId) {
        return allocationRuleService.getAllocationRulesByUser(userId);
    }

    // Create a new allocation rule
    @PostMapping
    public void createAllocation(@RequestBody AllocationRule allocationRule) {
        allocationRuleService.createAllocationRule(allocationRule);
    }

    // Update an existing allocation rule
    @PutMapping("/{id}")
    public void updateAllocation(@PathVariable Long id, @RequestBody AllocationRule allocationRule) {
        allocationRuleService.updateAllocationRule(id, allocationRule);
    }

    // Delete an allocation rule
    @DeleteMapping("/{id}")
    public void deleteAllocation(@PathVariable Long id) {
        allocationRuleService.deleteAllocationRule(id);
    }
}
