package com.example.model;//package com.example.model;
//
//public class PaymentVerification {
//    private String razorpayPaymentId;
//    private String razorpayOrderId;
//    private String razorpaySignature;
//    private String orderId;
//    private double amount;
//
//    // Default constructor
//    public PaymentVerification() {}
//
//    // Getters and setters
//    public String getRazorpayPaymentId() {
//        return razorpayPaymentId;
//    }
//
//    public void setRazorpayPaymentId(String razorpayPaymentId) {
//        this.razorpayPaymentId = razorpayPaymentId;
//    }
//
//    public String getRazorpayOrderId() {
//        return razorpayOrderId;
//    }
//
//    public void setRazorpayOrderId(String razorpayOrderId) {
//        this.razorpayOrderId = razorpayOrderId;
//    }
//
//    public String getRazorpaySignature() {
//        return razorpaySignature;
//    }
//
//    public void setRazorpaySignature(String razorpaySignature) {
//        this.razorpaySignature = razorpaySignature;
//    }
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//}

public class PaymentVerificationRequest {
    private String razorpayPaymentId;
    private String razorpayOrderId;
    private String razorpaySignature;
    private String orderId;
    private double amount;
    private String residentId;
    private String billId;
    // getters and setters


    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getRazorpaySignature() {
        return razorpaySignature;
    }

    public void setRazorpaySignature(String razorpaySignature) {
        this.razorpaySignature = razorpaySignature;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
}