package com.example.demo;

import com.example.controller.PaymentController;
import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import com.example.service.PaymentService;

import java.util.List;

public class PaymentSystemDemo {
    public static void main(String[] args) {
        // Initialize all components
        PaymentRepository paymentRepo = new PaymentRepository();
        PaymentService paymentService = new PaymentService(paymentRepo);
        PaymentController paymentController = new PaymentController(paymentService);

        // Simulate a resident making a payment
        System.out.println("=== Initiating Payment ===");
        Payment payment = paymentController.initiatePayment(
                1L,       // residentId
                101L,     // billId
                2500.0,   // amount
                "Razorpay" // paymentMethod
        );
        System.out.println("Created payment with ID: " + payment.getId());

        // Simulate payment gateway callback (success scenario)
        System.out.println("\n=== Processing Payment Callback (Success) ===");
        Payment successfulPayment = paymentController.paymentCallback(
                payment.getId(),
                "SUCCESS",
                "txn_123456789"
        );
        System.out.println("Payment status: " + successfulPayment.getStatus());
        System.out.println("Transaction ID: " + successfulPayment.getTransactionId());

        // Get payment history for resident
        System.out.println("\n=== Retrieving Payment History ===");
        List<Payment> history = paymentController.getPaymentHistory(1L);
        System.out.println("Found " + ((java.util.List<?>) history).size() + " payment(s):");
        for (Payment p : history) {
            System.out.printf("- ID: %d | Amount: ₹%.2f | Status: %s | Date: %s%n",
                    p.getId(),
                    p.getAmount(),
                    p.getStatus(),
                    p.getPaymentDate());
        }

        // Simulate a failed payment
        System.out.println("\n=== Testing Failed Payment Scenario ===");
        Payment failedPayment = paymentController.initiatePayment(1L, 102L, 1500.0, "Razorpay");
        paymentController.paymentCallback(failedPayment.getId(), "FAILED", "txn_987654321");
        System.out.println("Failed payment status: " +
                paymentController.getPaymentDetails(failedPayment.getId()).getStatus());
    }
}