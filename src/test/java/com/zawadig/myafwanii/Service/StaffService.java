package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Staff;
import com.zawadig.myafwanii.Repository.StaffRepository;
import com.zawadig.myafwanii.Repository.ComplaintRepository;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    // Save staff
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    // Get all staff
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Get staff by ID
    public Staff getStaffById(Long id) {
        Optional<Staff> optional = staffRepository.findById(id);
        return optional.orElse(null);
    }

    // Update staff
    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff existing = getStaffById(id);
        if (existing != null) {
            existing.setName(updatedStaff.getName());
            existing.setEmail(updatedStaff.getEmail());
            existing.setSpecialization(updatedStaff.getSpecialization());
            existing.setPhone(updatedStaff.getPhone());
            existing.setUsername(updatedStaff.getUsername());
            existing.setPassword(updatedStaff.getPassword());
            existing.setEnabled(updatedStaff.isEnabled());
            existing.setPosition(updatedStaff.getPosition());
            return staffRepository.save(existing);
        }
        return null;
    }

    // Delete staff
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }

    // Dashboard Summary - make sure countNewCustomers and countUnreadForStaff accept parameters or have proper queries
    public Map<String, Object> getDashboardSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("totalComplaints", complaintRepository.count());

        // Use LocalDateTime 7 days ago for new customers count
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        long newCustomersCount = customerRepository.countNewCustomers(sevenDaysAgo);
        summary.put("newCustomers", newCustomersCount);

        // For unread notifications, assuming countUnreadForStaff() exists in NotificationRepository
        long unreadNotificationsCount = notificationRepository.countUnreadForStaff();
        summary.put("unreadNotifications", unreadNotificationsCount);

        return summary;
    }
}
