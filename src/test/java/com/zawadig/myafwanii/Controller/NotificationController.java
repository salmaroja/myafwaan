package com.zawadig.myafwanii.Controller;



import com.zawadig.myafwanii.Model.Notification;
import com.zawadig.myafwanii.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
//@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Send notification to one customer
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Notification> sendToCustomer(@PathVariable Long customerId, @RequestBody Notification notification) {
        Notification result = notificationService.sendNotificationToCustomer(customerId, notification);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }

    // Send notification to all customers
    @PostMapping("/broadcast")
    public ResponseEntity<Void> broadcastNotification(@RequestBody Notification notification) {
        notificationService.sendNotificationToAll(notification.getTitle(), notification.getMessage());
        return ResponseEntity.ok().build();
    }

    // Get notifications by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Notification>> getByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(notificationService.getNotificationsByCustomer(customerId));
    }

    // Mark as read
    @PutMapping("/{id}/read")
    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
        Notification updated = notificationService.markAsRead(id);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
