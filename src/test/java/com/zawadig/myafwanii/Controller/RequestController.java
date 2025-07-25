package com.zawadig.myafwanii.Controller;//////package com.zawadig.myafwanii.Controller;//////package com.zawadig.myafwanii.Controller;
//////////
//////////
//////////
//////////
//////////import com.zawadig.myafwanii.Model.Request;
//////////import com.zawadig.myafwanii.Service.RequestService;
//////////import org.springframework.http.ResponseEntity;
//////////import org.springframework.web.bind.annotation.*;
//////////
//////////import java.util.List;
//////////import java.util.NoSuchElementException;
//////////import java.util.Optional;
//////////
//////////@RestController
//////////@RequestMapping("/api/requests")
//////////public class RequestController {
//////////
//////////    private final RequestService requestService;
//////////
//////////    public RequestController(RequestService requestService) {
//////////        this.requestService = requestService;
//////////    }
//////////
//////////    // GET /api/requests
//////////    @GetMapping
//////////    public ResponseEntity<List<Request>> getAllRequests() {
//////////        return ResponseEntity.ok(requestService.getAllRequests());
//////////    }
//////////
//////////    // GET /api/requests/{id}
//////////    @GetMapping("/{id}")
//////////    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
//////////        Optional<Request> maybe = requestService.getRequestById(id);
//////////        return maybe
//////////                .<ResponseEntity<?>>map(ResponseEntity::ok)
//////////                .orElseGet(() -> ResponseEntity.notFound().build());
//////////    }
//////////
//////////    // POST /api/requests
//////////    @PostMapping
//////////    public ResponseEntity<?> createRequest(@RequestBody Request request) {
//////////        try {
//////////            Request saved = requestService.createRequest(request);
//////////            return ResponseEntity.ok(saved);
//////////        } catch (IllegalArgumentException ex) {
//////////            return ResponseEntity.badRequest().body(ex.getMessage());
//////////        }
//////////    }
//////////
//////////    // PUT /api/requests/{id}
//////////    @PutMapping("/{id}")
//////////    public ResponseEntity<?> updateRequest(
//////////            @PathVariable Long id,
//////////            @RequestBody Request requestDetails
//////////    ) {
//////////        try {
//////////            Request updated = requestService.updateRequest(id, requestDetails);
//////////            return ResponseEntity.ok(updated);
//////////        } catch (NoSuchElementException ex) {
//////////            return ResponseEntity.notFound().build();
//////////        }
//////////    }
//////////
//////////    // DELETE /api/requests/{id}
//////////    @DeleteMapping("/{id}")
//////////    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//////////        requestService.deleteRequest(id);
//////////        return ResponseEntity.noContent().build();
//////////    }
//////////}
//////////package com.zawadig.myafwanii.Controller;
//////////
//////////import com.zawadig.myafwanii.Model.Request;
//////////import com.zawadig.myafwanii.Service.RequestService;
//////////import org.springframework.http.ResponseEntity;
//////////import org.springframework.web.bind.annotation.*;
//////////import org.springframework.web.client.RestTemplate;
//////////
//////////import java.util.HashMap;
//////////import java.util.List;
//////////import java.util.NoSuchElementException;
//////////import java.util.Optional;
//////////
//////////@RestController
//////////@RequestMapping("/api/requests")
//////////public class RequestController {
//////////
//////////    private final RequestService requestService;
//////////    private final RestTemplate restTemplate = new RestTemplate();
//////////
//////////    // Badilisha hizi kwa SMS API halisi
//////////    private final String SMS_API_URL = "https://api.example-sms-provider.com/send";
//////////    private final String SMS_API_KEY = "your_sms_api_key_here";
//////////
//////////    public RequestController(RequestService requestService) {
//////////        this.requestService = requestService;
//////////    }
//////////
//////////    // GET /api/requests
//////////    @GetMapping
//////////    public ResponseEntity<List<Request>> getAllRequests() {
//////////        return ResponseEntity.ok(requestService.getAllRequests());
//////////    }
//////////
//////////    // GET /api/requests/{id}
//////////    @GetMapping("/{id}")
//////////    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
//////////        Optional<Request> maybe = requestService.getRequestById(id);
//////////        return maybe
//////////                .<ResponseEntity<?>>map(ResponseEntity::ok)
//////////                .orElseGet(() -> ResponseEntity.notFound().build());
//////////    }
//////////
//////////    // POST /api/requests
//////////    @PostMapping
//////////    public ResponseEntity<?> createRequest(@RequestBody Request request) {
//////////        try {
//////////            Request saved = requestService.createRequest(request);
//////////
//////////            // 🔔 Tuma SMS hapa baada ya request kuokolewa
//////////            if (saved.getCustomerPhone() != null && !saved.getCustomerPhone().isEmpty()) {
//////////                try {
//////////                    String message = String.format(
//////////                            "Habari %s,\nOmbi lako la huduma (#%d) limepokelewa. Tutalifanyia kazi hivi karibuni.\nAsante kwa kutumia ZAWA!",
//////////                            saved.getCustomerName(), saved.getId()
//////////                    );
//////////
//////////                    HashMap<String, String> smsPayload = new HashMap<>();
//////////                    smsPayload.put("apiKey", SMS_API_KEY);
//////////                    smsPayload.put("to", saved.getCustomerPhone());
//////////                    smsPayload.put("message", message);
//////////                    smsPayload.put("sender", "ZAWA");
//////////
//////////                    restTemplate.postForObject(SMS_API_URL, smsPayload, String.class);
//////////                    System.out.println("✓ SMS imetumwa kwa: " + saved.getCustomerPhone());
//////////
//////////                } catch (Exception e) {
//////////                    System.err.println("❌ Hitilafu ya kutuma SMS: " + e.getMessage());
//////////                }
//////////            }
//////////
//////////            return ResponseEntity.ok(saved);
//////////        } catch (IllegalArgumentException ex) {
//////////            return ResponseEntity.badRequest().body(ex.getMessage());
//////////        }
//////////    }
//////////
//////////    // PUT /api/requests/{id}
//////////    @PutMapping("/{id}")
//////////    public ResponseEntity<?> updateRequest(
//////////            @PathVariable Long id,
//////////            @RequestBody Request requestDetails
//////////    ) {
//////////        try {
//////////            Request updated = requestService.updateRequest(id, requestDetails);
//////////            return ResponseEntity.ok(updated);
//////////        } catch (NoSuchElementException ex) {
//////////            return ResponseEntity.notFound().build();
//////////        }
//////////    }
//////////
//////////    // DELETE /api/requests/{id}
//////////    @DeleteMapping("/{id}")
//////////    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//////////        requestService.deleteRequest(id);
//////////        return ResponseEntity.noContent().build();
//////////    }
//////////}
////////package com.zawadig.myafwanii.Controller;
////////
////////import com.zawadig.myafwanii.Model.Request;
////////import com.zawadig.myafwanii.Service.RequestService;
////////import org.springframework.beans.factory.annotation.Value;
////////import org.springframework.http.ResponseEntity;
////////import org.springframework.http.HttpHeaders;
////////import org.springframework.http.MediaType;
////////import org.springframework.http.HttpEntity;
////////import org.springframework.web.bind.annotation.*;
////////import org.springframework.web.client.RestTemplate;
////////
////////import java.util.*;
////////
////////@RestController
////////@RequestMapping("/api/requests")
////////public class RequestController {
////////
////////    private final RequestService requestService;
////////    private final RestTemplate restTemplate = new RestTemplate();
////////
////////    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
////////
////////    // Inject API keys and sender name from application.properties
////////    @Value("${beem.api.key}")
////////    private String BEEM_API_KEY;
////////
////////    @Value("${beem.api.secret}")
////////    private String BEEM_API_SECRET;
////////
////////    @Value("${beem.sender.name}")
////////    private String SENDER_NAME;
////////
////////    public RequestController(RequestService requestService) {
////////        this.requestService = requestService;
////////    }
////////
////////    // GET all requests
////////    @GetMapping
////////    public ResponseEntity<List<Request>> getAllRequests() {
////////        return ResponseEntity.ok(requestService.getAllRequests());
////////    }
////////
////////    // GET request by ID
////////    @GetMapping("/{id}")
////////    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
////////        Optional<Request> maybe = requestService.getRequestById(id);
////////        return maybe
////////                .<ResponseEntity<?>>map(ResponseEntity::ok)
////////                .orElseGet(() -> ResponseEntity.notFound().build());
////////    }
////////
////////    // POST request + send SMS via Beem API
////////    @PostMapping
////////    public ResponseEntity<?> createRequest(@RequestBody Request request) {
////////        try {
////////            Request saved = requestService.createRequest(request);
////////
////////            if (saved.getCustomerPhone() != null && !saved.getCustomerPhone().isEmpty()) {
////////                try {
////////                    String customerName = saved.getCustomerName();
////////                    String customerPhone = saved.getCustomerPhone();
////////
////////                    String message = String.format(
////////                            "Habari %s,\nOmbi lako la huduma (#%d) limepokelewa. Tutalifanyia kazi hivi karibuni.\nAsante kwa kutumia ZAWA!",
////////                            customerName, saved.getId()
////////                    );
////////
////////                    HttpHeaders headers = new HttpHeaders();
////////                    headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
////////                    headers.setContentType(MediaType.APPLICATION_JSON);
////////
////////                    Map<String, Object> payload = new HashMap<>();
////////                    payload.put("source_addr", SENDER_NAME);
////////                    payload.put("encoding", "0");
////////                    payload.put("schedule_time", "");
////////                    payload.put("message", message);
////////
////////                    Map<String, String> recipient = new HashMap<>();
////////                    recipient.put("recipient_id", "1");
////////                    recipient.put("dest_addr", customerPhone);
////////
////////                    List<Map<String, String>> recipients = new ArrayList<>();
////////                    recipients.add(recipient);
////////
////////                    payload.put("recipients", recipients);
////////
////////                    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
////////                    restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
////////
////////                    System.out.println("✓ SMS imetumwa kwa: " + customerPhone);
////////
////////                } catch (Exception e) {
////////                    System.err.println("❌ Hitilafu ya kutuma SMS: " + e.getMessage());
////////                }
////////            }
////////
////////            return ResponseEntity.ok(saved);
////////
////////        } catch (IllegalArgumentException ex) {
////////            return ResponseEntity.badRequest().body(ex.getMessage());
////////        }
////////    }
////////
////////    // PUT update request
////////    @PutMapping("/{id}")
////////    public ResponseEntity<?> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
////////        try {
////////            Request updated = requestService.updateRequest(id, requestDetails);
////////            return ResponseEntity.ok(updated);
////////        } catch (NoSuchElementException ex) {
////////            return ResponseEntity.notFound().build();
////////        }
////////    }
////////
////////    // DELETE request
////////    @DeleteMapping("/{id}")
////////    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
////////        requestService.deleteRequest(id);
////////        return ResponseEntity.noContent().build();
////////    }
////////}
//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Model.Request;
//////import com.zawadig.myafwanii.Service.RequestService;
//////import org.springframework.beans.factory.annotation.Value;
//////import org.springframework.http.*;
//////import org.springframework.web.bind.annotation.*;
//////import org.springframework.web.client.RestTemplate;
//////
//////import java.util.*;
//////
//////@RestController
//////@RequestMapping("/api/requests")
//////public class RequestController {
//////
//////    private final RequestService requestService;
//////    private final RestTemplate restTemplate = new RestTemplate();
//////
//////    // Beem SMS API
//////    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//////
//////    // Injected from application.properties
//////    @Value("${beem.api.key}")
//////    private String BEEM_API_KEY;
//////
//////    @Value("${beem.api.secret}")
//////    private String BEEM_API_SECRET;
//////
//////    @Value("${beem.sender.name}")
//////    private String SENDER_NAME;
//////
//////    public RequestController(RequestService requestService) {
//////        this.requestService = requestService;
//////    }
//////
//////    // ✅ Get all requests
//////    @GetMapping
//////    public ResponseEntity<List<Request>> getAllRequests() {
//////        return ResponseEntity.ok(requestService.getAllRequests());
//////    }
//////
//////    // ✅ Get single request by ID
//////    @GetMapping("/{id}")
//////    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
//////        Optional<Request> maybe = requestService.getRequestById(id);
//////        return maybe.map(ResponseEntity::ok)
//////                .orElseGet(() -> ResponseEntity.notFound().build());
//////    }
//////
//////    // ✅ Create new request + Send SMS
//////    @PostMapping
//////    public ResponseEntity<?> createRequest(@RequestBody Request request) {
//////        try {
//////            Request saved = requestService.createRequest(request);
//////
//////            // Send SMS notification to customer after saving
//////            if (saved.getCustomerPhone() != null && !saved.getCustomerPhone().isEmpty()) {
//////                try {
//////                    String message = String.format(
//////                            "Habari %s,\nOmbi lako la huduma (#%d) limepokelewa. Tutalifanyia kazi hivi karibuni.\nAsante kwa kutumia ZAWA!",
//////                            saved.getCustomerName(), saved.getId()
//////                    );
//////
//////                    HttpHeaders headers = new HttpHeaders();
//////                    headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
//////                    headers.setContentType(MediaType.APPLICATION_JSON);
//////
//////                    Map<String, Object> payload = new HashMap<>();
//////                    payload.put("source_addr", SENDER_NAME);
//////                    payload.put("encoding", "0");
//////                    payload.put("schedule_time", "");
//////                    payload.put("message", message);
//////
//////                    Map<String, String> recipient = new HashMap<>();
//////                    recipient.put("recipient_id", "1");
//////                    recipient.put("dest_addr", saved.getCustomerPhone());
//////
//////                    List<Map<String, String>> recipients = new ArrayList<>();
//////                    recipients.add(recipient);
//////                    payload.put("recipients", recipients);
//////
//////                    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//////                    restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//////
//////                    System.out.println("✓ SMS imetumwa kwa: " + saved.getCustomerPhone());
//////
//////                } catch (Exception e) {
//////                    System.err.println("❌ Hitilafu ya kutuma SMS: " + e.getMessage());
//////                }
//////            }
//////
//////            return ResponseEntity.ok(saved);
//////
//////        } catch (IllegalArgumentException ex) {
//////            return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
//////        }
//////    }
//////
//////    // ✅ Update existing request
//////    @PutMapping("/{id}")
//////    public ResponseEntity<?> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
//////        try {
//////            Request updated = requestService.updateRequest(id, requestDetails);
//////            return ResponseEntity.ok(updated);
//////        } catch (NoSuchElementException ex) {
//////            return ResponseEntity.notFound().build();
//////        }
//////    }
//////
//////    // ✅ Delete request
//////    @DeleteMapping("/{id}")
//////    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//////        requestService.deleteRequest(id);
//////        return ResponseEntity.noContent().build();
//////    }
//////}
//////
//////
////
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Request;
////import com.zawadig.myafwanii.Service.RequestService;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.http.*;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.client.RestTemplate;
////
//////import java.util.*;
//////
//////@RestController
//////@RequestMapping("/api/requests")
//////public class RequestController {
//////
//////    private final RequestService requestService;
//////    private final RestTemplate restTemplate = new RestTemplate();
//////
//////    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//////
//////    @Value("${beem.api.key}")
//////    private String BEEM_API_KEY;
//////
//////    @Value("${beem.api.secret}")
//////    private String BEEM_API_SECRET;
//////
//////    @Value("${beem.sender.name}")
//////    private String SENDER_NAME;
//////
//////    public RequestController(RequestService requestService) {
//////        this.requestService = requestService;
//////    }
//////
//////    @GetMapping
//////    public ResponseEntity<List<Request>> getAllRequests() {
//////        return ResponseEntity.ok(requestService.getAllRequests());
//////    }
//////
//////    @PostMapping
//////    public ResponseEntity<?> createRequest(@RequestBody Request request) {
//////        try {
//////            Request saved = requestService.createRequest(request);
//////
//////            if (saved.getCustomer() != null && saved.getCustomer().getPhone() != null) {
//////                try {
//////                    String customerName = saved.getCustomer().getName();
//////                    String customerPhone = saved.getCustomer().getPhone();
//////
//////                    String message = String.format(
//////                            "Habari %s,\nOmbi lako (#%d) limepokelewa. Tutalifanyia kazi karibuni.\nZAWA",
//////                            customerName, saved.getId()
//////                    );
//////
//////                    HttpHeaders headers = new HttpHeaders();
//////                    headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
//////                    headers.setContentType(MediaType.APPLICATION_JSON);
//////
//////                    Map<String, Object> payload = new HashMap<>();
//////                    payload.put("source_addr", SENDER_NAME);
//////                    payload.put("encoding", "0");
//////                    payload.put("schedule_time", "");
//////                    payload.put("message", message);
//////
//////                    Map<String, String> recipient = new HashMap<>();
//////                    recipient.put("recipient_id", "1");
//////                    recipient.put("dest_addr", customerPhone);
//////
//////                    payload.put("recipients", List.of(recipient));
//////
//////                    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//////                    restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//////
//////                    System.out.println("✓ SMS sent to: " + customerPhone);
//////
//////                } catch (Exception e) {
//////                    System.err.println("❌ Failed to send SMS: " + e.getMessage());
//////                }
//////            }
//////
//////            return ResponseEntity.ok(saved);
//////        } catch (IllegalArgumentException ex) {
//////            return ResponseEntity.badRequest().body(ex.getMessage());
//////        }
//////    }
//////}
////
////
////import com.zawadig.myafwanii.Service.RequestService;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.http.*;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.client.RestTemplate;
////
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api/requests")
////@CrossOrigin(origins = "http://localhost:3000")
////public class RequestController {
////
////    private final RequestService requestService;
////    private final RestTemplate restTemplate = new RestTemplate();
////
////    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
////
////    @Value("${beem.api.key}")
////    private String BEEM_API_KEY;
////
////    @Value("${beem.api.secret}")
////    private String BEEM_API_SECRET;
////
////    @Value("${beem.sender.name}")
////    private String SENDER_NAME;
////
////    public RequestController(RequestService requestService) {
////        this.requestService = requestService;
////    }
////
////    @GetMapping
////    public ResponseEntity<List<Request>> getAllRequests() {
////        return ResponseEntity.ok(requestService.getAllRequests());
////    }
////
////    @PostMapping
////    public ResponseEntity<?> createRequest(@RequestBody Request request) {
////        try {
////            Request saved = requestService.createRequest(request);
////
////            // Tumia getCustomerName() na getCustomerPhone() badala ya getCustomer()
////            if (saved.getCustomerName() != null && saved.getCustomerPhone() != null) {
////                try {
////                    String customerName = saved.getCustomerName();
////                    String customerPhone = saved.getCustomerPhone();
////
////                    String message = String.format(
////                            "Habari %s,\nOmbi lako (#%d) limepokelewa. Tutalifanyia kazi karibuni.\nZAWA",
////                            customerName, saved.getId()
////                    );
////
////                    HttpHeaders headers = new HttpHeaders();
////                    headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
////                    headers.setContentType(MediaType.APPLICATION_JSON);
////
////                    Map<String, Object> payload = new HashMap<>();
////                    payload.put("source_addr", SENDER_NAME);
////                    payload.put("encoding", "0");
////                    payload.put("schedule_time", "");
////                    payload.put("message", message);
////
////                    Map<String, String> recipient = new HashMap<>();
////                    recipient.put("recipient_id", "1");
////                    recipient.put("dest_addr", customerPhone);
////
////                    payload.put("recipients", List.of(recipient));
////
////                    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
////                    restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
////
////                    System.out.println("✓ SMS sent to: " + customerPhone);
////
////                } catch (Exception e) {
////                    System.err.println("❌ Failed to send SMS: " + e.getMessage());
////                }
////            }
////
////            return ResponseEntity.ok(saved);
////        } catch (IllegalArgumentException ex) {
////            return ResponseEntity.badRequest().body(ex.getMessage());
////        }
////    }
////}
////
//
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Service.RequestService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/requests")
//@CrossOrigin(origins = "http://localhost:3000") // Ruhusu React
//public class RequestController {
//
//    private final RequestService requestService;
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // Mipangilio ya SMS (weka kwenye application.properties)
//    @Value("${beem.api.key}")
//    private String BEEM_API_KEY;
//    @Value("${beem.api.secret}")
//    private String BEEM_API_SECRET;
//    @Value("${beem.sender.name}")
//    private String SENDER_NAME;
//
//    public RequestController(RequestService requestService) {
//        this.requestService = requestService;
//    }
//
//    // 1. Pata requests zote (kwa Manager)
//    @GetMapping
//    public ResponseEntity<List<Request>> getAllRequests() {
//        return ResponseEntity.ok(requestService.getAllRequests());
//    }
//
//    // 2. Pata request kwa ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
//        return requestService.getRequestById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // 3. Tuma request mpya (kwa Customer)
//    @PostMapping
//    public ResponseEntity<?> createRequest(@RequestBody Request request) {
//        try {
//            Request saved = requestService.createRequest(request);
//            tumaSMS(saved); // Tuma SMS kwa mteja
//            return ResponseEntity.ok(saved);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    // 4. Approve/Ahidi request (kwa Manager)
//    @PutMapping("/{id}/approve")
//    public ResponseEntity<?> approveRequest(@PathVariable Long id) {
//        try {
//            Request updated = requestService.updateRequestStatus(id, "Approved");
//            return ResponseEntity.ok(updated);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    // 5. Edit request (kwa Manager)
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
//        try {
//            Request updated = requestService.updateRequest(id, requestDetails);
//            return ResponseEntity.ok(updated);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    // 6. Ondoa request (kwa Manager)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//        requestService.deleteRequest(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // ====================== UTUMAJI WA SMS ======================
//    private void tumaSMS(Request request) {
//        if (request.getCustomerPhone() == null) return;
//
//        try {
//            String message = String.format(
//                    "Habari %s,\nOmbi lako (#%d) limepokelewa. Status: %s\nINFO",
//                    request.getCustomerName(), request.getId(), request.getStatus()
//            );
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", SENDER_NAME);
//            payload.put("message", message);
//            payload.put("recipients", List.of(Map.of("dest_addr", request.getCustomerPhone())));
//
//            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
//            restTemplate.postForEntity("https://apisms.beem.africa/v1/send", entity, String.class);
//
//            System.out.println("✓ SMS Imetumwa kwa: " + request.getCustomerPhone());
//        } catch (Exception e) {
//            System.err.println("❌ Hitilafu ya SMS: " + e.getMessage());
//        }
//    }
//}

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Service.RequestService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/requests")
//@CrossOrigin(origins = "http://localhost:3000") // Ruhusu React
//public class RequestController {
//
//    private final RequestService requestService;
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${beem.api.key}")
//    private String BEEM_API_KEY;
//    @Value("${beem.api.secret}")
//    private String BEEM_API_SECRET;
//    @Value("${beem.sender.name}")
//    private String SENDER_NAME;
//
//    public RequestController(RequestService requestService) {
//        this.requestService = requestService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Request>> getAllRequests() {
//        return ResponseEntity.ok(requestService.getAllRequests());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
//        return requestService.getRequestById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<?> createRequest(@RequestBody Request request) {
//        try {
//            Request saved = requestService.createRequest(request);
//            tumaSMS(saved);
//            return ResponseEntity.ok(saved);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    @PutMapping("/{id}/approve")
//    public ResponseEntity<?> approveRequest(@PathVariable Long id) {
//        try {
//            Request updated = requestService.updateRequestStatus(id, "Approved");
//            return ResponseEntity.ok(updated);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
//        try {
//            Request updated = requestService.updateRequest(id, requestDetails);
//            return ResponseEntity.ok(updated);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    // Hapa soft delete inatokea, haitafuti database kabisa
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//        requestService.softDeleteRequest(id, "admin");  // "admin" ni jina wa mtu anaye futa, badilisha kama unataka
//        return ResponseEntity.noContent().build();
//    }
//
//    // SMS sending method haijabadilika hapa
//    private void tumaSMS(Request request) {
//        if (request.getCustomerPhone() == null) return;
//
//        try {
//            String message = String.format(
//                    "Habari %s,\nOmbi lako (#%d) limepokelewa. Status: %s\nINFO",
//                    request.getCustomerName(), request.getId(), request.getStatus()
//            );
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", SENDER_NAME);
//            payload.put("message", message);
//            payload.put("recipients", List.of(Map.of("dest_addr", request.getCustomerPhone())));
//
//            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
//            restTemplate.postForEntity("https://apisms.beem.africa/v1/send", entity, String.class);
//
//            System.out.println("✓ SMS Imetumwa kwa: " + request.getCustomerPhone());
//        } catch (Exception e) {
//            System.err.println("❌ Hitilafu ya SMS: " + e.getMessage());
//        }
//    }
//}
//

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.Request;
import com.zawadig.myafwanii.Service.CustomerService;
import com.zawadig.myafwanii.Service.RequestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

//@RestController
//@RequestMapping("/api/requests")
//@CrossOrigin(origins = "http://localhost:3000")
//public class RequestController {
//
//    private final RequestService requestService;
//    private final CustomerService customerService;
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${beem.api.key}")
//    private String BEEM_API_KEY;
//    @Value("${beem.api.secret}")
//    private String BEEM_API_SECRET;
//    @Value("${beem.sender.name}")
//    private String SENDER_NAME;
//
//    public RequestController(RequestService requestService, CustomerService customerService) {
//        this.requestService = requestService;
//        this.customerService = customerService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Request>> getAllRequests() {
//        return ResponseEntity.ok(requestService.getAllRequests());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
//        return requestService.getRequestById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<?> createRequest(@RequestBody Map<String, Object> data) {
//        try {
//            Long customerId = Long.valueOf(data.get("customerId").toString());
//            String address = data.get("address").toString();
//            String requestType = data.get("requestType").toString();
//            String description = data.get("description") != null ? data.get("description").toString() : "";
//
//            Customer customer = customerService.getCustomerById(customerId)
//                    .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
//
//            Request request = new Request();
//            request.setCustomer(customer);
//            request.setCustomerName(customer.getName());
//            request.setCustomerPhone(customer.getPhone());
//            request.setAddress(address);
//            request.setRequestType(requestType);
//            request.setDescription(description);
//            request.setStatus("Pending");
//
//            Request saved = requestService.createRequest(request);
//            tumaSMS(saved);
//
//            return ResponseEntity.ok(saved);
//
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body("Failed to create request: " + ex.getMessage());
//        }
//    }
//
//    @PutMapping("/{id}/approve")
//    public ResponseEntity<?> approveRequest(@PathVariable Long id) {
//        try {
//            Request updated = requestService.updateRequestStatus(id, "Approved");
//            return ResponseEntity.ok(updated);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
//        try {
//            Request updated = requestService.updateRequest(id, requestDetails);
//            return ResponseEntity.ok(updated);
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
//        requestService.softDeleteRequest(id, "admin");
//        return ResponseEntity.noContent().build();
//    }
//
//    private void tumaSMS(Request request) {
//        if (request.getCustomerPhone() == null) return;
//
//        try {
//            String message = String.format(
//                    "Habari %s,\nOmbi lako (#%d) limepokelewa. Status: %s\nINFO",
//                    request.getCustomerName(), request.getId(), request.getStatus()
//            );
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", SENDER_NAME);
//            payload.put("message", message);
//            payload.put("recipients", List.of(Map.of("dest_addr", request.getCustomerPhone())));
//
//            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
//            restTemplate.postForEntity("https://apisms.beem.africa/v1/send", entity, String.class);
//
//            System.out.println("✓ SMS Imetumwa kwa: " + request.getCustomerPhone());
//        } catch (Exception e) {
//            System.err.println("❌ Hitilafu ya SMS: " + e.getMessage());
//        }
//    }
//}

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:3000")
public class RequestController {

    private final RequestService requestService;
    private final CustomerService customerService;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${beem.api.key}")
    private String BEEM_API_KEY;
    @Value("${beem.api.secret}")
    private String BEEM_API_SECRET;
    @Value("${beem.sender.name}")
    private String SENDER_NAME;

    public RequestController(RequestService requestService, CustomerService customerService) {
        this.requestService = requestService;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
        return requestService.getRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createRequest(@RequestBody Map<String, Object> data) {
        try {
            // Validate presence of required fields
            if (!data.containsKey("customerId") || data.get("customerId") == null) {
                return ResponseEntity.badRequest().body("Customer ID is required.");
            }
            if (!data.containsKey("address") || data.get("address") == null) {
                return ResponseEntity.badRequest().body("Address is required.");
            }
            if (!data.containsKey("requestType") || data.get("requestType") == null) {
                return ResponseEntity.badRequest().body("Request Type is required.");
            }

            Long customerId = Long.valueOf(data.get("customerId").toString());
            String address = data.get("address").toString();
            String requestType = data.get("requestType").toString();
            String description = data.get("description") != null ? data.get("description").toString() : "";

            Customer customer = customerService.getCustomerById(customerId)
                    .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));

            Request request = new Request();
            request.setCustomer(customer);
            request.setCustomerName(customer.getName());
            request.setCustomerPhone(customer.getPhone());
            request.setAddress(address);
            request.setRequestType(requestType);
            request.setDescription(description);
            request.setStatus("Pending");
            request.setRequestDate(LocalDate.now());

            Request saved = requestService.createRequest(request);
            tumaSMS(saved);

            return ResponseEntity.ok(saved);

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Failed to create request: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approveRequest(@PathVariable Long id) {
        try {
            Request updated = requestService.updateRequestStatus(id, "Approved");
            return ResponseEntity.ok(updated);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails) {
        try {
            Request updated = requestService.updateRequest(id, requestDetails);
            return ResponseEntity.ok(updated);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        requestService.softDeleteRequest(id, "admin");
        return ResponseEntity.noContent().build();
    }

    private void tumaSMS(Request request) {
        if (request.getCustomerPhone() == null) return;

        try {
            String message = String.format(
                    "Habari %s,\nOmbi lako (#%d) limepokelewa. Status: %s\nINFO",
                    request.getCustomerName(), request.getId(), request.getStatus()
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(BEEM_API_KEY, BEEM_API_SECRET);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> payload = new HashMap<>();
            payload.put("source_addr", SENDER_NAME);
            payload.put("message", message);
            payload.put("recipients", List.of(Map.of("dest_addr", request.getCustomerPhone())));

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
            restTemplate.postForEntity("https://apisms.beem.africa/v1/send", entity, String.class);

            System.out.println("✓ SMS Imetumwa kwa: " + request.getCustomerPhone());
        } catch (Exception e) {
            System.err.println("❌ Hitilafu ya SMS: " + e.getMessage());
        }
    }
}
