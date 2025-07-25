package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "water_point")
public class WaterPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String location;

    @NotNull
    @DecimalMin("-6.5") @DecimalMax("-5.7")
    private Double latitude;

    @NotNull
    @DecimalMin("39.1") @DecimalMax("39.5")
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @NotNull
    @PastOrPresent
    private Date lastInspection;

    @NotNull
    @Positive
    private Integer capacity; // in liters

    @NotNull
    @Positive
    private Integer populationServed;

    public enum Status {
        FUNCTIONAL, NEEDS_REPAIR, NON_FUNCTIONAL
    }
}