package com.zawadig.myafwanii.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PaymentDTO {
    private Long id;
    private String controlNumber;
    private Double amountPaid;
    private Date paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    private String customerName;
    private String customerEmail;
}
