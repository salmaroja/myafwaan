package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Util.ControlNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Ondoa PasswordEncoder kabisa

    public Customer saveCustomer(Customer customer) {
        // Hapa password hutahifadhiwa plain text (HAKUKUMBIKI)
        // Ikiwa unataka encrypt, re-add PasswordEncoder na encode hapa
        // Lakini kwa sasa tuta-save plain password
        // (Kumbuka, hii sio salama kwa production!)

        // Hakikisha unahakikisha frontend inatuma password salama (e.g. HTTPS)

        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        // Save password as-is (plain text)
        // customer.setPassword(customer.getPassword()); // hii ni optional, kwa plain text

        // Angalia kama meter number bado haipo
        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
            customer.setMeterNumber(ControlNumberGenerator.generateMeterNumber());
        }

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Customer customer, Long id) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public long countCustomers() {
        return customerRepository.count();
    }

    // Authenticate method: plain text password comparison
    public Customer authenticate(String email, String rawPassword) throws Exception {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));

        // Plain text comparison (SI salama, lakini itafanya kazi sasa)
        if (!rawPassword.equals(customer.getPassword())) {
            throw new Exception("Invalid password");
        }

        return customer;
    }
}
