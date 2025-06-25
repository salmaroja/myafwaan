package com.zawadig.myafwanii.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")  // Optional, unaweza kuondoa kama jina la meza ni default (role)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructor bila parameters (required for JPA)
    public Role() {}

    // Constructor ya parameters (optional)
    public Role(String name) {
        this.name = name;
    }

    // Getters na Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
