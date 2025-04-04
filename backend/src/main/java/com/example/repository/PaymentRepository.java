package com.example.repository;

import com.example.model.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentRepository {
    private final ConcurrentHashMap<Long, Payment> payments = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create payment
    public Payment save(Payment payment) {
        if (payment.getId() == null) {
            payment.setId(idGenerator.getAndIncrement());
        }
        payments.put(payment.getId(), payment);
        return payment;
    }

    // Find by ID
    public Payment findById(Long id) {
        return payments.get(id);
    }

    // Find all payments for a resident
    public List<Payment> findByResidentId(Long residentId) {
        List<Payment> result = new ArrayList<>();
        for (Payment payment : payments.values()) {
            if (payment.getResidentId().equals(residentId)) {
                result.add(payment);
            }
        }
        return result;
    }

    // Update payment status
    public Payment updateStatus(Long paymentId, String status, String transactionId) {
        Payment payment = payments.get(paymentId);
        if (payment != null) {
            payment.setStatus(status);
            payment.setTransactionId(transactionId);
            return payment;
        }
        return null;
    }
}