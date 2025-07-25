//////package com.zawadig.myafwanii.Model;
//////
//////import jakarta.persistence.*;
//////import java.time.LocalDate;
//////
//////@Entity
//////@Table(name = "service_requests")
//////public class Request {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    @Column(nullable = false)
//////    private String customerName;
//////
//////    @Column(nullable = false)
//////    private String address;
//////
//////    @Column(nullable = false)
//////    private String requestType;
//////
//////    @Column(columnDefinition = "TEXT")
//////    private String description;
//////
//////    @Column(nullable = false)
//////    private String status;
//////
//////    @Column(nullable = false)
//////    private LocalDate requestDate;
//////
//////    // ----- Constructors -----
//////
//////    public Request() {
//////        // Default constructor
//////    }
//////
//////    public Request(String customerName, String address, String requestType, String description, String status, LocalDate requestDate) {
//////        this.customerName = customerName;
//////        this.address = address;
//////        this.requestType = requestType;
//////        this.description = description;
//////        this.status = status;
//////        this.requestDate = requestDate;
//////    }
//////
//////    // ----- Getters & Setters -----
//////
//////    public Long getId() {
//////        return id;
//////    }
//////
//////    public void setId(Long id) {
//////        this.id = id;
//////    }
//////
//////    public String getCustomerName() {
//////        return customerName;
//////    }
//////
//////    public void setCustomerName(String customerName) {
//////        this.customerName = customerName;
//////    }
//////
//////    public String getAddress() {
//////        return address;
//////    }
//////
//////    public void setAddress(String address) {
//////        this.address = address;
//////    }
//////
//////    public String getRequestType() {
//////        return requestType;
//////    }
//////
//////    public void setRequestType(String requestType) {
//////        this.requestType = requestType;
//////    }
//////
//////    public String getDescription() {
//////        return description;
//////    }
//////
//////    public void setDescription(String description) {
//////        this.description = description;
//////    }
//////
//////    public String getStatus() {
//////        return status;
//////    }
//////
//////    public void setStatus(String status) {
//////        this.status = status;
//////    }
//////
//////    public LocalDate getRequestDate() {
//////        return requestDate;
//////    }
//////
//////    public void setRequestDate(LocalDate requestDate) {
//////        this.requestDate = requestDate;
//////    }
//////}
////
//////package com.zawadig.myafwanii.Model;
//////
//////import jakarta.persistence.*;
//////import java.time.LocalDate;
//////
//////@Entity
//////@Table(name = "service_requests")
//////public class Request {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    @Column(nullable = false)
//////    private String customerName;
//////
//////    @Column(nullable = false)
//////    private String address;
//////
//////    @Column(nullable = false)
//////    private String requestType;
//////
//////    @Column(columnDefinition = "TEXT")
//////    private String description;
//////
//////    @Column(nullable = false)
//////    private String status;
//////
//////    @Column(nullable = false)
//////    private LocalDate requestDate;
//////
//////    // 🔽 SEHEMU MPYA ZAIDI HAPA
//////    @Column(nullable = false)
//////    private String customerPhone; // Namba ya simu ya mteja
//////
//////    @Column(columnDefinition = "TEXT")
//////    private String serviceDetails; // Maelezo ya huduma
//////
//////    // ----- Constructors -----
//////    public Request() {
//////        // Constructor ya chaguomsingi
//////    }
//////
//////    // 🔽 CONSTRUCTOR ILIYOSAHIHISHWA (Sasa na vigezo 8)
//////    public Request(String customerName, String address, String requestType,
//////                   String description, String status, LocalDate requestDate,
//////                   String customerPhone, String serviceDetails) {
//////        this.customerName = customerName;
//////        this.address = address;
//////        this.requestType = requestType;
//////        this.description = description;
//////        this.status = status;
//////        this.requestDate = requestDate;
//////        this.customerPhone = customerPhone;
//////        this.serviceDetails = serviceDetails;
//////    }
//////
//////    // ----- Getters & Setters -----
//////    // ... getters/setters za awali zipo hapa ...
//////
//////    // 🔽 GETTERS & SETTERS MPYA
//////    public String getCustomerPhone() {
//////        return customerPhone;
//////    }
//////
//////    public void setCustomerPhone(String customerPhone) {
//////        this.customerPhone = customerPhone;
//////    }
//////
//////    public String getServiceDetails() {
//////        return serviceDetails;
//////    }
//////
//////    public void setServiceDetails(String serviceDetails) {
//////        this.serviceDetails = serviceDetails;
//////    }
//////}
////package com.zawadig.myafwanii.Model;
////
////import jakarta.persistence.*;
////import java.time.LocalDate;
////
////@Entity
////@Table(name = "service_requests")
////public class Request {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(nullable = false)
////    private String customerName;
////
////    @Column(nullable = false)
////    private String address;
////
////    @Column(nullable = false)
////    private String requestType;
////
////    @Column(columnDefinition = "TEXT")
////    private String description;
////
////    @Column(nullable = false)
////    private String status;
////
////    @Column(nullable = false)
////    private LocalDate requestDate;
////
////    // Sehemu mpya zilizongezwa
////    @Column(nullable = false)
////    private String customerPhone;
////
////    @Column(columnDefinition = "TEXT")
////    private String serviceDetails;
////
////
////    // ----- Constructors -----
////    public Request() {
////        // Constructor ya chaguomsingi
////    }
////
////    // Constructor iliyopanuliwa
////    public Request(String customerName, String address, String requestType,
////                   String description, String status, LocalDate requestDate,
////                   String customerPhone, String serviceDetails) {
////        this.customerName = customerName;
////        this.address = address;
////        this.requestType = requestType;
////        this.description = description;
////        this.status = status;
////        this.requestDate = requestDate;
////        this.customerPhone = customerPhone;
////        this.serviceDetails = serviceDetails;
////    }
////
////    // ----- Getters & Setters -----
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getCustomerName() {
////        return customerName;
////    }
////
////    public void setCustomerName(String customerName) {
////        this.customerName = customerName;
////    }
////
////    public String getAddress() {
////        return address;
////    }
////
////    public void setAddress(String address) {
////        this.address = address;
////    }
////
////    public String getRequestType() {
////        return requestType;
////    }
////
////    public void setRequestType(String requestType) {
////        this.requestType = requestType;
////    }
////
////    public String getDescription() {
////        return description;
////    }
////
////    public void setDescription(String description) {
////        this.description = description;
////    }
////
////    public String getStatus() {
////        return status;
////    }
////
////    public void setStatus(String status) {
////        this.status = status;
////    }
////
////    public LocalDate getRequestDate() {
////        return requestDate;
////    }
////
////    public void setRequestDate(LocalDate requestDate) {
////        this.requestDate = requestDate;
////    }
////
////    public String getCustomerPhone() {
////        return customerPhone;
////    }
////
////    public void setCustomerPhone(String customerPhone) {
////        this.customerPhone = customerPhone;
////    }
////
////    public String getServiceDetails() {
////        return serviceDetails;
////    }
////
////    public void setServiceDetails(String serviceDetails) {
////        this.serviceDetails = serviceDetails;
////    }
////}
//
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "service_requests")
//public class Request {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String customerName;
//
//    @Column(nullable = false)
//    private String address;
//
//    @Column(nullable = false)
//    private String requestType;
//
//    @Column(columnDefinition = "TEXT")
//    private String description;
//
//    @Column(nullable = false)
//    private String status;
//
//    @Column(nullable = false)
//    private LocalDate requestDate;
//
//    @Column(nullable = false)
//    private String customerPhone;
//
//    @Column(columnDefinition = "TEXT")
//    private String serviceDetails;
//
//    // ===== Soft delete fields =====
//    private boolean deleted = false;
//
//    private LocalDate deletedAt;
//
//    private String deletedBy;
//
//    // ----- Constructors -----
//    public Request() {}
//
//    public Request(String customerName, String address, String requestType,
//                   String description, String status, LocalDate requestDate,
//                   String customerPhone, String serviceDetails) {
//        this.customerName = customerName;
//        this.address = address;
//        this.requestType = requestType;
//        this.description = description;
//        this.status = status;
//        this.requestDate = requestDate;
//        this.customerPhone = customerPhone;
//        this.serviceDetails = serviceDetails;
//    }
//
//    // ----- Getters & Setters -----
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getCustomerName() { return customerName; }
//    public void setCustomerName(String customerName) { this.customerName = customerName; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//
//    public String getRequestType() { return requestType; }
//    public void setRequestType(String requestType) { this.requestType = requestType; }
//
//    public String getDescription() { return description; }
//    public void setDescription(String description) { this.description = description; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//
//    public LocalDate getRequestDate() { return requestDate; }
//    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
//
//    public String getCustomerPhone() { return customerPhone; }
//    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
//
//    public String getServiceDetails() { return serviceDetails; }
//    public void setServiceDetails(String serviceDetails) { this.serviceDetails = serviceDetails; }
//
//    // ===== Soft Delete Getters & Setters =====
//    public boolean isDeleted() { return deleted; }
//    public void setDeleted(boolean deleted) { this.deleted = deleted; }
//
//    public LocalDate getDeletedAt() { return deletedAt; }
//    public void setDeletedAt(LocalDate deletedAt) { this.deletedAt = deletedAt; }
//
//    public String getDeletedBy() { return deletedBy; }
//    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
//}

package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Hapa tunongeza relationship na Customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")  // Hii ndiyo foreign key kwenye table ya Requests
    private Customer customer;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String requestType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDate requestDate;

    @Column(nullable = false)
    private String customerPhone;

    @Column(columnDefinition = "TEXT")
    private String serviceDetails;

    // ===== Soft delete fields =====
    private boolean deleted = false;

    private LocalDate deletedAt;

    private String deletedBy;

    // ----- Constructors -----
    public Request() {}

    // ... existing constructor (can update if needed)

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }

    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }

    public String getServiceDetails() { return serviceDetails; }
    public void setServiceDetails(String serviceDetails) { this.serviceDetails = serviceDetails; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public LocalDate getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDate deletedAt) { this.deletedAt = deletedAt; }

    public String getDeletedBy() { return deletedBy; }
    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
}
