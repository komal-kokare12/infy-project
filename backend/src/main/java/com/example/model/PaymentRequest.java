package com.example.model;//package com.example.model;
//
//public class PaymentRequest {
//    private int amount;
//    private String currency;
//
//    // Default constructor
//    public PaymentRequest() {}
//
//    // Parameterized constructor
//    public PaymentRequest(int amount, String currency) {
//        this.amount = amount;
//        this.currency = currency;
//    }
//
//    // Getters and setters
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//}

public class PaymentRequest {
    private String billId;
    private String residentId;
    private double amount;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
