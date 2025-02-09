package com.example.lab1_s2.service;

import com.example.lab1_s2.model.Payment;
import com.example.lab1_s2.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    // Create a new payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // Update a payment
    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        payment.setAmount(paymentDetails.getAmount());
        payment.setReceivedDate(paymentDetails.getReceivedDate());
        payment.setIncomeStream(paymentDetails.getIncomeStream());
        return paymentRepository.save(payment);
    }

    // Delete payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }


    // Receive a payment and save it in the database
    public Payment receivePayment(Payment payment) {
        // You can add any business logic here (e.g., splitting the payment into different pots)

        // Save the payment in the repository
        return paymentRepository.save(payment);
    }
}
