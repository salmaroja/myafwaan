package com.zawadig.myafwanii.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String location;
    private String imagePath;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserProfile() {}

    public UserProfile(String name, String phone, String location, String imagePath, User user) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.imagePath = imagePath;
        this.user = user;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getImagePath() { return imagePath; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getEmail() {
        return user != null ? user.getEmail() : null;
    }

    public String getFullName() {
        return user != null ? user.getFullName() : name;
    }
}
