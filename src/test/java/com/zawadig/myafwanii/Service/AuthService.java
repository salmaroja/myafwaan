package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.dto.CustomerRegisterRequest;
import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.User;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public AuthService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public String register(CustomerRegisterRequest request) {
        // Angalia kama email tayari imejisajili
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already registered!";
        }

        // Tengeneza User
        User user = new User();
        user.setEmail(request.getEmail());

        // Password is stored as plain text here, bad practice for production!
        user.setPassword(request.getPassword());

        user.setRole("CUSTOMER");

        User savedUser = userRepository.save(user);

        // Generate meter number
        String meterNumber = "ZAWA-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Tengeneza Customer
        Customer customer = new Customer();
//        customer.setFullName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setMeterNumber(meterNumber);
        customer.setUser(savedUser);

        customerRepository.save(customer);

        return "Registration successful!";
    }
}
