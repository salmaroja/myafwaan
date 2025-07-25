//package com.zawadig.myafwanii.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class Complaint {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//
//    @Column(length = 2000)
//    private String description;
//
//    @Column(name = "submitted_at")
//    private LocalDateTime submittedAt;
//
//    private String status; // e.g., "Pending", "In Progress", "Resolved"
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Prevent infinite recursion
//    private Customer customer;
//
//    public Complaint() {
//        this.submittedAt = LocalDateTime.now();
//        this.status = "Pending";
//    }
//
//    // Full constructor
//    public Complaint(String title, String description, Customer customer) {
//        this.title = title;
//        this.description = description;
//        this.customer = customer;
//        this.submittedAt = LocalDateTime.now();
//        this.status = "Pending";
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDateTime getSubmittedAt() {
//        return submittedAt;
//    }
//
//    public void setSubmittedAt(LocalDateTime submittedAt) {
//        this.submittedAt = submittedAt;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//}

package com.zawadig.myafwanii.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    private String status; // e.g., "Pending", "In Progress", "Resolved"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    // ===== Soft delete fields =====
    private boolean deleted = false;

    private LocalDateTime deletedAt;

    private String deletedBy;

    public Complaint() {
        this.submittedAt = LocalDateTime.now();
        this.status = "Pending";
    }

    public Complaint(String title, String description, Customer customer) {
        this.title = title;
        this.description = description;
        this.customer = customer;
        this.submittedAt = LocalDateTime.now();
        this.status = "Pending";
    }

    // ===== Getters and setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // ===== Soft delete getters/setters =====

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }
}
