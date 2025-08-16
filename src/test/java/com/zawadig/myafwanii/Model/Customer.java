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
//    // ======= Uhusiano na House =======
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "house_id", referencedColumnName = "id")
//    private House house;
//
//    // ======= Soft delete fields =======
//    private boolean deleted = false;
//    private LocalDateTime deletedAt;
//    private String deletedBy;
//
//    // ======= Tarehe ya usajili =======
//    private LocalDateTime registrationDate;
//
//    // ======= Constructors =======
//    public Customer() {}
//
//    // ======= Getters & Setters =======
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
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
//    public String getMeterNumber() {
//        return meterNumber;
//    }
//
//    public void setMeterNumber(String meterNumber) {
//        this.meterNumber = meterNumber;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public House getHouse() {
//        return house;
//    }
//
//    public void setHouse(House house) {
//        this.house = house;
//    }
//
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
//
//    public LocalDateTime getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDateTime registrationDate) {
//        this.registrationDate = registrationDate;
//    }
//}muuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu




//package com.zawadig.myafwanii.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Entity
//@Table(name = "customer")
//public class Customer {
//
//    // ===== ID =====
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // ===== Basic Info =====
//    private String name;
//    private String email;
//    private String password;
//    private String phone;
//    private String address;
//    private String status = "active";
//
//    // ===== Meter =====
//    @Column(name = "meter_number")
//    private String meterNumber;
//
//    // ===== Relation: User =====
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    // ===== Relation: House (House Number) =====
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "house_id", referencedColumnName = "id")
//    private House house;
//
//    // ===== Soft Delete =====
//    private boolean deleted = false;
//    private LocalDateTime deletedAt;
//    private String deletedBy;
//
//    // ===== Registration Info =====
//    private LocalDateTime registrationDate;
//
//    // ===== Constructors =====
//    public Customer() {}
//
//    // ===== Getters & Setters =====
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
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
//    public String getMeterNumber() {
//        return meterNumber;
//    }
//
//    public void setMeterNumber(String meterNumber) {
//        this.meterNumber = meterNumber;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public House getHouse() {
//        return house;
//    }
//
//    public void setHouse(House house) {
//        this.house = house;
//    }
//
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
//
//    public LocalDateTime getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDateTime registrationDate) {
//        this.registrationDate = registrationDate;
//    }
//
//    public void setFullName(String john_doe) {
//    }
//
//    public long getFullName() {
//        return getFullName();
//    }
//}






package com.zawadig.myafwanii.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "customer")
public class Customer {

    // ===== ID =====
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== Basic Info =====
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String status = "active";

    // ===== Meter =====
    @Column(name = "meter_number")
    private String meterNumber;

    // ===== Relation: User =====
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<RequestForm> requestForms = new ArrayList<>();


    // ===== Relation: House (House Number) =====
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;

    // ===== Soft Delete =====
    private boolean deleted = false;
    private LocalDateTime deletedAt;
    private String deletedBy;

    // ===== Registration Info =====
    private LocalDateTime registrationDate;
    // ===== Verification & Survey =====
    private boolean isVerified = false;
    private boolean isSurveyed = false;

    // ===== Location Info =====
    private String district;
    private String ward;


    // ===== Constructors =====
    public Customer() {}

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    // ===== Full Name Methods =====
    public String getFullName() {
        return this.name; // Au return firstName + " " + lastName ikiwa unatumia fields hizo
    }

    public void setFullName(String fullName) {
        this.name = fullName;
    }
    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isSurveyed() {
        return isSurveyed;
    }

    public void setSurveyed(boolean surveyed) {
        isSurveyed = surveyed;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

}