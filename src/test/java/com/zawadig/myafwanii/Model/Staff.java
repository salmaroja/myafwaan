package com.zawadig.myafwanii.Model;


import jakarta.persistence.Entity;

@Entity
public class Staff extends Technician {

    private String position;

    public Staff() {
        super(); // important: call the default constructor of Technician
    }

    public Staff(String name, String email, String specialization, String phone,
                 String username, String password, boolean enabled, String position) {
        super(); // call parent constructor, then set fields below
        this.setName(name);
        this.setEmail(email);
        this.setSpecialization(specialization);
        this.setPhone(phone);
        this.setUsername(username);
        this.setPassword(password);
        this.setEnabled(enabled);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Optional: if 'role' = 'position' in your system
    public String getRole() {
        return position;
    }
}
