// RequestForm.java (Model)
package com.zawadig.myafwanii.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Entity
@Table(name = "request_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String nationalId;
    private String address;
    private String phone;

    private String paymentMethod; // e.g. "Bank", "MobileMoney"
    private double amountPaid;

    private String picturePath; // path ya picha iliyopakiwa

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
