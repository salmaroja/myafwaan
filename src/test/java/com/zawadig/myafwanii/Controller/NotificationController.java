////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Notification;
////import com.zawadig.myafwanii.Service.NotificationService;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////@RequestMapping("/api/v1/notifications")
////public class NotificationController {
////
////    private final NotificationService notificationService;
////
////    public NotificationController(NotificationService notificationService) {
////        this.notificationService = notificationService;
////    }
////
////    @GetMapping("/customer/{customerId}")
////    public ResponseEntity<List<Notification>> getCustomerNotifications(
////            @PathVariable Long customerId) {
////        List<Notification> notifications =
////                notificationService.getNotificationsForCustomer(customerId);
////        return ResponseEntity.ok(notifications);
////    }
////
////    @GetMapping("/technician/{technicianId}")
////    public ResponseEntity<List<Notification>> getTechnicianNotifications(
////            @PathVariable Long technicianId) {
////        List<Notification> notifications =
////                notificationService.getNotificationsForTechnician(technicianId);
////        return ResponseEntity.ok(notifications);
////    }
////
////    @GetMapping("/admin/{adminId}")
////    public ResponseEntity<List<Notification>> getAdminNotifications(
////            @PathVariable Long adminId) {
////        List<Notification> notifications =
////                notificationService.getNotificationsForAdmin(adminId);
////        return ResponseEntity.ok(notifications);
////    }
////
////    @PutMapping("/read/{notificationId}")
////    public ResponseEntity<Void> markNotificationAsRead(
////            @PathVariable Long notificationId) {
////        notificationService.markAsRead(notificationId);
////        return ResponseEntity.noContent().build();
////    }
////
////    @DeleteMapping("/{notificationId}")
////    public ResponseEntity<Void> deleteNotification(
////            @PathVariable Long notificationId) {
////        notificationService.deleteNotification(notificationId);
////        return ResponseEntity.noContent().build();
////    }
////}
package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Notification;
import com.zawadig.myafwanii.Service.NotificationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
//
//@RestController
//@RequestMapping("/api/notifications")
//public class NotificationController {
//
//    private final NotificationService notificationService;
//
//    public NotificationController(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }
//
//    // For customers
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Notification>> getCustomerNotifications(
//            @PathVariable Long customerId) {
//        List<Notification> notifications =
//                notificationService.getNotificationsForCustomer(customerId);
//        return ResponseEntity.ok(notifications);
//    }
//
//    @PutMapping("/read/{notificationId}")
//    public ResponseEntity<Void> markNotificationAsRead(
//            @PathVariable Long notificationId) {
//        notificationService.markAsRead(notificationId);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{notificationId}")
//    public ResponseEntity<Void> deleteNotification(
//            @PathVariable Long notificationId) {
//        notificationService.deleteNotification(notificationId);
//        return ResponseEntity.noContent().build();
//    }
//}
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Notification>> getCustomerNotifications(
            @PathVariable Long customerId
    ) {
        try {
            List<Notification> notifications = notificationService.getNotificationsForCustomer(customerId);
            return ResponseEntity.ok(notifications);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
//@RestController
//@RequestMapping("/api/notifications")
//@CrossOrigin("*")
//public class NotificationController {
//
//    @Autowired
//    private NotificationService notificationService;
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long customerId) {
//        return ResponseEntity.ok(
//                notificationService.getUnreadNotifications(customerId)
//        );
//    }
//}