package com.example.model;

import java.util.Date;

public class Bill {
    private Long id;
    private Long residentId;
    private String type; // Maintenance, Water, Electricity
    private double amount;
    private Date dueDate;
    private boolean paid;

    // Constructors, Getters and Setters
    public Bill() {}

    public Bill(Long residentId, String type, double amount, Date dueDate) {
        this.residentId = residentId;
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getResidentId() { return residentId; }
    public void setResidentId(Long residentId) { this.residentId = residentId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}