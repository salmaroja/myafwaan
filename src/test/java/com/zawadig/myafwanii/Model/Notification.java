////package com.zawadig.myafwanii.Model;
////
////
////
////
////import jakarta.persistence.*;
////import java.time.LocalDateTime;
////
////@Entity
////public class Notification {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String title;
////    private String message;
////
////    @Column(name = "`read`")
////    private boolean read = false;
////
////    private LocalDateTime timestamp;
////
////    @ManyToOne
////    @JoinColumn(name = "customer_id")
////    private Customer customer;
////
////    @PrePersist
////    public void prePersist() {
////        this.timestamp = LocalDateTime.now();
////    }
////
////    // Getters & Setters
////
////    public Long getId() {
////        return id;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getMessage() {
////        return message;
////    }
////
////    public void setMessage(String message) {
////        this.message = message;
////    }
////
////    public boolean isRead() {
////        return read;
////    }
////
////    public void setRead(boolean read) {
////        this.read = read;
////    }
////
////    public LocalDateTime getTimestamp() {
////        return timestamp;
////    }
////
////    public Customer getCustomer() {
////        return customer;
////    }
////
////    public void setCustomer(Customer customer) {
////        this.customer = customer;
////    }
////}
//// Notification.java
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "notification")
//public class Notification {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "customer_id")
//    private Long customerId;
//
//    private String title;
//    private String message;
//
//    @Column(name = "`read`") // ✅ fix keyword issue
//    private boolean read = false;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    // Getters & Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Long customerId) {
//        this.customerId = customerId;
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
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public boolean isRead() {
//        return read;
//    }
//
//    public void setRead(boolean read) {
//        this.read = read;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//}
package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    private String title;
    private String message;

    @Column(name = "`read`") // escape SQL keyword
    private boolean read = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }
    public void setRead(boolean read) {
        this.read = read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
