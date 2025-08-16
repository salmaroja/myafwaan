package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Admin;
import com.zawadig.myafwanii.Repository.AdminRepository;
import com.zawadig.myafwanii.Service.EmailService;
import com.zawadig.myafwanii.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Admin;
//import com.zawadig.myafwanii.Repository.AdminRepository;
//import com.zawadig.myafwanii.dto.LoginRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    // 🟢 Login ya kawaida bila security
//
//
//        @PostMapping("/login")
//        public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//            Admin admin = adminRepository.findByEmail(request.getEmail()).orElse(null);
//            if (admin != null && admin.getPassword().equals(request.getPassword())) {
//                admin.setPassword(null); // usirudishe password kwenye response
//                return ResponseEntity.ok(admin);
//            }
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//
//
//
//    // 🟢 Sample ya kuchukua customers wote (baadaye admin atadhibiti haya)
//    @GetMapping("/customers")
//    public List<String> customersList() {
//        return List.of("Customer 1", "Customer 2", "Customer 3"); // test only
//    }
//}
//@RestController
//@RequestMapping("/api/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    // Login endpoint
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        Admin admin = adminRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new RuntimeException("Admin not found"));
//
//        System.out.println("🔍 Raw password from request: '" + request.getPassword() + "'");
//        System.out.println("🔍 Hash from DB: '" + admin.getPassword() + "'");
//        System.out.println("🔍 Password matches? " + passwordEncoder.matches(request.getPassword(), admin.getPassword()));
//
//        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
//        }
//
//        admin.setPassword(null);
//        return ResponseEntity.ok(admin);
//
//    }
//    @PostMapping("/create")
//    public ResponseEntity<Admin> createAdmin(@RequestParam String username,
//                                             @RequestParam String email,
//                                             @RequestParam String password) {
//        Admin admin = new Admin();
//        admin.setUsername(username);
//        admin.setEmail(email.trim());
//        admin.setPassword(passwordEncoder.encode(password.trim()));
//
//        Admin saved = adminRepository.save(admin);
//        saved.setPassword(null); // Usionyeshe password kwenye response
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//    }
//
//
//    // Password reset endpoint
//    @PostMapping("/reset-password")
//    public ResponseEntity<String> resetPassword(
//            @RequestParam String email,
//            @RequestParam String oldPassword,
//            @RequestParam String newPassword) {
//
//        Admin admin = adminRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("Admin not found"));
//
//        // Verify old password
//        if (!passwordEncoder.matches(oldPassword, admin.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Old password is incorrect");
//        }
//
//        // Update to new password
//        admin.setPassword(passwordEncoder.encode(newPassword));
//        adminRepository.save(admin);
//
//        return ResponseEntity.ok("Password updated successfully");
//    }
//}

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Admin admin = adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

        admin.setPassword(null);
        return ResponseEntity.ok(admin);
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestParam String username,
                                             @RequestParam String email,
                                             @RequestParam String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setEmail(email.trim());
        admin.setPassword(passwordEncoder.encode(password.trim()));

        Admin saved = adminRepository.save(admin);
        saved.setPassword(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Forgot password - Step 1: Request reset link
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // Generate token and set expiry (1 hour from now)
        String resetToken = UUID.randomUUID().toString();
        admin.setResetToken(resetToken);
        admin.setResetTokenExpiry(LocalDateTime.now().plusHours(1));
        adminRepository.save(admin);

        // Send email with reset link
        String resetLink = "http://your-frontend-domain/reset-password/" + resetToken;
        emailService.sendPasswordResetEmail(email, resetLink);

        return ResponseEntity.ok("Password reset instructions sent to your email");
    }

    // Forgot password - Step 2: Reset with token
    @PostMapping("/reset-password-with-token")
    public ResponseEntity<String> resetPasswordWithToken(
            @RequestParam String token,
            @RequestParam String newPassword) {

        Admin admin = adminRepository.findByResetToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));

        if (admin.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token has expired");
        }

        // Update password and clear token
        admin.setPassword(passwordEncoder.encode(newPassword));
        admin.setResetToken(null);
        admin.setResetTokenExpiry(null);
        adminRepository.save(admin);

        return ResponseEntity.ok("Password reset successfully");
    }

    // Existing password reset (requires old password)
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestParam String email,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {

        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!passwordEncoder.matches(oldPassword, admin.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Old password is incorrect");
        }

        admin.setPassword(passwordEncoder.encode(newPassword));
        adminRepository.save(admin);

        return ResponseEntity.ok("Password updated successfully");
    }
}