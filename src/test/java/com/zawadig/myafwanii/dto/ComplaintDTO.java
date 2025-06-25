package com.zawadig.myafwanii.dto;



import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ComplaintDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime submittedAt;
    private String customerName;
}

