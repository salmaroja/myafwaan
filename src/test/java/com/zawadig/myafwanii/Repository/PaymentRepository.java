package com.zawadig.myafwanii.Repository;



import com.zawadig.myafwanii.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Unaweza kuongeza query methods hapa kama ukihitaji
    List<Payment> findByBill_CustomerId(Long customerId);


}
