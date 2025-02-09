package com.example.lab1_s2.service;

import com.example.lab1_s2.model.Pot;
import com.example.lab1_s2.repo.PotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PotService {

    @Autowired
    private PotRepository potRepository;

    // Create a new pot
    public Pot createPot(Pot pot) {
        return potRepository.save(pot);
    }

    // Get pots for a specific user
    public List<Pot> getPotsByUser(Long userId) {
        return potRepository.findByUserId(userId);  // Query pots by user ID
    }

    // Get pot by ID
    public Optional<Pot> getPotById(Long id) {
        return potRepository.findById(id);
    }

    // Update pot
    public Pot updatePot(Long id, Pot potDetails) {
        Pot pot = potRepository.findById(id).orElseThrow();
        pot.setPotName(potDetails.getPotName());
        pot.setCurrentBalance(potDetails.getCurrentBalance());
        return potRepository.save(pot);
    }

    // Delete pot
    public void deletePot(Long id) {
        potRepository.deleteById(id);
    }

}
