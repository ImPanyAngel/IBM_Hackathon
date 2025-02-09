package com.example.lab1_s2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Links to User entity
    private User user;

    @ManyToOne
    @JoinColumn(name = "income_stream_id", nullable = false) // Foreign key to IncomeStream
    private IncomeStream incomeStream;

    @Column(precision = 19, scale = 2, nullable = false) // Ensures precision for money
    private BigDecimal amount;

    private LocalDate receivedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public IncomeStream getIncomeStream() {
        return incomeStream;
    }

    public void setIncomeStream(IncomeStream incomeStream) {
        this.incomeStream = incomeStream;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
