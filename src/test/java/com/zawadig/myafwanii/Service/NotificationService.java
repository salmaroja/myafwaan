//package com.zawadig.myafwanii.Service;
//
//
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.Notification;
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Repository.NotificationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class NotificationService {
//
//    @Autowired
//    private NotificationRepository notificationRepository;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    public Notification sendNotificationToCustomer(Long customerId, Notification notification) {
//        Customer customer = customerRepository.findById(customerId).orElse(null);
//        if (customer != null) {
//            notification.setCustomer(customer);
//            return notificationRepository.save(notification);
//        }
//        return null;
//    }
//
//    public List<Notification> getNotificationsByCustomer(Long customerId) {
//        return notificationRepository.findByCustomerIdOrderByTimestampDesc(customerId);
//    }
//
//    public Notification markAsRead(Long notificationId) {
//        Notification notification = notificationRepository.findById(notificationId).orElse(null);
//        if (notification != null) {
//            notification.setRead(true);
//            return notificationRepository.save(notification);
//        }
//        return null;
//    }
//
//    public void sendNotificationToAll(String title, String message) {
//        List<Customer> customers = customerRepository.findAll();
//        for (Customer customer : customers) {
//            Notification notification = new Notification();
//            notification.setTitle(title);
//            notification.setMessage(message);
//            notification.setCustomer(customer);
//            notificationRepository.save(notification);
//        }
//    }
//}
//
// NotificationService.java
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Notification;

import java.util.List;

public interface NotificationService {
    void sendNotification(Long customerId, String title, String message);
    List<Notification> getNotificationsForCustomer(Long customerId);
}
