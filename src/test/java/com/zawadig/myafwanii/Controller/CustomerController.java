////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Service.CustomerService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.*;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////import java.util.Optional;
////
////@RestController
////@RequestMapping("/api/v1/customer")
//////@CrossOrigin(origins = "*") // Imeongezwa hapa kwa ajili ya CORS
////public class CustomerController {
////
////    @Autowired
////    private CustomerService customerService;
////
////    // ✅ 1. Register customer
////    @PostMapping("/register")
////    public ResponseEntity<?> register(@RequestBody Customer customer) {
////        try {
////            Customer saved = customerService.saveCustomer(customer);
////
////            // Rudisha taarifa muhimu tu
////            Map<String, Object> response = new HashMap<>();
////            response.put("id", saved.getId());
////            response.put("name", saved.getName());
////            response.put("email", saved.getEmail());
////            response.put("meterNumber", saved.getMeterNumber());
////            response.put("message", "Usajili umefanikiwa");
////
////            return ResponseEntity.ok(response);
////        } catch (IllegalArgumentException ex) {
////            return ResponseEntity.badRequest().body(ex.getMessage());
////        }
////    }
////
////    // ✅ 2. Login customer
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
////        String email = data.get("email");
////        String password = data.get("password");
////
////        try {
////            Customer customer = customerService.authenticate(email, password);
////            return ResponseEntity.ok(customer);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
////        }
////    }
////
////    // ✅ 3. View customer profile by ID
////    @GetMapping("/{id}")
////    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
////        return ResponseEntity.of(customerService.getCustomerById(id));
////    }
////
////    // ✅ 4. Update profile (by customer or admin)
////    @PutMapping("/{id}")
////    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
////        try {
////            Customer updated = customerService.updateCustomer(updatedData, id);
////            return ResponseEntity.ok(updated);
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body("Failed to update profile");
////        }
////    }
////
////    // ✅ 5. Get all customers (for admin)
////    @GetMapping("/all")
////    public ResponseEntity<List<Customer>> getAllCustomers() {
////        return ResponseEntity.ok(customerService.getAllCustomers());
////    }
////
////    // ✅ 6. Delete customer (by admin)
////    @DeleteMapping("/{id}")
////    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
////        try {
////            customerService.deleteCustomer(id);
////            return ResponseEntity.noContent().build();
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
////        }
////    }
////
////    // ✅ 7. Update status only (e.g., activate/suspend customer)
////    @PutMapping("/{id}/status")
////    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
////        try {
////            String newStatus = body.get("status");
////            Customer updated = customerService.updateCustomerStatus(id, newStatus);
////            return ResponseEntity.ok(updated);
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body("Failed to update status");
////        }
////    }
////} ii nd muuimu
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Bill;
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Service.BillService;
//import com.zawadig.myafwanii.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    // Adding BillService for automatic bill creation
//    @Autowired
//    private BillService billService;
//
//    // ✅ 1. Register customer
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            Customer saved = customerService.saveCustomer(customer);
//
//            // Automatic bill creation for the new customer
//            billService.createInitialBillForCustomer(saved);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("id", saved.getId());
//            response.put("name", saved.getName());
//            response.put("email", saved.getEmail());
//            response.put("meterNumber", saved.getMeterNumber());
//            response.put("message", "Usajili umefanikiwa, bill yako ya kwanza imetengenezwa");
//
//            return ResponseEntity.ok(response);
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tatizo limetokea: " + ex.getMessage());
//        }
//    }
//
//    // ✅ 2. Login customer
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        try {
//            Customer customer = customerService.authenticate(email, password);
//            return ResponseEntity.ok(customer);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    // ✅ 3. View customer profile by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
//        return ResponseEntity.of(customerService.getCustomerById(id));
//    }
//
//    // ✅ 4. Update profile (by customer or admin)
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
//        try {
//            Customer updated = customerService.updateCustomer(updatedData, id);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update profile");
//        }
//    }
//
//    // ✅ 5. Get all customers (for admin)
//    @GetMapping("/all")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//
//    // ✅ 6. Delete customer (by admin)
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        }
//    }
//
//    // ✅ 7. Update status only (e.g., activate/suspend customer)
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        try {
//            String newStatus = body.get("status");
//            Customer updated = customerService.updateCustomerStatus(id, newStatus);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update status");
//        }
//    }
//}

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Service.BillService;
//import com.zawadig.myafwanii.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private BillService billService;
//
//    @Value("${beem.api.key}")
//    private String beemApiKey;
//
//    @Value("${beem.api.secret}")
//    private String beemApiSecret;
//
//    @Value("${beem.sender.name}")
//    private String senderName;
//
//    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // Helper: format phone number to start with 255 and no leading zero or plus
//    private String formatPhoneNumber(String phone) {
//        if (phone == null) return "";
//        phone = phone.trim();
//        if (phone.startsWith("0")) {
//            return "255" + phone.substring(1);
//        } else if (phone.startsWith("+")) {
//            return phone.substring(1);
//        }
//        return phone;
//    }
//
//    // Helper: Send SMS using Beem API
//    private void sendSmsBeem(String phone, String message) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(beemApiKey, beemApiSecret);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", senderName);
//            payload.put("encoding", "0");
//            payload.put("schedule_time", "");
//            payload.put("message", message);
//
//            Map<String, String> recipient = new HashMap<>();
//            recipient.put("recipient_id", "1");
//            recipient.put("dest_addr", formatPhoneNumber(phone));
//
//            payload.put("recipients", List.of(recipient));
//
//            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//
//            ResponseEntity<String> response = restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//
//            System.out.println("Beem SMS response status: " + response.getStatusCode());
//            System.out.println("Beem SMS response body: " + response.getBody());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS sending failed: " + e.getMessage());
//        }
//    }
//
//    // 1. Register customer + create bill + send SMS
////    @PostMapping("/register")
////    public ResponseEntity<?> register(@RequestBody Customer customer) {
////        try {
////            Customer saved = customerService.saveCustomer(customer);
////
////            // Create initial bill automatically
////            billService.createInitialBillForCustomer(saved);
////
////            // Send SMS confirmation
////            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
////                String message = String.format(
////                        "Habari %s, usajili wako umefanikiwa. Bill yako ya kwanza imetengenezwa. Asante kwa kutumia ZAWA!",
////                        saved.getName()
////                );
////                sendSmsBeem(saved.getPhone(), message);
////            }
////
////            Map<String, Object> response = new HashMap<>();
////            response.put("id", saved.getId());
////            response.put("name", saved.getName());
////            response.put("email", saved.getEmail());
////            response.put("meterNumber", saved.getMeterNumber());
////            response.put("message", "Usajili umefanikiwa, bill yako ya kwanza imetengenezwa");
////
////            return ResponseEntity.ok(response);
////
////        } catch (IllegalArgumentException ex) {
////            return ResponseEntity.badRequest().body(ex.getMessage());
////        } catch (Exception ex) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tatizo limetokea: " + ex.getMessage());
////        }
////    }
//// 1. Register customer + create bill + send SMS
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            // Hifadhi customer bila meter number wala bill
//            Customer saved = customerService.saveCustomerWithoutMeter(customer); // ← tumia "customer" (siyo Customer)
//
//            // Tuma SMS rahisi ya "karibu"
//            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
//                String message = String.format(
//                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
//                        saved.getName()
//                );
//                sendSmsBeem(saved.getPhone(), message); // ← hakikisha method hii ipo kwenye controller yako
//            }
//
//            return ResponseEntity.ok(saved); // rejesha taarifa ya customer aliyesajiliwa
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
//        }
//    }
//
//    // 2. Login customer
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        try {
//            Customer customer = customerService.authenticate(email, password);
//            return ResponseEntity.ok(customer);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    // 3. Get customer profile by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
//        return ResponseEntity.of(customerService.getCustomerById(id));
//    }
//
//    // 4. Update customer profile
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
//        try {
//            Customer updated = customerService.updateCustomer(updatedData, id);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update profile");
//        }
//    }
//
//    // 5. Get all customers (admin)
//    @GetMapping("/all")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//
//    // 6. Delete customer
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        }
//    }
//
//    // 7. Update customer status
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        try {
//            String newStatus = body.get("status");
//            Customer updated = customerService.updateCustomerStatus(id, newStatus);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update status");
//        }
//    }
//}
//
//
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Service.BillService;
//import com.zawadig.myafwanii.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private BillService billService;
//
//    @Value("${beem.api.key}")
//    private String beemApiKey;
//
//    @Value("${beem.api.secret}")
//    private String beemApiSecret;
//
//    @Value("${beem.sender.name}")
//    private String senderName;
//
//    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // Helper: format phone number to start with 255 and no leading zero or plus
//    private String formatPhoneNumber(String phone) {
//        if (phone == null) return "";
//        phone = phone.trim();
//        if (phone.startsWith("0")) {
//            return "255" + phone.substring(1);
//        } else if (phone.startsWith("+")) {
//            return phone.substring(1);
//        }
//        return phone;
//    }
//
//    // Helper: Send SMS using Beem API
//    private void sendSmsBeem(String phone, String message) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(beemApiKey, beemApiSecret);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", senderName);
//            payload.put("encoding", "0");
//            payload.put("schedule_time", "");
//            payload.put("message", message);
//
//            Map<String, String> recipient = new HashMap<>();
//            recipient.put("recipient_id", "1");
//            recipient.put("dest_addr", formatPhoneNumber(phone));
//
//            payload.put("recipients", List.of(recipient));
//
//            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//
//            ResponseEntity<String> response = restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//
//            System.out.println("Beem SMS response status: " + response.getStatusCode());
//            System.out.println("Beem SMS response body: " + response.getBody());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS sending failed: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            Customer saved = customerService.saveCustomerWithoutMeter(customer);
//
//            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
//                String message = String.format(
//                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
//                        saved.getName()
//                );
//                sendSmsBeem(saved.getPhone(), message);
//            }
//
//            return ResponseEntity.ok(saved);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        try {
//            Customer customer = customerService.authenticate(email, password);
//            return ResponseEntity.ok(customer);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
//        return ResponseEntity.of(customerService.getCustomerById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
//        try {
//            Customer updated = customerService.updateCustomer(updatedData, id);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update profile");
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        }
//    }
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        try {
//            String newStatus = body.get("status");
//            Customer updated = customerService.updateCustomerStatus(id, newStatus);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update status");
//        }
//    }
//
//    // ====== NEW SOFT DELETE ENDPOINTS (ADDED WITHOUT MODIFYING EXISTING CODE) ======
//
//    @GetMapping("/active")
//    public ResponseEntity<List<Customer>> getAllActiveCustomers() {
//        return ResponseEntity.ok(customerService.getAllActiveCustomers());
//    }
//
//    @GetMapping("/deleted")
//    public ResponseEntity<List<Customer>> getAllDeletedCustomers() {
//        return ResponseEntity.ok(customerService.getAllDeletedCustomers());
//    }
//
//    @DeleteMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeleteCustomer(@PathVariable Long id,
//                                                @RequestParam String deletedBy) {
//        try {
//            customerService.softDeleteCustomer(id, deletedBy);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/restore/{id}")
//    public ResponseEntity<?> restoreCustomer(@PathVariable Long id) {
//        try {
//            customerService.restoreCustomer(id);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}
//
//
//
//
//muimuuu

//
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Service.BillService;
//import com.zawadig.myafwanii.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private BillService billService;
//
//    @Value("${beem.api.key}")
//    private String beemApiKey;
//
//    @Value("${beem.api.secret}")
//    private String beemApiSecret;
//
//    @Value("${beem.sender.name}")
//    private String senderName;
//
//    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    private String formatPhoneNumber(String phone) {
//        if (phone == null) return "";
//        phone = phone.trim();
//        if (phone.startsWith("0")) {
//            return "255" + phone.substring(1);
//        } else if (phone.startsWith("+")) {
//            return phone.substring(1);
//        }
//        return phone;
//    }
//
//    private void sendSmsBeem(String phone, String message) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(beemApiKey, beemApiSecret);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", senderName);
//            payload.put("encoding", "0");
//            payload.put("schedule_time", "");
//            payload.put("message", message);
//
//            Map<String, String> recipient = new HashMap<>();
//            recipient.put("recipient_id", "1");
//            recipient.put("dest_addr", formatPhoneNumber(phone));
//
//            payload.put("recipients", List.of(recipient));
//
//            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//
//            ResponseEntity<String> response = restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//
//            System.out.println("Beem SMS response status: " + response.getStatusCode());
//            System.out.println("Beem SMS response body: " + response.getBody());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS sending failed: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            Customer saved = customerService.saveCustomerWithoutMeter(customer);
//
//            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
//                String message = String.format(
//                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
//                        saved.getName()
//                );
//                sendSmsBeem(saved.getPhone(), message);
//            }
//
//            return ResponseEntity.ok(saved);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        try {
//            Customer customer = customerService.authenticate(email, password);
//            return ResponseEntity.ok(customer);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
//        return ResponseEntity.of(customerService.getCustomerById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
//        try {
//            Customer updated = customerService.updateCustomer(updatedData, id);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update profile: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        }
//    }
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        try {
//            String newStatus = body.get("status");
//            Customer updated = customerService.updateCustomerStatus(id, newStatus);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update status: " + e.getMessage());
//        }
//    }
//
////    @GetMapping("/{id}/usage")
////    public ResponseEntity<?> getCustomerUsage(@PathVariable Long id) {
////        try {
////            Map<String, Object> usageData = billService.getCustomerUsageData(id);
////            return ResponseEntity.ok(usageData);
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body("Failed to get usage data: " + e.getMessage());
////        }
////    }
//
//    @GetMapping("/active")
//    public ResponseEntity<List<Customer>> getAllActiveCustomers() {
//        return ResponseEntity.ok(customerService.getAllActiveCustomers());
//    }
//
//    @GetMapping("/deleted")
//    public ResponseEntity<List<Customer>> getAllDeletedCustomers() {
//        return ResponseEntity.ok(customerService.getAllDeletedCustomers());
//    }
//
//    @DeleteMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeleteCustomer(@PathVariable Long id,
//                                                @RequestParam String deletedBy) {
//        try {
//            customerService.softDeleteCustomer(id, deletedBy);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/restore/{id}")
//    public ResponseEntity<?> restoreCustomer(@PathVariable Long id) {
//        try {
//            customerService.restoreCustomer(id);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//        @PostMapping("/reset-password")
//        public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> body) {
//            String email = body.get("email");
//            String newPassword = body.get("newPassword");
//
//            if (email == null || newPassword == null) {
//                return ResponseEntity.badRequest().body("Email na password mpya lazima zitoe.");
//            }
//
//            boolean updated = customerService.updatePasswordByEmail(email, newPassword);
//
//            if (updated) {
//                // Tuma email ya notifikasi
//                try {
//                    customerService.sendPasswordChangedEmail(email);
//                } catch (Exception e) {
//                    System.out.println("Kosa la kutuma email: " + e.getMessage());
//                }
//                return ResponseEntity.ok("Password imebadilishwa kikamilifu.");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email haipo kwenye mfumo.");
//            }
//        }
//    }
//
//
// muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu ya 2



//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Service.BillService;
//import com.zawadig.myafwanii.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private BillService billService;
//
//    @Value("${beem.api.key}")
//    private String beemApiKey;
//
//    @Value("${beem.api.secret}")
//    private String beemApiSecret;
//
//    @Value("${beem.sender.name}")
//    private String senderName;
//
//    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    private String formatPhoneNumber(String phone) {
//        if (phone == null) return "";
//        phone = phone.trim();
//        if (phone.startsWith("0")) {
//            return "255" + phone.substring(1);
//        } else if (phone.startsWith("+")) {
//            return phone.substring(1);
//        }
//        return phone;
//    }
//
//    private void sendSmsBeem(String phone, String message) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(beemApiKey, beemApiSecret);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", senderName);
//            payload.put("encoding", "0");
//            payload.put("schedule_time", "");
//            payload.put("message", message);
//
//            Map<String, String> recipient = new HashMap<>();
//            recipient.put("recipient_id", "1");
//            recipient.put("dest_addr", formatPhoneNumber(phone));
//
//            payload.put("recipients", List.of(recipient));
//
//            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//            ResponseEntity<String> response = restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//
//            System.out.println("Beem SMS response status: " + response.getStatusCode());
//            System.out.println("Beem SMS response body: " + response.getBody());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS sending failed: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            Customer saved = customerService.saveCustomerWithoutMeter(customer);
//
//            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
//                String message = String.format(
//                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
//                        saved.getName()
//                );
//                sendSmsBeem(saved.getPhone(), message);
//            }
//
//            return ResponseEntity.ok(saved);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        try {
//            Customer customer = customerService.authenticate(email, password);
//            return ResponseEntity.ok(customer);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    // Profile endpoints moved to avoid conflict
//    @GetMapping("/profile/{id}")
//    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
//        return ResponseEntity.of(customerService.getCustomerById(id));
//    }
//
//    @PutMapping("/profile/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
//        try {
//            Customer updated = customerService.updateCustomer(updatedData, id);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update profile: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
//        }
//    }
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        try {
//            String newStatus = body.get("status");
//            Customer updated = customerService.updateCustomerStatus(id, newStatus);
//            return ResponseEntity.ok(updated);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to update status: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/active")
//    public ResponseEntity<List<Customer>> getAllActiveCustomers() {
//        return ResponseEntity.ok(customerService.getAllActiveCustomers());
//    }
//
//    @GetMapping("/deleted")
//    public ResponseEntity<List<Customer>> getAllDeletedCustomers() {
//        return ResponseEntity.ok(customerService.getAllDeletedCustomers());
//    }
//
//    @DeleteMapping("/soft-delete/{id}")
//    public ResponseEntity<?> softDeleteCustomer(@PathVariable Long id,
//                                                @RequestParam String deletedBy) {
//        try {
//            customerService.softDeleteCustomer(id, deletedBy);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/restore/{id}")
//    public ResponseEntity<?> restoreCustomer(@PathVariable Long id) {
//        try {
//            customerService.restoreCustomer(id);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/reset-password")
//    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> body) {
//        String email = body.get("email");
//        String newPassword = body.get("newPassword");
//
//        if (email == null || newPassword == null) {
//            return ResponseEntity.badRequest().body("Email na password mpya lazima zitoe.");
//        }
//
//        boolean updated = customerService.updatePasswordByEmail(email, newPassword);
//
//        if (updated) {
//            try {
//                customerService.sendPasswordChangedEmail(email);
//            } catch (Exception e) {
//                System.out.println("Kosa la kutuma email: " + e.getMessage());
//            }
//            return ResponseEntity.ok("Password imebadilishwa kikamilifu.");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email haipo kwenye mfumo.");
//        }
//    }
//} muimuuuuuuuuuuuuuuuuuuuuuuuuuuu

package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Service.BillService;
import com.zawadig.myafwanii.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BillService billService;

    @Value("${beem.api.key}")
    private String beemApiKey;

    @Value("${beem.api.secret}")
    private String beemApiSecret;

    @Value("${beem.sender.name}")
    private String senderName;

    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
    private final RestTemplate restTemplate = new RestTemplate();

    private String formatPhoneNumber(String phone) {
        if (phone == null) return "";
        phone = phone.trim();
        if (phone.startsWith("0")) {
            return "255" + phone.substring(1);
        } else if (phone.startsWith("+")) {
            return phone.substring(1);
        }
        return phone;
    }

    private void sendSmsBeem(String phone, String message) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(beemApiKey, beemApiSecret);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> payload = new HashMap<>();
            payload.put("source_addr", senderName);
            payload.put("encoding", "0");
            payload.put("schedule_time", "");
            payload.put("message", message);

            Map<String, String> recipient = new HashMap<>();
            recipient.put("recipient_id", "1");
            recipient.put("dest_addr", formatPhoneNumber(phone));

            payload.put("recipients", List.of(recipient));

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);

            System.out.println("Beem SMS response status: " + response.getStatusCode());
            System.out.println("Beem SMS response body: " + response.getBody());

        } catch (Exception e) {
            System.err.println("❌ SMS sending failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Customer customer) {
        try {
            // Null checks for required fields
            if (customer.getName() == null || customer.getName().trim().isEmpty() ||
                    customer.getEmail() == null || customer.getEmail().trim().isEmpty() ||
                    customer.getPhone() == null || customer.getPhone().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Name, email and phone are required");
            }

            Customer saved = customerService.saveCustomerWithoutMeter(customer);

            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
                String message = String.format(
                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
                        saved.getName() != null ? saved.getName() : "Mteja"
                );
                sendSmsBeem(saved.getPhone(), message);
            }

            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
        try {
            String email = data.get("email");
            String password = data.get("password");

            if (email == null || password == null) {
                return ResponseEntity.badRequest().body("Email and password are required");
            }

            Customer customer = customerService.authenticate(email, password);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
        try {
            Optional<Customer> customer = customerService.getCustomerById(id);
            return customer.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
        try {
            // Null checks for required fields
            if (updatedData.getName() == null || updatedData.getName().trim().isEmpty() ||
                    updatedData.getEmail() == null || updatedData.getEmail().trim().isEmpty() ||
                    updatedData.getPhone() == null || updatedData.getPhone().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Name, email and phone are required");
            }

            Customer updated = customerService.updateCustomer(updatedData, id);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update profile: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            boolean deleted = customerService.deleteCustomer(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete customer: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            String newStatus = body.get("status");
            if (newStatus == null || newStatus.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Status is required");
            }

            Customer updated = customerService.updateCustomerStatus(id, newStatus);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update status: " + e.getMessage());
        }
    }

    @GetMapping("/active")
    public ResponseEntity<List<Customer>> getAllActiveCustomers() {
        try {
            List<Customer> customers = customerService.getAllActiveCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<Customer>> getAllDeletedCustomers() {
        try {
            List<Customer> customers = customerService.getAllDeletedCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<?> softDeleteCustomer(@PathVariable Long id,
                                                @RequestParam String deletedBy) {
        try {
            if (deletedBy == null || deletedBy.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Deleted by information is required");
            }

            boolean deleted = customerService.softDeleteCustomer(id, deletedBy);
            if (deleted) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/restore/{id}")
    public ResponseEntity<?> restoreCustomer(@PathVariable Long id) {
        try {
            boolean restored = customerService.restoreCustomer(id);
            if (restored) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            String newPassword = body.get("newPassword");

            if (email == null || email.trim().isEmpty() ||
                    newPassword == null || newPassword.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Email na password mpya lazima zitoe.");
            }

            boolean updated = customerService.updatePasswordByEmail(email, newPassword);
            if (updated) {
                try {
                    customerService.sendPasswordChangedEmail(email);
                } catch (Exception e) {
                    System.out.println("Kosa la kutuma email: " + e.getMessage());
                }
                return ResponseEntity.ok("Password imebadilishwa kikamilifu.");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email haipo kwenye mfumo.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error resetting password: " + e.getMessage());
        }
    }
}

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.PasswordResetToken;
//import com.zawadig.myafwanii.Service.BillService;
//import com.zawadig.myafwanii.Service.CustomerService;
//import com.zawadig.myafwanii.Service.PasswordResetTokenService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/v1/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private BillService billService;
//
//    @Autowired
//    private PasswordResetTokenService passwordResetTokenService;
//
//    @Value("${beem.api.key}")
//    private String beemApiKey;
//
//    @Value("${beem.api.secret}")
//    private String beemApiSecret;
//
//    @Value("${beem.sender.name}")
//    private String senderName;
//
//    private final String BEEM_API_URL = "https://apisms.beem.africa/v1/send";
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // ===========================
//    // Helper Methods
//    // ===========================
//
//    /**
//     * Format phone number to start with '255' and remove leading zero or plus.
//     */
//    private String formatPhoneNumber(String phone) {
//        if (phone == null) return "";
//        phone = phone.trim();
//        if (phone.startsWith("0")) {
//            return "255" + phone.substring(1);
//        } else if (phone.startsWith("+")) {
//            return phone.substring(1);
//        }
//        return phone;
//    }
//
//    /**
//     * Send SMS using Beem API.
//     */
//    private void sendSmsBeem(String phone, String message) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setBasicAuth(beemApiKey, beemApiSecret);
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Map<String, Object> payload = new HashMap<>();
//            payload.put("source_addr", senderName);
//            payload.put("encoding", "0");
//            payload.put("schedule_time", "");
//            payload.put("message", message);
//
//            Map<String, String> recipient = new HashMap<>();
//            recipient.put("recipient_id", "1");
//            recipient.put("dest_addr", formatPhoneNumber(phone));
//
//            payload.put("recipients", Collections.singletonList(recipient));
//
//            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
//
//            ResponseEntity<String> response = restTemplate.postForEntity(BEEM_API_URL, requestEntity, String.class);
//
//            System.out.println("Beem SMS response status: " + response.getStatusCode());
//            System.out.println("Beem SMS response body: " + response.getBody());
//
//        } catch (Exception e) {
//            System.err.println("❌ SMS sending failed: " + e.getMessage());
//        }
//    }
//
//
//    // ===========================
//    // 1. Register Customer
//    // ===========================
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            // Save customer without meter number or bill at registration
//            Customer saved = customerService.saveCustomerWithoutMeter(customer);
//
//            // Send welcome SMS if phone exists
//            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
//                String message = String.format(
//                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
//                        saved.getName()
//                );
//                sendSmsBeem(saved.getPhone(), message);
//            }
//
//            return ResponseEntity.ok(saved);
//
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
//        }
//    }
//
//
//    // ===========================
//    // 2. Login Customer
//    // ===========================
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        try {
//            Customer customer = customerService.authenticate(email, password);
//            return ResponseEntity.ok(customer);
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Tatizo la seva: " + e.getMessage());
//        }
//    }
//
//
//    // ===========================
//    // 3. Get Customer Profile By ID
//    // ===========================
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
//        return ResponseEntity.of(customerService.getCustomerById(id));
//    }
//
//
//    // ===========================
//    // 4. Update Customer Profile
//    // ===========================
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
//        try {
//            Customer updated = customerService.updateCustomer(updatedData, id);
//            return ResponseEntity.ok(updated);
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update profile");
//        }
//    }
//
//
//    // ===========================
//    // 5. Get All Customers (Admin)
//    // ===========================
//    @GetMapping("/all")
//    public ResponseEntity<List<Customer>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//
//
//    // ===========================
//    // 6. Delete Customer
//    // ===========================
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
//        try {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete customer");
//        }
//    }
//
//
//    // ===========================
//    // 7. Update Customer Status
//    // ===========================
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        try {
//            String newStatus = body.get("status");
//            Customer updated = customerService.updateCustomerStatus(id, newStatus);
//            return ResponseEntity.ok(updated);
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update status");
//        }
//    }
//
//
//    // ===========================
//    // 8. Password Reset Request (Send Token)
//    // ===========================
//    @PostMapping("/password-reset/request")
//    public ResponseEntity<?> requestPasswordReset(@RequestBody Map<String, String> body) {
//        String email = body.get("email");
//        try {
//            Optional<Customer> customerOpt = Optional.ofNullable(customerService.findByEmail(email));
//            if (customerOpt.isEmpty()) {
//                return ResponseEntity.badRequest().body("Email haipo");
//            }
//            Customer customer = customerOpt.get();
//
//            String token = passwordResetTokenService.createPasswordResetToken(customer);
//
//            String resetLink = "https://yourfrontend.com/reset-password?token=" + token;
//
//            // Tuma SMS yenye reset link
//            sendSmsBeem(customer.getPhone(), "Tafadhali tumia link hii kubadili password yako: " + resetLink);
//
//            return ResponseEntity.ok("Reset link imetumwa kwa simu yako.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tatizo limetokea: " + e.getMessage());
//        }
//    }
//
//
//    // ===========================
//    // 9. Password Reset Confirm (Change Password)
//    // ===========================
//    @PostMapping("/password-reset/confirm")
//    public ResponseEntity<?> confirmPasswordReset(@RequestBody Map<String, String> body) {
//        String token = body.get("token");
//        String newPassword = body.get("newPassword");
//
//        try {
//            passwordResetTokenService.resetPassword(token, newPassword);
//            return ResponseEntity.ok("Password imebadilishwa kwa mafanikio");
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tatizo limetokea: " + e.getMessage());
//        }
//    }
//
//}
//
