package com.zawadig.myafwanii.dto;
import com.zawadig.myafwanii.dto.CustomerRegisterRequest;


public class CustomerRegisterRequest {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;

    // Constructors
    public CustomerRegisterRequest() {}

    public CustomerRegisterRequest(String name, String phone, String address, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
