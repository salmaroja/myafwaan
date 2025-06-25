package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Bill;
import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Repository.BillRepository;
import com.zawadig.myafwanii.Repository.PaymentRepository;
import com.zawadig.myafwanii.Util.ControlNumberGenerator;
import com.zawadig.myafwanii.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getPaymentsByCustomerId(Long customerId) {
        return paymentRepository.findByBill_CustomerId(customerId);
    }

    @Override
    public Payment createPayment(Payment payment) {
        if (payment.getBill() == null || payment.getBill().getId() == null) {
            throw new IllegalArgumentException("Bill must be provided");
        }

        Bill bill = billRepository.findById(payment.getBill().getId())
                .orElseThrow(() -> new IllegalArgumentException("Bill not found"));

        payment.setBill(bill);
        payment.setControlNumber(ControlNumberGenerator.generate());

        if (payment.getPaymentStatus() == null) {
            payment.setPaymentStatus("PENDING");
        }

        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentDTO> getAllPaymentsDTO() {
        List<Payment> payments = paymentRepository.findAll();

        return payments.stream().map(payment -> {
            PaymentDTO dto = new PaymentDTO();
            dto.setId(payment.getId());
            dto.setControlNumber(payment.getControlNumber());
            dto.setAmountPaid(payment.getAmountPaid());

            // Conversion from LocalDateTime to Date
            LocalDateTime ldt = payment.getPaymentDate();
            if (ldt != null) {
                Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
                dto.setPaymentDate(date);
            } else {
                dto.setPaymentDate(null);
            }

            dto.setPaymentMethod(payment.getPaymentMethod());
            dto.setPaymentStatus(payment.getPaymentStatus());

            if (payment.getBill() != null &&
                    payment.getBill().getCustomer() != null &&
                    payment.getBill().getCustomer().getUser() != null) {

                dto.setCustomerName(payment.getBill().getCustomer().getUser().getFullName());
                dto.setCustomerEmail(payment.getBill().getCustomer().getUser().getEmail());
            } else {
                dto.setCustomerName("Unknown");
                dto.setCustomerEmail("N/A");
            }

            return dto;
        }).collect(Collectors.toList());
    }
}
