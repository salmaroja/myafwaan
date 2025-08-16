//package com.zawadig.myafwanii.dto;
//
//import java.math.BigDecimal;
//
//public class PaymentHistoryDTO {
//    private Long id;
//    private String controlNumber;
//    private BigDecimal amountPaid;
//    private String paymentStatus;
//    private String paymentDate;
//    private String serviceType;
//    private String paymentMethod;
//    private String phone;
//    private String verifiedDate;
//
//    // Getters
//    public Long getId() { return id; }
//    public String getControlNumber() { return controlNumber; }
//    public BigDecimal getAmountPaid() { return amountPaid; }
//    public String getPaymentStatus() { return paymentStatus; }
//    public String getPaymentDate() { return paymentDate; }
//    public String getServiceType() { return serviceType; }
//    public String getPaymentMethod() { return paymentMethod; }
//    public String getPhone() { return phone; }
//    public String getVerifiedDate() { return verifiedDate; }
//
//    // Setters
//    public void setId(Long id) { this.id = id; }
//    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
//    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; }
//    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
//    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
//    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
//    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
//    public void setPhone(String phone) { this.phone = phone; }
//    public void setVerifiedDate(String verifiedDate) { this.verifiedDate = verifiedDate; }
//
//    public void setPdfReference(String pdfReference) {
//    }
//
//    public void setPdfUrl(String s) {
//    }
//}















package com.zawadig.myafwanii.dto;

import java.math.BigDecimal;

public class PaymentHistoryDTO {
    private Long id;
    private String controlNumber;
    private BigDecimal amountPaid;
    private String paymentStatus;
    private String paymentDate;
    private String serviceType;
    private String paymentMethod;
    private String phone;
    private String verifiedDate;
    private String pdfUrl; // ➡ tunaongeza field hii

    // Getters
    public Long getId() { return id; }
    public String getControlNumber() { return controlNumber; }
    public BigDecimal getAmountPaid() { return amountPaid; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getPaymentDate() { return paymentDate; }
    public String getServiceType() { return serviceType; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPhone() { return phone; }
    public String getVerifiedDate() { return verifiedDate; }
    public String getPdfUrl() { return pdfUrl; } // ➡ getter ya pdfUrl

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setControlNumber(String controlNumber) { this.controlNumber = controlNumber; }
    public void setAmountPaid(BigDecimal amountPaid) { this.amountPaid = amountPaid; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setVerifiedDate(String verifiedDate) { this.verifiedDate = verifiedDate; }
    public void setPdfUrl(String pdfUrl) { this.pdfUrl = pdfUrl; } // ➡ setter ya pdfUrl

    public void setPdfReference(String pdfReference) {
    }
}
