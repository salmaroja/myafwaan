package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByResetToken(String resetToken); // Add this line

}
