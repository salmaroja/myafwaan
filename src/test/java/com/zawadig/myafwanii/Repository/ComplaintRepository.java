package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByCustomerId(Long customerId);
    List<Complaint> findByStatus(String status);
}
