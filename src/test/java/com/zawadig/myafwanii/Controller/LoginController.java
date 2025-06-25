package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.dto.LoginRequest;
import com.zawadig.myafwanii.dto.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Customer customer = customerRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        if (customer == null) {
            return ResponseEntity.badRequest().body("Invalid email");
        }

        // Plain text password comparison
        if (!loginRequest.getPassword().equals(customer.getPassword())) {
            return ResponseEntity.badRequest().body("Incorrect password");
        }

        LoginResponse response = new LoginResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}
