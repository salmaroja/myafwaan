////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Repository.CustomerRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////import java.util.Random;
////
////@Service
////public class CustomerServiceImpl implements CustomerService {
////
////    @Autowired
////    private CustomerRepository customerRepository;
////
////    @Autowired
////    private PasswordEncoder passwordEncoder; // For password encryption
////
////    // 1. Save/Register customer
////    @Override
////    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
////        // Validate unique email
////        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
////            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
////        }
////
////        // Generate meter number if not provided
////        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
////            customer.setMeterNumber(generateMeterNumber());
////        }
////
////        // Set default status to 'active'
////        if (customer.getStatus() == null || customer.getStatus().isEmpty()) {
////            customer.setStatus("active");
////        }
////
////        // Encrypt password before saving
////        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
////            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
////        }
////
////        return customerRepository.save(customer);
////    }
////
////    // Helper method to generate unique meter number
////    private String generateMeterNumber() {
////        String[] mikoa = {"DSM", "ZNZ", "MWZ", "ARU", "KIG", "MTW", "MOR", "DOD", "TAB", "SHI"};
////        String randomMkoa = mikoa[new Random().nextInt(mikoa.length)];
////        String uniqueDigits = String.format("%06d", new Random().nextInt(999999));
////        return "MTR-" + randomMkoa + "-" + uniqueDigits;
////    }
////
////    // 2. Authenticate customer (login)
////    @Override
////    public Customer authenticate(String email, String password) throws Exception {
////        Optional<Customer> optional = customerRepository.findByEmail(email);
////        if (optional.isEmpty()) {
////            throw new Exception("Maelezo ya kuingia si sahihi");
////        }
////
////        Customer customer = optional.get();
////
////        // Verify password using encoder
////        if (!passwordEncoder.matches(password, customer.getPassword())) {
////            throw new Exception("Maelezo ya kuingia si sahihi");
////        }
////
////        return customer;
////    }
////
////    // 3. Get customer by ID
////    @Override
////    public Optional<Customer> getCustomerById(Long id) {
////        return customerRepository.findById(id);
////    }
////
////    // 4. Update customer data
////    @Override
////    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
////        Customer existing = customerRepository.findById(id)
////                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
////
////        // Update fields with null checks
////        if (updatedData.getName() != null) existing.setName(updatedData.getName());
////        if (updatedData.getEmail() != null) {
////            // Check if email is being changed to another existing email
////            if (!existing.getEmail().equals(updatedData.getEmail()) &&
////                    customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
////                throw new IllegalArgumentException("Barua pepe tayari inatumika na mteja mwingine");
////            }
////            existing.setEmail(updatedData.getEmail());
////        }
////        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
////            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
////        }
////        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
////        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
////        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
////        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
////
////        return customerRepository.save(existing);
////    }
////
////    // 5. Get all customers
////    @Override
////    public List<Customer> getAllCustomers() {
////        return customerRepository.findAll();
////    }
////
////    // 6. Delete customer by ID
////    @Override
////    public void deleteCustomer(Long id) throws Exception {
////        if (!customerRepository.existsById(id)) {
////            throw new Exception("Mteja hajapatikana");
////        }
////        customerRepository.deleteById(id);
////    }
////
////    // 7. Update status only
////    @Override
////    public Customer updateCustomerStatus(Long id, String status) throws Exception {
////        Customer existing = customerRepository.findById(id)
////                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
////
////        existing.setStatus(status);
////        return customerRepository.save(existing);
////    }
////}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.User;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Repository.UserRepository;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    // Existing methods...
//
//    @Override
//    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
//        return null;
//    }
//
//    @Override
//    public Customer authenticate(String email, String password) throws Exception {
//        return null;
//    }
//
//    @Override
//    public Optional<Customer> getCustomerById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
//        return null;
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return null;
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws Exception {
//
//    }
//
//    @Override
//    public Customer updateCustomerStatus(Long id, String status) throws Exception {
//        return null;
//    }
//
//    // New method implementation to create customer using DTO and link User
//    @Override
//    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
//        Optional<User> userOpt = userRepository.findById(dto.getUserId());
//        if (!userOpt.isPresent()) {
//            throw new RuntimeException("User not found with id: " + dto.getUserId());
//        }
//
//        // Check email uniqueness
//        if (customerRepository.findByEmail(dto.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
//        }
//
//        User user = userOpt.get();
//
//        Customer customer = new Customer();
//        customer.setName(dto.getName());
//        customer.setEmail(dto.getEmail());
//        customer.setPhone(dto.getPhone());
//        customer.setAddress(dto.getAddress());
//        customer.setMeterNumber(dto.getMeterNumber() != null ? dto.getMeterNumber() : generateMeterNumber());
//        customer.setUser(user);
//        customer.setStatus("active");
//
//        // Password is not included in DTO for security; you may add if needed
//
//        return customerRepository.save(customer);
//    }
//
//    // Existing methods continued...
//
//    private String generateMeterNumber() {
//        String[] mikoa = {"DSM", "ZNZ", "MWZ", "ARU", "KIG", "MTW", "MOR", "DOD", "TAB", "SHI"};
//        String randomMkoa = mikoa[new Random().nextInt(mikoa.length)];
//        String uniqueDigits = String.format("%06d", new Random().nextInt(999999));
//        return "MTR-" + randomMkoa + "-" + uniqueDigits;
//    }
//
//    // ... rest of your existing code
//}izo apo nd muumimu
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private String generateMeterNumber() {
//        return "ZNZ" + (new Random().nextInt(900000) + 100000); // 6-digit random
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
//        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
//        }
//
//        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
//            customer.setMeterNumber(generateMeterNumber());
//        }
//
//        if (customer.getStatus() == null || customer.getStatus().isEmpty()) {
//            customer.setStatus("active");
//        }
//
//        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
//            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        }
//
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public Customer authenticate(String email, String password) throws Exception {
//        Optional<Customer> optional = customerRepository.findByEmail(email);
//        if (optional.isEmpty()) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//
//        Customer customer = optional.get();
//        if (!passwordEncoder.matches(password, customer.getPassword())) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//
//        return customer;
//    }
//
//    @Override
//    public Optional<Customer> getCustomerById(Long id) {
//        return customerRepository.findById(id);
//    }
//
//    @Override
//    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//
//        if (updatedData.getName() != null) existing.setName(updatedData.getName());
//        if (updatedData.getEmail() != null && !updatedData.getEmail().equals(existing.getEmail())) {
//            if (customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
//                throw new IllegalArgumentException("Barua pepe tayari inatumika");
//            }
//            existing.setEmail(updatedData.getEmail());
//        }
//
//        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
//            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
//        }
//
//        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
//        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
//        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
//        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
//
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws Exception {
//        if (!customerRepository.existsById(id)) {
//            throw new Exception("Mteja hajapatikana");
//        }
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public Customer updateCustomerStatus(Long id, String status) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        existing.setStatus(status);
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
//        return null;
//    }
//}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Util.BeemSmsSender;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private String generateMeterNumber() {
//        return "ZNZ" + (new Random().nextInt(900000) + 100000); // Generates a 6-digit number prefixed with ZNZ
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
//        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
//        }
//
//        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
//            customer.setMeterNumber(generateMeterNumber());
//        }
//
//        if (customer.getStatus() == null || customer.getStatus().isEmpty()) {
//            customer.setStatus("active");
//        }
//
//        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
//            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        }
//
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public Customer authenticate(String email, String password) throws Exception {
//        Optional<Customer> optional = customerRepository.findByEmail(email);
//        if (optional.isEmpty()) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//
//        Customer customer = optional.get();
//        if (!passwordEncoder.matches(password, customer.getPassword())) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//
//        return customer;
//    }
//
//    @Override
//    public Optional<Customer> getCustomerById(Long id) {
//        return customerRepository.findById(id);
//    }
//
//    @Override
//    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//
//        if (updatedData.getName() != null) existing.setName(updatedData.getName());
//
//        if (updatedData.getEmail() != null && !updatedData.getEmail().equals(existing.getEmail())) {
//            if (customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
//                throw new IllegalArgumentException("Barua pepe tayari inatumika");
//            }
//            existing.setEmail(updatedData.getEmail());
//        }
//
//        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
//            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
//        }
//
//        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
//        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
//        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
//        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
//
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws Exception {
//        if (!customerRepository.existsById(id)) {
//            throw new Exception("Mteja hajapatikana");
//        }
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public Customer updateCustomerStatus(Long id, String status) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        existing.setStatus(status);
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
//        // Implementation if you want to create Customer using DTO and linking to User entity
//        // For now, returning null or you can implement this as per your app logic
//        return null;
//    }
//    @Autowired
//    private BeemSmsSender smsSender;
//
//    public Customer registerCustomer(Customer customer) {
//        Customer savedCustomer = customerRepository.save(customer);
//
//        // Tuma SMS
//        String message = "Asante kwa kujisajili ZAWA. Akaunti yako imefanikiwa!";
//        smsSender.sendSms(savedCustomer.getPhone(), message);
//
//        return savedCustomer;
//    }
//
//}

//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Util.BeemSmsSender;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private BeemSmsSender smsSender;
//
//    private String generateMeterNumber() {
//        return "ZNZ" + (new Random().nextInt(900000) + 100000);
//    }
//
//    @Override
//    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
//        // Validate email uniqueness
//        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
//        }
//
//        // Generate meter number
//        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
//            customer.setMeterNumber(generateMeterNumber());
//        }
//
//        // Default status
//        if (customer.getStatus() == null) {
//            customer.setStatus("active");
//        }
//
//        // Encrypt password
//        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
//            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        }
//
//        Customer saved = customerRepository.save(customer);
//
//        // Send SMS after save
//        String message = String.format("Habari %s, usajili wako umefanikiwa!", saved.getName());
//        smsSender.sendSms(saved.getPhone(), message);
//
//        return saved;
//    }
//
//    @Override
//    public Customer authenticate(String email, String password) throws Exception {
//        Optional<Customer> opt = customerRepository.findByEmail(email);
//        if (opt.isEmpty()) throw new Exception("Maelezo ya kuingia si sahihi");
//        Customer c = opt.get();
//        if (!passwordEncoder.matches(password, c.getPassword())) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//        return c;
//    }
//
//    @Override
//    public Optional<Customer> getCustomerById(Long id) {
//        return customerRepository.findById(id);
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        if (updatedData.getName() != null) existing.setName(updatedData.getName());
//        if (updatedData.getEmail() != null && !updatedData.getEmail().equals(existing.getEmail())) {
//            if (customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
//                throw new IllegalArgumentException("Barua pepe tayari inatumika");
//            }
//            existing.setEmail(updatedData.getEmail());
//        }
//        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
//            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
//        }
//        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
//        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
//        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
//        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws Exception {
//        if (!customerRepository.existsById(id)) {
//            throw new Exception("Mteja hajapatikana");
//        }
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public Customer updateCustomerStatus(Long id, String status) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        existing.setStatus(status);
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
//        return null;
//    }
//}
//
//// CustomerController.java (src/main/java/com/zawadig/myafwanii/Controller/CustomerController.java)

//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Util.BeemSmsSender;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private BeemSmsSender smsSender;
//
//    private String generateMeterNumber() {
//        return "ZNZ" + (new Random().nextInt(900000) + 100000);
//    }
//
//    @Override
//    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
//        // Validate email uniqueness
//        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
//        }
//
//        // Generate meter number
//        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
//            customer.setMeterNumber(generateMeterNumber());
//        }
//
//        // Default status
//        if (customer.getStatus() == null) {
//            customer.setStatus("active");
//        }
//
//        // Set registration date
//        customer.setRegistrationDate(LocalDateTime.now());
//
//        // Encrypt password
//        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
//            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        }
//
//        Customer saved = customerRepository.save(customer);
//
//        // Send SMS after save
//        String message = String.format("Habari %s, usajili wako umefanikiwa!", saved.getName());
//        smsSender.sendSms(saved.getPhone(), message);
//
//        return saved;
//    }
//
//    @Override
//    public Customer authenticate(String email, String password) throws Exception {
//        Optional<Customer> opt = customerRepository.findByEmail(email);
//        if (opt.isEmpty()) throw new Exception("Maelezo ya kuingia si sahihi");
//        Customer c = opt.get();
//        if (!passwordEncoder.matches(password, c.getPassword())) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//        return c;
//    }
//
//    @Override
//    public Optional<Customer> getCustomerById(Long id) {
//        return customerRepository.findById(id);
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        if (updatedData.getName() != null) existing.setName(updatedData.getName());
//        if (updatedData.getEmail() != null && !updatedData.getEmail().equals(existing.getEmail())) {
//            if (customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
//                throw new IllegalArgumentException("Barua pepe tayari inatumika");
//            }
//            existing.setEmail(updatedData.getEmail());
//        }
//        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
//            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
//        }
//        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
//        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
//        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
//        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws Exception {
//        if (!customerRepository.existsById(id)) {
//            throw new Exception("Mteja hajapatikana");
//        }
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public Customer updateCustomerStatus(Long id, String status) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        existing.setStatus(status);
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
//        // Implement conversion from DTO to Customer, then save
//        Customer customer = new Customer();
//        customer.setName(dto.getName());
//        customer.setEmail(dto.getEmail());
//        customer.setPhone(dto.getPhone());
//        customer.setAddress(dto.getAddress());
//        customer.setPassword(dto.getPassword()); // Remember to encode password in saveCustomer
//        // other fields from DTO as needed
//
//        return saveCustomer(customer);
//    }
//
////    @Override
////    public Customer saveCustomerWithoutMeter(CustomerDTO dto) throws RuntimeException {
////        return null;
////    }
//    @Override
//    public Customer saveCustomerWithoutMeter(Customer dto) throws RuntimeException {
//        if (dto == null || dto.getName() == null || dto.getPhone() == null || dto.getAddress() == null) {
//            throw new RuntimeException("Missing required fields");
//        }
//
//        Customer customer = new Customer();
//        customer.setName(dto.getName());
//        customer.setEmail(dto.getEmail());
//        customer.setPassword(dto.getPassword());
//        customer.setAddress(dto.getAddress());
//        customer.setPhone(dto.getPhone());
//        customer.setStatus("PENDING");
//        // Hakuna meter number kwa sasa
//
//        return customerRepository.save(customer);
//    }
//
//}

//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Util.BeemSmsSender;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private BeemSmsSender smsSender;
//
//    private String generateMeterNumber() {
//        return "ZNZ" + (new Random().nextInt(900000) + 100000);
//    }
//
//    @Override
//    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
//        // Validate email uniqueness
//        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
//        }
//
//        // Generate meter number if not provided
//        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
//            customer.setMeterNumber(generateMeterNumber());
//        }
//
//        // Default status
//        if (customer.getStatus() == null) {
//            customer.setStatus("active");
//        }
//
//        // Set registration date
//        customer.setRegistrationDate(LocalDateTime.now());
//
//        // Encrypt password
//        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
//            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        } else {
//            throw new IllegalArgumentException("Password ni lazima");
//        }
//
//        Customer saved = customerRepository.save(customer);
//
//        // Send SMS after save
//        String message = String.format("Habari %s, usajili wako umefanikiwa!", saved.getName());
//        smsSender.sendSms(saved.getPhone(), message);
//
//        return saved;
//    }
//
//    @Override
//    public Customer authenticate(String email, String password) throws Exception {
//        Optional<Customer> opt = customerRepository.findByEmail(email);
//        if (opt.isEmpty()) throw new Exception("Maelezo ya kuingia si sahihi");
//        Customer c = opt.get();
//        if (!passwordEncoder.matches(password, c.getPassword())) {
//            throw new Exception("Maelezo ya kuingia si sahihi");
//        }
//        return c;
//    }
//
//    @Override
//    public Optional<Customer> getCustomerById(Long id) {
//        return customerRepository.findById(id);
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        if (updatedData.getName() != null) existing.setName(updatedData.getName());
//        if (updatedData.getEmail() != null && !updatedData.getEmail().equals(existing.getEmail())) {
//            if (customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
//                throw new IllegalArgumentException("Barua pepe tayari inatumika");
//            }
//            existing.setEmail(updatedData.getEmail());
//        }
//        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
//            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
//        }
//        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
//        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
//        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
//        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws Exception {
//        if (!customerRepository.existsById(id)) {
//            throw new Exception("Mteja hajapatikana");
//        }
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public Customer updateCustomerStatus(Long id, String status) throws Exception {
//        Customer existing = customerRepository.findById(id)
//                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
//        existing.setStatus(status);
//        return customerRepository.save(existing);
//    }
//
//    @Override
//    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
//        return null;
//    }
//
//    @Override
//    public Customer saveCustomerWithoutMeter(Customer dto) throws RuntimeException {
//        return null;
//    }
//
//    // Save customer without meter number (usajili wa awali, meter number itatolewa baadaye)
//    @Override
//    public Customer saveCustomerWithoutMeter(CustomerDTO dto) throws RuntimeException {
//        if (dto == null || dto.getName() == null || dto.getPhone() == null || dto.getAddress() == null) {
//            throw new RuntimeException("Sehemu muhimu hazijajazwa");
//        }
//        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
//            throw new RuntimeException("Nenosiri ni lazima");
//        }
//
//        Customer customer = new Customer();
//        customer.setName(dto.getName());
//        customer.setEmail(dto.getEmail());
//        customer.setPhone(dto.getPhone());
//        customer.setAddress(dto.getAddress());
//        customer.setStatus("PENDING");
//        customer.setMeterNumber(null);
//        customer.setPassword(passwordEncoder.encode(dto.getPassword()));  // HASHING PASSWORD
//
//        return customerRepository.save(customer);
//    }
//}

package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Util.BeemSmsSender;
import com.zawadig.myafwanii.dto.CustomerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BeemSmsSender smsSender;

    private String generateMeterNumber() {
        return "ZNZ" + (new Random().nextInt(900000) + 100000);
    }

    @Override
    public Customer saveCustomer(Customer customer) throws IllegalArgumentException {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Barua pepe tayari imesajiliwa");
        }

        if (customer.getMeterNumber() == null || customer.getMeterNumber().isEmpty()) {
            customer.setMeterNumber(generateMeterNumber());
        }

        if (customer.getStatus() == null) {
            customer.setStatus("active");
        }

        customer.setRegistrationDate(LocalDateTime.now());

        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        } else {
            throw new IllegalArgumentException("Password ni lazima");
        }

        Customer saved = customerRepository.save(customer);

        String message = String.format("Habari %s, usajili wako umefanikiwa!", saved.getName());
        smsSender.sendSms(saved.getPhone(), message);

        return saved;
    }

    @Override
    public Customer authenticate(String email, String password) throws Exception {
        Optional<Customer> opt = customerRepository.findByEmail(email);
        if (opt.isEmpty()) throw new Exception("Maelezo ya kuingia si sahihi");
        Customer c = opt.get();
        if (!passwordEncoder.matches(password, c.getPassword())) {
            throw new Exception("Maelezo ya kuingia si sahihi");
        }
        return c;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer updatedData, Long id) throws Exception {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
        if (updatedData.getName() != null) existing.setName(updatedData.getName());
        if (updatedData.getEmail() != null && !updatedData.getEmail().equals(existing.getEmail())) {
            if (customerRepository.findByEmail(updatedData.getEmail()).isPresent()) {
                throw new IllegalArgumentException("Barua pepe tayari inatumika");
            }
            existing.setEmail(updatedData.getEmail());
        }
        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
        }
        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
        if (updatedData.getAddress() != null) existing.setAddress(updatedData.getAddress());
        if (updatedData.getMeterNumber() != null) existing.setMeterNumber(updatedData.getMeterNumber());
        if (updatedData.getStatus() != null) existing.setStatus(updatedData.getStatus());
        return customerRepository.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) throws Exception {
        if (!customerRepository.existsById(id)) {
            throw new Exception("Mteja hajapatikana");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomerStatus(Long id, String status) throws Exception {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Mteja hajapatikana"));
        existing.setStatus(status);
        return customerRepository.save(existing);
    }

    @Override
    public Customer createCustomer(CustomerDTO dto) throws RuntimeException {
        if (dto == null || dto.getName() == null || dto.getPhone() == null || dto.getAddress() == null) {
            throw new RuntimeException("Sehemu muhimu hazijajazwa");
        }
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new RuntimeException("Nenosiri ni lazima");
        }

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setStatus("PENDING");
        customer.setMeterNumber(null);
        customer.setPassword(passwordEncoder.encode(dto.getPassword()));

        return customerRepository.save(customer);
    }

    @Override
    public Customer saveCustomerWithoutMeter(Customer customer) throws RuntimeException {
        if (customer == null || customer.getName() == null || customer.getPhone() == null || customer.getAddress() == null) {
            throw new RuntimeException("Sehemu muhimu hazijajazwa");
        }
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            throw new RuntimeException("Nenosiri ni lazima");
        }

        customer.setStatus("PENDING");
        customer.setMeterNumber(null);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRegistrationDate(LocalDateTime.now());

        return customerRepository.save(customer);
    }

    @Override
    public Customer saveCustomerWithoutMeter(CustomerDTO dto) throws RuntimeException {
        return null;
    }
}
