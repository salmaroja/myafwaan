//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Model.ServicePayment;
//////import com.zawadig.myafwanii.Service.ServicePaymentService;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.util.Map;
//////
//////@RestController
//////@RequestMapping("/api/v1/service-payments")
//////public class ServicePaymentController {
//////
//////    @Autowired
//////    private ServicePaymentService servicePaymentService;
//////
//////    // 1. Request Payment (generate control number)
//////    @PostMapping("/request")
//////    public ResponseEntity<?> requestPayment(@RequestBody RequestPaymentDTO dto) {
//////        try {
//////            ServicePayment payment = servicePaymentService.requestPayment(dto.getCustomerId(), dto.getServiceType(), dto.getAmount());
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "message", "Control number generated",
//////                    "controlNumber", payment.getControlNumber(),
//////                    "paymentStatus", payment.getPaymentStatus()
//////            ));
//////        } catch (Exception e) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Failed to generate control number",
//////                    "error", e.getMessage()
//////            ));
//////        }
//////    }
//////
//////    // 2. Confirm Payment
//////    @PostMapping("/confirm/{controlNumber}")
//////    public ResponseEntity<?> confirmPayment(@PathVariable String controlNumber) {
//////        try {
//////            ServicePayment payment = servicePaymentService.confirmPayment(controlNumber);
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "message", "Payment confirmed",
//////                    "paymentStatus", payment.getPaymentStatus(),
//////                    "paymentDate", payment.getPaymentDate()
//////            ));
//////        } catch (Exception e) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Payment confirmation failed",
//////                    "error", e.getMessage()
//////            ));
//////        }
//////    }
//////
//////    // 3. Check Payment Status
//////    @GetMapping("/status/{controlNumber}")
//////    public ResponseEntity<?> checkStatus(@PathVariable String controlNumber) {
//////        try {
//////            ServicePayment payment = servicePaymentService.getPaymentStatus(controlNumber);
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "paymentStatus", payment.getPaymentStatus(),
//////                    "amount", payment.getAmount(),
//////                    "serviceType", payment.getServiceType(),
//////                    "paymentDate", payment.getPaymentDate()
//////            ));
//////        } catch (Exception e) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Error fetching payment status",
//////                    "error", e.getMessage()
//////            ));
//////        }
//////    }
//////
//////    // DTO class for request body
//////    public static class RequestPaymentDTO {
//////        private Long customerId;
//////        private String serviceType;
//////        private Double amount;
//////
//////        // getters and setters
//////        public Long getCustomerId() {
//////            return customerId;
//////        }
//////        public void setCustomerId(Long customerId) {
//////            this.customerId = customerId;
//////        }
//////        public String getServiceType() {
//////            return serviceType;
//////        }
//////        public void setServiceType(String serviceType) {
//////            this.serviceType = serviceType;
//////        }
//////        public Double getAmount() {
//////            return amount;
//////        }
//////        public void setAmount(Double amount) {
//////            this.amount = amount;
//////        }
//////    }
//////}
////package com.zawadig.myafwanii.Controller;
////
//////import com.zawadig.myafwanii.Model.ServicePayment;
//////import com.zawadig.myafwanii.Service.ServicePaymentService;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.util.Map;
//////
//////@RestController
//////@RequestMapping("/api/v1/request-payments")
//////public class ServicePaymentController {
//////
//////    @Autowired
//////    private ServicePaymentService servicePaymentService;
//////
//////    // 1. Request Payment (generate control number)
////////    @PostMapping("/request")
////////    public ResponseEntity<?> requestPayment(@RequestBody RequestPaymentDTO dto) {
////////        try {
////////            // KUREKEBISHWA: Hakikisha data inakuja vizuri
////////            System.out.println("Imepokea ombi: " + dto);
////////
////////            ServicePayment payment = servicePaymentService.requestPayment(
////////                    dto.getCustomerId(),
////////                    dto.getServiceType(),
////////                    dto.getAmount()
////////            );
////////
////////            return ResponseEntity.ok(Map.of(
////////                    "success", true,
////////                    "message", "Control number generated",
////////                    "controlNumber", payment.getControlNumber(),
////////                    "paymentStatus", payment.getPaymentStatus()
////////            ));
////////        } catch (Exception e) {
////////            return ResponseEntity.badRequest().body(Map.of(
////////                    "success", false,
////////                    "message", "Failed to generate control number",
////////                    "error", e.getMessage()
////////            ));
////////        }
////////    }
////////
////////    // ... (Endpoints nyingine hazijabadilika)
////////
////////    // DTO class for request body
////////    public static class RequestPaymentDTO {
////////        private Long customerId;
////////        private String serviceType;
////////        private Double amount;
////////
////////        // KUREKEBISHWA: Ongeza toString kwa utatuzi
////////        @Override
////////        public String toString() {
////////            return "RequestPaymentDTO{" +
////////                    "customerId=" + customerId +
////////                    ", serviceType='" + serviceType + '\'' +
////////                    ", amount=" + amount +
////////                    '}';
////////        }
////////
////////        // Getters na setters
////////        public Long getCustomerId() { return customerId; }
////////        public void setCustomerId(Long customerId) { this.customerId = customerId; }
////////
////////        public String getServiceType() { return serviceType; }
////////        public void setServiceType(String serviceType) { this.serviceType = serviceType; }
////////
////////        public Double getAmount() { return amount; }
////////        public void setAmount(Double amount) { this.amount = amount; }
////////    }
////////}
//////    @PostMapping("/request")
//////    public ResponseEntity<?> requestPayment(@RequestBody RequestPaymentDTO dto) {
//////        try {
//////            System.out.println("Imepokea ombi: " + dto); // Debug log
//////
//////            ServicePayment payment = servicePaymentService.requestPayment(
//////                    dto.getCustomerId(),
//////                    dto.getServiceType(),
//////                    dto.getAmount()
//////            );
//////
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "message", "Control number generated",
//////                    "controlNumber", payment.getControlNumber(),
//////                    "paymentStatus", payment.getPaymentStatus()
//////            ));
//////        } catch (Exception e) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Failed to generate control number",
//////                    "error", e.getMessage()
//////            ));
//////        }
//////    }
//////
//////    // DTO class
//////    public static class RequestPaymentDTO {
//////        private Long customerId;
//////        private String serviceType;
//////        private Double amount;
//////
//////        @Override
//////        public String toString() {
//////            return "RequestPaymentDTO{" +
//////                    "customerId=" + customerId +
//////                    ", serviceType='" + serviceType + '\'' +
//////                    ", amount=" + amount +
//////                    '}';
//////        }
//////
//////        public Long getCustomerId() {
//////            return customerId;
//////        }
//////
//////        public void setCustomerId(Long customerId) {
//////            this.customerId = customerId;
//////        }
//////
//////        public String getServiceType() {
//////            return serviceType;
//////        }
//////
//////        public void setServiceType(String serviceType) {
//////            this.serviceType = serviceType;
//////        }
//////
//////        public Double getAmount() {
//////            return amount;
//////        }
//////
//////        public void setAmount(Double amount) {
//////            this.amount = amount;
//////        }
//////    }
//////
////
////import com.zawadig.myafwanii.Model.ServicePayment;
////import com.zawadig.myafwanii.Service.ServicePaymentService;
////import jakarta.validation.Valid;
////import jakarta.validation.constraints.Min;
////import jakarta.validation.constraints.NotNull;
////import lombok.AllArgsConstructor;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////import lombok.extern.slf4j.Slf4j;
////import org.hibernate.validator.constraints.NotBlank;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
//////import javax.validation.Valid;
//////import javax.validation.constraints.Min;
//////import javax.validation.constraints.NotBlank;
//////import javax.validation.constraints.NotNull;
//////import java.util.Map;
//////
//////@RestController
//////@RequestMapping("/api/v1/request-payments")
//////@Slf4j
//////public class ServicePaymentController {
//////
//////    @Autowired
//////    private ServicePaymentService servicePaymentService;
//////
//////    // POST: Request Payment
//////    @PostMapping("/request")
//////    public ResponseEntity<?> requestPayment(@RequestBody RequestPaymentDTO dto) {
//////        try {
//////            System.out.println("Imepokea ombi: " + dto);
//////
//////            ServicePayment payment = servicePaymentService.requestPayment(
//////                    dto.getCustomerId(),
//////                    dto.getServiceType(),
//////                    dto.getAmount(),
//////                    dto.getPaymentMethod(),   // Ongeza hii
//////                    dto.getPhone()            // Pia kama unahitaji phone
//////            );
//////
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "message", "Control number generated",
//////                    "controlNumber", payment.getControlNumber(),
//////                    "paymentStatus", payment.getPaymentStatus()
//////            ));
//////        } catch (Exception e) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Failed to generate control number",
//////                    "error", e.getMessage()
//////            ));
//////        }
//////    }
//////
//////    // ===================== DTO CLASS =====================
//////    @Data
//////    @AllArgsConstructor
//////    @NoArgsConstructor
//////    public static class RequestPaymentDTO {
//////        @NotNull(message = "Customer ID is required")
//////        private Long customerId;
//////
//////        @NotBlank(message = "Service type is required")
//////        private String serviceType;
//////
//////        @NotNull(message = "Amount is required")
//////        @Min(value = 1, message = "Amount must be greater than 0")
//////        private Double amount;
//////
//////        public Object getPaymentMethod() {
//////        }
//////    }
//////}
////
////import com.zawadig.myafwanii.dto.RequestPaymentDTO;
////import com.zawadig.myafwanii.Model.ServicePayment;
////import com.zawadig.myafwanii.Service.ServicePaymentService;
////
////import lombok.RequiredArgsConstructor;
////import lombok.extern.slf4j.Slf4j;
////
////import org.springframework.http.ResponseEntity;
////import org.springframework.validation.annotation.Validated;
////import org.springframework.web.bind.annotation.*;
////
//////import javax.validation.Valid;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/v1/request-payments")
////@RequiredArgsConstructor
////@Slf4j
////@Validated
////public class ServicePaymentController {
////
////    private final ServicePaymentService servicePaymentService;
//////
//////    @PostMapping("/request")
//////    public ResponseEntity<?> requestPayment(@RequestBody @Valid RequestPaymentDTO dto) {
//////        try {
//////            log.info("Imepokea ombi: {}", dto);
//////
//////            ServicePayment payment = servicePaymentService.requestPayment(
//////                    dto.getCustomerId(),
//////                    dto.getServiceType(),
//////                    dto.getAmount(),
//////                    dto.getPaymentMethod(),
//////                    dto.getPhone()
//////            );
//////
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "message", "Control number generated",
//////                    "controlNumber", payment.getControlNumber(),
//////                    "paymentStatus", payment.getPaymentStatus()
//////            ));
//////        } catch (Exception e) {
//////            log.error("Error in requestPayment", e);
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Failed to generate control number",
//////                    "error", e.getMessage()
//////            ));
//////        }
//////    }
//////}
//////@PostMapping("/request")
//////public ResponseEntity<?> requestPayment(@RequestBody @Valid RequestPaymentDTO dto) {
//////    try {
//////        log.info("Imepokea ombi: {}", dto);
//////
//////        // Hakiki data kabla ya kufanya mchakato
//////        if (dto.getCustomerId() == null || dto.getAmount() == null) {
//////            throw new IllegalArgumentException("Taarifa za mteja au kiasi hazikamiliki");
//////        }
//////
//////        // Tengeneza namba ya kudhibiti kabla ya kuhifadhi
//////        String controlNumber = generateControlNumber(); // Tengeneza mbinu yako mwenyewe
//////
//////        ServicePayment payment = servicePaymentService.RequestPayment(
//////                dto.getCustomerId(),
//////                dto.getServiceType(),
//////                dto.getAmount(),
//////                dto.getPaymentMethod(),
//////                dto.getPhone(),
//////                controlNumber // Pita namba ya kudhibiti tayari
//////        );
//////
//////        if (payment == null || payment.getControlNumber() == null) {
//////            throw new RuntimeException("Imeshindwa kuhifadhi malipo");
//////        }
//////
//////        return ResponseEntity.ok(Map.of(
//////                "success", true,
//////                "message", "Control number generated",
//////                "controlNumber", payment.getControlNumber(),
//////                "paymentStatus", "PENDING" // Weka hali ya awali
//////        ));
//////    } catch (Exception e) {
//////        log.error("Error in requestPayment", e);
//////        return ResponseEntity.badRequest().body(Map.of(
//////                "success", false,
//////                "message", "Failed to generate control number: " + e.getMessage(),
//////                "error", e.getMessage()
//////        ));
//////    }
//////}
//////
//////    // Mbinu ya kuzalisha namba ya kudhibiti
//////    private String generateControlNumber() {
//////        return "CN" + System.currentTimeMillis() + (int)(Math.random() * 1000);
//////    }}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.ServicePayment;
////import com.zawadig.myafwanii.Service.ServicePaymentService;
////import com.zawadig.myafwanii.Service.ServicePaymentServiceImpl;
////import com.zawadig.myafwanii.dto.RequestPaymentDTO;
////import jakarta.validation.Valid;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/v1/request-payments")
////public class ServicePaymentController {
////
////    @Autowired
////    private ServicePaymentService servicePaymentService;
////
//////    @PostMapping("/request")
//////    public ResponseEntity<?> requestPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//////        try {
//////            String controlNumber = generateControlNumber();
//////
//////            ServicePayment payment = servicePaymentService.createPayment(dto, controlNumber);
//////
//////            if (payment == null || payment.getControlNumber() == null) {
//////                throw new RuntimeException("Imeshindwa kuhifadhi malipo");
//////            }
//////
//////            return ResponseEntity.ok(Map.of(
//////                    "success", true,
//////                    "message", "Control number generated",
//////                    "controlNumber", payment.getControlNumber(),
//////                    "paymentStatus", payment.getPaymentStatus().toString()
//////            ));
//////        } catch (Exception e) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Failed to generate control number: " + e.getMessage()
//////            ));
//////        }
//////    }
//////
//////    @GetMapping("/status/{controlNumber}")
//////    public ResponseEntity<?> getPaymentStatus(@PathVariable String controlNumber) {
//////        ServicePayment payment = servicePaymentService.getPaymentByControlNumber(controlNumber);
//////        if (payment == null) {
//////            return ResponseEntity.badRequest().body(Map.of(
//////                    "success", false,
//////                    "message", "Payment not found for control number: " + controlNumber
//////            ));
//////        }
//////        return ResponseEntity.ok(Map.of(
//////                "success", true,
//////                "paymentStatus", payment.getPaymentStatus().toString()
//////        ));
//////    }
//////
//////    private String generateControlNumber() {
//////        return "CN" + System.currentTimeMillis() + (int)(Math.random() * 1000);
//////    }
//////}
////
////
////
////        @PostMapping("/request")
////        public ResponseEntity<?> requestPayment(@Valid @RequestBody RequestPaymentDTO dto) {
////            String controlNumber = ((ServicePaymentServiceImpl)servicePaymentService).generateControlNumber();
////
////            ServicePayment payment = servicePaymentService.createPayment(dto, controlNumber);
////
////            if (payment == null || payment.getControlNumber() == null) {
////                throw new RuntimeException("Imeshindwa kuhifadhi malipo");
////            }
////
////            return ResponseEntity.ok(Map.of(
////                    "success", true,
////                    "message", "Control number generated",
////                    "controlNumber", payment.getControlNumber(),
////                    "paymentStatus", payment.getPaymentStatus().toString()
////            ));
////        }
////    }
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.Service.ServicePaymentServiceImpl;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import com.zawadig.myafwanii.dto.ServicePaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService servicePaymentService;
//
//    // 1️⃣ Mteja anatoa ombi la control number
//    @PostMapping("/request")
//    public ResponseEntity<?> requestPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        String controlNumber = ((ServicePaymentServiceImpl) servicePaymentService).generateControlNumber();
//
//        ServicePayment payment = servicePaymentService.createPayment(dto, controlNumber);
//
//        if (payment == null || payment.getControlNumber() == null) {
//            throw new RuntimeException("Imeshindwa kuhifadhi malipo");
//        }
//
//        return ResponseEntity.ok(Map.of(
//                "success", true,
//                "message", "Control number generated",
//                "controlNumber", payment.getControlNumber(),
//                "paymentStatus", payment.getPaymentStatus().toString()
//        ));
//    }
//
//    // 2️⃣ Mteja ana-check status ya malipo
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> getPaymentStatus(@PathVariable String controlNumber) {
//        ServicePayment payment = servicePaymentService.getPaymentByControlNumber(controlNumber);
//        if (payment == null) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Payment not found for control number: " + controlNumber
//            ));
//        }
//        return ResponseEntity.ok(Map.of(
//                "success", true,
//                "paymentStatus", payment.getPaymentStatus().toString()
//        ));
//    }
//
//    // 3️⃣ Admin anathibitisha malipo
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        boolean updated = servicePaymentService.verifyPayment(controlNumber);
//        if (!updated) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", "Failed to verify payment. Control number not found."
//            ));
//        }
//        return ResponseEntity.ok(Map.of(
//                "success", true,
//                "message", "Payment verified successfully."
//        ));
//    }
//} MUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUIMUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
// port com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import com.zawadig.myafwanii.dto.ServicePaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
////import javax.validation.Valid;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService servicePaymentService;
//
//    @PostMapping("/request")
//    public ResponseEntity<?> requestPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = servicePaymentService.createPayment(dto);
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment request created successfully",
//                    "payment", convertToDTO(payment)
//            );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", e.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> getPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePaymentDTO payment = servicePaymentService.getPaymentByControlNumber(controlNumber);
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "payment", payment
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", e.getMessage()
//            ));
//        }
//    }
//
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            ServicePaymentDTO payment = servicePaymentService.verifyPayment(controlNumber);
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment verified successfully",
//                    "payment", payment
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", e.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllPayments() {
//        try {
//            List<ServicePaymentDTO> payments = servicePaymentService.getAllPayments();
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "payments", payments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                    "success", false,
//                    "message", e.getMessage()
//            ));
//        }
//    }
//
//    private ServicePaymentDTO convertToDTO(ServicePayment payment) {
//        ServicePaymentDTO dto = new ServicePaymentDTO();
//        dto.setId(payment.getId());
//        dto.setControlNumber(payment.getControlNumber());
//        dto.setAmount(payment.getAmount());
//        dto.setPaymentMethod(payment.getPaymentMethod());
//        dto.setPaymentStatus(payment.getPaymentStatus());
//        dto.setPaymentDate(payment.getPaymentDate());
//        dto.setCreatedAt(payment.getCreatedAt());
//
//        if (payment.getRequestForm() != null) {
//            dto.setRequestFormId(payment.getRequestForm().getId());
//            if (payment.getRequestForm().getCustomer() != null) {
//                dto.setCustomerName(payment.getRequestForm().getCustomer().getName());
//            }
//            dto.setServiceType(payment.getRequestForm().getServiceType());
//        }
//
//        return dto;
//    }
//}
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    // 1️⃣ Create payment request and generate control number
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            if (payment == null || payment.getControlNumber() == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to save payment information"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "controlNumber", payment.getControlNumber(),
//                    "paymentStatus", payment.getPaymentStatus().toString()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 2️⃣ Check payment status
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "No payment found with control number: " + controlNumber
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "paymentStatus", payment.getPaymentStatus().toString(),
//                    "paymentDate", payment.getPaymentDate()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 3️⃣ Verify payment (Admin only)
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            boolean isVerified = paymentService.verifyPayment(controlNumber);
//
//            if (!isVerified) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to verify payment. Control number not found or payment already verified"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment verified successfully",
//                    "controlNumber", controlNumber
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//}
// ioooooo muuuuimuuuuuuuu kwenye dasboaaaardddd usifuteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee





//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Notification;
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Repository.NotificationRepository;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
////@CrossOrigin(origins = "*") // Kuwezesha mawasiliano kutoka React Native
//public class ServicePaymentController {
//
//    private final ServicePaymentService paymentService;
//
//    @Autowired
//    public ServicePaymentController(ServicePaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    // 1️⃣ Create payment request
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            if (payment == null || payment.getControlNumber() == null) {
//                return errorResponse(HttpStatus.BAD_REQUEST, "Failed to process payment");
//            }
//
//            return successResponse(
//                    "Control number generated successfully",
//                    Map.of(
//                            "controlNumber", payment.getControlNumber(),
//                            "paymentStatus", payment.getPaymentStatus().toString(),
//                            "amount", payment.getAmount() // Kuongeza amount kwa response
//                    )
//            );
//
//        } catch (Exception e) {
//            return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Payment error: " + e.getMessage());
//        }
//    }
//
//    // 2️⃣ Check payment status
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return errorResponse(HttpStatus.NOT_FOUND, "Payment not found");
//            }
//
//            return successResponse(
//                    "Payment status retrieved",
//                    Map.of(
//                            "paymentStatus", payment.getPaymentStatus().toString(),
//                            "paymentDate", payment.getPaymentDate(),
//                            "amountPaid", payment.getAmountPaid(),
//                            "serviceType", payment.getServiceType()
//                    )
//            );
//
//        } catch (Exception e) {
//            return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Status check failed: " + e.getMessage());
//        }
//    }
//
//    // 3️⃣ Verify payment (Admin only)
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            // 1. First get the payment to verify
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return errorResponse(HttpStatus.NOT_FOUND, "Payment not found");
//            }
//
//            // 2. Perform verification
//            boolean isVerified = paymentService.verifyPayment(controlNumber);
//
//            if (!isVerified) {
//                return errorResponse(HttpStatus.BAD_REQUEST, "Payment already verified or verification failed");
//            }
//
//            // 3. Get updated payment details
//            ServicePayment verifiedPayment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            return successResponse(
//                    "Payment verified successfully",
//                    Map.of(
//                            "controlNumber", verifiedPayment.getControlNumber(),
//                            "verifiedAt", verifiedPayment.getUpdatedAt(),
//                            "paymentStatus", verifiedPayment.getPaymentStatus()
//                    )
//            );
//
//        } catch (Exception e) {
//            return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
//                    "Verification error: " + e.getMessage());
//        }
//    }
//
//    // Helper methods
//    private ResponseEntity<?> successResponse(String message, Map<String, Object> data) {
//        return ResponseEntity.ok(Map.of(
//                "success", true,
//                "message", message,
//                "data", data
//        ));
//    }
//
//    private ResponseEntity<?> errorResponse(HttpStatus status, String errorMessage) {
//        return ResponseEntity.status(status).body(Map.of(
//                "success", false,
//                "message", errorMessage
//        ));
//    }
//    // ServicePaymentController.java
//    @PutMapping("/admin/verify/{controlNumber}")
//    public ResponseEntity<?> adminVerifyPayment(
//            @PathVariable String controlNumber,
//            @RequestHeader("Authorization") String authHeader) {
//
//        // 1. Hakiki kama admin
////        Object authService = new Object();
////        if (!authService.isAdmin(authHeader)) {
////            return errorResponse(HttpStatus.UNAUTHORIZED, "Unauthorized access");
////        }
//
//        // 2. Tafuta malipo
//        ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//        if (payment == null) {
//            return errorResponse(HttpStatus.NOT_FOUND, "Malipo hayajapatikana");
//        }
//
//        // 3. Thibitisha
//        paymentService.verifyPayment(controlNumber);
//
//        // 4. Tuma notifikasi
//        Notification notifikasi = new Notification();
//        notifikasi.setTitle("Uthibitishaji wa Malipo");
//        notifikasi.setMessage("Malipo yako ya " + payment.getAmount() + " kwa huduma ya "
//                + payment.getServiceType() + " yamethibitishwa. Namba ya kudhibiti: " + controlNumber);
//        notifikasi.setCustomer(payment.getCustomer());
//        NotificationRepository.Save((com.sun.nio.sctp.Notification) notifikasi);
//
//        // 5. Tuma SMS (optional)
//        SmsController smsService = new SmsController();
//        smsService.sendSms(
//                payment.getPhone(),
//                "Malipo yako yamethibitishwa. Namba ya kudhibiti: " + controlNumber
//        );
//
//        return successResponse(
//                "Malipo yamethibitishwa",
//                Map.of(
//                        "controlNumber", controlNumber,
//                        "newStatus", "VERIFIED",
//                        "notificationId", notifikasi.getId()
//                )
//        );
//    }
//}



//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    // 1️⃣ Create payment request and generate control number
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            if (payment == null || payment.getControlNumber() == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to save payment information"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "controlNumber", payment.getControlNumber(),
//                    "paymentStatus", payment.getPaymentStatus().toString()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 2️⃣ Check payment status using control number
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "No payment found with control number: " + controlNumber
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "controlNumber", controlNumber,
//                    "paymentStatus", payment.getPaymentStatus().toString(),
//                    "paymentDate", payment.getPaymentDate()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 3️⃣ Verify payment by control number
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            boolean isVerified = paymentService.verifyPayment(controlNumber);
//
//            if (!isVerified) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to verify payment. Control number not found or payment already verified"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment verified successfully",
//                    "controlNumber", controlNumber
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 4️⃣ Get all payments (for now, all users — you can filter later by user)
////    @GetMapping("/all")
////    public ResponseEntity<?> getAllPayments() {
////        try {
////            List<ServicePayment> payments = paymentService.getAllPayments();
////            return ResponseEntity.ok(Map.of(
////                    "success", true,
////                    "count", payments.size(),
////                    "payments", payments
////            ));
////        } catch (Exception e) {
////            return ResponseEntity.internalServerError().body(Map.of(
////                    "success", false,
////                    "message", "Failed to fetch payment records: " + e.getMessage()
////            ));
////        }
////    }
////}
//
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getAllPayments();
//
//            // Safisha data kabla ya kuituma
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                // Add customer info if exists
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch payment records: " + e.getMessage()
//            ));
//        }
//    }
//    @GetMapping("/verified")
//    public ResponseEntity<?> getVerifiedPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch verified payments: " + e.getMessage()
//            ));
//        }
//    }
//
//}ya muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu kwenye kuverify



































//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
////@CrossOrigin(origins = "*")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    // 1️⃣ Create payment request and generate control number
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            if (payment == null || payment.getControlNumber() == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to save payment information"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "controlNumber", payment.getControlNumber(),
//                    "paymentStatus", payment.getPaymentStatus().toString()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 2️⃣ Check payment status using control number
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "No payment found with control number: " + controlNumber
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "controlNumber", controlNumber,
//                    "paymentStatus", payment.getPaymentStatus().toString(),
//                    "paymentDate", payment.getPaymentDate()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 3️⃣ Verify payment by control number
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            boolean isVerified = paymentService.verifyPayment(controlNumber);
//
//            if (!isVerified) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to verify payment. Control number not found or payment already verified"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment verified successfully",
//                    "controlNumber", controlNumber
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 4️⃣ Get all service payments
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getAllPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch payment records: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 5️⃣ Get verified payments (for admin or summary)
//    @GetMapping("/verified")
//    public ResponseEntity<?> getVerifiedPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch verified payments: " + e.getMessage()
//            ));
//        }
//    }
//
//    /// 6️⃣ ✅ NEW: Get verified payments for a specific customer
//    @GetMapping("/customer/{customerId}/verified")
//    public ResponseEntity<?> getVerifiedPaymentsByCustomer(@PathVariable Long customerId) {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPaymentsByCustomerId(customerId);
//
//            // ✅ Jihadhari: kama payments ni null, rudisha empty list
//            if (payments == null || payments.isEmpty()) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "count", 0,
//                        "payments", List.of()  // empty list
//                ));
//            }
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", payment.getId());
//                map.put("controlNumber", payment.getControlNumber());
//                map.put("amountPaid", payment.getAmountPaid());
//                map.put("paymentStatus", payment.getPaymentStatus().toString());
//                map.put("paymentDate", payment.getPaymentDate());
//                map.put("phone", payment.getPhone());
//                if (payment.getCustomer() != null) {
//                    map.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    map.put("customerName", "N/A");
//                }
//                return map;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch customer verified payments: " + e.getMessage()
//            ));
//        }
//    }
//} muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu














//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
////@CrossOrigin(origins = "*") // weka if needed kwa frontend CORS
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    // 1️⃣ Create payment request and generate control number
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            if (payment == null || payment.getControlNumber() == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to save payment information"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "controlNumber", payment.getControlNumber(),
//                    "paymentStatus", payment.getPaymentStatus().toString()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 2️⃣ Check payment status using control number
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "No payment found with control number: " + controlNumber
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "controlNumber", controlNumber,
//                    "paymentStatus", payment.getPaymentStatus().toString(),
//                    "paymentDate", payment.getPaymentDate()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 3️⃣ Verify payment by control number
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            boolean isVerified = paymentService.verifyPayment(controlNumber);
//
//            if (!isVerified) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to verify payment. Control number not found or payment already verified"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment verified successfully",
//                    "controlNumber", controlNumber
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 4️⃣ Get all service payments
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getAllPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch payment records: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 5️⃣ Get verified payments (for admin or summary)
//    @GetMapping("/verified")
//    public ResponseEntity<?> getVerifiedPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch verified payments: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 6️⃣ Get verified payments for a specific customer
//    @GetMapping("/customer/{customerId}/verified")
//    public ResponseEntity<?> getVerifiedPaymentsByCustomer(@PathVariable Long customerId) {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPaymentsByCustomerId(customerId);
//
//            if (payments == null || payments.isEmpty()) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "count", 0,
//                        "payments", List.of()
//                ));
//            }
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", payment.getId());
//                map.put("controlNumber", payment.getControlNumber());
//                map.put("amountPaid", payment.getAmountPaid());
//                map.put("paymentStatus", payment.getPaymentStatus().toString());
//                map.put("paymentDate", payment.getPaymentDate());
//                map.put("phone", payment.getPhone());
//                if (payment.getCustomer() != null) {
//                    map.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    map.put("customerName", "N/A");
//                }
//                return map;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch customer verified payments: " + e.getMessage()
//            ));
//        }
//    }
//}



//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
////@CrossOrigin(origins = "*")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    // 1️⃣ Create payment request and generate control number
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            if (payment == null || payment.getControlNumber() == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to save payment information"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Control number generated successfully",
//                    "controlNumber", payment.getControlNumber(),
//                    "paymentStatus", payment.getPaymentStatus().toString()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 2️⃣ Check payment status using control number
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "No payment found with control number: " + controlNumber
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "controlNumber", controlNumber,
//                    "paymentStatus", payment.getPaymentStatus().toString(),
//                    "paymentDate", payment.getPaymentDate()
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 2️⃣b Check payment status using requestFormId and customerId
//    @GetMapping("/status")
//    public ResponseEntity<?> getPaymentStatusByRequestFormAndCustomer(
//            @RequestParam Long requestFormId,
//            @RequestParam Long customerId
//    ) {
//        ServicePayment payment = paymentService.getLatestPaymentByRequestFormAndCustomer(requestFormId, customerId);
//        if (payment == null) {
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "paymentStatus", "NO_PAYMENT"
//            ));
//        }
//        return ResponseEntity.ok(Map.of(
//                "success", true,
//                "paymentStatus", payment.getPaymentStatus().toString(),
//                "controlNumber", payment.getControlNumber(),
//                "paymentDate", payment.getPaymentDate()
//        ));
//    }
//
//    // 3️⃣ Verify payment by control number
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            boolean isVerified = paymentService.verifyPayment(controlNumber);
//
//            if (!isVerified) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Failed to verify payment. Control number not found or payment already verified"
//                ));
//            }
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Payment verified successfully",
//                    "controlNumber", controlNumber
//            ));
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "System error: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 4️⃣ Get all service payments
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getAllPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch payment records: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 5️⃣ Get verified payments (for admin or summary)
//    @GetMapping("/verified")
//    public ResponseEntity<?> getVerifiedPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPayments();
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> paymentMap = new HashMap<>();
//                paymentMap.put("id", payment.getId());
//                paymentMap.put("controlNumber", payment.getControlNumber());
//                paymentMap.put("amountPaid", payment.getAmountPaid());
//                paymentMap.put("paymentStatus", payment.getPaymentStatus().toString());
//                paymentMap.put("paymentDate", payment.getPaymentDate());
//                paymentMap.put("phone", payment.getPhone());
//
//                if (payment.getCustomer() != null) {
//                    paymentMap.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    paymentMap.put("customerName", "N/A");
//                }
//
//                return paymentMap;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch verified payments: " + e.getMessage()
//            ));
//        }
//    }
//
//    // 6️⃣ Get verified payments for a specific customer
//    @GetMapping("/customer/{customerId}/verified")
//    public ResponseEntity<?> getVerifiedPaymentsByCustomer(@PathVariable Long customerId) {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPaymentsByCustomerId(customerId);
//
//            if (payments == null || payments.isEmpty()) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "count", 0,
//                        "payments", List.of()
//                ));
//            }
//
//            List<Map<String, Object>> cleanedPayments = payments.stream().map(payment -> {
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", payment.getId());
//                map.put("controlNumber", payment.getControlNumber());
//                map.put("amountPaid", payment.getAmountPaid());
//                map.put("paymentStatus", payment.getPaymentStatus().toString());
//                map.put("paymentDate", payment.getPaymentDate());
//                map.put("phone", payment.getPhone());
//                if (payment.getCustomer() != null) {
//                    map.put("customerName", payment.getCustomer().getFullName());
//                } else {
//                    map.put("customerName", "N/A");
//                }
//                return map;
//            }).collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", cleanedPayments.size(),
//                    "payments", cleanedPayments
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Failed to fetch customer verified payments: " + e.getMessage()
//            ));
//        }
//    }
//}  muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu

























//
//
//
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.PaymentHistoryDTO;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    // 1️⃣ Fanya malipo ya huduma
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("success", true);
//            response.put("message", "Malipo yamepokelewa kwa mafanikio");
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("paymentStatus", payment.getPaymentStatus().toString());
//            response.put("amount", payment.getAmountPaid());
//            response.put("serviceType", payment.getServiceType());
//            response.put("paymentDate", formatDate(payment.getPaymentDate()));
//
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            return errorResponse("Malipo yameshindikana", e);
//        }
//    }
//    @GetMapping("/history/{customerId}")
//    public ResponseEntity<?> getPaymentHistory(@PathVariable Long customerId) {
//        try {
//            List<ServicePayment> payments = paymentService.getPaymentHistoryByCustomerId(customerId);
//
//            List<PaymentHistoryDTO> history = payments.stream()
//                    .map(payment -> {
//                        PaymentHistoryDTO dto = new PaymentHistoryDTO();
//                        dto.setId(payment.getId());
//                        dto.setControlNumber(payment.getControlNumber());
//                        dto.setAmountPaid(payment.getAmountPaid());
//                        dto.setPaymentStatus(payment.getPaymentStatus().toString());
//                        dto.setPaymentDate(payment.getPaymentDate() != null ?
//                                payment.getPaymentDate().format(DATE_FORMATTER) : null);
//                        dto.setServiceType(payment.getServiceType());
//                        dto.setPaymentMethod(payment.getPaymentMethod());
//                        dto.setPhone(payment.getPhone());
//                        dto.setVerifiedDate(payment.getVerificationDate() != null ?
//                                payment.getVerificationDate().format(DATE_FORMATTER) : null);
//                        return dto;
//                    })
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", history.size(),
//                    "payments", history
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(Map.of(
//                    "success", false,
//                    "message", "Imeshindikana kupata historia ya malipo",
//                    "error", e.getMessage()
//            ));
//        }
//    }
//    // 3️⃣ Angalia status ya malipo kwa namba ya udhibiti
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "paymentStatus", "HAKUNA_TAARIFA",
//                        "message", "Hakuna malipo yaliyopatikana na namba hii ya udhibiti"
//                ));
//            }
//
//            return ResponseEntity.ok(createStatusResponse(payment));
//
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kuangalia hali ya malipo", e);
//        }
//    }
//
//    // 4️⃣ Angalia status ya malipo kwa namba ya ombi na mteja
//    @GetMapping("/status")
//    public ResponseEntity<?> getPaymentStatus(
//            @RequestParam Long requestFormId,
//            @RequestParam Long customerId) {
//        try {
//            ServicePayment payment = paymentService.getLatestPaymentByRequestFormAndCustomer(requestFormId, customerId);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "paymentStatus", "HAKUNA_TAARIFA"
//                ));
//            }
//
//            return ResponseEntity.ok(createStatusResponse(payment));
//
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kuangalia hali ya malipo", e);
//        }
//    }
//
//    // ====== Mbinu za Kusaidia ======
//
//    private PaymentHistoryDTO convertToHistoryDTO(ServicePayment payment) {
//        PaymentHistoryDTO dto = new PaymentHistoryDTO();
//        dto.setId(payment.getId());
//        dto.setControlNumber(payment.getControlNumber());
//        dto.setAmountPaid(payment.getAmountPaid());
//        dto.setPaymentStatus(payment.getPaymentStatus().toString());
//        dto.setPaymentDate(formatDate(payment.getPaymentDate()));
//        dto.setServiceType(payment.getServiceType());
//        dto.setPaymentMethod(payment.getPaymentMethod());
//        dto.setPhone(payment.getPhone());
//        return dto;
//    }
//
//    private Map<String, Object> createStatusResponse(ServicePayment payment) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", true);
//        response.put("paymentStatus", payment.getPaymentStatus().toString());
//        response.put("controlNumber", payment.getControlNumber());
//        response.put("amountPaid", payment.getAmountPaid());
//        response.put("serviceType", payment.getServiceType());
//        response.put("paymentDate", formatDate(payment.getPaymentDate()));
//
//        if (payment.getPaymentStatus() == PaymentStatus.VERIFIED) {
//            response.put("verifiedDate", formatDate(payment.getVerificationDate()));
//        }
//
//        return response;
//    }
//
//    private String formatDate(LocalDateTime date) {
//        return date != null ? date.format(DATE_FORMATTER) : null;
//    }
//
//    private ResponseEntity<Map<String, Object>> errorResponse(String message, Exception e) {
//        return ResponseEntity.internalServerError().body(Map.of(
//                "success", false,
//                "message", message,
//                "error", e.getMessage()
//        ));
//    }
//} muimuuuuuu 2 kwa formid





















//
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Service.ServicePaymentService;
//import com.zawadig.myafwanii.dto.PaymentHistoryDTO;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/v1/request-payments")
//public class ServicePaymentController {
//
//    @Autowired
//    private ServicePaymentService paymentService;
//
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    @PutMapping("/verify/{controlNumber}")
//    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.verifyPayment(controlNumber);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("success", true);
//            response.put("message", "Malipo yamethibitishwa kikamilifu");
//            response.put("paymentStatus", payment.getPaymentStatus().toString());
//            response.put("verifiedDate", formatDate(payment.getVerificationDate()));
//
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("success", false);
//            errorResponse.put("message", "Imeshindikana kuthibitisha malipo");
//            errorResponse.put("error", e.getMessage() != null ? e.getMessage() : "Unknown error");
//
//            return ResponseEntity.badRequest().body(errorResponse);
//        }
//    }
//
//    // Other methods remain exactly the same as in your original code
//    @PostMapping("/request")
//    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
//        try {
//            ServicePayment payment = paymentService.createPayment(dto);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("success", true);
//            response.put("message", "Malipo yamepokelewa kwa mafanikio");
//            response.put("controlNumber", payment.getControlNumber());
//            response.put("paymentStatus", payment.getPaymentStatus().toString());
//            response.put("amount", payment.getAmountPaid());
//            response.put("serviceType", payment.getServiceType());
//            response.put("paymentDate", formatDate(payment.getPaymentDate()));
//
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            return errorResponse("Malipo yameshindikana", e);
//        }
//    }
//
//    @GetMapping("/history/{customerId}")
//    public ResponseEntity<?> getPaymentHistory(@PathVariable Long customerId) {
//        try {
//            List<ServicePayment> payments = paymentService.getPaymentHistoryByCustomerId(customerId);
//
//            List<PaymentHistoryDTO> history = payments.stream()
//                    .map(this::convertToHistoryDTO)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", history.size(),
//                    "payments", history
//            ));
//
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kupata historia ya malipo", e);
//        }
//    }
//
//    @GetMapping("/status/{controlNumber}")
//    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
//        try {
//            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "paymentStatus", "HAKUNA_TAARIFA",
//                        "message", "Hakuna malipo yaliyopatikana na namba hii ya udhibiti"
//                ));
//            }
//
//            return ResponseEntity.ok(createStatusResponse(payment));
//
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kuangalia hali ya malipo", e);
//        }
//    }
//
//    @GetMapping("/status")
//    public ResponseEntity<?> getPaymentStatus(
//            @RequestParam Long requestFormId,
//            @RequestParam Long customerId) {
//        try {
//            ServicePayment payment = paymentService.getLatestPaymentByRequestFormAndCustomer(requestFormId, customerId);
//
//            if (payment == null) {
//                return ResponseEntity.ok(Map.of(
//                        "success", true,
//                        "paymentStatus", "HAKUNA_TAARIFA"
//                ));
//            }
//
//            return ResponseEntity.ok(createStatusResponse(payment));
//
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kuangalia hali ya malipo", e);
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getAllPayments();
//
//            List<PaymentHistoryDTO> history = payments.stream()
//                    .map(this::convertToHistoryDTO)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", history.size(),
//                    "payments", history
//            ));
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kupata malipo yote", e);
//        }
//    }
//
//    @GetMapping("/verified")
//    public ResponseEntity<?> getVerifiedPayments() {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPayments();
//
//            List<PaymentHistoryDTO> history = payments.stream()
//                    .map(this::convertToHistoryDTO)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", history.size(),
//                    "payments", history
//            ));
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kupata malipo yaliyothibitishwa", e);
//        }
//    }
//
//    @GetMapping("/customer/{customerId}/verified")
//    public ResponseEntity<?> getVerifiedPaymentsByCustomer(@PathVariable Long customerId) {
//        try {
//            List<ServicePayment> payments = paymentService.getVerifiedPaymentsByCustomerId(customerId);
//
//            List<PaymentHistoryDTO> history = payments.stream()
//                    .map(this::convertToHistoryDTO)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "count", history.size(),
//                    "payments", history
//            ));
//        } catch (Exception e) {
//            return errorResponse("Imeshindikana kupata historia ya mteja", e);
//        }
//    }
//
//    // ====== Helper Methods ======
//    private PaymentHistoryDTO convertToHistoryDTO(ServicePayment payment) {
//        PaymentHistoryDTO dto = new PaymentHistoryDTO();
//        dto.setId(payment.getId());
//        dto.setControlNumber(payment.getControlNumber());
//        dto.setAmountPaid(payment.getAmountPaid());
//        dto.setPaymentStatus(payment.getPaymentStatus().toString());
//        dto.setPaymentDate(formatDate(payment.getPaymentDate()));
//        dto.setServiceType(payment.getServiceType());
//        dto.setPaymentMethod(payment.getPaymentMethod());
//        dto.setPhone(payment.getPhone());
//        dto.setVerifiedDate(formatDate(payment.getVerificationDate()));
//        return dto;
//    }
//
//    private Map<String, Object> createStatusResponse(ServicePayment payment) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", true);
//        response.put("paymentStatus", payment.getPaymentStatus().toString());
//        response.put("controlNumber", payment.getControlNumber());
//        response.put("amountPaid", payment.getAmountPaid());
//        response.put("serviceType", payment.getServiceType());
//        response.put("paymentDate", formatDate(payment.getPaymentDate()));
//
//        if (payment.getPaymentStatus() == PaymentStatus.VERIFIED) {
//            response.put("verifiedDate", formatDate(payment.getVerificationDate()));
//        }
//
//        return response;
//    }
//
//    private String formatDate(LocalDateTime date) {
//        return date != null ? date.format(DATE_FORMATTER) : null;
//    }
//
//    private ResponseEntity<Map<String, Object>> errorResponse(String message, Exception e) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", false);
//        response.put("message", message != null ? message : "Error occurred");
//        response.put("error", e != null && e.getMessage() != null ? e.getMessage() : "Unknown error");
//
//        return ResponseEntity.internalServerError().body(response);
//    }
//} muuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu











package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.ServicePayment;
import com.zawadig.myafwanii.Service.ServicePaymentService;
import com.zawadig.myafwanii.Service.PdfStorageService;
import com.zawadig.myafwanii.dto.PaymentHistoryDTO;
import com.zawadig.myafwanii.dto.RequestPaymentDTO;
import com.zawadig.myafwanii.enums.PaymentStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/request-payments")
public class ServicePaymentController {

    @Autowired
    private ServicePaymentService paymentService;

    @Autowired
    private PdfStorageService pdfStorageService;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @PutMapping("/verify/{controlNumber}")
    public ResponseEntity<?> verifyPayment(@PathVariable String controlNumber) {
        try {
            ServicePayment payment = paymentService.verifyPayment(controlNumber);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Malipo yamethibitishwa kikamilifu");
            response.put("paymentStatus", payment.getPaymentStatus().toString());
            response.put("verifiedDate", formatDate(payment.getVerificationDate()));

            if (payment.getPdfReference() != null) {
                response.put("pdfUrl", "/api/v1/request-payments/download-pdf/" + controlNumber);
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Imeshindikana kuthibitisha malipo");
            errorResponse.put("error", e.getMessage() != null ? e.getMessage() : "Unknown error");

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/request")
    public ResponseEntity<?> createPayment(@Valid @RequestBody RequestPaymentDTO dto) {
        try {
            ServicePayment payment = paymentService.createPayment(dto);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Malipo yamepokelewa kwa mafanikio");
            response.put("controlNumber", payment.getControlNumber());
            response.put("paymentStatus", payment.getPaymentStatus().toString());
            response.put("amount", payment.getAmountPaid());
            response.put("serviceType", payment.getServiceType());
            response.put("paymentDate", formatDate(payment.getPaymentDate()));

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return errorResponse("Malipo yameshindikana", e);
        }
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<?> getPaymentHistory(@PathVariable Long customerId) {
        try {
            List<ServicePayment> payments = paymentService.getPaymentHistoryByCustomerId(customerId);

            List<PaymentHistoryDTO> history = payments.stream()
                    .map(this::convertToHistoryDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "count", history.size(),
                    "payments", history
            ));

        } catch (Exception e) {
            return errorResponse("Imeshindikana kupata historia ya malipo", e);
        }
    }

    @GetMapping("/status/{controlNumber}")
    public ResponseEntity<?> checkPaymentStatus(@PathVariable String controlNumber) {
        try {
            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);

            if (payment == null) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "paymentStatus", "HAKUNA_TAARIFA",
                        "message", "Hakuna malipo yaliyopatikana na namba hii ya udhibiti"
                ));
            }

            Map<String, Object> response = createStatusResponse(payment);
            if (payment.getPdfReference() != null) {
                response.put("pdfUrl", "/api/v1/request-payments/download-pdf/" + controlNumber);
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return errorResponse("Imeshindikana kuangalia hali ya malipo", e);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<?> getPaymentStatus(
            @RequestParam Long requestFormId,
            @RequestParam Long customerId) {
        try {
            ServicePayment payment = paymentService.getLatestPaymentByRequestFormAndCustomer(requestFormId, customerId);

            if (payment == null) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "paymentStatus", "HAKUNA_TAARIFA"
                ));
            }

            Map<String, Object> response = createStatusResponse(payment);
            if (payment.getPdfReference() != null) {
                response.put("pdfUrl", "/api/v1/request-payments/download-pdf/" + payment.getControlNumber());
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return errorResponse("Imeshindikana kuangalia hali ya malipo", e);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPayments() {
        try {
            List<ServicePayment> payments = paymentService.getAllPayments();

            List<PaymentHistoryDTO> history = payments.stream()
                    .map(this::convertToHistoryDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "count", history.size(),
                    "payments", history
            ));
        } catch (Exception e) {
            return errorResponse("Imeshindikana kupata malipo yote", e);
        }
    }

    @GetMapping("/verified")
    public ResponseEntity<?> getVerifiedPayments() {
        try {
            List<ServicePayment> payments = paymentService.getVerifiedPayments();

            List<PaymentHistoryDTO> history = payments.stream()
                    .map(this::convertToHistoryDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "count", history.size(),
                    "payments", history
            ));
        } catch (Exception e) {
            return errorResponse("Imeshindikana kupata malipo yaliyothibitishwa", e);
        }
    }

    @GetMapping("/customer/{customerId}/verified")
    public ResponseEntity<?> getVerifiedPaymentsByCustomer(@PathVariable Long customerId) {
        try {
            List<ServicePayment> payments = paymentService.getVerifiedPaymentsByCustomerId(customerId);

            List<PaymentHistoryDTO> history = payments.stream()
                    .map(this::convertToHistoryDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "count", history.size(),
                    "payments", history
            ));
        } catch (Exception e) {
            return errorResponse("Imeshindikana kupata historia ya mteja", e);
        }
    }

    @PostMapping("/upload-pdf/{controlNumber}")
    public ResponseEntity<?> uploadApplicationPdf(
            @PathVariable String controlNumber,
            @RequestParam("file") MultipartFile file) {
        try {
            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
            if (payment == null) {
                return ResponseEntity.notFound().build();
            }

            String pdfFilename = pdfStorageService.storePdf(file, controlNumber);
            payment.setPdfReference(pdfFilename);
            paymentService.savePayment(payment);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "PDF ya maombi imehifadhiwa kikamilifu",
                    "pdfReference", pdfFilename,
                    "downloadUrl", "/api/v1/request-payments/download-pdf/" + controlNumber
            ));
        } catch (Exception e) {
            return errorResponse("Imeshindikana kuhifadhi PDF", e);
        }
    }

    @GetMapping("/download-pdf/{controlNumber}")
    public ResponseEntity<Resource> downloadApplicationPdf(@PathVariable String controlNumber) {
        try {
            ServicePayment payment = paymentService.getPaymentByControlNumber(controlNumber);
            if (payment == null || payment.getPdfReference() == null) {
                return ResponseEntity.notFound().build();
            }

            Resource pdfResource = pdfStorageService.loadPdf(payment.getPdfReference());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "inline; filename=\"" + payment.getPdfReference() + "\"")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfResource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/verified-pdfs/{customerId}")
    public ResponseEntity<?> getVerifiedApplicationsPdfs(@PathVariable Long customerId) {
        try {
            List<ServicePayment> verifiedPayments = paymentService.getVerifiedPaymentsByCustomerId(customerId);

            List<Map<String, String>> pdfList = verifiedPayments.stream()
                    .filter(p -> p.getPdfReference() != null)
                    .map(p -> {
                        Map<String, String> pdfInfo = new HashMap<>();
                        pdfInfo.put("controlNumber", p.getControlNumber());
                        pdfInfo.put("serviceType", p.getServiceType());
                        pdfInfo.put("pdfUrl", "/api/v1/request-payments/download-pdf/" + p.getControlNumber());
                        pdfInfo.put("verifiedDate", formatDate(p.getVerificationDate()));
                        return pdfInfo;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "count", pdfList.size(),
                    "documents", pdfList
            ));
        } catch (Exception e) {
            return errorResponse("Imeshindikana kupata PDF za maombi", e);
        }
    }

    private PaymentHistoryDTO convertToHistoryDTO(ServicePayment payment) {
        PaymentHistoryDTO dto = new PaymentHistoryDTO();
        dto.setId(payment.getId());
        dto.setControlNumber(payment.getControlNumber());
        dto.setAmountPaid(payment.getAmountPaid());
        dto.setPaymentStatus(payment.getPaymentStatus().toString());
        dto.setPaymentDate(formatDate(payment.getPaymentDate()));
        dto.setServiceType(payment.getServiceType());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPhone(payment.getPhone());
        dto.setVerifiedDate(formatDate(payment.getVerificationDate()));
        dto.setPdfReference(payment.getPdfReference());

        if (payment.getPdfReference() != null) {
            dto.setPdfUrl("/api/v1/request-payments/download-pdf/" + payment.getControlNumber());
        }

        return dto;
    }

    private Map<String, Object> createStatusResponse(ServicePayment payment) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("paymentStatus", payment.getPaymentStatus().toString());
        response.put("controlNumber", payment.getControlNumber());
        response.put("amountPaid", payment.getAmountPaid());
        response.put("serviceType", payment.getServiceType());
        response.put("paymentDate", formatDate(payment.getPaymentDate()));

        if (payment.getPaymentStatus() == PaymentStatus.VERIFIED) {
            response.put("verifiedDate", formatDate(payment.getVerificationDate()));
        }

        return response;
    }

    private String formatDate(LocalDateTime date) {
        return date != null ? date.format(DATE_FORMATTER) : null;
    }

    private ResponseEntity<Map<String, Object>> errorResponse(String message, Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", message != null ? message : "Error occurred");
        response.put("error", e != null && e.getMessage() != null ? e.getMessage() : "Unknown error");

        return ResponseEntity.internalServerError().body(response);
    }
}