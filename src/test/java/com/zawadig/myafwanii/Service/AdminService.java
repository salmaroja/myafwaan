package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Admin;
import com.zawadig.myafwanii.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepository;

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public void deleteAdmni(Long id) {
        adminRepository.deleteById(id);
    }

    public void deleteAdmin(Long id) {
    }
}

