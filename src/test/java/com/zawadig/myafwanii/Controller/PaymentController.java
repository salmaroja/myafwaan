package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Bill;
import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.Notification;
import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Model.User;
import com.zawadig.myafwanii.Repository.UserRepository;
import com.zawadig.myafwanii.Service.NotificationService;
import com.zawadig.myafwanii.Service.PaymentService;
import java.time.LocalDateTime;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
//@CrossOrigin(origins = {"http://localhost:3000", "http://10.3.2.95:19006"}, allowCredentials = "true")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    // ✅ GET ALL PAYMENTS
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    // ✅ CREATE PAYMENT
    @PostMapping
    public ResponseEntity<?> createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        // Tafuta user kwa email
        User user = userRepository.findByEmail(paymentRequest.getEmail()).orElse(null);
        if (user == null) {
            return ResponseEntity.badRequest().body("User with email not found");
        }

        // Tafuta customer aliyeunganishwa na user
        Customer customer = user.getCustomer();
        if (customer == null) {
            return ResponseEntity.badRequest().body("Customer not linked to user");
        }

        // Tengeneza object ya Payment
        Payment payment = new Payment();
        payment.setBill(paymentRequest.getBill());
        payment.setAmountPaid(paymentRequest.getAmountPaid());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());
        payment.setPaymentStatus("PENDING");
        payment.setPaymentDate(LocalDateTime.now());// ✅ Muhimu: Ili usipate error ya 400

        try {
            // Hifadhi malipo kwenye database
            Payment saved = paymentService.createPayment(payment);

            // ✅ Tengeneza notification kwa jina la mteja
            String fullName = customer.getFullName(); // kutoka kwa field ya 'name'
            String message = "Dear " + fullName + ", your payment of TZS " + payment.getAmountPaid() + " has been received. Thank you!";

            Notification notification = new Notification();
            notification.setTitle("Payment Confirmation");
            notification.setMessage(message);
            notification.setRead(false);

            // Tuma notification
            notificationService.sendNotificationToCustomer(customer.getId(), notification);

            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // ✅ DTO Class for Payment Creation
    public static class PaymentRequest {
        private String email;
        private Long billId;
        private Double amountPaid;
        private String paymentMethod;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public Long getBillId() { return billId; }
        public void setBillId(Long billId) { this.billId = billId; }

        public Double getAmountPaid() { return amountPaid; }
        public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }

        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

        public Bill getBill() {
            Bill bill = new Bill();
            bill.setId(this.billId);
            return bill;
        }
    }
}
