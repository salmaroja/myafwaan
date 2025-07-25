//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Complaint;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
//    List<Complaint> findByCustomerId(Long customerId);
//    List<Complaint> findByStatus(String status);
//}

package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByCustomerId(Long customerId);
    List<Complaint> findByStatus(String status);

    // Active complaints only
    @Query("SELECT c FROM Complaint c WHERE c.deleted = false")
    List<Complaint> findAllActive();

    // Deleted complaints only
    @Query("SELECT c FROM Complaint c WHERE c.deleted = true")
    List<Complaint> findAllDeleted();
}
