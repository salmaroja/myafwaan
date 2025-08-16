package com.zawadig.myafwanii.Controller;//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Repository.CustomerRepository;
//import com.zawadig.myafwanii.Repository.ServicePaymentRepository;
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/admin/dashboard")
//public class AdminDashboardController {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private ServicePaymentRepository servicePaymentRepository;
//
//    @GetMapping("/stats")
//    public Map<String, Object> getDashboardStats() {
//        Map<String, Object> stats = new HashMap<>();
//
//        // Jumla ya wateja
//        long totalCustomers = customerRepository.count();
//        stats.put("totalCustomers", totalCustomers);
//
//        // Jumla ya wateja wapya mwezi huu
//        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0);
//        long newCustomersThisMonth = customerRepository.countNewCustomers(startOfMonth);
//        stats.put("newCustomersThisMonth", newCustomersThisMonth);
//
//        // Malipo yaliyothibitishwa
//        long verifiedPayments = servicePaymentRepository.findByPaymentStatus(PaymentStatus.VERIFIED).size();
//        stats.put("verifiedPayments", verifiedPayments);
//
//        // Malipo yasiyothibitishwa
//        long pendingPayments = servicePaymentRepository.findByPaymentStatus(PaymentStatus.PENDING).size();
//        stats.put("pendingPayments", pendingPayments);
//
//        return stats;
//    }
//}

import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.ServicePaymentRepository;
import com.zawadig.myafwanii.enums.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/dashboard")
public class AdminDashboardController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServicePaymentRepository servicePaymentRepository;

    @GetMapping("/stats")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();

        // Jumla ya wateja
        long totalCustomers = customerRepository.count();
        stats.put("totalCustomers", totalCustomers);

        // Wateja wapya mwezi huu
        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0);
        long newCustomersThisMonth = customerRepository.countNewCustomers(startOfMonth);
        stats.put("newCustomersThisMonth", newCustomersThisMonth);

        // Malipo yaliyothibitishwa
        long verifiedPayments = servicePaymentRepository.findByPaymentStatus(PaymentStatus.VERIFIED).size();
        stats.put("verifiedPayments", verifiedPayments);

        // Malipo yasiyothibitishwa
        long pendingPayments = servicePaymentRepository.findByPaymentStatus(PaymentStatus.PENDING).size();
        stats.put("pendingPayments", pendingPayments);

        // 🔴 FIXED: Added soft-delete stats
        long deletedCustomers = customerRepository.findAllDeletedCustomers().size();
        stats.put("deletedCustomers", deletedCustomers);

        long activeCustomers = customerRepository.findAllActiveCustomers().size();
        stats.put("activeCustomers", activeCustomers);

        // 🔴 FIXED: Added verification & survey stats
        long verifiedCustomers = customerRepository.findAllVerifiedCustomers().size();
        stats.put("verifiedCustomers", verifiedCustomers);

        long surveyedCustomers = customerRepository.findAllSurveyedCustomers().size();
        stats.put("surveyedCustomers", surveyedCustomers);

        return stats;
    }

    // 🔴 FIXED: Soft delete endpoint
    @PostMapping("/soft-delete/{id}")
    public void softDeleteCustomer(
            @PathVariable Long id,
            @RequestParam String deletedBy
    ) {
        customerRepository.softDelete(id, LocalDateTime.now(), deletedBy);
    }

    // 🔴 FIXED: Restore endpoint
    @PostMapping("/restore/{id}")
    public void restoreCustomer(@PathVariable Long id) {
        customerRepository.restoreCustomer(id);
    }
}