package com.example.lab1_s2.repo;

import com.example.lab1_s2.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
