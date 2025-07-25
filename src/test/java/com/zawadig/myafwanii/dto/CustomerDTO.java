//package com.zawadig.myafwanii.dto;
//
//
//
//public class CustomerDTO {
//    private String name;
//    private String email;
//    private String phone;
//    private String address;
//    private String meterNumber;
//    private Long userId;  // Hii ni muhimu! Inamwonyesha backend ni user gani ku-link.
//
//    // Getters and Setters
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//
//    public Long getUserId() { return userId; }
//    public void setUserId(Long userId) { this.userId = userId; }
//}
package com.zawadig.myafwanii.dto;

public class CustomerDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String meterNumber;
    private Long userId;  // Link to User
    private String password;  // Add this field

    // Getters and Setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMeterNumber() { return meterNumber; }
    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
