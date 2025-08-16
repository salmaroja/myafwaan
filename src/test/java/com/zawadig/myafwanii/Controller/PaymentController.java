//////////package com.zawadig.myafwanii.Controller;
//////////
//////////import com.zawadig.myafwanii.Model.Payment;
//////////import com.zawadig.myafwanii.Service.PaymentService;
//////////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//////////import org.springframework.http.ResponseEntity;
//////////import org.springframework.web.bind.annotation.*;
//////////
//////////import java.util.HashMap;
//////////import java.util.Map;
//////////
//////////@RestController
//////////@RequestMapping("/api/v1/payments")
////////////@CrossOrigin("*") // If you're accessing from frontend (Flutter/React), leave this on
//////////public class PaymentController {
//////////
//////////    private final PaymentService paymentService;
//////////
//////////    public PaymentController(PaymentService paymentService) {
//////////        this.paymentService = paymentService;
//////////    }
//////////
////////////    @PostMapping("/request-control")
////////////    public ResponseEntity<Map<String, Object>> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
////////////        Payment payment = paymentService.generateControlNumber(dto);
////////////
////////////        // Construct custom response
////////////        Map<String, Object> response = new HashMap<>();
////////////        response.put("id", payment.getId());
////////////        response.put("controlNumber", payment.getControlNumber());
////////////        response.put("amountPaid", payment.getAmountPaid());
////////////        response.put("meterNumber", payment.getMeterNumber());
////////////        response.put("paymentMethod", payment.getPaymentMethod());
////////////        response.put("paymentStatus", payment.getPaymentStatus());
////////////        response.put("paymentDate", payment.getPaymentDate());
////////////
////////////        return ResponseEntity.ok(response);
////////////    }
//////////@PostMapping("/request-control")
//////////public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//////////    Payment payment = paymentService.generateControlNumber(dto);
//////////
//////////    if (payment == null) {
//////////        Map<String, String> errorResponse = new HashMap<>();
//////////        errorResponse.put("error", "Failed to generate control number. Check meter number and bill ID.");
//////////        return ResponseEntity.badRequest().body(errorResponse);
//////////    }
//////////
//////////    Map<String, Object> response = new HashMap<>();
//////////    response.put("id", payment.getId());
//////////    response.put("controlNumber", payment.getControlNumber());
//////////    response.put("amountPaid", payment.getAmountPaid());
//////////    response.put("meterNumber", payment.getMeterNumber());
//////////    response.put("paymentMethod", payment.getPaymentMethod());
//////////    response.put("paymentStatus", payment.getPaymentStatus());
//////////    response.put("paymentDate", payment.getPaymentDate());
//////////
//////////    return ResponseEntity.ok(response);
//////////}
//////////
//////////    @PostMapping("/confirm/{controlNumber}")
//////////    public ResponseEntity<Map<String, Object>> confirmPayment(@PathVariable String controlNumber) {
//////////        Payment payment = paymentService.confirmPayment(controlNumber);
//////////
//////////        Map<String, Object> response = new HashMap<>();
//////////        response.put("message", "Payment confirmed successfully");
//////////        response.put("controlNumber", payment.getControlNumber());
//////////        response.put("status", payment.getPaymentStatus());
//////////        response.put("confirmedAt", payment.getUpdatedAt());
//////////
//////////        return ResponseEntity.ok(response);
//////////    }
//////////}
////////package com.zawadig.myafwanii.Controller;
////////
////////import com.zawadig.myafwanii.Service.PaymentService;
////////import com.zawadig.myafwanii.dto.PaymentDTO;
////////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
////////import com.zawadig.myafwanii.Model.Payment;
////////import org.springframework.http.ResponseEntity;
////////import org.springframework.web.bind.annotation.*;
////////
////////import java.util.HashMap;
////////import java.util.List;
////////import java.util.Map;
////////
////////@RestController
////////@RequestMapping("/api/v1/payments")
//////////@CrossOrigin("*") // Ruhusu frontend kupata API hii
////////public class PaymentController {
////////
////////    private final PaymentService paymentService;
////////
////////    public PaymentController(PaymentService paymentService) {
////////        this.paymentService = paymentService;
////////    }
////////
////////    // GET all payments with DTO (includes customer name/email)
////////    @GetMapping("")
////////    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
////////        List<PaymentDTO> payments = paymentService.getAllPayments();
////////        return ResponseEntity.ok(payments);
////////    }
////////
////////    // POST request control number
////////    @PostMapping("/request-control")
////////    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
////////        Payment payment = paymentService.generateControlNumber(dto);
////////
////////        if (payment == null) {
////////            Map<String, String> errorResponse = new HashMap<>();
////////            errorResponse.put("error", "Failed to generate control number. Check meter number and bill ID.");
////////            return ResponseEntity.badRequest().body(errorResponse);
////////        }
////////
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
////////
////////    // POST confirm payment
////////    @PostMapping("/confirm/{controlNumber}")
////////    public ResponseEntity<Map<String, Object>> confirmPayment(@PathVariable String controlNumber) {
////////        Payment payment = paymentService.confirmPayment(controlNumber);
////////
////////        Map<String, Object> response = new HashMap<>();
////////        response.put("message", "Payment confirmed successfully");
////////        response.put("controlNumber", payment.getControlNumber());
////////        response.put("status", payment.getPaymentStatus());
////////        response.put("confirmedAt", payment.getUpdatedAt());
////////
////////        return ResponseEntity.ok(response);
////////    }
////////}
//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Service.PaymentService;
//////import com.zawadig.myafwanii.dto.PaymentDTO;
//////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//////import com.zawadig.myafwanii.Model.Payment;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.util.HashMap;
//////import java.util.List;
//////import java.util.Map;
//////
//////@RestController
//////@RequestMapping("/api/v1/payments")
//////public class PaymentController {
//////
//////    private final PaymentService paymentService;
//////
//////    public PaymentController(PaymentService paymentService) {
//////        this.paymentService = paymentService;
//////    }
//////
//////    // GET all payments with DTO info
//////    @GetMapping("")
//////    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
//////        List<PaymentDTO> payments = paymentService.getAllPayments();
//////        return ResponseEntity.ok(payments);
//////    }
//////
//////    // POST request control number
//////    @PostMapping("/request-control")
//////    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//////        try {
//////            Payment payment = paymentService.generateControlNumber(dto);
//////
//////            Map<String, Object> response = new HashMap<>();
//////            response.put("id", payment.getId());
//////            response.put("controlNumber", payment.getControlNumber());
//////            response.put("amountPaid", payment.getAmountPaid());
//////            response.put("meterNumber", payment.getMeterNumber());
//////            response.put("paymentMethod", payment.getPaymentMethod());
//////            response.put("paymentStatus", payment.getPaymentStatus());
//////            response.put("paymentDate", payment.getPaymentDate());
//////
//////            return ResponseEntity.ok(response);
//////        } catch (IllegalArgumentException ex) {
//////            Map<String, String> errorResponse = new HashMap<>();
//////            errorResponse.put("error", ex.getMessage());
//////            return ResponseEntity.badRequest().body(errorResponse);
//////        }
//////    }
//////
//////    // POST confirm payment by control number
//////    @PostMapping("/confirm/{controlNumber}")
//////    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//////        try {
//////            Payment payment = paymentService.confirmPayment(controlNumber);
//////
//////            Map<String, Object> response = new HashMap<>();
//////            response.put("message", "Payment confirmed successfully");
//////            response.put("controlNumber", payment.getControlNumber());
//////            response.put("status", payment.getPaymentStatus());
//////            response.put("confirmedAt", payment.getUpdatedAt());
//////
//////            return ResponseEntity.ok(response);
//////        } catch (IllegalArgumentException ex) {
//////            Map<String, String> errorResponse = new HashMap<>();
//////            errorResponse.put("error", ex.getMessage());
//////            return ResponseEntity.badRequest().body(errorResponse);
//////        }
//////    }
//////}
////
//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Service.PaymentService;
//////import com.zawadig.myafwanii.dto.PaymentDTO;
//////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//////import com.zawadig.myafwanii.Model.Payment;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.util.HashMap;
//////import java.util.List;
//////import java.util.Map;
//////
//////@RestController
//////@RequestMapping("/api/v1/payments")
//////public class PaymentController {
//////
//////    private final PaymentService paymentService;
//////
//////    public PaymentController(PaymentService paymentService) {
//////        this.paymentService = paymentService;
//////    }
//////
//////    // GET all payments with DTO info
//////    @GetMapping("")
//////    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
//////        List<PaymentDTO> payments = paymentService.getAllPayments();
//////        return ResponseEntity.ok(payments);
//////    }
//////
//////    // POST request control number
//////    @PostMapping("/request-control")
//////    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//////        try {
//////            Payment payment = paymentService.generateControlNumber(dto);
//////
//////            Map<String, Object> response = new HashMap<>();
//////            response.put("id", payment.getId());
//////            response.put("controlNumber", payment.getControlNumber());
//////            response.put("amountPaid", payment.getAmountPaid());
//////            response.put("meterNumber", payment.getMeterNumber());
//////            response.put("paymentMethod", payment.getPaymentMethod());
//////            response.put("paymentStatus", payment.getPaymentStatus());
//////            response.put("paymentDate", payment.getPaymentDate());
//////
//////            return ResponseEntity.ok(response);
//////        } catch (IllegalArgumentException ex) {
//////            Map<String, String> errorResponse = new HashMap<>();
//////            errorResponse.put("error", ex.getMessage());
//////            return ResponseEntity.badRequest().body(errorResponse);
//////        }
//////    }
//////
//////    // POST confirm payment by control number
//////    @PostMapping("/confirm/{controlNumber}")
//////    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//////        try {
//////            Payment payment = paymentService.confirmPayment(controlNumber);
//////
//////            Map<String, Object> response = new HashMap<>();
//////            response.put("message", "Payment confirmed successfully");
//////            response.put("controlNumber", payment.getControlNumber());
//////            response.put("status", payment.getPaymentStatus());
//////            response.put("confirmedAt", payment.getUpdatedAt());
//////
//////            return ResponseEntity.ok(response);
//////        } catch (IllegalArgumentException ex) {
//////            Map<String, String> errorResponse = new HashMap<>();
//////            errorResponse.put("error", ex.getMessage());
//////            return ResponseEntity.badRequest().body(errorResponse);
//////        }
//////    }
//////}
////
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
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api/v1/payments")
//class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    // GET all active payments (not deleted)
//    @GetMapping("")
//    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
//        List<PaymentDTO> payments = paymentService.getAllPayments();
//        return ResponseEntity.ok(payments);
//    }
//
//    // GET all soft deleted payments (Recycle Bin)
//    @GetMapping("/deleted")
//    public ResponseEntity<List<PaymentDTO>> getDeletedPayments() {
//        List<PaymentDTO> deletedPayments = paymentService.getDeletedPayments();
//        return ResponseEntity.ok(deletedPayments);
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
//
//    // PATCH soft delete payment (mark as deleted)
//    @PatchMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
//        boolean deleted = paymentService.deletePaymentById(id, deletedBy);
//        if (deleted) {
//            return ResponseEntity.ok(Map.of("message", "Payment soft deleted successfully"));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // PATCH restore payment from soft delete
//    @PatchMapping("/restore/{id}")
//    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
//        boolean restored = paymentService.restorePayment(id);
//        if (restored) {
//            return ResponseEntity.ok(Map.of("message", "Payment restored successfully"));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
//        try {
//            Payment payment = paymentService.updatePayment(id, updatedPayment);
//            if (payment != null) {
//                return ResponseEntity.ok(payment);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(Map.of("error", "Failed to update payment"));
//        }
//    }
//
//
//    // DELETE permanently delete payment from DB
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
//        boolean deleted = paymentService.permanentDeletePayment(id);
//        if (deleted) {
//            return ResponseEntity.ok(Map.of("message", "Payment permanently deleted"));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Service.PaymentService;
////import com.zawadig.myafwanii.Service.RequestFormService;
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
////@CrossOrigin(origins = "http://localhost:3000")
////@RequestMapping("/api/v1/payments")
////public class PaymentController {
////
////    private final PaymentService paymentService;
////    private final RequestFormService requestFormService;
////
////    public PaymentController(PaymentService paymentService,
////                             RequestFormService requestFormService) {
////        this.paymentService = paymentService;
////        this.requestFormService = requestFormService;
////    }
////
////    /* Existing Methods (UNCHANGED) */
////    @GetMapping("")
////    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
////        List<PaymentDTO> payments = paymentService.getAllPayments();
////        return ResponseEntity.ok(payments);
////    }
////
////    @GetMapping("/deleted")
////    public ResponseEntity<List<PaymentDTO>> getDeletedPayments() {
////        List<PaymentDTO> deletedPayments = paymentService.getDeletedPayments();
////        return ResponseEntity.ok(deletedPayments);
////    }
////
////    @PostMapping("/request-control")
////    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
////        try {
////            Payment payment = paymentService.generateControlNumber(dto);
////
////            Map<String, Object> response = new HashMap<>();
////            response.put("id", payment.getId());
////            response.put("controlNumber", payment.getControlNumber());
////            response.put("amountPaid", payment.getAmountPaid());
////            response.put("meterNumber", payment.getMeterNumber());
////            response.put("paymentMethod", payment.getPaymentMethod());
////            response.put("paymentStatus", payment.getPaymentStatus());
////            response.put("paymentDate", payment.getPaymentDate());
////
////            return ResponseEntity.ok(response);
////        } catch (IllegalArgumentException ex) {
////            Map<String, String> errorResponse = new HashMap<>();
////            errorResponse.put("error", ex.getMessage());
////            return ResponseEntity.badRequest().body(errorResponse);
////        }
////    }
////
////    @PostMapping("/confirm/{controlNumber}")
////    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
////        try {
////            Payment payment = paymentService.confirmPayment(controlNumber);
////
////            Map<String, Object> response = new HashMap<>();
////            response.put("message", "Payment confirmed successfully");
////            response.put("controlNumber", payment.getControlNumber());
////            response.put("status", payment.getPaymentStatus());
////            response.put("confirmedAt", payment.getUpdatedAt());
////
////            return ResponseEntity.ok(response);
////        } catch (IllegalArgumentException ex) {
////            Map<String, String> errorResponse = new HashMap<>();
////            errorResponse.put("error", ex.getMessage());
////            return ResponseEntity.badRequest().body(errorResponse);
////        }
////    }
////
////    @PatchMapping("/soft-delete/{id}")
////    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
////        boolean deleted = paymentService.deletePaymentById(id, deletedBy);
////        if (deleted) {
////            return ResponseEntity.ok(Map.of("message", "Payment soft deleted successfully"));
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @PatchMapping("/restore/{id}")
////    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
////        boolean restored = paymentService.restorePayment(id);
////        if (restored) {
////            return ResponseEntity.ok(Map.of("message", "Payment restored successfully"));
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @PutMapping("/update/{id}")
////    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
////        try {
////            Payment payment = paymentService.updatePayment(id, updatedPayment);
////            if (payment != null) {
////                return ResponseEntity.ok(payment);
////            } else {
////                return ResponseEntity.notFound().build();
////            }
////        } catch (Exception e) {
////            return ResponseEntity.status(500).body(Map.of("error", "Failed to update payment"));
////        }
////    }
////
////    @DeleteMapping("/delete/{id}")
////    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
////        boolean deleted = paymentService.permanentDeletePayment(id);
////        if (deleted) {
////            return ResponseEntity.ok(Map.of("message", "Payment permanently deleted"));
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    /* New Methods for Request-Payment Linking */
////    @GetMapping("/by-request/{requestId}")
////    public ResponseEntity<List<PaymentDTO>> getPaymentsByRequest(@PathVariable Long requestId) {
////        List<PaymentDTO> payments = paymentService.findByRequestId(requestId);
////        return ResponseEntity.ok(payments);
////    }
////
////    @PostMapping("/approve/{paymentId}")
////    public ResponseEntity<?> approvePaymentAndRequest(@PathVariable Long paymentId) {
////        try {
////            Payment payment = paymentService.approvePayment(paymentId);
////
////            requestFormService.updateStatus(
////                    payment.getRequestForm().getId(),
////                    "APPROVED"
////            );
////
////            return ResponseEntity.ok(Map.of(
////                    "message", "Payment and request approved successfully",
////                    "paymentId", paymentId,
////                    "requestId", payment.getRequestForm().getId()
////            ));
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body(Map.of(
////                    "error", e.getMessage()
////            ));
////        }
////    }
////
////    @PostMapping("/pay-for-request")
////    public ResponseEntity<?> payForRequest(@RequestBody PaymentRequestDTO dto) {
////        try {
////            Payment payment = paymentService.createForRequest(dto);
////
////            return ResponseEntity.ok(Map.of(
////                    "controlNumber", payment.getControlNumber(),
////                    "requestId", dto.getRequestId(),
////                    "status", "PENDING"
////            ));
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body(Map.of(
////                    "error", e.getMessage()
////            ));
////        }
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
//@CrossOrigin
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping("/request-control")
//    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//        try {
//            Payment payment = paymentService.generateControlNumber(dto);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("amount", payment.getAmountPaid());
//            response.put("serviceType", payment.getServiceType());
//            response.put("status", "PENDING");
//
//            return ResponseEntity.ok(response);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @PostMapping("/confirm/{controlNumber}")
//    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//        try {
//            Payment payment = paymentService.confirmPayment(controlNumber);
//
//            return ResponseEntity.ok(Map.of(
//                    "message", "Payment confirmed successfully",
//                    "paymentStatus", "PAID",
//                    "requestId", payment.getRequestId()
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/status/{requestId}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String requestId) {
//        try {
//            Payment payment = paymentService.findByRequestId(requestId);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "paymentStatus", "NOT_FOUND"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "paymentStatus", payment.getPaymentStatus(),
//                    "paidAmount", payment.getAmountPaid(),
//                    "paidAt", payment.getPaymentDate()
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<?> getCustomerPayments(@PathVariable Long customerId) {
//        try {
//            List<PaymentDTO> payments = paymentService.findByCustomerId(customerId);
//            return ResponseEntity.ok(payments);
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "error", ex.getMessage()
//            ));
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
//@CrossOrigin
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping("/request-control")
//    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//        try {
//            Payment payment = paymentService.generateControlNumber(dto);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("success", true);
//            response.put("message", "Control number generated successfully");
//            response.put("data", Map.of(
//                    "controlNumber", payment.getControlNumber(),
//                    "amount", payment.getAmountPaid(),
//                    "serviceType", payment.getServiceType(),
//                    "requestId", payment.getRequestId(),
//                    "status", "PENDING",
//                    "paymentMethod", payment.getPaymentMethod(),
//                    "customerId", payment.getCustomerId()
//            ));
//
//            return ResponseEntity.ok(response);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to generate control number",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @PostMapping("/confirm/{controlNumber}")
//    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//        try {
//            Payment payment = paymentService.confirmPayment(controlNumber);
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment confirmed successfully",
//                    "data", Map.of(
//                            "paymentStatus", "PAID",
//                            "requestId", payment.getRequestId(),
//                            "confirmedAt", payment.getUpdatedAt(),
//                            "controlNumber", payment.getControlNumber(),
//                            "amountPaid", payment.getAmountPaid()
//                    )
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Payment confirmation failed",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/status/{requestId}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String requestId) {
//        try {
//            Payment payment = paymentService.findByRequestId(requestId);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment record not found",
//                        "data", Map.of("paymentStatus", "NOT_FOUND")
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment status retrieved",
//                    "data", Map.of(
//                            "paymentStatus", payment.getPaymentStatus(),
//                            "paidAmount", payment.getAmountPaid(),
//                            "paidAt", payment.getPaymentDate(),
//                            "serviceType", payment.getServiceType(),
//                            "requestId", payment.getRequestId(),
//                            "controlNumber", payment.getControlNumber()
//                    )
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Error checking payment status",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<?> getCustomerPayments(@PathVariable Long customerId) {
//        try {
//            List<PaymentDTO> payments = paymentService.findByCustomerId(customerId);
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Customer payments retrieved",
//                    "data", payments
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to retrieve customer payments",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @PatchMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
//        try {
//            boolean deleted = paymentService.deletePaymentById(id, deletedBy);
//
//            if (deleted) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment soft deleted successfully"
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to soft delete payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @PatchMapping("/restore/{id}")
//    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
//        try {
//            boolean restored = paymentService.restorePayment(id);
//
//            if (restored) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment restored successfully"
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to restore payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
//        try {
//            boolean deleted = paymentService.permanentDeletePayment(id);
//
//            if (deleted) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment permanently deleted"
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to permanently delete payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
//        try {
//            Payment payment = paymentService.updatePayment(id, updatedPayment);
//
//            if (payment != null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment updated successfully",
//                        "data", payment
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to update payment",
//                    "error", ex.getMessage()
//            ));
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

import java.util.*;

//@RestController
//@RequestMapping("/api/v1/payments")
////@CrossOrigin(origins = "*") // if needed you can restrict it to a specific domain
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    // 1. Request Control Number
//    @PostMapping("/request-control")
//    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//        try {
//            Payment payment = paymentService.generateControlNumber(dto);
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("controlNumber", payment.getControlNumber());
//            data.put("amount", payment.getAmountPaid());
//            data.put("serviceType", payment.getServiceType());
//            data.put("requestId", payment.getRequestId());
//            data.put("status", "PENDING");
//            data.put("paymentMethod", payment.getPaymentMethod());
//            data.put("customerId", payment.getCustomerId());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "data", data
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to generate control number",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 2. Confirm Payment
//    @PostMapping("/confirm/{controlNumber}")
//    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//        try {
//            Payment payment = paymentService.confirmPayment(controlNumber);
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment confirmed successfully",
//                    "data", Map.of(
//                            "paymentStatus", "PAID",
//                            "requestId", payment.getRequestId(),
//                            "confirmedAt", payment.getUpdatedAt(),
//                            "controlNumber", payment.getControlNumber(),
//                            "amountPaid", payment.getAmountPaid()
//                    )
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Payment confirmation failed",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 3. Check Status by Request ID
//    @GetMapping("/status/{requestId}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String requestId) {
//        try {
//            Payment payment = paymentService.findByRequestId(requestId);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment record not found",
//                        "data", Map.of("paymentStatus", "NOT_FOUND")
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment status retrieved",
//                    "data", Map.of(
//                            "paymentStatus", payment.getPaymentStatus(),
//                            "paidAmount", payment.getAmountPaid(),
//                            "paidAt", payment.getPaymentDate(),
//                            "serviceType", payment.getServiceType(),
//                            "requestId", payment.getRequestId(),
//                            "controlNumber", payment.getControlNumber()
//                    )
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Error checking payment status",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 4. Get All Payments by Customer ID
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<?> getCustomerPayments(@PathVariable Long customerId) {
//        try {
//            List<PaymentDTO> payments = paymentService.findByCustomerId(customerId);
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Customer payments retrieved",
//                    "data", payments
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to retrieve customer payments",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 5. Soft Delete
//    @PatchMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
//        try {
//            boolean deleted = paymentService.deletePaymentById(id, deletedBy);
//            if (deleted) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment soft deleted successfully"
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to soft delete payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 6. Restore Payment
//    @PatchMapping("/restore/{id}")
//    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
//        try {
//            boolean restored = paymentService.restorePayment(id);
//            if (restored) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment restored successfully"
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to restore payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 7. Permanent Delete
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
//        try {
//            boolean deleted = paymentService.permanentDeletePayment(id);
//            if (deleted) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment permanently deleted"
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to permanently delete payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 8. Update Payment
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
//        try {
//            Payment payment = paymentService.updatePayment(id, updatedPayment);
//            if (payment != null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment updated successfully",
//                        "data", payment
//                ));
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to update payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//}



import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Service.PaymentService;
import com.zawadig.myafwanii.dto.PaymentDTO;
import com.zawadig.myafwanii.dto.PaymentRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//    // 1. Request Control Number
//    @PostMapping("/request-control")
//    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
//        try {
//            Payment payment = paymentService.generateControlNumber(dto);
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("controlNumber", payment.getControlNumber());
//            data.put("amount", payment.getAmountPaid());
//            data.put("serviceType", payment.getServiceType());
//            data.put("requestId", payment.getRequestId());
//            data.put("status", payment.getPaymentStatus());
//            data.put("paymentMethod", payment.getPaymentMethod());
//            data.put("customerId", payment.getCustomerId());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "data", data
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to generate control number",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 2. Confirm Payment
//    @PostMapping("/confirm/{controlNumber}")
//    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//        try {
//            Payment payment = paymentService.confirmPayment(controlNumber);
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("paymentStatus", payment.getPaymentStatus());
//            data.put("requestId", payment.getRequestId());
//            data.put("confirmedAt", payment.getUpdatedAt());
//            data.put("controlNumber", payment.getControlNumber());
//            data.put("amountPaid", payment.getAmountPaid());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment confirmed successfully",
//                    "data", data
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Payment confirmation failed",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 3. Check Status by Request ID
//    @GetMapping("/status/{requestId}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String requestId) {
//        try {
//            Payment payment = paymentService.findByRequestId(requestId);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment record not found",
//                        "data", Map.of("paymentStatus", "NOT_FOUND")
//                ));
//            }
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("paymentStatus", payment.getPaymentStatus());
//            data.put("paidAmount", payment.getAmountPaid());
//            data.put("paidAt", payment.getPaymentDate());
//            data.put("serviceType", payment.getServiceType());
//            data.put("requestId", payment.getRequestId());
//            data.put("controlNumber", payment.getControlNumber());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment status retrieved",
//                    "data", data
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Error checking payment status",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 4. Get All Payments by Customer ID
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<?> getCustomerPayments(@PathVariable Long customerId) {
//        try {
//            List<PaymentDTO> payments = paymentService.findByCustomerId(customerId);
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Customer payments retrieved",
//                    "data", payments
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to retrieve customer payments",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 5. Soft Delete Payment
//    @PatchMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
//        try {
//            boolean deleted = paymentService.deletePaymentById(id, deletedBy);
//            if (deleted) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment soft deleted successfully"
//                ));
//            } else {
//                return ResponseEntity.status(404).body(Map.of(
//                        "success", false,
//                        "message", "Payment not found"
//                ));
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to soft delete payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 6. Restore Soft Deleted Payment
//    @PatchMapping("/restore/{id}")
//    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
//        try {
//            boolean restored = paymentService.restorePayment(id);
//            if (restored) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment restored successfully"
//                ));
//            } else {
//                return ResponseEntity.status(404).body(Map.of(
//                        "success", false,
//                        "message", "Payment not found"
//                ));
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to restore payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 7. Permanent Delete Payment
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
//        try {
//            boolean deleted = paymentService.permanentDeletePayment(id);
//            if (deleted) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "message", "Payment permanently deleted"
//                ));
//            } else {
//                return ResponseEntity.status(404).body(Map.of(
//                        "success", false,
//                        "message", "Payment not found"
//                ));
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to permanently delete payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//
//    // 8. Update Payment
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
//        try {
//            Payment payment = paymentService.updatePayment(id, updatedPayment);
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment updated successfully",
//                    "data", payment
//            ));
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.status(404).body(Map.of(
//                    "success", false,
//                    "message", ex.getMessage()
//            ));
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to update payment",
//                    "error", ex.getMessage()
//            ));
//        }
//    }
//}


import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Service.PaymentService;
import com.zawadig.myafwanii.dto.PaymentDTO;
import com.zawadig.myafwanii.dto.PaymentRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin(origins = "http://localhost:3000'") // au weka specific origin kama 'http://localhost:3000'
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // 1. Generate Control Number
    @PostMapping("/request-control")
    public ResponseEntity<?> requestControlNumber(@RequestBody PaymentRequestDTO dto) {
        try {
            Payment payment = paymentService.generateControlNumber(dto);

            Map<String, Object> data = new HashMap<>();
            data.put("controlNumber", payment.getControlNumber());
            data.put("amount", payment.getAmountPaid());
            data.put("serviceType", payment.getServiceType());
            data.put("requestId", payment.getRequestId());
            data.put("status", payment.getPaymentStatus());
            data.put("paymentMethod", payment.getPaymentMethod());
            data.put("customerId", payment.getCustomerId());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Control number generated successfully",
                    "data", data
            ));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Failed to generate control number",
                    "error", ex.getMessage()
            ));
        }
    }

    // 2. Confirm Payment by Control Number
    @PostMapping("/confirm/{controlNumber}")
    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
        try {
            Payment payment = paymentService.confirmPayment(controlNumber);

            Map<String, Object> data = new HashMap<>();
            data.put("paymentStatus", payment.getPaymentStatus());
            data.put("requestId", payment.getRequestId());
            data.put("confirmedAt", payment.getUpdatedAt());
            data.put("controlNumber", payment.getControlNumber());
            data.put("amountPaid", payment.getAmountPaid());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Payment confirmed successfully",
                    "data", data
            ));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Payment confirmation failed",
                    "error", ex.getMessage()
            ));
        }
    }

    // 3. Check Payment Status by Request ID
    @GetMapping("/status/{requestId}")
    public ResponseEntity<?> checkPaymentStatus(@PathVariable String requestId) {
        try {
            Payment payment = paymentService.findByRequestId(requestId);

            if (payment == null) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Payment record not found",
                        "data", Map.of("paymentStatus", "NOT_FOUND")
                ));
            }

            Map<String, Object> data = new HashMap<>();
            data.put("paymentStatus", payment.getPaymentStatus());
            data.put("paidAmount", payment.getAmountPaid());
            data.put("paidAt", payment.getPaymentDate());
            data.put("serviceType", payment.getServiceType());
            data.put("requestId", payment.getRequestId());
            data.put("controlNumber", payment.getControlNumber());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Payment status retrieved",
                    "data", data
            ));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(Map.of(
                    "success", false,
                    "message", "Error checking payment status",
                    "error", ex.getMessage()
            ));
        }
    }

    // 4. Get All Payments for Customer by Customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerPayments(@PathVariable Long customerId) {
        try {
            List<PaymentDTO> payments = paymentService.findByCustomerId(customerId);

            if (payments == null) {
                payments = new ArrayList<>();
            }

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Customer payments retrieved",
                    "data", payments
            ));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(Map.of(
                    "success", false,
                    "message", "Failed to retrieve customer payments",
                    "error", ex.getMessage()
            ));
        }
    }


    // 5. Soft Delete Payment
    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<?> softDeletePayment(@PathVariable Long id, @RequestParam String deletedBy) {
        try {
            boolean deleted = paymentService.deletePaymentById(id, deletedBy);
            if (deleted) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Payment soft deleted successfully"
                ));
            } else {
                return ResponseEntity.status(404).body(Map.of(
                        "success", false,
                        "message", "Payment not found"
                ));
            }
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Failed to soft delete payment",
                    "error", ex.getMessage()
            ));
        }
    }

    // 6. Restore Soft Deleted Payment
    @PatchMapping("/restore/{id}")
    public ResponseEntity<?> restorePayment(@PathVariable Long id) {
        try {
            boolean restored = paymentService.restorePayment(id);
            if (restored) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Payment restored successfully"
                ));
            } else {
                return ResponseEntity.status(404).body(Map.of(
                        "success", false,
                        "message", "Payment not found"
                ));
            }
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Failed to restore payment",
                    "error", ex.getMessage()
            ));
        }
    }

    // 7. Permanently Delete Payment
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> permanentDeletePayment(@PathVariable Long id) {
        try {
            boolean deleted = paymentService.permanentDeletePayment(id);
            if (deleted) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Payment permanently deleted"
                ));
            } else {
                return ResponseEntity.status(404).body(Map.of(
                        "success", false,
                        "message", "Payment not found"
                ));
            }
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Failed to permanently delete payment",
                    "error", ex.getMessage()
            ));
        }
    }

    // 8. Update Payment
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        try {
            Payment payment = paymentService.updatePayment(id, updatedPayment);
            if (payment == null) {
                return ResponseEntity.status(404).body(Map.of(
                        "success", false,
                        "message", "Payment not found"
                ));
            }
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Payment updated successfully",
                    "data", payment
            ));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", "Failed to update payment",
                    "error", ex.getMessage()
            ));
        }
    }
}
