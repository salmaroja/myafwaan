package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.dto.CustomerRegisterRequest;
import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.User;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Ondoa PasswordEncoder

    public String register(CustomerRegisterRequest request) {
        // Angalia kama email imesajiliwa
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already registered!";
        }

        // Step 1: Create and save User
        User user = new User();
        user.setEmail(request.getEmail());

        // Hifadhi password kama plain text (HAKUKUMBIKI!)
        user.setPassword(request.getPassword());

        user.setRole("CUSTOMER");
        User savedUser = userRepository.save(user);

        // Step 2: Generate meter number
        String meterNumber = "ZAWA-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        // Step 3: Create and save Customer
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setPassword(null); // au weka sawa na user password kama unavyotaka
        customer.setMeterNumber(meterNumber);
        customer.setUser(savedUser);

        customerRepository.save(customer);

        return "Registration successful!";
    }
}
