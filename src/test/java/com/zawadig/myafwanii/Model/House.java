////package com.zawadig.myafwanii.Model;
////
////
////
////
////
//////import jakarta.persistence.*;
//////import lombok.*;
//////
//////import java.time.LocalDateTime;
//////import java.util.ArrayList;
//////import java.util.List;
//////
//////@Entity
//////@Data
//////@NoArgsConstructor
//////@AllArgsConstructor
//////@Table(name = "house")
//////public class House {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    @Column(name = "house_number", unique = true, nullable = false)
//////    private String houseNumber; // Format: NAPA-00123 (Tanzania National Property Addressing)
//////
//////    private String streetName;
//////    private String ward;
//////    private String district;
//////    private String region;
//////
//////    // Geo-coordinates for mapping
//////    private Double latitude;
//////    private Double longitude;
//////
//////    @Column(columnDefinition = "BOOLEAN DEFAULT false")
//////    private boolean connected = false; // Inaonyesha kama nyumba imeunganishwa na huduma
//////
//////    // ===== Timestamps =====
//////    @Column(name = "created_at", updatable = false)
//////    private LocalDateTime createdAt = LocalDateTime.now();
//////
//////    @Column(name = "updated_at")
//////    private LocalDateTime updatedAt = LocalDateTime.now();
//////
//////    // ===== Soft delete support =====
//////    private boolean deleted = false;
//////    private LocalDateTime deletedAt;
//////    private String deletedBy;
//////
//////    // ===== Relationship with Customer (One house can have many customers over time) =====
//////    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//////    private List<Customer> customers = new ArrayList<>();
//////
//////    // ===== Relationship with Survey =====
//////    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//////    private List<Survey> surveys = new ArrayList<>();
//////
//////    // Pre-update hook to set update timestamp
//////    @PreUpdate
//////    public void setUpdatedAt() {
//////        this.updatedAt = LocalDateTime.now();
//////    }
//////} mumuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
////
////
////
////
////
////
////
////
////
////import jakarta.persistence.*;
////import lombok.*;
////import java.time.LocalDateTime;
////import java.util.ArrayList;
////import java.util.List;
////
////@Entity
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////@Builder
////@Table(name = "house")
////public class House {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(name = "house_number", unique = true, nullable = false)
////    private String houseNumber; // e.g., NAPA-00123
////
////    private String streetName;
////    private String ward;
////    private String district;
////    private String region;
////
////    // Geo-coordinates
////    private Double latitude;
////    private Double longitude;
////
////    @Column(columnDefinition = "BOOLEAN DEFAULT false")
////    private boolean connected = false;
////
////    // ===== Timestamps =====
////    @Column(name = "created_at", updatable = false)
////    private LocalDateTime createdAt = LocalDateTime.now();
////
////    @Column(name = "updated_at")
////    private LocalDateTime updatedAt = LocalDateTime.now();
////
////    // ===== Soft delete fields =====
////    private boolean deleted = false;
////    private LocalDateTime deletedAt;
////    private String deletedBy;
////
////    // ===== Relationship with Customer =====
////    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    private List<Customer> customers = new ArrayList<>();
////
////    // ===== Relationship with Survey =====
////    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    private List<Survey> surveys = new ArrayList<>();
////
////    // Auto-update timestamp before update
////    @PreUpdate
////    public void setUpdatedAt() {
////        this.updatedAt = LocalDateTime.now();
////    }
////
////    public String getLocation() {
////    }
////}
//
//
//
//
//
//package com.zawadig.myafwanii.Model;
//
//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "house")
//public class House {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Builder.Default
//    private String houseNumber = "UNKNOWN";
//
//    @Column(name = "house_number", unique = true, nullable = false)
////    private String houseNumber; // e.g., NAPA-00123
//
//    private String streetName;
//    private String ward;
//    private String district;
//    private String region;
//
//    private Double latitude;
//    private Double longitude;
//
//    @Column(columnDefinition = "BOOLEAN DEFAULT false")
//    private boolean connected = false;
//
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    private boolean deleted = false;
//    private LocalDateTime deletedAt;
//    private String deletedBy;
//
//    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Customer> customers = new ArrayList<>();
//
//    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Survey> surveys = new ArrayList<>();
//
//    // Set timestamps before insert
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    // Auto-update timestamp before update
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    // Helper method to get location summary
//    public String getLocation() {
//        return String.format("%s, %s, %s", ward != null ? ward : "", district != null ? district : "", region != null ? region : "");
//    }
//}
package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIXED: Removed explicit @Column annotation
    @Builder.Default
    private String houseNumber = "UNKNOWN"; // e.g., NAPA-00123

    private String streetName;
    private String ward;
    private String district;
    private String region;

    private Double latitude;
    private Double longitude;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean connected = false;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private boolean deleted = false;
    private LocalDateTime deletedAt;
    private String deletedBy;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();

    // FIXED: Corrected typo (movedBy -> mappedBy)
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Survey> surveys = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getLocation() {
        return String.format("%s, %s, %s",
                ward != null ? ward : "",
                district != null ? district : "",
                region != null ? region : "");
    }
}