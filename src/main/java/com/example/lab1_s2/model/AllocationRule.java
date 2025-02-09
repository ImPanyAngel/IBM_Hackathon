package com.example.lab1_s2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class AllocationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User
    private User user;

    @ManyToOne
    @JoinColumn(name = "income_stream_id", nullable = false) // Foreign key to IncomeStream
    private IncomeStream incomeStream;


    @Column(precision = 5, scale = 2, nullable = false) // Store percentage as decimal (e.g., 25.50%)
    private BigDecimal percentage;

    @ManyToOne
    @JoinColumn(name = "pot_id", nullable = false) // Foreign key to Pot
    private Pot pot;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pot getPot() {
        return pot;
    }

    public void setPot(Pot pot) {
        this.pot = pot;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
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
