package com.zawadig.myafwanii.Repository;//package com.zawadig.myafwanii.Repository;
//
//
//import com.zawadig.myafwanii.Model.Notification;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface NotificationRepository extends JpaRepository<Notification, Long> {
//    List<Notification> findByCustomerIdOrderByTimestampDesc(Long customerId);
//}
//
// NotificationRepository.java
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Notification;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface NotificationRepository extends JpaRepository<Notification, Long> {
//    List<Notification> findByCustomerIdOrderByCreatedAtDesc(Long customerId);
//}


//
//import com.zawadig.myafwanii.Model.Notification;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface NotificationRepository extends JpaRepository<Notification, Long> {
//
//    List<Notification> findByCustomerIdOrderByCreatedAtDesc(Long customerId);
//
//    @Query("SELECT COUNT(n) FROM Notification n WHERE n.read = false")
//    long countUnreadForStaff();
//
//    List<Notification> findByCustomerIdIsNullOrderByCreatedAtDesc();
//
//}


import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // 🔔 Fetch notifications for a specific customer
    List<Notification> findByCustomerOrderByCreatedAtDesc(Customer customer);

    // 🔔 Count unread notifications for staff (assuming staff notifications have no customer)
    @Query("SELECT COUNT(n) FROM Notification n WHERE n.read = false AND n.customer IS NULL")
    long countUnreadForStaff();

    // 🔔 Fetch notifications meant for staff (no customer assigned)
    List<Notification> findByCustomerIsNullOrderByCreatedAtDesc();

    List<Notification> findByCustomer_IdOrderByCreatedAtDesc(Long customerId);
    List<Notification> findByCustomerIdOrderByCreatedAtDesc(Long customerId);

    List<Notification> findByCustomerIdAndReadFalse(Long customerId);

    void deleteByCustomerId(Long customerId);


    List<Notification> findByCustomerId(Long customerId);

        // AU kama unatumia @Query
        @Query("SELECT n FROM Notification n WHERE n.customer.id = :customerId ORDER BY n.createdAt DESC")
        List<Notification> findCustomerNotifications(@Param("customerId") Long customerId);
    }

