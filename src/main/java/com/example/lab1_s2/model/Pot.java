package com.example.lab1_s2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Pot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User
    private User user;

    private String potName; // e.g., "Rent", "Savings", "Food"

    @Column(precision = 19, scale = 2, nullable = false) // Ensures correct precision
    private BigDecimal currentBalance = BigDecimal.ZERO; // Default balance

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getPotName() {
        return potName;
    }

    public void setPotName(String potName) {
        this.potName = potName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
