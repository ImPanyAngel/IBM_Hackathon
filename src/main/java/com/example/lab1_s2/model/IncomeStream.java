package com.example.lab1_s2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class IncomeStream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne// Many payments can belong to one user
    @JoinColumn(name = "user_id", nullable = false) // Defines the foreign key column
    private User user;


    private String sourceName;  // Student Loan , Part-Time Job
    private String frequency;  // "Weekly" , "biweekly"

    private LocalDate expectedPaymentDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getExpectedPaymentDate() {
        return expectedPaymentDate;
    }

    public void setExpectedPaymentDate(LocalDate expectedPaymentDate) {
        this.expectedPaymentDate = expectedPaymentDate;
    }





}
