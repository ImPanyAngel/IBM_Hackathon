package com.example.lab1_s2.repo;

import com.example.lab1_s2.model.IncomeStream;
import com.example.lab1_s2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeStreamRepository extends JpaRepository<IncomeStream, Long> {

    // Finds all IncomeStreams associated with a specific user
    List<IncomeStream> findByUser(User user);
}
