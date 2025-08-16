package com.zawadig.myafwanii.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ServicePaymentDTO {
    private Long id;
    private String controlNumber;
    private Double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;
    private Long requestFormId;
    private String customerName;
    private String serviceType;
}