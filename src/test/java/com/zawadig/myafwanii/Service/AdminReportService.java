package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.*;
import com.zawadig.myafwanii.Repository.*;
import com.zawadig.myafwanii.enums.PaymentStatus;
import com.zawadig.myafwanii.Repository.CustomerRepository;
import com.zawadig.myafwanii.Repository.RequestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AdminReportService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RequestFormRepository requestFormRepository;

    @Autowired
    private ServicePaymentRepository paymentRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    // Summary Report
    public Map<String, Object> getAdminSummary() {
        Map<String, Object> report = new HashMap<>();

        report.put("totalCustomers", customerRepository.count());
        report.put("newCustomersThisMonth", customerRepository.countNewCustomers(LocalDateTime.now().minusMonths(1)));
        report.put("verifiedCustomers", customerRepository.findAllVerifiedCustomers().size());
        report.put("completedSurveys", surveyRepository.count());
        report.put("totalRequests", requestFormRepository.count());

        BigDecimal totalAmountPaid = paymentRepository.findAll()
                .stream()
                .map(ServicePayment::getAmountPaid)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        report.put("totalAmountPaid", totalAmountPaid);

        report.put("pendingPayments", paymentRepository.findByPaymentStatus(PaymentStatus.PENDING).size());
        report.put("verifiedPayments", paymentRepository.findByPaymentStatus(PaymentStatus.VERIFIED).size());
        report.put("failedPayments", paymentRepository.findByPaymentStatus(PaymentStatus.FAILED).size());

        return report;
    }

    // Customers Report
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Payments Report
    public List<ServicePayment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Surveys Report
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Requests Report
    public List<RequestForm> getAllRequests() {
        return requestFormRepository.findAll();
    }

    // Services Report
    public List<Map<String, Object>> getAllServices() {
        List<Map<String, Object>> serviceReports = new ArrayList<>();

        surveyRepository.findAll().forEach(survey -> {
            Map<String, Object> data = new HashMap<>();
            data.put("serviceId", survey.getId());
            data.put("customerName", survey.getCustomer().getName());
            data.put("phone", survey.getCustomer().getPhone());
            data.put("location", survey.getLocation());
            data.put("surveyStatus", survey.getSurveyStatus());
            data.put("serviceDate", survey.getServiceDate());
            data.put("notes", survey.getNotes());
            serviceReports.add(data);
        });

        return serviceReports;
    }
}