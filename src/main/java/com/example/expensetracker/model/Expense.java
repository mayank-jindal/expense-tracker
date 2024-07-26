package com.example.expensetracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    private LocalDate date;

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
