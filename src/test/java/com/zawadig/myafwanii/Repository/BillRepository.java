package com.zawadig.myafwanii.Repository;//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Bill;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface BillRepository extends JpaRepository<Bill, Long> {
//    List<Bill> findByCustomerId(Long customerId);
//}
import com.zawadig.myafwanii.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByCustomerId(Long customerId);

    Optional<Bill> findTopByCustomerIdOrderByIdDesc(Long customerId); // Bill ya mwisho
}
