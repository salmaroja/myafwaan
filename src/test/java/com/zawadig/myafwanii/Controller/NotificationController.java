package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Notification;
import com.zawadig.myafwanii.Service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Get notifications for a specific customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Notification>> getCustomerNotifications(@PathVariable Long customerId) {
        List<Notification> notifications = notificationService.getNotificationsForCustomer(customerId);
        return ResponseEntity.ok(notifications);
    }
}
