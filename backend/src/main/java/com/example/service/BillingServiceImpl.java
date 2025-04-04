//package com.example.service;
//
//import com.example.model.Bill;
//import com.example.model.Payment;
//import com.example.repository.BillRepository;
//import com.example.repository.PaymentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class BillingServiceImpl implements BillingService {
//
//    @Autowired
//    private BillRepository billRepository;
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Override
//    public List<Bill> getBillsByResident(String residentId) {
//        return billRepository.findByResidentId(residentId);
//    }
//
//    @Override
//    public List<Bill> getUnpaidBillsByResident(String residentId) {
//        return billRepository.findByResidentIdAndPaid(residentId, false);
//    }
//
//    @Override
//    public Bill createBill(Bill bill) {
//        return billRepository.save(bill);
//    }
//
//    @Override
//    public Payment processPayment(Payment payment) {
//        // Update the bill status to paid
//        Bill bill = billRepository.findById(payment.getBillId()).orElse(null);
//        if (bill != null) {
//            bill.setPaid(true);
//            billRepository.save(bill);
//        }
//        return paymentRepository.save(payment);
//    }
//
//    @Override
//    public List<Payment> getPaymentHistory(String residentId) {
//        return paymentRepository.findByResidentId(residentId);
//    }
//}