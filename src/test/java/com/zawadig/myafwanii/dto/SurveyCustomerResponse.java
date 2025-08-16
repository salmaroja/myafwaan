package com.zawadig.myafwanii.dto;//package com.zawadig.myafwanii.dto;
////
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.time.LocalDateTime;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class SurveyCustomerResponse {
//    private Long surveyId;
//    private String location;
//    private String notes;
//    private LocalDateTime surveyDate;
//    private Long technicianId;
//    private Long customerId;
//    private String customerName;
//}


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyCustomerResponse {
    private Long surveyId;
    private String location;
    private String notes;
    private LocalDateTime surveyDate;
    private Long technicianId;
    private Long customerId;
    private String customerName;
}




//
//
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//public class SurveyCustomerResponse {
//    private Long surveyId;
//    private String location;
//    private String notes;
//    private LocalDateTime surveyDate;
//    private Long technicianId;
//    private Long customerId;
//    private String customerName;
//
//    // Hii ndiyo constructor muhimu inayolingana na queries za SurveyRepository
//    public SurveyCustomerResponse(Long surveyId, String location, String notes, LocalDateTime surveyDate, Long technicianId, Long customerId, String customerName) {
//        this.surveyId = surveyId;
//        this.location = location;
//        this.notes = notes;
//        this.surveyDate = surveyDate;
//        this.technicianId = technicianId;
//        this.customerId = customerId;
//        this.customerName = customerName;
//    }
//
//    public String getSurveyStatus() {
//        return customerName;
//    }
//}
//
//
//
