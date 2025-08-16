//////package com.zawadig.myafwanii.Repository;
//////
//////import com.zawadig.myafwanii.Model.Customer;
//////import org.springframework.data.jpa.repository.JpaRepository;
//////import org.springframework.data.jpa.repository.Query;
//////import org.springframework.data.repository.query.Param;
//////
//////import java.time.LocalDateTime;
//////import java.util.Optional;
//////
//////public interface CustomerRepository extends JpaRepository<Customer, Long> {
//////
//////    Optional<Customer> findByEmail(String email);
//////    boolean existsByEmail(String email);
//////    Optional<Customer> findByMeterNumber(String meterNumber);
//////
//////    // Badilisha query ili itumie parameteri ya tarehe
//////    @Query("SELECT COUNT(c) FROM Customer c WHERE c.registrationDate >= :sinceDate")
//////    long countNewCustomers(@Param("sinceDate") LocalDateTime sinceDate);
//////}
////
////
////
////
////
////
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.House;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//
//    // Existing methods
//    Optional<Customer> findByEmail(String email);
//    List<Customer> findAllByEmailIn(List<String> emails);
//    boolean existsByEmail(String email);
//    Optional<Customer> findByMeterNumber(String meterNumber);
//
//    @Query("SELECT COUNT(c) FROM Customer c WHERE c.registrationDate >= :sinceDate")
//    long countNewCustomers(@Param("sinceDate") LocalDateTime sinceDate);
//
//    @Query("SELECT c FROM Customer c WHERE c.house.houseNumber = :houseNumber")
//    List<Customer> findByHouseNumber(@Param("houseNumber") String houseNumber);
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Customer c SET c.house = :house WHERE c.email = :email")
//    void updateHouseByEmail(@Param("email") String email, @Param("house") House house);
//
//    List<Customer> findByHouse_HouseNumber(String houseNumber);
//
//    // 🔴 FIXED: Soft delete method
//    @Modifying
//    @Transactional
//    @Query("UPDATE Customer c SET c.deleted = true, c.deletedAt = :now, c.deletedBy = :deletedBy WHERE c.id = :id")
//    void softDelete(@Param("id") Long id, @Param("now") LocalDateTime now, @Param("deletedBy") String deletedBy);
//
//    // 🔴 FIXED: Restore method
//    @Modifying
//    @Transactional
//    @Query("UPDATE Customer c SET c.deleted = false, c.deletedAt = NULL, c.deletedBy = NULL WHERE c.id = :id")
//    void restoreCustomer(@Param("id") Long id);
//
//    // 🔴 FIXED: Find deleted customers
//    @Query("SELECT c FROM Customer c WHERE c.deleted = true")
//    List<Customer> findAllDeletedCustomers();
//
//    // 🔴 FIXED: Find active customers
//    @Query("SELECT c FROM Customer c WHERE c.deleted = false OR c.deleted IS NULL")
//    List<Customer> findAllActiveCustomers();
//
//    // 🔴 FIXED: Find verified customers
//    @Query("SELECT c FROM Customer c WHERE c.isVerified = true")
//    List<Customer> findAllVerifiedCustomers();
//
//    // 🔴 FIXED: Find surveyed customers
//    @Query("SELECT c FROM Customer c WHERE c.isSurveyed = true")
//    List<Customer> findAllSurveyedCustomers();
//}muimuuuuuuuuu

package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 🔹 Find by email
    Optional<Customer> findByEmail(String email);

    // 🔹 Find multiple by emails
    List<Customer> findAllByEmailIn(List<String> emails);

    // 🔹 Check existence by email
    boolean existsByEmail(String email);

    // 🔹 Find by meter number
    Optional<Customer> findByMeterNumber(String meterNumber);

    // 🔹 Count new customers since date
    @Query("SELECT COUNT(c) FROM Customer c WHERE c.registrationDate >= :sinceDate")
    long countNewCustomers(@Param("sinceDate") LocalDateTime sinceDate);

    // 🔹 Find by house number
    @Query("SELECT c FROM Customer c WHERE c.house.houseNumber = :houseNumber")
    List<Customer> findByHouseNumber(@Param("houseNumber") String houseNumber);

    List<Customer> findByHouse_HouseNumber(String houseNumber);

    // 🔹 Update house assignment by email
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.house = :house WHERE c.email = :email")
    void updateHouseByEmail(@Param("email") String email, @Param("house") House house);

    // 🔹 Soft delete customer
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.deleted = true, c.deletedAt = :now, c.deletedBy = :deletedBy WHERE c.id = :id")
    void softDelete(@Param("id") Long id, @Param("now") LocalDateTime now, @Param("deletedBy") String deletedBy);

    // 🔹 Restore soft-deleted customer
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.deleted = false, c.deletedAt = NULL, c.deletedBy = NULL WHERE c.id = :id")
    void restoreCustomer(@Param("id") Long id);

    // 🔹 Find all deleted customers
    @Query("SELECT c FROM Customer c WHERE c.deleted = true")
    List<Customer> findAllDeletedCustomers();

    // 🔹 Find all active customers
    @Query("SELECT c FROM Customer c WHERE c.deleted = false OR c.deleted IS NULL")
    List<Customer> findAllActiveCustomers();

    // 🔹 Find all verified customers
    @Query("SELECT c FROM Customer c WHERE c.isVerified = true")
    List<Customer> findAllVerifiedCustomers();

    // 🔹 Find all surveyed customers
    @Query("SELECT c FROM Customer c WHERE c.isSurveyed = true")
    List<Customer> findAllSurveyedCustomers();

    // 🔹 Update password by email
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.password = :newPassword WHERE c.email = :email")
    int updatePasswordByEmail(@Param("email") String email, @Param("newPassword") String newPassword);
    Optional<Customer> findById(Long id);
}

