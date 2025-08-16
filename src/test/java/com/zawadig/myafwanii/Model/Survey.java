package com.zawadig.myafwanii.Model;



//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDate;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Survey {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String location;
//    private String notes;
//    private LocalDate surveyDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "technician_id")
//    private Staff technician;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_form_id")
//    private RequestForm requestForm;
//}




//import jakarta.persistence.*;
//import lombok.*;
//import java.time.LocalDate;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Survey {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String location;
//    private String notes;
//    private LocalDate surveyDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "technician_id")
//    private Staff technician;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_form_id")
//    private RequestForm requestForm;
//
//    // ✅ Hii ndiyo ilikuwa inakosekana
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "house_id")
//    private House house;
//}muuuuuuuuuuuuuuuuuuuuimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu

//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//
//@Data
//public class Survey {
//    private Long customerId;
//    private String condition;
//    private String comments;
//    @ManyToOne
//    private RequestForm requestForm;
//
//    public static Object builder() {
//        return builder();
//    }
//}


//import jakarta.persistence.*;
//import lombok.Data;
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@Table(name = "survey")
//public class Survey {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "request_form_id")
//    private RequestForm requestForm;
//    @ManyToOne
//    @JoinColumn(name = "house_id")
//    private House house;
//    @Column(name = "survey_date") // Make sure this matches your database column
//    private LocalDateTime surveyDate;
//
//
//    @ManyToOne
//    @JoinColumn(name = "technician_id")
//    private Staff technician;
//
//    private String location;
//
//    @Column(length = 1000)
//    private String notes;
//
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    public LocalDateTime getSurveyDate() {
//        return createdAt;
//    }
//}





//import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@Table(name = "survey")
//public class Survey {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "request_form_id") // angalia uniqueness kama inahitajika
//    private RequestForm requestForm;
//
//    @ManyToOne
//    @JoinColumn(name = "house_id")
//    private House house;
//
//    @Column(name = "survey_date")
//    private LocalDateTime surveyDate;
//
//    @ManyToOne
//    @JoinColumn(name = "technician_id")
//    private Staff technician;
//
//    private String location;
//
//    @Column(length = 1000)
//    private String notes;
//
//    @CreationTimestamp
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt;
//
//    // Tafuta method za getter/setter unazotaka ziwepo, lakini Lombok @Data itazizalisha automatically
//}

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_form_id", nullable = false)
    private RequestForm requestForm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private House house;

    @Column(name = "survey_date")
    private LocalDateTime surveyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id", nullable = false)
    private Staff technician;

    private String location;

    @Column(length = 1000)
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // ✅ Hii ni field mpya kwa verification
    @Column(name = "survey_status")
    private String surveyStatus;

    // ✅ Tarehe ya huduma kwa mteja
    @Column(name = "service_date")
    private LocalDate serviceDate;

    private String status;


    public Object getTechnicianId() {
        return technician;
    }
}
