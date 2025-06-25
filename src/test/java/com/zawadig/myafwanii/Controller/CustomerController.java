package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create a new customer
    @PostMapping("/create")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Customer customer = customerService.authenticate(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(new LoginResponse(customer.getId(), customer.getEmail(), "fake-jwt-token"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email au password si sahihi");
        }
    }

    // DTO classes
    public static class LoginRequest {
        private String email;
        private String password;
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class LoginResponse {
        private Long id;
        private String email;
        private String token;
        public LoginResponse(Long id, String email, String token) {
            this.id = id;
            this.email = email;
            this.token = token;
        }
        public Long getId() { return id; }
        public String getEmail() { return email; }
        public String getToken() { return token; }
    }

    // Zingine ulizokuwa nazo
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customer.setId(id);
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/count")
    public long countCustomers() {
        return customerService.countCustomers();
    }
}
