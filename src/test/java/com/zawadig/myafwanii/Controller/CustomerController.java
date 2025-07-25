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
//
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

    // Helper: format phone number to start with 255 and no leading zero or plus
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

    // Helper: Send SMS using Beem API
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

    // 1. Register customer + create bill + send SMS
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Customer customer) {
//        try {
//            Customer saved = customerService.saveCustomer(customer);
//
//            // Create initial bill automatically
//            billService.createInitialBillForCustomer(saved);
//
//            // Send SMS confirmation
//            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
//                String message = String.format(
//                        "Habari %s, usajili wako umefanikiwa. Bill yako ya kwanza imetengenezwa. Asante kwa kutumia ZAWA!",
//                        saved.getName()
//                );
//                sendSmsBeem(saved.getPhone(), message);
//            }
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("id", saved.getId());
//            response.put("name", saved.getName());
//            response.put("email", saved.getEmail());
//            response.put("meterNumber", saved.getMeterNumber());
//            response.put("message", "Usajili umefanikiwa, bill yako ya kwanza imetengenezwa");
//
//            return ResponseEntity.ok(response);
//
//        } catch (IllegalArgumentException ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tatizo limetokea: " + ex.getMessage());
//        }
//    }
// 1. Register customer + create bill + send SMS
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Customer customer) {
        try {
            // Hifadhi customer bila meter number wala bill
            Customer saved = customerService.saveCustomerWithoutMeter(customer); // ← tumia "customer" (siyo Customer)

            // Tuma SMS rahisi ya "karibu"
            if (saved.getPhone() != null && !saved.getPhone().isEmpty()) {
                String message = String.format(
                        "Habari %s, usajili wako umefanikiwa. Tafadhali ingia kwenye mfumo na uwasilishe maombi ya huduma ili uendelee.",
                        saved.getName()
                );
                sendSmsBeem(saved.getPhone(), message); // ← hakikisha method hii ipo kwenye controller yako
            }

            return ResponseEntity.ok(saved); // rejesha taarifa ya customer aliyesajiliwa

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kuna kosa limetokea wakati wa usajili: " + e.getMessage());
        }
    }

    // 2. Login customer
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String password = data.get("password");

        try {
            Customer customer = customerService.authenticate(email, password);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // 3. Get customer profile by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getProfile(@PathVariable Long id) {
        return ResponseEntity.of(customerService.getCustomerById(id));
    }

    // 4. Update customer profile
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Customer updatedData) {
        try {
            Customer updated = customerService.updateCustomer(updatedData, id);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update profile");
        }
    }

    // 5. Get all customers (admin)
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // 6. Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }

    // 7. Update customer status
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            String newStatus = body.get("status");
            Customer updated = customerService.updateCustomerStatus(id, newStatus);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update status");
        }
    }
}
