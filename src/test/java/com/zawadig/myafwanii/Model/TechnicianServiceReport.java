package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TechnicianServiceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RequestForm requestForm;

    @ManyToOne
    private Staff technician;

    private String status; // e.g. COMPLETED, NOT_DONE, PARTIALLY_DONE

    @Column(length = 1000)
    private String report;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}
