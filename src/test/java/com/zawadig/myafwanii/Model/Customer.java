////package com.zawadig.myafwanii.Model;
////
////import jakarta.persistence.*;
////
////@Entity
////@Table(name = "customer")
////public class Customer {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String name;
////    private String email;
////    private String password;
////    private String phone;
////    private String address;
////    private String status = "active";
////
////    @Column(name = "meter_number")
////    private String meterNumber;
////
////    @OneToOne
////    @JoinColumn(name = "user_id")
////    private User user;
////
////    // e.g., active, inactive, pending, suspended
////
////    public Customer() {}
////
////    // Getters & Setters for all fields including status
////
////    public Long getId() { return id; }
////    public void setId(Long id) { this.id = id; }
////
////    public String getName() { return name; }
////    public void setName(String name) { this.name = name; }
////
////    public String getEmail() { return email; }
////    public void setEmail(String email) { this.email = email; }
////
////    public String getPassword() { return password; }
////    public void setPassword(String password) { this.password = password; }
////
////    public String getPhone() { return phone; }
////    public void setPhone(String phone) { this.phone = phone; }
////
////    public String getAddress() { return address; }
////    public void setAddress(String address) { this.address = address; }
////
////    public String getMeterNumber() { return meterNumber; }
////    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
////
////    public User getUser() { return user; }
////    public void setUser(User user) { this.user = user; }
////
////    public String getStatus() { return status; }
////    public void setStatus(String status) { this.status = status; }
////}
//package com.zawadig.myafwanii.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // 👈 Hii ndiyo inayozuia Jackson exception
//@Entity
//@Table(name = "customer")
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String email;
//    private String password;
//    private String phone;
//    private String address;
//    private String status = "active";
//
//    @Column(name = "meter_number")
//    private String meterNumber;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public Customer() {}
//
//    // Getters & Setters
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//}

//package com.zawadig.myafwanii.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Entity
//@Table(name = "customer")
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String email;
//    private String password;
//    private String phone;
//    private String address;
//    private String status = "active";
//
//    @Column(name = "meter_number")
//    private String meterNumber;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    // ======= Soft delete fields =======
//    private boolean deleted = false;
//
//    private LocalDateTime deletedAt;
//
//    private String deletedBy;
//
//    // ======= Constructors =======
//    public Customer() {}
//
//    // ======= Getters & Setters =======
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//
//    // ======= Soft delete getters/setters =======
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }
//
//    public LocalDateTime getDeletedAt() {
//        return deletedAt;
//    }
//
//    public void setDeletedAt(LocalDateTime deletedAt) {
//        this.deletedAt = deletedAt;
//    }
//
//    public String getDeletedBy() {
//        return deletedBy;
//    }
//
//    public void setDeletedBy(String deletedBy) {
//        this.deletedBy = deletedBy;
//    }
//}
//package com.zawadig.myafwanii.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Entity
//@Table(name = "customer")
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String email;
//    private String password;
//    private String phone;
//    private String address;
//    private String status = "active";
//
//    @Column(name = "meter_number")
//    private String meterNumber;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    // ======= Soft delete fields =======
//    private boolean deleted = false;
//
//    private LocalDateTime deletedAt;
//
//    private String deletedBy;
//
//    // ======= Newly added registrationDate field =======
//    private LocalDateTime registrationDate;
//
//    // ======= Constructors =======
//    public Customer() {}
//
//    // ======= Getters & Setters =======
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//
//    // Soft delete getters/setters
//    public boolean isDeleted() { return deleted; }
//    public void setDeleted(boolean deleted) { this.deleted = deleted; }
//
//    public LocalDateTime getDeletedAt() { return deletedAt; }
//    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }
//
//    public String getDeletedBy() { return deletedBy; }
//    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }
//
//    // Getter and Setter for registrationDate
//    public LocalDateTime getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDateTime registrationDate) {
//        this.registrationDate = registrationDate;
//    }
//}

package com.zawadig.myafwanii.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String status = "active";

    @Column(name = "meter_number")
    private String meterNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ======= Soft delete fields =======
    private boolean deleted = false;

    private LocalDateTime deletedAt;

    private String deletedBy;

    // ======= Newly added registrationDate field =======
    private LocalDateTime registrationDate;

    // ======= Constructors =======
    public Customer() {}

    // ======= Getters & Setters =======

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMeterNumber() { return meterNumber; }
    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Soft delete getters/setters
    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public LocalDateTime getDeletedAt() { return deletedAt; }
    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }

    public String getDeletedBy() { return deletedBy; }
    public void setDeletedBy(String deletedBy) { this.deletedBy = deletedBy; }

    // Getter and Setter for registrationDate
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
