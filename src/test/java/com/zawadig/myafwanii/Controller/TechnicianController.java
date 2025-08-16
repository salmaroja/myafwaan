package com.zawadig.myafwanii.Controller;//////package com.zawadig.myafwanii.Controller;
//////
//////
//////
//////
//////import com.zawadig.myafwanii.Model.Technician;
//////import com.zawadig.myafwanii.Service.TechnicianService;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.web.bind.annotation.*;
//////
//////import java.util.List;
//////
//////@RestController
//////@RequestMapping("/api/technicians")
////////@CrossOrigin(origins = "*")
//////public class TechnicianController {
//////
//////    @Autowired
//////    private TechnicianService technicianService;
//////
//////    @PostMapping
//////    public Technician createTechnician(@RequestBody Technician technician) {
//////        return technicianService.saveTechnician(technician);
//////    }
//////
//////    @GetMapping("/technician")
//////    public List<Technician> getAllTechnicians() {
//////        return technicianService.getAllTechnicians();
//////    }
//////
//////    @GetMapping("/{id}")
//////    public Technician getTechnicianById(@PathVariable Long id) {
//////        return technicianService.getTechnicianById(id);
//////    }
//////
//////    @PutMapping("/{id}")
//////    public Technician updateTechnician(@PathVariable Long id, @RequestBody Technician technician) {
//////        return technicianService.updateTechnician(id, technician);
//////    }
//////
//////    @DeleteMapping("/{id}")
//////    public void deleteTechnician(@PathVariable Long id) {
//////        technicianService.deleteTechnician(id);
//////    }
//////}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Request;
////import com.zawadig.myafwanii.Repository.RequestRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////@RequestMapping("/api/technician/requests")
////@CrossOrigin("*")
////public class TechnicianController {
////
////    @Autowired
////    private RequestRepository requestRepository;
////
////    // ✅ Technician anaweza kuona requests zote kutoka kwa customer
////    @GetMapping("/all")
////    public List<Request> getAllCustomerRequests() {
////        return requestRepository.findAll();
////    }
////
////    // ✅ Technician anaweza kubadilisha status ya request
////    @PutMapping("/{id}/status")
////    public ResponseEntity<?> updateRequestStatus(
////            @PathVariable Long id,
////            @RequestParam("status") String status
////    ) {
////        return requestRepository.findById(id)
////                .map(req -> {
////                    req.setStatus(status);
////                    requestRepository.save(req);
////                    return ResponseEntity.ok(req);
////                })
////                .orElse(ResponseEntity.notFound().build());
////    }
////}
//
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Request;
////import com.zawadig.myafwanii.Repository.RequestRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.client.RestTemplate;
////
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/technician/requests")
////@CrossOrigin("*")
////public class TechnicianController {
////
////    @Autowired
////    private RequestRepository requestRepository;
////
////    private final RestTemplate restTemplate = new RestTemplate();
////    private final String SMS_API_URL = "https://api.example-sms-provider.com/send";
////    private final String SMS_API_KEY = "your_sms_api_key_here";
////
////    // ✅ Technician anaweza kuona requests zote kutoka kwa customer
////    @GetMapping("/all")
////    public List<Request> getAllCustomerRequests() {
////        return requestRepository.findAll();
////    }
////
////    // ✅ Technician anaweza kubadilisha status ya request na kutuma SMS
////    @PutMapping("/{id}/status")
////    public ResponseEntity<?> updateRequestStatus(
////            @PathVariable Long id,
////            @RequestParam("status") String status
////    ) {
////        return requestRepository.findById(id)
////                .map(req -> {
////                    String previousStatus = req.getStatus();
////                    req.setStatus(status);
////                    Request updatedRequest = requestRepository.save(req);
////
////                    // Tuma SMS ikiwa ombi limeidhinishwa
////                    if ("Approved".equalsIgnoreCase(status) &&
////                            !"Approved".equalsIgnoreCase(previousStatus)) {
////                        sendApprovalSMS(updatedRequest);
////                    }
////
////                    return ResponseEntity.ok(updatedRequest);
////                })
////                .orElse(ResponseEntity.notFound().build());
////    }
////
////    // Njia ya kutuma SMS kwa mteja
////    private void sendApprovalSMS(Request request) {
////        try {
////            // Tengeneza ujumbe wa SMS
////            String message = String.format(
////                    "Habari, ombi lako la huduma #%d limeidhinishwa. Taarifa za mafikio: %s. Asante kwa kutumia huduma zetu!",
////                    request.getId(),
////                    request.getServiceDetails()
////            );
////
////            // Tuma ombi kwa API ya SMS
////            Map<String, String> smsRequest = new HashMap<>();
////            smsRequest.put("apiKey", SMS_API_KEY);
////            smsRequest.put("to", request.getCustomerPhone());
////            smsRequest.put("message", message);
////            smsRequest.put("sender", "ZAWA");
////
////            restTemplate.postForObject(SMS_API_URL, smsRequest, String.class);
////
////        } catch (Exception e) {
////            // Weka alama kwenye logi ikiwa kuna hitilafu
////            System.err.println("Hitilafu katika kutuma SMS: " + e.getMessage());
////        }
////    }
////
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/technician/requests")
////@CrossOrigin("*")
//public class TechnicianController {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String SMS_API_URL = "https://api.example-sms-provider.com/send";
//    private final String SMS_API_KEY = "your_sms_api_key_here";
//
//    // 1. Kupata maombi yote
//    @GetMapping("/all")
//    public List<Request> getAllCustomerRequests() {
//        return requestRepository.findAll();
//    }
//
//    // 2. Kubadilisha status ya ombi
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateRequestStatus(
//            @PathVariable Long id,
//            @RequestParam("status") String status,
//            @RequestParam(value = "arrivalDetails", required = false) String arrivalDetails) {
//
//        return requestRepository.findById(id)
//                .map(req -> {
//                    String previousStatus = req.getStatus();
//                    req.setStatus(status);
//
//                    // Weka maelezo ya mafikio ikiwepo
//                    if (arrivalDetails != null && !arrivalDetails.isEmpty()) {
//                        req.setServiceDetails(arrivalDetails);
//                    }
//
//                    Request updatedRequest = requestRepository.save(req);
//
//                    // Tuma SMS ikiwa ombi limeidhinishwa
//                    if ("Approved".equalsIgnoreCase(status) &&
//                            !"Approved".equalsIgnoreCase(previousStatus)) {
//                        sendApprovalSMS(updatedRequest);
//                    }
//
//                    return ResponseEntity.ok(updatedRequest);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // 3. Utumaji wa SMS
//    private void sendApprovalSMS(Request request) {
//        // Hakikisha namba ya simu ipo
//        if (request.getCustomerPhone() == null || request.getCustomerPhone().isEmpty()) {
//            System.err.println("⚠️ Namba ya simu haipo kwa ombi #" + request.getId());
//            return;
//        }
//
//        try {
//            // Tengeneza ujumbe
//            String details = (request.getServiceDetails() != null && !request.getServiceDetails().isEmpty())
//                    ? request.getServiceDetails()
//                    : "taarifa za mafikio zitakujulishwa baadaye";
//
//            String message = String.format(
//                    "Habari %s,\nOmb lako la huduma #%d limeidhinishwa.\nMaelezo: %s\n\nAsante kwa kutumia huduma zetu!",
//                    request.getCustomerName(),
//                    request.getId(),
//                    details
//            );
//
//            // Tuma kwa API ya SMS
//            Map<String, String> smsPayload = new HashMap<>();
//            smsPayload.put("apiKey", SMS_API_KEY);
//            smsPayload.put("to", request.getCustomerPhone());
//            smsPayload.put("message", message);
//            smsPayload.put("sender", "ZAWA");
//
//            restTemplate.postForObject(SMS_API_URL, smsPayload, String.class);
//            System.out.println("✓ SMS imetumwa kwa: " + request.getCustomerPhone());
//
//        } catch (Exception e) {
//            System.err.println("❌ Hitilafu katika kutuma SMS: " + e.getMessage());
//        }
//    }
//}

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/technician/requests")
////@CrossOrigin("*")
//public class TechnicianController {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String SMS_API_URL = "https://api.example-sms-provider.com/send";
//    private final String SMS_API_KEY = "your_sms_api_key_here"; // ← Replace with real API key
//
//    // 1. Get all requests
//    @GetMapping("/all")
//    public List<Request> getAllCustomerRequests() {
//        return requestRepository.findAll();
//    }
//
//    // 2. Update status + optional arrival details
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateRequestStatus(
//            @PathVariable Long id,
//            @RequestParam("status") String status,
//            @RequestParam(value = "arrivalDetails", required = false) String arrivalDetails) {
//
//        return requestRepository.findById(id)
//                .map(req -> {
//                    String previousStatus = req.getStatus();
//                    req.setStatus(status);
//
//                    if (arrivalDetails != null && !arrivalDetails.isEmpty()) {
//                        req.setServiceDetails(arrivalDetails);
//                    }
//
//                    Request updatedRequest = requestRepository.save(req);
//
//                    // Send SMS only if newly approved
//                    if ("Approved".equalsIgnoreCase(status)
//                            && !"Approved".equalsIgnoreCase(previousStatus)) {
//                        sendApprovalSMS(updatedRequest);
//                    }
//
//                    return ResponseEntity.ok(updatedRequest);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // 3. SMS sender method
//    private void sendApprovalSMS(Request request) {
//        if (request.getCustomerPhone() == null || request.getCustomerPhone().isEmpty()) {
//            System.err.println("⚠️ No phone number for request #" + request.getId());
//            return;
//        }
//
//        try {
//            String details = (request.getServiceDetails() != null && !request.getServiceDetails().isEmpty())
//                    ? request.getServiceDetails()
//                    : "Taarifa za mafikio zitakujulishwa baadaye.";
//
//            String message = String.format(
//                    "Habari %s,\nOmbi lako la huduma #%d limeidhinishwa.\nMaelezo: %s\n\nAsante kwa kutumia huduma zetu!",
//                    request.getCustomerName(),
//                    request.getId(),
//                    details
//            );
//
//            Map<String, String> smsPayload = new HashMap<>();
//            smsPayload.put("apiKey", SMS_API_KEY);
//            smsPayload.put("to", request.getCustomerPhone());
//            smsPayload.put("message", message);
//            smsPayload.put("sender", "ZAWA");
//
//            restTemplate.postForObject(SMS_API_URL, smsPayload, String.class);
//            System.out.println("✓ SMS imetumwa kwa: " + request.getCustomerPhone());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS error: " + e.getMessage());
//        }
//    }
//}






//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/technician/requests")
////@CrossOrigin(origins = "*")  // Ruhusu CORS kwa frontend (React/Thunder Client)
//public class TechnicianController {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String SMS_API_URL = "https://api.example-sms-provider.com/send"; // Badilisha na API halali
//    private final String SMS_API_KEY = "your_sms_api_key_here"; // Badilisha na key halali
//
//    // 1. Rudisha requests zote
//    @GetMapping("/all")
//    public List<Request> getAllCustomerRequests() {
//        return requestRepository.findAll();
//    }
//
//    // 2. Update status + arrival details (hiari)
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateRequestStatus(
//            @PathVariable Long id,
//            @RequestParam("status") String status,
//            @RequestParam(value = "arrivalDetails", required = false) String arrivalDetails) {
//
//        return requestRepository.findById(id)
//                .map(req -> {
//                    String previousStatus = req.getStatus();
//                    req.setStatus(status);
//
//                    if (arrivalDetails != null && !arrivalDetails.isEmpty()) {
//                        req.setServiceDetails(arrivalDetails);
//                    }
//
//                    Request updatedRequest = requestRepository.save(req);
//
//                    // Tuma SMS ikiwa status ni Approved na haikuwa Approved awali
//                    if ("Approved".equalsIgnoreCase(status)
//                            && !"Approved".equalsIgnoreCase(previousStatus)) {
//                        sendApprovalSMS(updatedRequest);
//                    }
//
//                    return ResponseEntity.ok(updatedRequest);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // 3. SMS sender method
//    private void sendApprovalSMS(Request request) {
//        if (request.getCustomerPhone() == null || request.getCustomerPhone().isEmpty()) {
//            System.err.println("⚠️ No phone number for request #" + request.getId());
//            return;
//        }
//
//        try {
//            String details = (request.getServiceDetails() != null && !request.getServiceDetails().isEmpty())
//                    ? request.getServiceDetails()
//                    : "Taarifa za mafanikio zitakujulishwa baadaye.";
//
//            String message = String.format(
//                    "Habari %s,\nOmbi lako la huduma #%d limeidhinishwa.\nMaelezo: %s\n\nAsante kwa kutumia huduma zetu!",
//                    request.getCustomerName(),
//                    request.getId(),
//                    details
//            );
//
//            Map<String, String> smsPayload = new HashMap<>();
//            smsPayload.put("apiKey", SMS_API_KEY);
//            smsPayload.put("to", request.getCustomerPhone());
//            smsPayload.put("message", message);
//            smsPayload.put("sender", "ZAWA");
//
//            restTemplate.postForObject(SMS_API_URL, smsPayload, String.class);
//            System.out.println("✓ SMS imetumwa kwa: " + request.getCustomerPhone());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS error: " + e.getMessage());
//        }
//    }
//}

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/technician/requests")
//@CrossOrigin(origins = "http://localhost:3000")  // Badilisha hii kwa frontend yako
//public class TechnicianController {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // TODO: Badilisha hizi na za kweli (sms provider)
//    private final String SMS_API_URL = "https://api.example-sms-provider.com/send";
//    private final String SMS_API_KEY = "your_sms_api_key_here";
//
//    // 1. Rudisha requests zote
//    @GetMapping("/all")
//    public List<Request> getAllCustomerRequests() {
//        return requestRepository.findAll();
//    }
//
//    // 2. Update status + arrival details (hiari)
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateRequestStatus(
//            @PathVariable Long id,
//            @RequestParam("status") String status,
//            @RequestParam(value = "arrivalDetails", required = false) String arrivalDetails) {
//
//        return requestRepository.findById(id)
//                .map(req -> {
//                    String previousStatus = req.getStatus();
//                    req.setStatus(status);
//
//                    if (arrivalDetails != null && !arrivalDetails.isEmpty()) {
//                        req.setServiceDetails(arrivalDetails);
//                    }
//
//                    Request updatedRequest = requestRepository.save(req);
//
//                    // Tuma SMS ikiwa status ni Approved na haikuwa Approved awali
//                    if ("Approved".equalsIgnoreCase(status)
//                            && !"Approved".equalsIgnoreCase(previousStatus)) {
//                        sendApprovalSMS(updatedRequest);
//                    }
//
//                    return ResponseEntity.ok(updatedRequest);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // 3. SMS sender method
//    private void sendApprovalSMS(Request request) {
//        if (request.getCustomerPhone() == null || request.getCustomerPhone().isEmpty()) {
//            System.err.println("⚠️ No phone number for request #" + request.getId());
//            return;
//        }
//
//        try {
//            String details = (request.getServiceDetails() != null && !request.getServiceDetails().isEmpty())
//                    ? request.getServiceDetails()
//                    : "Taarifa za mafanikio zitakujulishwa baadaye.";
//
//            String message = String.format(
//                    "Habari %s,\nOmbi lako la huduma #%d limeidhinishwa.\nMaelezo: %s\n\nAsante kwa kutumia huduma zetu!",
//                    request.getCustomerName(),
//                    request.getId(),
//                    details
//            );
//
//            Map<String, String> smsPayload = new HashMap<>();
//            smsPayload.put("apiKey", SMS_API_KEY);
//            smsPayload.put("to", request.getCustomerPhone());
//            smsPayload.put("message", message);
//            smsPayload.put("sender", "ZAWA");
//
//            restTemplate.postForObject(SMS_API_URL, smsPayload, String.class);
//            System.out.println("✓ SMS imetumwa kwa: " + request.getCustomerPhone());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS error: " + e.getMessage());
//        }
//    }
//}
//
//




//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/technician/requests")
//@CrossOrigin(origins = "http://localhost:3000") // Badilisha hii kama frontend yako iko domain nyingine
//public class TechnicianController {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // Badala ya kuweka moja kwa moja, tunasoma kutoka application.properties
//    @Value("${sms.api.url}")
//    private String SMS_API_URL;
//
//    @Value("${sms.api.key}")
//    private String SMS_API_KEY;
//
//    // 1. Pata requests zote
//    @GetMapping("/all")
//    public ResponseEntity<List<Request>> getAllCustomerRequests() {
//        List<Request> requests = requestRepository.findAll();
//        return ResponseEntity.ok(requests);
//    }
//
//    // 2. Rekebisha status ya ombi
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateRequestStatus(
//            @PathVariable Long id,
//            @RequestParam("status") String status,
//            @RequestParam(value = "arrivalDetails", required = false) String arrivalDetails) {
//
//        return requestRepository.findById(id).map(req -> {
//            String previousStatus = req.getStatus();
//            req.setStatus(status);
//
//            if (arrivalDetails != null && !arrivalDetails.trim().isEmpty()) {
//                req.setServiceDetails(arrivalDetails);
//            }
//
//            Request updatedRequest = requestRepository.save(req);
//
//            if ("Approved".equalsIgnoreCase(status)
//                    && !"Approved".equalsIgnoreCase(previousStatus)) {
//                sendApprovalSMS(updatedRequest);
//            }
//
//            return ResponseEntity.ok(updatedRequest);
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    // 3. Tuma SMS ya kuidhinishwa
//    private void sendApprovalSMS(Request request) {
//        if (request.getCustomerPhone() == null || request.getCustomerPhone().isEmpty()) {
//            System.err.println("⚠️ Hakuna namba ya simu kwa request #" + request.getId());
//            return;
//        }
//
//        try {
//            String details = (request.getServiceDetails() != null && !request.getServiceDetails().isEmpty())
//                    ? request.getServiceDetails()
//                    : "Taarifa zaidi zitatumwa hivi karibuni.";
//
//            String message = String.format(
//                    "Habari %s,\nOmbi lako la huduma #%d limeidhinishwa.\nMaelezo: %s\n\nAsante kwa kutumia huduma zetu!",
//                    request.getCustomerName(),
//                    request.getId(),
//                    details
//            );
//
//            Map<String, String> smsPayload = new HashMap<>();
//            smsPayload.put("apiKey", SMS_API_KEY);
//            smsPayload.put("to", request.getCustomerPhone());
//            smsPayload.put("message", message);
//            smsPayload.put("sender", "ZAWA");
//
//            restTemplate.postForObject(SMS_API_URL, smsPayload, String.class);
//            System.out.println("✓ SMS imetumwa kwa: " + request.getCustomerPhone());
//
//        } catch (Exception e) {
//            System.err.println("❌ Hitilafu ya kutuma SMS: " + e.getMessage());
//        }
//    }
//}




import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Model.Technician;
import com.zawadig.myafwanii.Repository.TechnicianRepository;
import com.zawadig.myafwanii.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/technician")
@CrossOrigin(origins = "http://localhost:3000")
public class TechnicianController {

    @Autowired
    private TechnicianRepository technicianRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginTechnician(@RequestBody LoginRequest loginRequest) {

        Optional<Technician> techOpt = technicianRepository.findByEmail(loginRequest.getEmail());

        if (techOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("⚠ Email haipo kwenye mfumo");
        }

        Technician tech = techOpt.get();

        if (!tech.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("⚠ Nenosiri si sahihi");
        }

        if (!tech.isEnabled()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("⚠ Akaunti imezimwa, wasiliana na admin");
        }

        return ResponseEntity.ok(tech);

    }
    @Autowired
    private PaymentService paymentService; // au InstallationReportService

    // API kwa technician kuona kazi active
    @GetMapping("/request-payments/verified")
    public List<Payment> getVerifiedPayments() {
        // Rudi payments ambazo status=VERIFIED na surveyStatus NOT_DONE
        return paymentService.getVerifiedPaymentsPendingSurvey();
    }


    // DTO for JSON body
    public static class LoginRequest {
        private String email;
        private String password;

        public LoginRequest() {}

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
