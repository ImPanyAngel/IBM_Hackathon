package com.example.lab1_s2.service;

import com.example.lab1_s2.model.IncomeStream;
import com.example.lab1_s2.model.User;
import com.example.lab1_s2.repo.IncomeStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeStreamService {

    @Autowired
    private IncomeStreamRepository ISRepo;

    public IncomeStream createIncomeStream(IncomeStream incomeStream) {
        return ISRepo.save(incomeStream);
    }

    public List<IncomeStream> getIncomeStreamsByUser(User user) {
        return ISRepo.findByUser(user);
    }

    // Save a new income stream
    public void saveIncomeStream(IncomeStream incomeStream) {
        ISRepo.save(incomeStream);
    }

    // Update an existing income stream
    public void updateIncomeStream(Long id, IncomeStream updatedIncomeStream) {
        Optional<IncomeStream> existingIncomeStreamOpt = ISRepo.findById(id);
        if (existingIncomeStreamOpt.isPresent()) {
            IncomeStream existingIncomeStream = existingIncomeStreamOpt.get();
            existingIncomeStream.setSourceName(updatedIncomeStream.getSourceName());
            existingIncomeStream.setFrequency(updatedIncomeStream.getFrequency());
            existingIncomeStream.setExpectedPaymentDate(updatedIncomeStream.getExpectedPaymentDate());
            ISRepo.save(existingIncomeStream);
        }
    }

    // Delete an income stream
    public void deleteIncomeStream(Long id) {
        ISRepo.deleteById(id);
    }
}
