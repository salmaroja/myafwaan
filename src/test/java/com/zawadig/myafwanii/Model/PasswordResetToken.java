package com.zawadig.myafwanii.Model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Constructors
    public PasswordResetToken() {}

    public PasswordResetToken(String token, Customer customer, LocalDateTime expiryDate) {
        this.token = token;
        this.customer = customer;
        this.expiryDate = expiryDate;
    }

    // Getters and setters
    // ...

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryDate);
    }

    public Customer getCustomer() {
        return customer;
    }
}
