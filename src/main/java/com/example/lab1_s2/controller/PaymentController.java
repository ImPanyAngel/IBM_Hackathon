package com.example.lab1_s2.controller;


import com.example.lab1_s2.model.Payment;
import com.example.lab1_s2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Handle receiving a payment and triggering allocation
    @PostMapping
    public void receivePayment(@RequestBody Payment payment) {
        paymentService.receivePayment(payment);
    }
}
