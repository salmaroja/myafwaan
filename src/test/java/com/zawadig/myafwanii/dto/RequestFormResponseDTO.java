package com.zawadig.myafwanii.dto;

import com.zawadig.myafwanii.enums.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestFormResponseDTO {
    private String message;
    private Long requestFormId;
    private String pictureUrl;
    private String instructions;



    }


