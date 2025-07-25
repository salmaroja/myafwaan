////////package com.zawadig.myafwanii.Service;
////////
////////import com.zawadig.myafwanii.Model.Customer;
////////import java.util.List;
////////import java.util.Optional;
////////
////////public interface CustomerService {
////////
////////    Customer saveCustomer(Customer customer) throws IllegalArgumentException;
////////
////////    Customer authenticate(String email, String password) throws Exception;
////////
////////    Optional<Customer> getCustomerById(Long id);
////////
////////    Customer updateCustomer(Customer updatedData, Long id) throws Exception;
////////
////////    List<Customer> getAllCustomers();
////////
////////    void deleteCustomer(Long id) throws Exception;
////////
////////    Customer updateCustomerStatus(Long id, String status) throws Exception;
////////}
//////package com.zawadig.myafwanii.Service;
//////
//////import com.zawadig.myafwanii.Model.Customer;
//////import com.zawadig.myafwanii.dto.CustomerDTO;
//////import java.util.List;
//////import java.util.Optional;
//////
//////public interface CustomerService {
//////
//////    Customer saveCustomer(Customer customer) throws IllegalArgumentException;
//////
//////    Customer authenticate(String email, String password) throws Exception;
//////
//////    Optional<Customer> getCustomerById(Long id);
//////
//////    Customer updateCustomer(Customer updatedData, Long id) throws Exception;
//////
//////    List<Customer> getAllCustomers();
//////
//////    void deleteCustomer(Long id) throws Exception;
//////
//////    Customer updateCustomerStatus(Long id, String status) throws Exception;
//////
//////    // Method mpya ili ku-create Customer na ku-link User kwa userId
//////    Customer createCustomer(CustomerDTO dto) throws RuntimeException;
//////}
////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.dto.CustomerDTO;
////
////import java.util.List;
////import java.util.Optional;
////
////public interface CustomerService {
////
////    Customer saveCustomer(Customer customer) throws IllegalArgumentException;
////
////    Customer authenticate(String email, String password) throws Exception;
////
////    Optional<Customer> getCustomerById(Long id);
////
////    Customer updateCustomer(Customer updatedData, Long id) throws Exception;
////
////    List<Customer> getAllCustomers();
////
////    void deleteCustomer(Long id) throws Exception;
////
////    Customer updateCustomerStatus(Long id, String status) throws Exception;
////
////    Customer createCustomer(CustomerDTO dto) throws RuntimeException;
////}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CustomerService {
//
//    Customer saveCustomer(Customer customer) throws IllegalArgumentException;
//
//    Customer authenticate(String email, String password) throws Exception;
//
//    Optional<Customer> getCustomerById(Long id);
//
//    Customer updateCustomer(Customer updatedData, Long id) throws Exception;
//
//    List<Customer> getAllCustomers();
//
//    void deleteCustomer(Long id) throws Exception;
//
//    Customer updateCustomerStatus(Long id, String status) throws Exception;
//
//    Customer createCustomer(CustomerDTO dto) throws RuntimeException;
//}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.dto.CustomerDTO;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CustomerService {
//
//    Customer saveCustomer(Customer customer) throws IllegalArgumentException;
//
//    Customer authenticate(String email, String password) throws Exception;
//
//    Optional<Customer> getCustomerById(Long id);
//
//    Customer updateCustomer(Customer updatedData, Long id) throws Exception;
//
//    List<Customer> getAllCustomers();
//
//    void deleteCustomer(Long id) throws Exception;
//
//    Customer updateCustomerStatus(Long id, String status) throws Exception;
//
//    Customer createCustomer(CustomerDTO dto) throws RuntimeException;
//}
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer) throws IllegalArgumentException;

    Customer authenticate(String email, String password) throws Exception;

    Optional<Customer> getCustomerById(Long id);

    Customer updateCustomer(Customer updatedData, Long id) throws Exception;

    List<Customer> getAllCustomers();

    void deleteCustomer(Long id) throws Exception;

    Customer updateCustomerStatus(Long id, String status) throws Exception;

    Customer createCustomer(CustomerDTO dto) throws RuntimeException;

    // ✅ Method mpya ya ku-save customer bila meter number
    Customer saveCustomerWithoutMeter(Customer dto) throws RuntimeException;

    // Save customer without meter number (usajili wa awali, meter number itatolewa baadaye)
    Customer saveCustomerWithoutMeter(CustomerDTO dto) throws RuntimeException;
}
