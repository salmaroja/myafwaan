//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Model.Payment;
//////import com.zawadig.myafwanii.Service.PaymentService;
//////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.util.HashMap;
//////import java.util.Map;
//////
//////@RestController
//////@RequestMapping("/api/v1/payments")
////////@CrossOrigin("*") // If you're accessing from frontend (Flutter/React), leave this on
//////public class PaymentController {
//////
//////    private final PaymentService paymentService;
//////
//////    public PaymentController(PaymentService paymentService) {
//////        this.paymentService = paymentService;
//////    }
//////
////////    @PostMapping("/request-control")
////////    public ResponseEntity<Map<String, Object>> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
////////        Payment payment = paymentService.generateControlNumber(dto);
////////
////////        // Construct custom response
////////        Map<String, Object> response = new HashMap<>();
////////        response.put("id", payment.getId());
////////        response.put("controlNumber", payment.getControlNumber());
////////        response.put("amountPaid", payment.getAmountPaid());
////////        response.put("meterNumber", payment.getMeterNumber());
////////        response.put("paymentMethod", payment.getPaymentMethod());
////////        response.put("paymentStatus", payment.getPaymentStatus());
////////        response.put("paymentDate", payment.getPaymentDate());
////////
////////        return ResponseEntity.ok(response);
////////    }
//////@PostMapping("/request-control")
//////public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//////    Payment payment = paymentService.generateControlNumber(dto);
//////
//////    if (payment == null) {
//////        Map<String, String> errorResponse = new HashMap<>();
//////        errorResponse.put("error", "Failed to generate control number. Check meter number and bill ID.");
//////        return ResponseEntity.badRequest().body(errorResponse);
//////    }
//////
//////    Map<String, Object> response = new HashMap<>();
//////    response.put("id", payment.getId());
//////    response.put("controlNumber", payment.getControlNumber());
//////    response.put("amountPaid", payment.getAmountPaid());
//////    response.put("meterNumber", payment.getMeterNumber());
//////    response.put("paymentMethod", payment.getPaymentMethod());
//////    response.put("paymentStatus", payment.getPaymentStatus());
//////    response.put("paymentDate", payment.getPaymentDate());
//////
//////    return ResponseEntity.ok(response);
//////}
//////
//////    @PostMapping("/confirm/{controlNumber}")
//////    public ResponseEntity<Map<String, Object>> confirmPayment(@PathVariable String controlNumber) {
//////        Payment payment = paymentService.confirmPayment(controlNumber);
//////
//////        Map<String, Object> response = new HashMap<>();
//////        response.put("message", "Payment confirmed successfully");
//////        response.put("controlNumber", payment.getControlNumber());
//////        response.put("status", payment.getPaymentStatus());
//////        response.put("confirmedAt", payment.getUpdatedAt());
//////
//////        return ResponseEntity.ok(response);
//////    }
//////}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Service.PaymentService;
////import com.zawadig.myafwanii.dto.PaymentDTO;
////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
////import com.zawadig.myafwanii.Model.Payment;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/v1/payments")
//////@CrossOrigin("*") // Ruhusu frontend kupata API hii
////public class PaymentController {
////
////    private final PaymentService paymentService;
////
////    public PaymentController(PaymentService paymentService) {
////        this.paymentService = paymentService;
////    }
////
////    // GET all payments with DTO (includes customer name/email)
////    @GetMapping("")
////    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
////        List<PaymentDTO> payments = paymentService.getAllPayments();
////        return ResponseEntity.ok(payments);
////    }
////
////    // POST request control number
////    @PostMapping("/request-control")
////    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
////        Payment payment = paymentService.generateControlNumber(dto);
////
////        if (payment == null) {
////            Map<String, String> errorResponse = new HashMap<>();
////            errorResponse.put("error", "Failed to generate control number. Check meter number and bill ID.");
////            return ResponseEntity.badRequest().body(errorResponse);
////        }
////
////        Map<String, Object> response = new HashMap<>();
////        response.put("id", payment.getId());
////        response.put("controlNumber", payment.getControlNumber());
////        response.put("amountPaid", payment.getAmountPaid());
////        response.put("meterNumber", payment.getMeterNumber());
////        response.put("paymentMethod", payment.getPaymentMethod());
////        response.put("paymentStatus", payment.getPaymentStatus());
////        response.put("paymentDate", payment.getPaymentDate());
////
////        return ResponseEntity.ok(response);
////    }
////
////    // POST confirm payment
////    @PostMapping("/confirm/{controlNumber}")
////    public ResponseEntity<Map<String, Object>> confirmPayment(@PathVariable String controlNumber) {
////        Payment payment = paymentService.confirmPayment(controlNumber);
////
////        Map<String, Object> response = new HashMap<>();
////        response.put("message", "Payment confirmed successfully");
////        response.put("controlNumber", payment.getControlNumber());
////        response.put("status", payment.getPaymentStatus());
////        response.put("confirmedAt", payment.getUpdatedAt());
////
////        return ResponseEntity.ok(response);
////    }
////}
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Service.PaymentService;
//import com.zawadig.myafwanii.dto.PaymentDTO;
//import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//import com.zawadig.myafwanii.Model.Payment;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/payments")
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    // GET all payments with DTO info
//    @GetMapping("")
//    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
//        List<PaymentDTO> payments = paymentService.getAllPayments();
//        return ResponseEntity.ok(payments);
//    }
//
//    // POST request control number
//    @PostMapping("/request-control")
//    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//        try {
//            Payment payment = paymentService.generateControlNumber(dto);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("id", payment.getId());
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("amountPaid", payment.getAmountPaid());
//            response.put("meterNumber", payment.getMeterNumber());
//            response.put("paymentMethod", payment.getPaymentMethod());
//            response.put("paymentStatus", payment.getPaymentStatus());
//            response.put("paymentDate", payment.getPaymentDate());
//
//            return ResponseEntity.ok(response);
//        } catch (IllegalArgumentException ex) {
//            Map<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("error", ex.getMessage());
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//
//    // POST confirm payment by control number
//    @PostMapping("/confirm/{controlNumber}")
//    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//        try {
//            Payment payment = paymentService.confirmPayment(controlNumber);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "Payment confirmed successfully");
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("status", payment.getPaymentStatus());
//            response.put("confirmedAt", payment.getUpdatedAt());
//
//            return ResponseEntity.ok(response);
//        } catch (IllegalArgumentException ex) {
//            Map<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("error", ex.getMessage());
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//}

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Service.PaymentService;
//import com.zawadig.myafwanii.dto.PaymentDTO;
//import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//import com.zawadig.myafwanii.Model.Payment;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/payments")
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    // GET all payments with DTO info
//    @GetMapping("")
//    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
//        List<PaymentDTO> payments = paymentService.getAllPayments();
//        return ResponseEntity.ok(payments);
//    }
//
//    // POST request control number
//    @PostMapping("/request-control")
//    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//        try {
//            Payment payment = paymentService.generateControlNumber(dto);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("id", payment.getId());
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("amountPaid", payment.getAmountPaid());
//            response.put("meterNumber", payment.getMeterNumber());
//            response.put("paymentMethod", payment.getPaymentMethod());
//            response.put("paymentStatus", payment.getPaymentStatus());
//            response.put("paymentDate", payment.getPaymentDate());
//
//            return ResponseEntity.ok(response);
//        } catch (IllegalArgumentException ex) {
//            Map<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("error", ex.getMessage());
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//
//    // POST confirm payment by control number
//    @PostMapping("/confirm/{controlNumber}")
//    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//        try {
//            Payment payment = paymentService.confirmPayment(controlNumber);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "Payment confirmed successfully");
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("status", payment.getPaymentStatus());
//            response.put("confirmedAt", payment.getUpdatedAt());
//
//            return ResponseEntity.ok(response);
//        } catch (IllegalArgumentException ex) {
//            Map<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("error", ex.getMessage());
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//}

package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Service.PaymentService;
import com.zawadig.myafwanii.dto.PaymentDTO;
import com.zawadig.myafwanii.dto.PaymentRequestDTO;
import com.zawadig.myafwanii.Model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // GET all active payments (not deleted)
    @GetMapping("")
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    // GET all soft deleted payments (Recycle Bin)
    @GetMapping("/deleted")
    public ResponseEntity<List<PaymentDTO>> getDeletedPayments() {
        List<PaymentDTO> deletedPayments = paymentService.getDeletedPayments();
        return ResponseEntity.ok(deletedPayments);
    }

    // POST request control number
    @PostMapping("/request-control")
    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
        try {
            Payment payment = paymentService.generateControlNumber(dto);

            Map<String, Object> response = new HashMap<>();
            response.put("id", payment.getId());
            response.put("controlNumber", payment.getControlNumber());
            response.put("amountPaid", payment.getAmountPaid());
            response.put("meterNumber", payment.getMeterNumber());
            response.put("paymentMethod", payment.getPaymentMethod());
            response.put("paymentStatus", payment.getPaymentStatus());
            response.put("paymentDate", payment.getPaymentDate());

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", ex.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    // POST confirm payment by control number
    @PostMapping("/confirm/{controlNumber}")
    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
        try {
            Payment payment = paymentService.confirmPayment(controlNumber);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Payment confirmed successfully");
            response.put("controlNumber", payment.getControlNumber());
            response.put("status", payment.getPaymentStatus());
            response.put("confirmedAt", payment.getUpdatedAt());

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", ex.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    // PATCH soft delete payment (mark as deleted)
    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
        boolean deleted = paymentService.deletePaymentById(id, deletedBy);
        if (deleted) {
            return ResponseEntity.ok(Map.of("message", "Payment soft deleted successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PATCH restore payment from soft delete
    @PatchMapping("/restore/{id}")
    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
        boolean restored = paymentService.restorePayment(id);
        if (restored) {
            return ResponseEntity.ok(Map.of("message", "Payment restored successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        try {
            Payment payment = paymentService.updatePayment(id, updatedPayment);
            if (payment != null) {
                return ResponseEntity.ok(payment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Failed to update payment"));
        }
    }


    // DELETE permanently delete payment from DB
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
        boolean deleted = paymentService.permanentDeletePayment(id);
        if (deleted) {
            return ResponseEntity.ok(Map.of("message", "Payment permanently deleted"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
