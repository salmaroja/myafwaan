package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Object> findByEmail(String email);
}
