
package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.RequestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestFormRepository extends JpaRepository<RequestForm, Long> {

    // Get all requests with their payments
    @Query("SELECT DISTINCT r FROM RequestForm r LEFT JOIN FETCH r.payments")
    List<RequestForm> findAllWithPayments();
    List<RequestForm> findByCustomerId(Long customerId);
    Optional<RequestForm> findByIdAndCustomerId(Long id, Long customerId);

    // Standard JPA methods are inherited
}