package com.zawadig.myafwanii.Model;////// RequestForm.java (Model)
////package com.zawadig.myafwanii.Model;
////
////import jakarta.persistence.*;
////import lombok.*;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.time.LocalDateTime;
////
////@Entity
////@Table(name = "request_form")
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////@Builder
////public class RequestForm {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String fullName;
////    private String nationalId;
////    private String address;
////    private String phone;
////
////    private String paymentMethod; // e.g. "Bank", "MobileMoney"
////    private double amountPaid;
////
////    private String picturePath; // path ya picha iliyopakiwa
////
////    private LocalDateTime createdAt;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "customer_id")
////    private Customer customer;
////
////    @PrePersist
////    public void onCreate() {
////        this.createdAt = LocalDateTime.now();
////    }
////}
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDateTime;
//
////@Entity
////@Table(name = "request_form")
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////@Builder
////public class RequestForm {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String fullName;
////    private String nationalId;
////    private String address;
////    private String phone;
////
////    private String requestType; // mfano: "Meter Installation", "Water Connection", n.k.
////
////    private String description; // maelezo ya ziada ya huduma inayotakiwa
////
////    private LocalDateTime createdAt;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "customer_id")
////    private Customer customer;
////
////    @PrePersist
////    public void onCreate() {
////        this.createdAt = LocalDateTime.now();
////    }
////}
//// RequestForm.java
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "request_form")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class RequestForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private String fullName;
////    private String nationalId;
////    private String address;
////    private String phone;
////
////    private String paymentMethod; // e.g., Bank, MobileMoney
////    private double amountPaid;
////    private String picturePath;
////
////    private String serviceType; // mfano: "Kuomba mita mpya", "Uunganishwaji mpya"
////    private String meterType;   // mfano: "Smart", "Manual"
////
////    private LocalDateTime createdAt;
////    private LocalDateTime updatedAt;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "customer_id")
////    private Customer customer;
////
////    @PrePersist
////    protected void onCreate() {
////        this.createdAt = LocalDateTime.now();
////        this.updatedAt = LocalDateTime.now();
////    }
////
////    @PreUpdate
////    protected void onUpdate() {
////        this.updatedAt = LocalDateTime.now();
////    }
////}
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table(name = "request_form")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class RequestForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String fullName;
//    private String nationalId;
//    private String address;
//    private String phone;
//    private String serviceType;
//    private String meterType;
//
//    private String picturePath;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @Column(updatable = false)
//    private java.time.LocalDateTime createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = java.time.LocalDateTime.now();
//    }
//}
//package com.zawadig.myafwanii.Model;

//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table(name = "request_form")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class RequestForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String fullName;
//    private String nationalId;
//    private String address;
//    private String phone;
//    private String serviceType;
//    private String meterType;
//
//    private String picturePath;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @OneToMany(mappedBy = "requestForm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ServicePayment> payments;
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
//}
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Digits;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "request_form")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//public class RequestForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String fullName;
//    private String nationalId;
//    private String address;
//    private String phone;
//    private String serviceType;
//    private String meterType;
//
//    private String picturePath;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @OneToMany(mappedBy = "requestForm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Digits.List payments;
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
//}







//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "request_form")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class RequestForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String fullName;
//
//    @Column(nullable = false)
//    private String nationalId;
//
//    @Column(nullable = false)
//    private String address;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String meterType;
//
//    @Column(nullable = false)
//    private String picturePath;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @OneToMany(
//            mappedBy = "requestForm",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @Builder.Default
//    private List<ServicePayment> payments = new ArrayList<>();
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
//} nzuriii iyoiooooo ya 2 usisaaaau














//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "request_form")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class RequestForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String fullName;
//
//    @Column(nullable = false)
//    private String nationalId;
//
//    @Column(nullable = false)
//    private String address;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String meterType;
//
//    @Column(nullable = false)
//    private String picturePath;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @OneToMany(
//            mappedBy = "requestForm",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @Builder.Default
//    private List<ServicePayment> payments = new ArrayList<>();
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//    }
//}







import com.zawadig.myafwanii.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "request_form")
@Getter
@Setter
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String nationalId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private String meterType;

    @Column(nullable = false)
    private String picturePath;

    @ManyToOne(fetch = FetchType.EAGER) // Badili kuwa EAGER
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @OneToMany(mappedBy = "requestForm", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ServicePayment> payments = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;
    @Column(unique = true)
    private String controlNumber;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
