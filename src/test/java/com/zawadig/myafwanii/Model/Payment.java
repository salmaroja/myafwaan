//////package com.zawadig.myafwanii.Model;
//////
//////import jakarta.persistence.*;
//////import java.time.LocalDateTime;
//////
//////@Entity
//////@Table(name = "payment")
//////public class Payment {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    private Double amountPaid;
//////
//////    @Column(name = "created_at")
//////    private LocalDateTime createdAt;
//////
//////    @Column(name = "payment_date", nullable = false)
//////    private LocalDateTime paymentDate;
//////
//////    @Column(name = "payment_method", nullable = false, length = 50)
//////    private String paymentMethod;
//////
//////    @Column(name = "payment_status", nullable = false, length = 255)
//////    private String paymentStatus;
//////
//////    @Column(name = "updated_at")
//////    private LocalDateTime updatedAt;
//////
//////    @Column(name = "bill_id", nullable = false)
//////    private Long billId;
//////
//////    @Column(name = "control_number", unique = true, length = 255)
//////    private String controlNumber;
//////
//////    @Column(name = "customer_id")
//////    private Long customerId;
//////
//////    @Column(name = "meter_number", length = 255)
//////    private String meterNumber;
//////
//////    // Getters and Setters
//////    public Long getId() {
//////        return id;
//////    }
//////
//////    public void setId(Long id) {
//////        this.id = id;
//////    }
//////
//////    public Double getAmountPaid() {
//////        return amountPaid;
//////    }
//////
//////    public void setAmountPaid(Double amountPaid) {
//////        this.amountPaid = amountPaid;
//////    }
//////
//////    public LocalDateTime getCreatedAt() {
//////        return createdAt;
//////    }
//////
//////    public void setCreatedAt(LocalDateTime createdAt) {
//////        this.createdAt = createdAt;
//////    }
//////
//////    public LocalDateTime getPaymentDate() {
//////        return paymentDate;
//////    }
//////
//////    public void setPaymentDate(LocalDateTime paymentDate) {
//////        this.paymentDate = paymentDate;
//////    }
//////
//////    public String getPaymentMethod() {
//////        return paymentMethod;
//////    }
//////
//////    public void setPaymentMethod(String paymentMethod) {
//////        this.paymentMethod = paymentMethod;
//////    }
//////
//////    public String getPaymentStatus() {
//////        return paymentStatus;
//////    }
//////
//////    public void setPaymentStatus(String paymentStatus) {
//////        this.paymentStatus = paymentStatus;
//////    }
//////
//////    public LocalDateTime getUpdatedAt() {
//////        return updatedAt;
//////    }
//////
//////    public void setUpdatedAt(LocalDateTime updatedAt) {
//////        this.updatedAt = updatedAt;
//////    }
//////
//////    public Long getBillId() {
//////        return billId;
//////    }
//////
//////    public void setBillId(Long billId) {
//////        this.billId = billId;
//////    }
//////
//////    public String getControlNumber() {
//////        return controlNumber;
//////    }
//////
//////    public void setControlNumber(String controlNumber) {
//////        this.controlNumber = controlNumber;
//////    }
//////
//////    public Long getCustomerId() {
//////        return customerId;
//////    }
//////
//////    public void setCustomerId(Long customerId) {
//////        this.customerId = customerId;
//////    }
//////
//////    public String getMeterNumber() {
//////        return meterNumber;
//////    }
//////
//////    public void setMeterNumber(String meterNumber) {
//////        this.meterNumber = meterNumber;
//////    }
//////}
////package com.zawadig.myafwanii.Model;
////
////import jakarta.persistence.*;
////import java.time.LocalDateTime;
////
////@Entity
////@Table(name = "payment")
////public class Payment {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private Double amountPaid;
////
////    @Column(name = "created_at")
////    private LocalDateTime createdAt;
////
////    @Column(name = "payment_date", nullable = false)
////    private LocalDateTime paymentDate;
////
////    @Column(name = "payment_method", nullable = false, length = 50)
////    private String paymentMethod;
////
////    @Column(name = "payment_status", nullable = false, length = 255)
////    private String paymentStatus;
////
////    @Column(name = "updated_at")
////    private LocalDateTime updatedAt;
////
////    @Column(name = "bill_id", nullable = false)
////    private Long billId;
////
////    @Column(name = "control_number", unique = true, length = 255)
////    private String controlNumber;
////
////    @Column(name = "customer_id")
////    private Long customerId;
////
////    @Column(name = "meter_number", length = 255)
////    private String meterNumber;
////
////    // Add ManyToOne relation to Customer (optional but recommended)
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
////    private Customer customer;
////
////    // Getters and Setters for all fields (including customer)
////
////    public Long getId() { return id; }
////    public void setId(Long id) { this.id = id; }
////
////    public Double getAmountPaid() { return amountPaid; }
////    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }
////
////    public LocalDateTime getCreatedAt() { return createdAt; }
////    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
////
////    public LocalDateTime getPaymentDate() { return paymentDate; }
////    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
////
////    public String getPaymentMethod() { return paymentMethod; }
////    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
////
////    public String getPaymentStatus() { return paymentStatus; }
////    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
////
////    public LocalDateTime getUpdatedAt() { return updatedAt; }
////    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
////
////    public Long getBillId() { return billId; }
////    public void setBillId(Long billId) { this.billId = billId; }
////
////    public String getControlNumber() { return controlNumber; }
////    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
////
////    public Long getCustomerId() { return customerId; }
////    public void setCustomerId(Long customerId) { this.customerId = customerId; }
////
////    public String getMeterNumber() { return meterNumber; }
////    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
////
////    public Customer getCustomer() { return customer; }
////    public void setCustomer(Customer customer) { this.customer = customer; }
////}
//
////package com.zawadig.myafwanii.Model;
////
////import jakarta.persistence.*;
////import java.time.LocalDateTime;
////
////@Entity
////@Table(name = "payment")
////public class Payment {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private Double amountPaid;
////
////    @Column(name = "created_at")
////    private LocalDateTime createdAt;
////
////    @Column(name = "payment_date", nullable = false)
////    private LocalDateTime paymentDate;
////
////    @Column(name = "payment_method", nullable = false, length = 50)
////    private String paymentMethod;
////
////    @Column(name = "payment_status", nullable = false, length = 255)
////    private String paymentStatus;
////
////    @Column(name = "updated_at")
////    private LocalDateTime updatedAt;
////
////    @Column(name = "bill_id", nullable = false)
////    private Long billId;
////
////    @Column(name = "control_number", unique = true, length = 255)
////    private String controlNumber;
////
////    @Column(name = "customer_id")
////    private Long customerId;
////
////    @Column(name = "meter_number", length = 255)
////    private String meterNumber;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
////    private Customer customer;
////
////    // ===== Soft Delete Fields =====
////    @Column(nullable = false)
////    private boolean deleted = false;
////
////    private LocalDateTime deletedAt;
////
////    private String deletedBy;
////
////    // ===== Getters and Setters =====
////
////    public Long getId() { return id; }
////    public void setId(Long id) { this.id = id; }
////
////    public Double getAmountPaid() { return amountPaid; }
////    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }
////
////    public LocalDateTime getCreatedAt() { return createdAt; }
////    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
////
////    public LocalDateTime getPaymentDate() { return paymentDate; }
////    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
////
////    public String getPaymentMethod() { return paymentMethod; }
////    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
////
////    public String getPaymentStatus() { return paymentStatus; }
////    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
////
////    public LocalDateTime getUpdatedAt() { return updatedAt; }
////    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
////
////    public Long getBillId() { return billId; }
////    public void setBillId(Long billId) { this.billId = billId; }
////
////    public String getControlNumber() { return controlNumber; }
////    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
////
////    public Long getCustomerId() { return customerId; }
////    public void setCustomerId(Long customerId) { this.customerId = customerId; }
////
////    public String getMeterNumber() { return meterNumber; }
////    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
////
////    public Customer getCustomer() { return customer; }
////    public void setCustomer(Customer customer) { this.customer = customer; }
////
////    // ===== Soft Delete Getters & Setters =====
////    public boolean isDeleted() { return deleted; }
////    public void setDeleted(boolean deleted) { this.deleted = deleted; }
////
////    public LocalDateTime getDeletedAt() { return deletedAt; }
////    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
////
////    public String getDeletedBy() { return deletedBy; }
////    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
////}
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "payment")
//public class Payment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Double amountPaid;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "payment_date", nullable = false)
//    private LocalDateTime paymentDate;
//
//    @Column(name = "payment_method", nullable = false, length = 50)
//    private String paymentMethod;
//
//    @Column(name = "payment_status", nullable = false, length = 255)
//    private String paymentStatus;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @Column(name = "bill_id", nullable = false)
//    private Long billId;
//
//    @Column(name = "control_number", unique = true, length = 255)
//    private String controlNumber;
//
//    @Column(name = "customer_id", nullable = false)
//    private Long customerId;
//
//    @Column(name = "meter_number", length = 255)
//    private String meterNumber;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Customer customer;
//
//    // ===== Soft Delete Fields =====
//    @Column(nullable = false)
//    private boolean deleted = false;
//
//    private LocalDateTime deletedAt;
//
//    private String deletedBy;
//
//    // ==== Hooks ====
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.paymentDate = (this.paymentDate == null) ? LocalDateTime.now() : this.paymentDate;
//        this.paymentStatus = (this.paymentStatus == null) ? "PENDING" : this.paymentStatus;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    // ===== Getters and Setters =====
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public Double getAmountPaid() { return amountPaid; }
//    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }
//
//    public LocalDateTime getCreatedAt() { return createdAt; }
//    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
//
//    public LocalDateTime getPaymentDate() { return paymentDate; }
//    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
//
//    public String getPaymentMethod() { return paymentMethod; }
//    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
//
//    public String getPaymentStatus() { return paymentStatus; }
//    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
//
//    public LocalDateTime getUpdatedAt() { return updatedAt; }
//    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
//
//    public Long getBillId() { return billId; }
//    public void setBillId(Long billId) { this.billId = billId; }
//
//    public String getControlNumber() { return controlNumber; }
//    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
//
//    public Long getCustomerId() { return customerId; }
//    public void setCustomerId(Long customerId) { this.customerId = customerId; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//
//    public Customer getCustomer() { return customer; }
//    public void setCustomer(Customer customer) { this.customer = customer; }
//
//    public boolean isDeleted() { return deleted; }
//    public void setDeleted(boolean deleted) { this.deleted = deleted; }
//
//    public LocalDateTime getDeletedAt() { return deletedAt; }
//    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
//
//    public String getDeletedBy() { return deletedBy; }
//    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
//
//    public Customer getRequestForm() {
//        return null;
//    }
//}
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "payment")
//public class Payment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Double amountPaid;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "payment_date", nullable = false)
//    private LocalDateTime paymentDate;
//
//    @Column(name = "payment_method", nullable = false, length = 50)
//    private String paymentMethod;
//
//    @Column(name = "payment_status", nullable = false, length = 255)
//    private String paymentStatus;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @Column(name = "bill_id", nullable = false)
//    private Long billId;
//
//    @Column(name = "control_number", unique = true, length = 255)
//    private String controlNumber;
//
//    @Column(name = "customer_id", nullable = false)
//    private Long customerId;
//
//    @Column(name = "meter_number", length = 255)
//    private String meterNumber;
//
//    @Column(name = "request_id", length = 255)
//    private String requestId;
//
//    @Column(name = "service_type", length = 255)
//    private String serviceType;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Customer customer;
//
//    // ===== Soft Delete Fields =====
//    @Column(nullable = false)
//    private boolean deleted = false;
//
//    private LocalDateTime deletedAt;
//
//    private String deletedBy;
//
//    // ==== Hooks ====
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.paymentDate = (this.paymentDate == null) ? LocalDateTime.now() : this.paymentDate;
//        this.paymentStatus = (this.paymentStatus == null) ? "PENDING" : this.paymentStatus;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    // ===== Getters and Setters =====
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public Double getAmountPaid() { return amountPaid; }
//    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }
//
//    public LocalDateTime getCreatedAt() { return createdAt; }
//    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
//
//    public LocalDateTime getPaymentDate() { return paymentDate; }
//    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
//
//    public String getPaymentMethod() { return paymentMethod; }
//    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
//
//    public String getPaymentStatus() { return paymentStatus; }
//    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
//
//    public LocalDateTime getUpdatedAt() { return updatedAt; }
//    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
//
//    public Long getBillId() { return billId; }
//    public void setBillId(Long billId) { this.billId = billId; }
//
//    public String getControlNumber() { return controlNumber; }
//    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
//
//    public Long getCustomerId() { return customerId; }
//    public void setCustomerId(Long customerId) { this.customerId = customerId; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//
//    public String getRequestId() { return requestId; }
//    public void setRequestId(String requestId) { this.requestId = requestId; }
//
//    public String getServiceType() { return serviceType; }
//    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
//
//    public Customer getCustomer() { return customer; }
//    public void setCustomer(Customer customer) { this.customer = customer; }
//
//    public boolean isDeleted() { return deleted; }
//    public void setDeleted(boolean deleted) { this.deleted = deleted; }
//
//    public LocalDateTime getDeletedAt() { return deletedAt; }
//    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
//
//    public String getDeletedBy() { return deletedBy; }
//    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
//}
package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "payment_status", nullable = false, length = 255)
    private String paymentStatus;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "bill_id", nullable = false)
    private Long billId;

    @Column(name = "control_number", unique = true, length = 255)
    private String controlNumber;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "meter_number", length = 255)
    private String meterNumber;

    @Column(name = "request_id", length = 255)
    private String requestId;

    @Column(name = "service_type", length = 255)
    private String serviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private String deletedBy;

    // ==== Lifecycle Hooks ====
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.paymentDate = (this.paymentDate == null) ? LocalDateTime.now() : this.paymentDate;
        this.paymentStatus = (this.paymentStatus == null) ? "PENDING" : this.paymentStatus;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ==== Getters and Setters ====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Long getBillId() { return billId; }
    public void setBillId(Long billId) { this.billId = billId; }

    public String getControlNumber() { return controlNumber; }
    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getMeterNumber() { return meterNumber; }
    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }

    public String getDeletedBy() { return deletedBy; }
    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
}
