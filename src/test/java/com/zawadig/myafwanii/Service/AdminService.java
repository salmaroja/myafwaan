////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Admin;
////import com.zawadig.myafwanii.Repository.AdminRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////import java.util.Optional;
////
////@Service
////public class AdminService {
////
////    @Autowired
////    private AdminRepository adminRepository;
////
////    public Admin saveAdmin(Admin admin) {
////        return adminRepository.save(admin);
////    }
////
////    public List<Admin> getAllAdmins() {
////        return adminRepository.findAll();
////    }
////
////    public Optional<Admin> getAdminById(Long id) {
////        return adminRepository.findById(id);
////    }
////
////    public void deleteAdmni(Long id) {
////        adminRepository.deleteById(id);
////    }
////
////    public void deleteAdmin(Long id) {
////    }
////}
////
//
//
//
//
//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Admin;
//import com.zawadig.myafwanii.Repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AdminService {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    public Admin saveAdmin(Admin admin) {
//        return adminRepository.save(admin);
//    }
//
//    public List<Admin> getAllAdmins() {
//        return adminRepository.findAll();
//    }
//
//    public Optional<Admin> getAdminById(Long id) {
//        return adminRepository.findById(id);
//    }
//
//    public void deleteAdmin(Long id) {
//        adminRepository.deleteById(id);
//    }
//}


package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Admin;
import com.zawadig.myafwanii.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin createAdmin(String username, String email, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        Admin admin = Admin.builder()
                .username(username)
                .email(email)
                .password(encodedPassword)
                .build();
        return adminRepository.save(admin);
    }
}
