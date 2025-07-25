//package com.zawadig.myafwanii.dto;
//
//import java.util.Date;
//
//public class PaymentDTO {
//    private Long id;
//    private String controlNumber;
//    private Double amountPaid;
//    private Date paymentDate;
//    private String paymentMethod;
//    private String paymentStatus;
//    private String customerName;
//    private String customerEmail;
//    private String meterNumber; // added for your use case
//
//    // 👇 Add these missing methods:
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    // Add other getters and setters below...
//
//    public String getControlNumber() { return controlNumber; }
//    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
//
//    public Double getAmountPaid() { return amountPaid; }
//    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }
//
//    public Date getPaymentDate() { return paymentDate; }
//    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
//
//    public String getPaymentMethod() { return paymentMethod; }
//    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
//
//    public String getPaymentStatus() { return paymentStatus; }
//    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
//
//    public String getCustomerName() { return customerName; }
//    public void setCustomerName(String customerName) { this.customerName = customerName; }
//
//    public String getCustomerEmail() { return customerEmail; }
//    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
//
//    public String getMeterNumber() { return meterNumber; }
//    public void setMeterNumber(String meterNumber) { this.meterNumber = meterNumber; }
//}
package com.zawadig.myafwanii.dto;

import java.time.LocalDateTime;

public class PaymentDTO {
    private Long id;
    private String controlNumber;
    private Double amountPaid;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    private String customerName;
    private String customerEmail;
    private String meterNumber;

    // Getters and setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getControlNumber() {
        return controlNumber;
    }
    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getMeterNumber() {
        return meterNumber;
    }
    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }
}
