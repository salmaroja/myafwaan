////package com.zawadig.myafwanii.dto;
////
////
////
////public class CustomerDTO {
////    private String name;
////    private String email;
////    private String phone;
////    private String address;
////    private String meterNumber;
////    private Long userId;  // Hii ni muhimu! Inamwonyesha backend ni user gani ku-link.
////
////    // Getters and Setters
////
////    public String getName() { return name; }
////    public void setName(String name) { this.name = name; }
////
////    public String getEmail() { return email; }
////    public void setEmail(String email) { this.email = email; }
////
////    public String getPhone() { return phone; }
////    public void setPhone(String phone) { this.phone = phone; }
////
////    public String getAddress() { return address; }
////    public void setAddress(String address) { this.address = address; }
////
////    public String getMeterNumber() { return meterNumber; }
////    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
////
////    public Long getUserId() { return userId; }
////    public void setUserId(Long userId) { this.userId = userId; }
////}
//package com.zawadig.myafwanii.dto;
//
//public class CustomerDTO {
//    private String name;
//    private String email;
//    private String phone;
//    private String address;
//    private String meterNumber;
//    private Long userId;  // Link to User
//    private String password;  // Add this field
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
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//}
package com.zawadig.myafwanii.dto;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.House;

public class CustomerDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String meterNumber;
    private Long userId;
    private String password;

    // House details
    private Long houseId;
    private String houseNumber;
    private String location;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.address = customer.getAddress();
        this.meterNumber = customer.getMeterNumber();

        if (customer.getUser() != null) {
            this.userId = customer.getUser().getId();
            this.password = customer.getUser().getPassword(); // optional
        }

        House house = customer.getHouse();
        if (house != null) {
            this.houseId = house.getId();
            this.houseNumber = house.getHouseNumber();
            this.location = house.getLocation();
        }
    }

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

    public Long getHouseId() { return houseId; }
    public void setHouseId(Long houseId) { this.houseId = houseId; }

    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
