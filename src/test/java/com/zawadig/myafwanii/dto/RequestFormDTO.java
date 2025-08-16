//////package com.zawadig.myafwanii.dto;
//////
//////public class RequestFormDTO {
//////    private String fullName;
//////    private String nationalId;
//////    private String address;
//////    private String phone;
//////    private String serviceType;
//////    private String meterType;
//////    private Long customerId;
//////
//////    // Getters and Setters
//////}
////package com.zawadig.myafwanii.dto;
////
////import lombok.Data;
////import java.time.LocalDateTime;
////
////@Data
////public class RequestFormDTO {
////    private Long id;
////    private String fullName;
////    private String nationalId;
////    private String address;
////    private String phone;
////    private String serviceType;
////    private String meterType;
////    private String picturePath;
////    private LocalDateTime createdAt;
////    private Long customerId;
////    private String customerName;
////}
//package com.zawadig.myafwanii.dto;
//
//import com.zawadig.myafwanii.enums.RequestStatus;
//import lombok.Data;
//import java.time.LocalDateTime;
//
//@Data
//public class RequestFormDTO {
//    private Long id;
//    private String fullName;
//    private String nationalId;
//    private String address;
//    private String phone;
//    private String serviceType;
//    private String meterType;
//    private String picturePath;
//    private LocalDateTime createdAt;
//    private Long customerId;
//    private String customerName;
//
//    public void setStatus(String s) {
//    }
//    private RequestStatus status;
//
//    public void setControlNumber(String controlNumber) {
//    }
//}
package com.zawadig.myafwanii.dto;

import com.zawadig.myafwanii.enums.RequestStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RequestFormDTO {
    private Long id;
    private String fullName;
    private String nationalId;
    private String address;
    private String phone;
    private String serviceType;
    private String meterType;
    private String picturePath;
    private LocalDateTime createdAt;
    private Long customerId;
    private String customerName;
    private RequestStatus status;   // sasa setter/getter sahihi inaundwa na Lombok
    private String controlNumber;   // control number setter/getter pia inaundwa na Lombok
}
