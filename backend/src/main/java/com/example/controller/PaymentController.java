package com.example.controller;

import com.example.model.Payment;
import com.example.service.PaymentService;

import java.util.List;

public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Endpoint to initiate payment
    public Payment initiatePayment(Long residentId, Long billId, double amount, String paymentMethod) {
        return paymentService.processPayment(residentId, billId, amount, paymentMethod);
    }

    // Endpoint for payment callback (from Razorpay)
    public Payment paymentCallback(Long paymentId, String status, String transactionId) {
        return paymentService.updatePaymentStatus(paymentId, status, transactionId);
    }

    // Endpoint to get payment history
    public List<Payment> getPaymentHistory(Long residentId) {
        return paymentService.getPaymentHistory(residentId);
    }

    // Endpoint to get payment details
    public Payment getPaymentDetails(Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }
}