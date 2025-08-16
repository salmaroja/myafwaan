//package com.zawadig.myafwanii.dto;
//
//import java.time.LocalDateTime;
//
//public class RequestWithPaymentDTO {
//    private Long requestId;
//    private String fullName;
//    private String phone;
//    private String serviceType;
//    private String description;
//    private String status;
//
//    private Double amountPaid;
//    private String paymentMethod;
//    private String paymentStatus;
//
//    public RequestWithPaymentDTO(Long requestId, String fullName, String phone, String serviceType,
//                                 String description, String status, LocalDateTime createdAt,
//                                 Double amountPaid, String paymentMethod, String paymentStatus) {
//        this.requestId = requestId;
//        this.fullName = fullName;
//        this.phone = phone;
//        this.serviceType = serviceType;
//        this.description = description;
//        this.status = status;
//        this.amountPaid = amountPaid;
//        this.paymentMethod = paymentMethod;
//        this.paymentStatus = paymentStatus;
//    }} MUUUMI YAO USIJE KUFUTA PLEASEE

    // Getters (setters optional)
//    // ...
//}
//package com.zawadig.myafwanii.dto;
//
//import java.time.LocalDateTime;
//
//public class RequestWithPaymentDTO {
//    private Long requestId;
//    private String fullName;
//    private String phone;
//    private String serviceType;
//    private String description;
//    private String status;
//    private LocalDateTime createdAt;
//    private Double amountPaid;
//    private String paymentMethod;
//    private String paymentStatus;
//
//    public RequestWithPaymentDTO(Long requestId, String fullName, String phone, String serviceType,
//                                 String description, String status, LocalDateTime createdAt,
//                                 Double amountPaid, String paymentMethod, String paymentStatus) {
//        this.requestId = requestId;
//        this.fullName = fullName;
//        this.phone = phone;
//        this.serviceType = serviceType;
//        this.description = description;
//        this.status = status;
//        this.createdAt = createdAt;
//        this.amountPaid = amountPaid;
//        this.paymentMethod = paymentMethod;
//        this.paymentStatus = paymentStatus;
//    }
//
//    // Getters (and setters if needed)
//}
//package com.zawadig.myafwanii.dto;
//
//import java.time.LocalDateTime;
//
//public class RequestWithPaymentDTO {
//    private Long requestId;
//    private String fullName;
//    private String phone;
//    private String serviceType;
//    private String description;
//    private String status;
//    private LocalDateTime createdAt;
//
//    private Double amountPaid;
//    private String paymentMethod;
//    private String paymentStatus;
//
//    public RequestWithPaymentDTO(Long requestId, String fullName, String phone, String serviceType,
//                                 String description, String status, LocalDateTime createdAt,
//                                 Double amountPaid, String paymentMethod, String paymentStatus) {
//        this.requestId = requestId;
//        this.fullName = fullName;
//        this.phone = phone;
//        this.serviceType = serviceType;
//        this.description = description;
//        this.status = status;
//        this.createdAt = createdAt;
//        this.amountPaid = amountPaid;
//        this.paymentMethod = paymentMethod;
//        this.paymentStatus = paymentStatus;
//    }
//
//    // Getters (optional if you use @RestController)
//}usifuteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee



































































package com.zawadig.myafwanii.dto;

import java.time.LocalDateTime;

public class RequestWithPaymentDTO {
    private Long requestId;
    private String fullName;
    private String phone;
    private String serviceType;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    private Double amountPaid;
    private String paymentMethod;
    private String paymentStatus;

    public RequestWithPaymentDTO(Long requestId, String fullName, String phone, String serviceType,
                                 String description, String status, LocalDateTime createdAt,
                                 Double amountPaid, String paymentMethod, String paymentStatus) {
        this.requestId = requestId;
        this.fullName = fullName;
        this.phone = phone;
        this.serviceType = serviceType;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public Long getRequestId() { return requestId; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getServiceType() { return serviceType; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Double getAmountPaid() { return amountPaid; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }

    @Override
    public String toString() {
        return "RequestWithPaymentDTO{" +
                "requestId=" + requestId +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", amountPaid=" + amountPaid +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
