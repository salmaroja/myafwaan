package com.zawadig.myafwanii.Repository;



import com.zawadig.myafwanii.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByMeterNumber(String meterNumber);
    List<Bill> findByCustomerId(Long customerId);
}