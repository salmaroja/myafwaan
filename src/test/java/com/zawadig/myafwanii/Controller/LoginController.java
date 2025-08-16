package com.zawadig.myafwanii.Controller;////package com.zawadig.myafwanii.Controller;

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

//
//
//
//
//
//import com.zawadig.myafwanii.Model.Admin;
//import com.zawadig.myafwanii.Model.Technician;
//import com.zawadig.myafwanii.Repository.AdminRepository;
//import com.zawadig.myafwanii.Repository.TechnicianRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Autowired
//    private TechnicianRepository technicianRepository;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(
//            @RequestParam String role,
//            @RequestParam String email,
//            @RequestParam String password) {
//
//        if ("admin".equalsIgnoreCase(role)) {
//            Admin admin = adminRepository.findByEmail(email).orElse(null);
//            if (admin != null && admin.getPassword().equals(password)) {
//                return ResponseEntity.ok(admin);
//            } else {
//                return ResponseEntity.status(401).body("Admin credentials invalid");
//            }
//        } else if ("technician".equalsIgnoreCase(role)) {
//            Technician tech = technicianRepository.findByEmail(email).orElse(null);
//            if (tech != null && tech.getPassword().equals(password)) {
//                return ResponseEntity.ok(tech);
//            } else {
//                return ResponseEntity.status(401).body("Technician credentials invalid");
//            }
//        } else {
//            return ResponseEntity.badRequest().body("Role not supported");
//        }
//    }
//}
//
////import com.zawadig.myafwanii.Model.Admin;
////import com.zawadig.myafwanii.Model.Technician;
////import com.zawadig.myafwanii.Repository.AdminRepository;
////import com.zawadig.myafwanii.Repository.TechnicianRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////@RestController
////@RequestMapping("/api")
////public class LoginController {
////
////    @Autowired
////    private AdminRepository adminRepository;
////
////    @Autowired
////    private TechnicianRepository technicianRepository;
////
////    @PostMapping("/login")
////    public ResponseEntity<?> login(
////            @RequestParam String role,
////            @RequestParam String email,
////            @RequestParam String password) {
////
////        if ("admin".equalsIgnoreCase(role)) {
////            Admin admin = adminRepository.findByEmail(email).orElse(null);
////            if (admin != null && ((Admin) admin).getPassword().equals(password)) {
////                return ResponseEntity.ok().body("Admin login successful");
////            } else {
////                return ResponseEntity.status(401).body("Admin credentials invalid");
////            }
////        }
////        else if ("technician".equalsIgnoreCase(role)) {
////            Technician tech = technicianRepository.findByEmail(email).orElse(null);
//            if (tech != null && tech.getPassword().equals(password)) {
//                return ResponseEntity.ok().body("Technician login successful");
//            } else {
//                return ResponseEntity.status(401).body("Technician credentials invalid");
//            }
//        }
//        else {
//            return ResponseEntity.badRequest().body("Role not supported");
//        }
//    }
//}
//
//
