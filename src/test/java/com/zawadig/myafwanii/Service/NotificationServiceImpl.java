////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Model.Notification;
////import com.zawadig.myafwanii.Repository.NotificationRepository;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class NotificationServiceImpl implements NotificationService {
////
////    private final NotificationRepository notificationRepository;
////
////    public NotificationServiceImpl(NotificationRepository notificationRepository) {
////        this.notificationRepository = notificationRepository;
////    }
////
////    @Override
////    public List<Notification> getNotificationsForCustomer(Long customerId) {
////        return notificationRepository.findByCustomer_IdOrderByCreatedAtDesc(customerId);
////    }
////
////    @Override
////    public void sendNotification(Long customerId, String title, String message) {
////        Customer customer = new Customer();
////        customer.setId(customerId); // ✅ Create lightweight customer reference
////
////        Notification notification = new Notification();
////        notification.setCustomer(customer);
////        notification.setTitle(title);
////        notification.setMessage(message);
////
////        notificationRepository.save(notification);
////    }
////
////    @Override
////    public void sendNotificationToCustomer(Customer customer, String subject, String plainMessage) {
////        Notification notification = new Notification();
////        notification.setCustomer(customer);
////        notification.setTitle(subject);
////        notification.setMessage(plainMessage);
////
////        notificationRepository.save(notification);
////    }
////
////    @Override
////    public List<Notification> getNotificationsForTechnician(Long technicianId) {
////        return null;
////    }
////
////    @Override
////    public List<Notification> getNotificationsForAdmin(Long adminId) {
////        return null;
////    }
////
////    @Override
////    public void markAsRead(Long notificationId) {
////
////    }
////
////    @Override
////    public void deleteNotification(Long notificationId) {
////
////    }
////}
//
//
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.Notification;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.NotificationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final CustomerRepository customerRepository; // Ili kuhakikisha customer exists

    @Autowired
    public NotificationServiceImpl(
            NotificationRepository notificationRepository,
            CustomerRepository customerRepository
    ) {
        this.notificationRepository = notificationRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Notification> getNotificationsForCustomer(Long customerId) {
        // 1. Hakikisha customerId sio null na customer yupo
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        // 2. Thibitisha customer yupo
        customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + customerId));

        // 3. Pata notifikesheni na upange kwa mpangilio
        return notificationRepository.findByCustomerIdOrderByCreatedAtDesc(customerId);
    }

    // ... methods nyingine

    @Override
    public void sendNotification(Long customerId, String title, String message) {
        try {
            System.out.println("=== ATTEMPTING TO SEND NOTIFICATION ===");
            System.out.println("Customer ID: " + customerId);

            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

            System.out.println("Customer found: " + customer.getFullName());

            Notification notification = new Notification();
            notification.setCustomer(customer);
            notification.setTitle(title);
            notification.setMessage(message);
            notification.setCreatedAt(LocalDateTime.now());
            notification.setRead(false);

            notificationRepository.save(notification);

            System.out.println("=== NOTIFICATION SAVED SUCCESSFULLY ===");
            System.out.println("ID: " + notification.getId());

        } catch (Exception e) {
            System.err.println("!!! FAILED TO SEND NOTIFICATION !!!");
            e.printStackTrace();
        }
    }
    @Override
    public void sendNotificationToCustomer(Customer customer, String title, String message) {
        Notification notification = new Notification();
        notification.setCustomer(customer);
        notification.setTitle(title);
        notification.setMessage(message);

        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsForTechnician(Long technicianId) {
        // Implementation inafanyika hapa kama unahitaji
        throw new UnsupportedOperationException("Huduma ya taarifa kwa fundi haijatengenezwa bado");
    }

    @Override
    public List<Notification> getNotificationsForAdmin(Long adminId) {
        // Implementation inafanyika hapa kama unahitaji
        throw new UnsupportedOperationException("Huduma ya taarifa kwa admin haijatengenezwa bado");
    }

    @Override
    @Transactional
    public void markAsRead(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            notification.setRead(true);
            notificationRepository.save(notification);
        }
    }
//
//    @Override
//    @Transactional
//    public void deleteNotification(Long notificationId) {
//        notificationRepository.deleteById(notificationId);
//    }

    // ======== UTENGENEZAJI WA ZAIDI ========
    @Transactional
    public void markAllAsReadForCustomer(Long customerId) {
        List<Notification> unreadNotifications = notificationRepository
                .findByCustomerIdAndReadFalse(customerId);

        unreadNotifications.forEach(notification -> {
            notification.setRead(true);
            notificationRepository.save(notification);
        });
    }

    @Transactional
    public void deleteAllNotificationsForCustomer(Long customerId) {
        notificationRepository.deleteByCustomerId(customerId);
    }

//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.Notification;
//import com.zawadig.myafwanii.Repository.NotificationRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NotificationServiceImpl implements NotificationService {
//
//    private final NotificationRepository notificationRepository;
//
//    @Override
//    public List<Notification> getNotificationsForCustomer(Long customerId) {
//        return null;
//    }
//
//    @Override
//    public void sendNotification(Long customerId, String title, String message) {
//        Notification notification = new Notification();
//        notification.setCustomer(new Customer(customerId)); // Hii ni muhimu!
//        notification.setTitle(title);
//        notification.setMessage(message);
//        notification.setCreatedAt(LocalDateTime.now());
//        notification.setRead(false);
//        notificationRepository.save(notification);
//    }
//
//    @Override
//    public void sendNotificationToCustomer(Customer customer, String subject, String plainMessage) {
//
//    }
//
//    @Override
//    public List<Notification> getNotificationsForTechnician(Long technicianId) {
//        return null;
//    }
//
//    @Override
//    public List<Notification> getNotificationsForAdmin(Long adminId) {
//        return null;
//    }
//
//    @Override
//    public void markAsRead(Long notificationId) {
//
//    }

    @Override
    public void deleteNotification(Long notificationId) {

    }

    @Override
    public List<Notification> getUnreadNotifications(Long customerId) {
        return notificationRepository.findByCustomerIdAndReadFalse(customerId);
    }
}