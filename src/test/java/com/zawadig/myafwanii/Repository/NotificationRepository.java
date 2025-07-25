//package com.zawadig.myafwanii.Repository;
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

package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByCustomerIdOrderByCreatedAtDesc(Long customerId);

    // ✅ Count unread notifications for staff
    @Query("SELECT COUNT(n) FROM Notification n WHERE n.read = false")
    long countUnreadForStaff();
}
