package com.zawadig.myafwanii.dto;

public class UserProfileDTO {
    private String fullName;
    private String email;

    public UserProfileDTO(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}

