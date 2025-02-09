package com.example.lab1_s2.controller;

import com.example.lab1_s2.model.IncomeStream;
import com.example.lab1_s2.model.User;
import com.example.lab1_s2.service.IncomeStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomeStreams")
public class IncomeStreamController {

    @Autowired
    private IncomeStreamService incomeStreamService;

    // Create a new income stream
    @PostMapping
    public void createIncomeStream(@RequestBody IncomeStream incomeStream) {
        incomeStreamService.saveIncomeStream(incomeStream);
    }

    // Update an existing income stream
    @PutMapping("/{id}")
    public void updateIncomeStream(@PathVariable Long id, @RequestBody IncomeStream incomeStream) {
        incomeStreamService.updateIncomeStream(id, incomeStream);
    }

    //Delete an income stream
    @DeleteMapping("/{id}")
    public void deleteIncomeStream(@PathVariable Long id) {
        incomeStreamService.deleteIncomeStream(id);
    }

    // Get all income streams for a user
    @GetMapping("/user/{userId}")
    public List<IncomeStream> getIncomeStreamsByUser(@PathVariable Long userId) {
        User user = new User();  // Assuming you retrieve user by ID from DB, or authentication context
        user.setId(userId);
        return incomeStreamService.getIncomeStreamsByUser(user);
    }
}
