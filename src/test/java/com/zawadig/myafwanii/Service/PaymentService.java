package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
    List<Payment> getPaymentsByCustomerId(Long customerId);
    Payment createPayment(Payment payment);
    void deletePayment(Long id);
    List<PaymentDTO> getAllPaymentsDTO();  // ✅ Already correct
}
