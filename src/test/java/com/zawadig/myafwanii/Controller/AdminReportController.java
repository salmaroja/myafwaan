package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.RequestForm;
import com.zawadig.myafwanii.Model.ServicePayment;
import com.zawadig.myafwanii.Model.Survey;
import com.zawadig.myafwanii.Service.AdminReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/reports")
@CrossOrigin(origins = "*")
public class AdminReportController {

    @Autowired
    private AdminReportService adminReportService;

    @GetMapping("/summary")
    public Map<String, Object> getAdminSummary() {
        return adminReportService.getAdminSummary();
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return adminReportService.getAllCustomers();
    }

    @GetMapping("/payments")
    public List<ServicePayment> getAllPayments() {
        return adminReportService.getAllPayments();
    }

    @GetMapping("/surveys")
    public List<Survey> getAllSurveys() {
        return adminReportService.getAllSurveys();
    }

    @GetMapping("/requests")
    public List<RequestForm> getAllRequests() {
        return adminReportService.getAllRequests();
    }

    @GetMapping("/services")
    public List<Map<String, Object>> getAllServices() {
        return adminReportService.getAllServices();
    }
}