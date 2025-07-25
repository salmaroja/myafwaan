package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Customer> findByMeterNumber(String meterNumber);

    // Badilisha query ili itumie parameteri ya tarehe
    @Query("SELECT COUNT(c) FROM Customer c WHERE c.registrationDate >= :sinceDate")
    long countNewCustomers(@Param("sinceDate") LocalDateTime sinceDate);
}
