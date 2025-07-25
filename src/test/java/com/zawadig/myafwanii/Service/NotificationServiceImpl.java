package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Notification;
import com.zawadig.myafwanii.Repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepo;

    public NotificationServiceImpl(NotificationRepository notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    @Override
    public void sendNotification(Long customerId, String title, String message) {
        Notification notification = new Notification();
        notification.setCustomerId(customerId);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepo.save(notification);
    }

    @Override
    public List<Notification> getNotificationsForCustomer(Long customerId) {
        return notificationRepo.findByCustomerIdOrderByCreatedAtDesc(customerId);
    }
}
