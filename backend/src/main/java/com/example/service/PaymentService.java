package com.example.service;

import com.example.model.Payment;
import com.example.repository.PaymentRepository;

import java.util.List;

public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Process a new payment
    public Payment processPayment(Long residentId, Long billId, double amount, String paymentMethod) {
        Payment payment = new Payment(residentId, billId, amount, paymentMethod);
        return paymentRepository.save(payment);
    }

    // Update payment status after gateway response
    public Payment updatePaymentStatus(Long paymentId, String status, String transactionId) {
        return paymentRepository.updateStatus(paymentId, status, transactionId);
    }

    // Get payment history for a resident
    public List<Payment> getPaymentHistory(Long residentId) {
        return paymentRepository.findByResidentId(residentId);
    }

    // Get payment by ID
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}