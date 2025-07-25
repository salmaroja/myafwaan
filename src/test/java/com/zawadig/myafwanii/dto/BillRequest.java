package com.zawadig.myafwanii.dto;

import java.time.LocalDate;

public class BillRequest {

    private Long customerId;
    private Double amount;
    private LocalDate billingDate;
    private LocalDate dueDate;
    private Boolean paid;
    private String status;

    // Getters & Setters

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getBillingDate() { return billingDate; }
    public void setBillingDate(LocalDate billingDate) { this.billingDate = billingDate; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Boolean getPaid() { return paid; }
    public void setPaid(Boolean paid) { this.paid = paid; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
