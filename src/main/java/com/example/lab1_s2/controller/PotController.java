package com.example.lab1_s2.controller;

import com.example.lab1_s2.model.Pot;
import com.example.lab1_s2.service.PotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pots")
public class PotController {
    @Autowired
    private PotService potService;

    // Get all pots for a user
    @GetMapping
    public List<Pot> getPots(@PathVariable Long  userId) {
        return potService.getPotsByUser(userId);
    }

    // Create a new pot
    @PostMapping
    public void createPot(@RequestBody Pot pot) {
        potService.createPot(pot);
    }

    // Update an existing pot
    @PutMapping("/{id}")
    public void updatePot(@PathVariable Long id, @RequestBody Pot pot) {
        potService.updatePot(id, pot);
    }

    // Delete a pot
    @DeleteMapping("/{id}")
    public void deletePot(@PathVariable Long id) {
        potService.deletePot(id);
    }

}
