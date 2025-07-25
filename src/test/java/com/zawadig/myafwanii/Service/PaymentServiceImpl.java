////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Bill;
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Model.Payment;
////import com.zawadig.myafwanii.Repository.BillRepository;
////import com.zawadig.myafwanii.Repository.CustomerRepository;
////import com.zawadig.myafwanii.Repository.PaymentRepository;
////import com.zawadig.myafwanii.dto.PaymentDTO;
////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
////import org.springframework.stereotype.Service;
////
////import java.time.LocalDateTime;
////import java.util.List;
////import java.util.UUID;
////import java.util.stream.Collectors;
////
////@Service
////public class PaymentServiceImpl implements PaymentService {
////
////    private final BillRepository billRepo;
////    private final CustomerRepository customerRepo;
////    private final PaymentRepository paymentRepo;
////
////    public PaymentServiceImpl(BillRepository billRepo, CustomerRepository customerRepo, PaymentRepository paymentRepo) {
////        this.billRepo = billRepo;
////        this.customerRepo = customerRepo;
////        this.paymentRepo = paymentRepo;
////    }
////
////    // Map Payment entity to PaymentDTO cleanly
////    private PaymentDTO mapToDTO(Payment payment) {
////        PaymentDTO dto = new PaymentDTO();
////        dto.setId(payment.getId());
////        dto.setControlNumber(payment.getControlNumber());
////        dto.setAmountPaid(payment.getAmountPaid());
////        dto.setPaymentDate(payment.getPaymentDate());  // no unnecessary conversions
////        dto.setPaymentMethod(payment.getPaymentMethod());
////        dto.setPaymentStatus(payment.getPaymentStatus());
////        dto.setMeterNumber(payment.getMeterNumber());
////
////        if (payment.getCustomerId() != null) {
////            customerRepo.findById(payment.getCustomerId()).ifPresent(customer -> {
////                dto.setCustomerName(customer.getName());
////                dto.setCustomerEmail(customer.getEmail());
////            });
////        } else {
////            dto.setCustomerName("Unknown Customer");
////            dto.setCustomerEmail("");
////        }
////
////        return dto;
////    }
////
////    @Override
////    public List<PaymentDTO> getAllPayments() {
////        List<Payment> payments = paymentRepo.findAll();
////        return payments.stream()
////                .map(this::mapToDTO)
////                .collect(Collectors.toList());
////    }
////
////    @Override
////    public Payment generateControlNumber(PaymentRequestDTO dto) {
////        Customer customer = customerRepo.findByMeterNumber(dto.getMeterNumber())
////                .orElseThrow(() -> new IllegalArgumentException("Customer not found with this meter number"));
////
////        Bill bill = billRepo.findById(dto.getBillId())
////                .orElseThrow(() -> new IllegalArgumentException("Bill not found"));
////
////        if (!bill.getCustomer().getId().equals(customer.getId())) {
////            throw new IllegalArgumentException("Bill does not belong to this customer");
////        }
////
////        Payment payment = new Payment();
////        payment.setCustomerId(customer.getId());
////        payment.setBillId(bill.getId());
////        payment.setAmountPaid(dto.getAmountPaid());
////        payment.setMeterNumber(customer.getMeterNumber());
////        payment.setPaymentMethod(dto.getPaymentMethod());
////        payment.setPaymentStatus("PENDING");
////
////        // Ensure unique control number generation
////        String controlNumber;
////        do {
////            controlNumber = "CTRL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
////        } while (paymentRepo.findByControlNumber(controlNumber).isPresent());
////
////        payment.setControlNumber(controlNumber);
////        payment.setPaymentDate(LocalDateTime.now());
////        payment.setCreatedAt(LocalDateTime.now());
////
////        return paymentRepo.save(payment);
////    }
////
////    @Override
////    public Payment confirmPayment(String controlNumber) {
////        Payment payment = paymentRepo.findByControlNumber(controlNumber)
////                .orElseThrow(() -> new IllegalArgumentException("Invalid control number"));
////
////        payment.setPaymentStatus("PAID");
////        // Keep original paymentDate, update updatedAt to now
////        payment.setUpdatedAt(LocalDateTime.now());
////
////        return paymentRepo.save(payment);
////    }
////}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Bill;
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.Payment;
//import com.zawadig.myafwanii.Repository.BillRepository;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Repository.PaymentRepository;
//import com.zawadig.myafwanii.dto.PaymentDTO;
//import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    private final BillRepository billRepo;
//    private final CustomerRepository customerRepo;
//    private final PaymentRepository paymentRepo;
//    private final NotificationService notificationService;
//
//    public PaymentServiceImpl(
//            BillRepository billRepo,
//            CustomerRepository customerRepo,
//            PaymentRepository paymentRepo,
//            NotificationService notificationService
//    ) {
//        this.billRepo = billRepo;
//        this.customerRepo = customerRepo;
//        this.paymentRepo = paymentRepo;
//        this.notificationService = notificationService;
//    }
//
//    private PaymentDTO mapToDTO(Payment payment) {
//        PaymentDTO dto = new PaymentDTO();
//        dto.setId(payment.getId());
//        dto.setControlNumber(payment.getControlNumber());
//        dto.setAmountPaid(payment.getAmountPaid());
//        dto.setPaymentDate(payment.getPaymentDate());
//        dto.setPaymentMethod(payment.getPaymentMethod());
//        dto.setPaymentStatus(payment.getPaymentStatus());
//        dto.setMeterNumber(payment.getMeterNumber());
//
//        if (payment.getCustomerId() != null) {
//            customerRepo.findById(payment.getCustomerId()).ifPresent(customer -> {
//                dto.setCustomerName(customer.getName());
//                dto.setCustomerEmail(customer.getEmail());
//            });
//        } else {
//            dto.setCustomerName("Unknown Customer");
//            dto.setCustomerEmail("");
//        }
//
//        return dto;
//    }
//
//    @Override
//    public List<PaymentDTO> getAllPayments() {
//        List<Payment> payments = paymentRepo.findAll();
//        return payments.stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Payment generateControlNumber(PaymentRequestDTO dto) {
//        Customer customer = customerRepo.findByMeterNumber(dto.getMeterNumber())
//                .orElseThrow(() -> new IllegalArgumentException("Customer not found with this meter number"));
//
//        Bill bill = billRepo.findById(dto.getBillId())
//                .orElseThrow(() -> new IllegalArgumentException("Bill not found"));
//
//        if (!bill.getCustomer().getId().equals(customer.getId())) {
//            throw new IllegalArgumentException("Bill does not belong to this customer");
//        }
//
//        Payment payment = new Payment();
//        payment.setCustomerId(customer.getId());
//        payment.setBillId(bill.getId());
//        payment.setAmountPaid(dto.getAmountPaid());
//        payment.setMeterNumber(customer.getMeterNumber());
//        payment.setPaymentMethod(dto.getPaymentMethod());
//        payment.setPaymentStatus("PENDING");
//
//        // Generate unique control number
//        String controlNumber;
//        do {
//            controlNumber = "CTRL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
//        } while (paymentRepo.findByControlNumber(controlNumber).isPresent());
//
//        payment.setControlNumber(controlNumber);
//        payment.setPaymentDate(LocalDateTime.now());
//        payment.setCreatedAt(LocalDateTime.now());
//
//        return paymentRepo.save(payment);
//    }
//
//    @Override
//    public Payment confirmPayment(String controlNumber) {
//        Payment payment = paymentRepo.findByControlNumber(controlNumber)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid control number"));
//
//        payment.setPaymentStatus("PAID");
//        payment.setUpdatedAt(LocalDateTime.now());
//
//        Payment saved = paymentRepo.save(payment);
//
//        // ✅ Send notification after confirmation
//        if (saved.getCustomerId() != null) {
//            notificationService.sendNotification(
//                    saved.getCustomerId(),
//                    "Payment Confirmed",
//                    "Your payment with Control #" + saved.getControlNumber() + " has been successfully confirmed. Thank you!"
//            );
//        }
//
//        return saved;
//    }
//}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Bill;
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.Payment;
//import com.zawadig.myafwanii.Repository.BillRepository;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Repository.PaymentRepository;
//import com.zawadig.myafwanii.dto.PaymentDTO;
//import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//    private final BillRepository billRepo;
//    private final CustomerRepository customerRepo;
//    private final PaymentRepository paymentRepo;
//    private final NotificationService notificationService;
//
//    public PaymentServiceImpl(
//            BillRepository billRepo,
//            CustomerRepository customerRepo,
//            PaymentRepository paymentRepo,
//            NotificationService notificationService
//    ) {
//        this.billRepo = billRepo;
//        this.customerRepo = customerRepo;
//        this.paymentRepo = paymentRepo;
//        this.notificationService = notificationService;
//    }
//
//    private PaymentDTO mapToDTO(Payment payment) {
//        PaymentDTO dto = new PaymentDTO();
//        dto.setId(payment.getId());
//        dto.setControlNumber(payment.getControlNumber());
//        dto.setAmountPaid(payment.getAmountPaid());
//        dto.setPaymentDate(payment.getPaymentDate());
//        dto.setPaymentMethod(payment.getPaymentMethod());
//        dto.setPaymentStatus(payment.getPaymentStatus());
//        dto.setMeterNumber(payment.getMeterNumber());
//
//        if (payment.getCustomerId() != null) {
//            customerRepo.findById(payment.getCustomerId()).ifPresent(customer -> {
//                dto.setCustomerName(customer.getName());
//                dto.setCustomerEmail(customer.getEmail());
//            });
//        } else {
//            dto.setCustomerName("Unknown Customer");
//            dto.setCustomerEmail("");
//        }
//
//        return dto;
//    }
//
//    @Override
//    public List<PaymentDTO> getAllPayments() {
//        List<Payment> payments = paymentRepo.findByDeletedFalse();
//        return payments.stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Payment generateControlNumber(PaymentRequestDTO dto) {
//        Customer customer = customerRepo.findByMeterNumber(dto.getMeterNumber())
//                .orElseThrow(() -> new IllegalArgumentException("Customer not found with this meter number"));
//
//        Bill bill = billRepo.findById(dto.getBillId())
//                .orElseThrow(() -> new IllegalArgumentException("Bill not found"));
//
//        if (!bill.getCustomer().getId().equals(customer.getId())) {
//            throw new IllegalArgumentException("Bill does not belong to this customer");
//        }
//
//        Payment payment = new Payment();
//        payment.setCustomerId(customer.getId());
//        payment.setBillId(bill.getId());
//        payment.setAmountPaid(dto.getAmountPaid());
//        payment.setMeterNumber(customer.getMeterNumber());
//        payment.setPaymentMethod(dto.getPaymentMethod());
//        payment.setPaymentStatus("PENDING");
//
//        String controlNumber;
//        do {
//            controlNumber = "CTRL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
//        } while (paymentRepo.findByControlNumber(controlNumber).isPresent());
//
//        payment.setControlNumber(controlNumber);
//        payment.setPaymentDate(LocalDateTime.now());
//        payment.setCreatedAt(LocalDateTime.now());
//
//        return paymentRepo.save(payment);
//    }
//
//    @Override
//    public Payment confirmPayment(String controlNumber) {
//        Payment payment = paymentRepo.findByControlNumber(controlNumber)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid control number"));
//
//        payment.setPaymentStatus("PAID");
//        payment.setUpdatedAt(LocalDateTime.now());
//
//        Payment saved = paymentRepo.save(payment);
//
//        if (saved.getCustomerId() != null) {
//            notificationService.sendNotification(
//                    saved.getCustomerId(),
//                    "Payment Confirmed",
//                    "Your payment with Control #" + saved.getControlNumber() + " has been successfully confirmed. Thank you!"
//            );
//        }
//
//        return saved;
//    }
//
//    // ✅ Soft Delete a Payment
//    public boolean deletePaymentById(Long id, String deletedBy) {
//        return paymentRepo.findById(id).map(payment -> {
//            payment.setDeleted(true);
//            payment.setDeletedAt(LocalDateTime.now());
//            payment.setDeletedBy(deletedBy);
//            paymentRepo.save(payment);
//            return true;
//        }).orElse(false);
//    }
//
//    // ✅ Restore a Soft Deleted Payment
//    public boolean restorePayment(Long id) {
//        return paymentRepo.findById(id).map(payment -> {
//            payment.setDeleted(false);
//            payment.setDeletedAt(null);
//            payment.setDeletedBy(null);
//            paymentRepo.save(payment);
//            return true;
//        }).orElse(false);
//    }
//
//    // ✅ Get All Soft Deleted Payments
//    public List<PaymentDTO> getDeletedPayments() {
//        List<Payment> deleted = paymentRepo.findByDeletedTrue();
//        return deleted.stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//}

package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Bill;
import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Repository.BillRepository;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.PaymentRepository;
import com.zawadig.myafwanii.dto.PaymentDTO;
import com.zawadig.myafwanii.dto.PaymentRequestDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final BillRepository billRepo;
    private final CustomerRepository customerRepo;
    private final PaymentRepository paymentRepo;
    private final NotificationService notificationService;

    public PaymentServiceImpl(
            BillRepository billRepo,
            CustomerRepository customerRepo,
            PaymentRepository paymentRepo,
            NotificationService notificationService
    ) {
        this.billRepo = billRepo;
        this.customerRepo = customerRepo;
        this.paymentRepo = paymentRepo;
        this.notificationService = notificationService;
    }

    private PaymentDTO mapToDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setControlNumber(payment.getControlNumber());
        dto.setAmountPaid(payment.getAmountPaid());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setMeterNumber(payment.getMeterNumber());

        if (payment.getCustomerId() != null) {
            customerRepo.findById(payment.getCustomerId()).ifPresent(customer -> {
                dto.setCustomerName(customer.getName());
                dto.setCustomerEmail(customer.getEmail());
            });
        } else {
            dto.setCustomerName("Unknown Customer");
            dto.setCustomerEmail("");
        }

        return dto;
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepo.findAllActivePayments();
        return payments.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Payment generateControlNumber(PaymentRequestDTO dto) {
        Customer customer = customerRepo.findByMeterNumber(dto.getMeterNumber())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with this meter number"));

        Bill bill = billRepo.findById(dto.getBillId())
                .orElseThrow(() -> new IllegalArgumentException("Bill not found"));

        if (!bill.getCustomer().getId().equals(customer.getId())) {
            throw new IllegalArgumentException("Bill does not belong to this customer");
        }

        Payment payment = new Payment();
        payment.setCustomerId(customer.getId());
        payment.setBillId(bill.getId());
        payment.setAmountPaid(dto.getAmountPaid());
        payment.setMeterNumber(customer.getMeterNumber());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentStatus("PENDING");

        String controlNumber;
        do {
            controlNumber = "CTRL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (paymentRepo.findByControlNumber(controlNumber).isPresent());

        payment.setControlNumber(controlNumber);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setCreatedAt(LocalDateTime.now());
        payment.setDeleted(false);          // Hakikisha default ni false

        return paymentRepo.save(payment);
    }

    @Override
    public Payment confirmPayment(String controlNumber) {
        Payment payment = paymentRepo.findByControlNumber(controlNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invalid control number"));

        payment.setPaymentStatus("PAID");
        payment.setUpdatedAt(LocalDateTime.now());

        Payment saved = paymentRepo.save(payment);

        if (saved.getCustomerId() != null) {
            notificationService.sendNotification(
                    saved.getCustomerId(),
                    "Payment Confirmed",
                    "Your payment with Control #" + saved.getControlNumber() + " has been successfully confirmed. Thank you!"
            );
        }

        return saved;
    }

    // Soft delete payment
    public boolean deletePaymentById(Long id, String deletedBy) {
        return paymentRepo.findById(id).map(payment -> {
            payment.setDeleted(true);
            payment.setDeletedAt(LocalDateTime.now());
            payment.setDeletedBy(deletedBy);
            paymentRepo.save(payment);
            return true;
        }).orElse(false);
    }

    // Restore soft deleted payment
    public boolean restorePayment(Long id) {
        return paymentRepo.findById(id).map(payment -> {
            payment.setDeleted(false);
            payment.setDeletedAt(null);
            payment.setDeletedBy(null);
            paymentRepo.save(payment);
            return true;
        }).orElse(false);
    }

    // Get all soft deleted payments (Recycle Bin)
    public List<PaymentDTO> getDeletedPayments() {
        List<Payment> deleted = paymentRepo.findAllDeletedPayments();
        return deleted.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean permanentDeletePayment(Long id) {
        return false;
    }

    @Override

    // ✅ Update Payment
    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepo.findById(id).map(existingPayment -> {
            existingPayment.setAmountPaid(updatedPayment.getAmountPaid());
            existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
            existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());
            existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());
            existingPayment.setUpdatedAt(LocalDateTime.now());
            return paymentRepo.save(existingPayment);
        }).orElseThrow(() -> new IllegalArgumentException("Payment not found with ID: " + id));
    }

}
