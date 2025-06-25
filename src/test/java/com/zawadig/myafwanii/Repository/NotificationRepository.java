package com.zawadig.myafwanii.Repository;


import com.zawadig.myafwanii.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByCustomerIdOrderByTimestampDesc(Long customerId);
}

