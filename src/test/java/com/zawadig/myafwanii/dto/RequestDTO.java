package com.zawadig.myafwanii.dto;



import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RequestDTO {
    private Long id;
    private String requestType;
    private String address;
    private String status;
    private LocalDateTime requestDate;
    private String customerName;
}

