////////////////////package com.zawadig.myafwanii.Model;
////////////////////
////////////////////import jakarta.persistence.*;
////////////////////import java.time.LocalDateTime;
////////////////////
////////////////////@Entity
////////////////////@Table(name = "service_payments")
////////////////////public class ServicePayment {
////////////////////
////////////////////    @Id
////////////////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////////////////////    private Long id;
////////////////////
////////////////////    private Long customerId;
////////////////////
////////////////////    private String serviceType; // Mfano: "Meter Installation", "New Connection" n.k.
////////////////////
////////////////////    private Double amount;
////////////////////
////////////////////    private String paymentStatus; // UNPAID, PAID
////////////////////
////////////////////    @Column(unique = true)
////////////////////    private String controlNumber;
////////////////////
////////////////////    private LocalDateTime paymentDate;
////////////////////
////////////////////    private boolean deleted = false;
////////////////////
////////////////////    private LocalDateTime createdAt;
////////////////////
////////////////////    private LocalDateTime updatedAt;
////////////////////
////////////////////    // Getters & Setters
////////////////////
////////////////////    public Long getId() {
////////////////////        return id;
////////////////////    }
////////////////////
////////////////////    public void setId(Long id) {
////////////////////        this.id = id;
////////////////////    }
////////////////////
////////////////////    public Long getCustomerId() {
////////////////////        return customerId;
////////////////////    }
////////////////////
////////////////////    public void setCustomerId(Long customerId) {
////////////////////        this.customerId = customerId;
////////////////////    }
////////////////////
////////////////////    public String getServiceType() {
////////////////////        return serviceType;
////////////////////    }
////////////////////
////////////////////    public void setServiceType(String serviceType) {
////////////////////        this.serviceType = serviceType;
////////////////////    }
////////////////////
////////////////////    public Double getAmount() {
////////////////////        return amount;
////////////////////    }
////////////////////
////////////////////    public void setAmount(Double amount) {
////////////////////        this.amount = amount;
////////////////////    }
////////////////////
////////////////////    public String getPaymentStatus() {
////////////////////        return paymentStatus;
////////////////////    }
////////////////////
////////////////////    public void setPaymentStatus(String paymentStatus) {
////////////////////        this.paymentStatus = paymentStatus;
////////////////////    }
////////////////////
////////////////////    public String getControlNumber() {
////////////////////        return controlNumber;
////////////////////    }
////////////////////
////////////////////    public void setControlNumber(String controlNumber) {
////////////////////        this.controlNumber = controlNumber;
////////////////////    }
////////////////////
////////////////////    public LocalDateTime getPaymentDate() {
////////////////////        return paymentDate;
////////////////////    }
////////////////////
////////////////////    public void setPaymentDate(LocalDateTime paymentDate) {
////////////////////        this.paymentDate = paymentDate;
////////////////////    }
////////////////////
////////////////////    public boolean isDeleted() {
////////////////////        return deleted;
////////////////////    }
////////////////////
////////////////////    public void setDeleted(boolean deleted) {
////////////////////        this.deleted = deleted;
////////////////////    }
////////////////////
////////////////////    public LocalDateTime getCreatedAt() {
////////////////////        return createdAt;
////////////////////    }
////////////////////
////////////////////    public void setCreatedAt(LocalDateTime createdAt) {
////////////////////        this.createdAt = createdAt;
////////////////////    }
////////////////////
////////////////////    public LocalDateTime getUpdatedAt() {
////////////////////        return updatedAt;
////////////////////    }
////////////////////
////////////////////    public void setUpdatedAt(LocalDateTime updatedAt) {
////////////////////        this.updatedAt = updatedAt;
////////////////////    }
////////////////////}
//////////////////package com.zawadig.myafwanii.Model;
//////////////////
//////////////////import jakarta.persistence.*;
//////////////////import java.math.BigDecimal;
//////////////////import java.sql.Timestamp;
//////////////////
//////////////////@Entity
//////////////////@Table(name = "service_payments")
//////////////////public class ServicePayment {
//////////////////
//////////////////    @Id
//////////////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////////////////    private Long id;
//////////////////
//////////////////    @Column(name = "request_id", nullable = false)
//////////////////    private String requestId;  // Hii ni varchar(100) kwenye DB
//////////////////
//////////////////    @Column(name = "customer_id", nullable = false)
//////////////////    private Long customerId;
//////////////////
//////////////////    @Column(name = "amount_paid", nullable = false, precision = 15, scale = 2)
//////////////////    private BigDecimal amountPaid;
//////////////////
//////////////////    @Column(name = "payment_method", nullable = false, length = 50)
//////////////////    private String paymentMethod;
//////////////////
//////////////////    @Column(name = "control_number", unique = true, nullable = false, length = 100)
//////////////////    private String controlNumber;
//////////////////
//////////////////    @Enumerated(EnumType.STRING)
//////////////////    @Column(name = "payment_status", nullable = false)
//////////////////    private PaymentStatus paymentStatus; // Enum ya PAID, UNPAID
//////////////////
//////////////////    @Column(name = "service_type", nullable = false, length = 100)
//////////////////    private String serviceType;
//////////////////
//////////////////    @Column(name = "phone", length = 20)
//////////////////    private String phone;
//////////////////
//////////////////    @Column(name = "created_at", insertable = false, updatable = false)
//////////////////    private Timestamp createdAt;
//////////////////
//////////////////    @Column(name = "updated_at", insertable = false, updatable = false)
//////////////////    private Timestamp updatedAt;
//////////////////
//////////////////    @Column(name = "deleted")
//////////////////    private Boolean deleted = false;
//////////////////
//////////////////    @Column(name = "deleted_at")
//////////////////    private Timestamp deletedAt;
//////////////////
//////////////////    @Column(name = "deleted_by", length = 100)
//////////////////    private String deletedBy;
//////////////////    private Timestamp paymentDate;
//////////////////
//////////////////    // Getters and setters
//////////////////
//////////////////    public Long getId() {
//////////////////        return id;
//////////////////    }
//////////////////
//////////////////    public void setId(Long id) {
//////////////////        this.id = id;
//////////////////    }
//////////////////
//////////////////    public String getRequestId() {
//////////////////        return requestId;
//////////////////    }
//////////////////
//////////////////    public void setRequestId(String requestId) {
//////////////////        this.requestId = requestId;
//////////////////    }
//////////////////
//////////////////    public Long getCustomerId() {
//////////////////        return customerId;
//////////////////    }
//////////////////
//////////////////    public void setCustomerId(Long customerId) {
//////////////////        this.customerId = customerId;
//////////////////    }
//////////////////
//////////////////    public BigDecimal getAmountPaid() {
//////////////////        return amountPaid;
//////////////////    }
//////////////////
//////////////////    public void setAmountPaid(BigDecimal amountPaid) {
//////////////////        this.amountPaid = amountPaid;
//////////////////    }
//////////////////
//////////////////    public String getPaymentMethod() {
//////////////////        return paymentMethod;
//////////////////    }
//////////////////
//////////////////    public void setPaymentMethod(String paymentMethod) {
//////////////////        this.paymentMethod = paymentMethod;
//////////////////    }
//////////////////
//////////////////    public String getControlNumber() {
//////////////////        return controlNumber;
//////////////////    }
//////////////////
//////////////////    public void setControlNumber(String controlNumber) {
//////////////////        this.controlNumber = controlNumber;
//////////////////    }
//////////////////
//////////////////    public PaymentStatus getPaymentStatus() {
//////////////////        return paymentStatus;
//////////////////    }
//////////////////
//////////////////    public void setPaymentStatus(PaymentStatus paymentStatus) {
//////////////////        this.paymentStatus = paymentStatus;
//////////////////    }
//////////////////
//////////////////    public String getServiceType() {
//////////////////        return serviceType;
//////////////////    }
//////////////////
//////////////////    public void setServiceType(String serviceType) {
//////////////////        this.serviceType = serviceType;
//////////////////    }
//////////////////
//////////////////    public String getPhone() {
//////////////////        return phone;
//////////////////    }
//////////////////
//////////////////    public void setPhone(String phone) {
//////////////////        this.phone = phone;
//////////////////    }
//////////////////
//////////////////    public Timestamp getCreatedAt() {
//////////////////        return createdAt;
//////////////////    }
//////////////////
//////////////////    public Timestamp getUpdatedAt() {
//////////////////        return updatedAt;
//////////////////    }
//////////////////
//////////////////    public Boolean getDeleted() {
//////////////////        return deleted;
//////////////////    }
//////////////////
//////////////////    public void setDeleted(Boolean deleted) {
//////////////////        this.deleted = deleted;
//////////////////    }
//////////////////
//////////////////    public Timestamp getDeletedAt() {
//////////////////        return deletedAt;
//////////////////    }
//////////////////
//////////////////    public void setDeletedAt(Timestamp deletedAt) {
//////////////////        this.deletedAt = deletedAt;
//////////////////    }
//////////////////
//////////////////    public String getDeletedBy() {
//////////////////        return deletedBy;
//////////////////    }
//////////////////
//////////////////    public void setDeletedBy(String deletedBy) {
//////////////////        this.deletedBy = deletedBy;
//////////////////    }
//////////////////
//////////////////    // ndani ya ServicePayment.java
//////////////////
//////////////////    public void setPaymentDate(Timestamp paymentDate) {
//////////////////        this.paymentDate = paymentDate;
//////////////////    }
//////////////////
//////////////////    public Timestamp getPaymentDate() {
//////////////////        return this.paymentDate;
//////////////////    }
//////////////////
//////////////////    public BigDecimal getAmount() {
//////////////////        return amountPaid;
//////////////////    }
//////////////////
//////////////////
//////////////////    // Enum for payment status
//////////////////    public enum PaymentStatus {
//////////////////        PAID,
//////////////////        UNPAID
//////////////////    }
//////////////////}
////////////////package com.zawadig.myafwanii.Model;
////////////////
////////////////import jakarta.persistence.*;
////////////////import lombok.*;
////////////////
////////////////import java.time.LocalDateTime;
////////////////
////////////////@Entity
////////////////@Getter
////////////////@Setter
////////////////@NoArgsConstructor
////////////////@AllArgsConstructor
////////////////@Table(name = "service_payments")
////////////////public class ServicePayment {
////////////////
////////////////    @Id
////////////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////////////////    private Long id;
////////////////
////////////////    private Double amount;
////////////////    private String paymentMethod;
////////////////    private String controlNumber;
////////////////    private LocalDateTime paymentDate;
////////////////
////////////////    @ManyToOne(fetch = FetchType.LAZY)
////////////////    @JoinColumn(name = "service_request_id")
////////////////    private ServiceRequest serviceRequest;
////////////////}
//////////////package com.zawadig.myafwanii.Model;
//////////////
//////////////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//////////////import jakarta.persistence.*;
//////////////
//////////////import java.math.BigDecimal;
//////////////import java.time.LocalDateTime;
//////////////
//////////////@Entity
//////////////@Table(name = "service_payments")
//////////////@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//////////////public class ServicePayment {
//////////////
//////////////    @Id
//////////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////////////    private Long id;
//////////////
//////////////    @Column(name = "request_id", nullable = false)
//////////////    private String requestId;
//////////////
//////////////    @Column(name = "customer_id", nullable = false)
//////////////    private Long customerId;
//////////////
//////////////    @Column(name = "amount_paid", nullable = false)
//////////////    private BigDecimal amountPaid;
//////////////
//////////////    @Column(name = "payment_method", nullable = false)
//////////////    private String paymentMethod;
//////////////
//////////////    @Column(name = "control_number", nullable = false, unique = true)
//////////////    private String controlNumber;
//////////////
//////////////    @Enumerated(EnumType.STRING)
//////////////    @Column(name = "payment_status")
//////////////    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
//////////////
//////////////    @Column(name = "service_type", nullable = false)
//////////////    private String serviceType;
//////////////
//////////////    @Column(name = "phone")
//////////////    private String phone;
//////////////
//////////////    @Column(name = "created_at", insertable = false, updatable = false)
//////////////    private LocalDateTime createdAt;
//////////////
//////////////    @Column(name = "updated_at", insertable = false, updatable = false)
//////////////    private LocalDateTime updatedAt;
//////////////
//////////////    @Column(name = "deleted")
//////////////    private Boolean deleted = false;
//////////////
//////////////    @Column(name = "deleted_at")
//////////////    private LocalDateTime deletedAt;
//////////////
//////////////    @Column(name = "deleted_by")
//////////////    private String deletedBy;
//////////////
//////////////    @Column(name = "amount", nullable = false)
//////////////    private BigDecimal amount;
//////////////
//////////////    @Column(name = "payment_date")
//////////////    private LocalDateTime paymentDate;
//////////////
//////////////    // ====== Getters and Setters ======
//////////////
//////////////    public Long getId() {
//////////////        return id;
//////////////    }
//////////////
//////////////    public void setId(Long id) {
//////////////        this.id = id;
//////////////    }
//////////////
//////////////    public String getRequestId() {
//////////////        return requestId;
//////////////    }
//////////////
//////////////    public void setRequestId(String requestId) {
//////////////        this.requestId = requestId;
//////////////    }
//////////////
//////////////    public Long getCustomerId() {
//////////////        return customerId;
//////////////    }
//////////////
//////////////    public void setCustomerId(Long customerId) {
//////////////        this.customerId = customerId;
//////////////    }
//////////////
//////////////    public BigDecimal getAmountPaid() {
//////////////        return amountPaid;
//////////////    }
//////////////
//////////////    public void setAmountPaid(BigDecimal amountPaid) {
//////////////        this.amountPaid = amountPaid;
//////////////    }
//////////////
//////////////    public String getPaymentMethod() {
//////////////        return paymentMethod;
//////////////    }
//////////////
//////////////    public void setPaymentMethod(String paymentMethod) {
//////////////        this.paymentMethod = paymentMethod;
//////////////    }
//////////////
//////////////    public String getControlNumber() {
//////////////        return controlNumber;
//////////////    }
//////////////
//////////////    public void setControlNumber(String controlNumber) {
//////////////        this.controlNumber = controlNumber;
//////////////    }
//////////////
//////////////    public PaymentStatus getPaymentStatus() {
//////////////        return paymentStatus;
//////////////    }
//////////////
//////////////    public void setPaymentStatus(PaymentStatus paymentStatus) {
//////////////        this.paymentStatus = paymentStatus;
//////////////    }
//////////////
//////////////    public String getServiceType() {
//////////////        return serviceType;
//////////////    }
//////////////
//////////////    public void setServiceType(String serviceType) {
//////////////        this.serviceType = serviceType;
//////////////    }
//////////////
//////////////    public String getPhone() {
//////////////        return phone;
//////////////    }
//////////////
//////////////    public void setPhone(String phone) {
//////////////        this.phone = phone;
//////////////    }
//////////////
//////////////    public LocalDateTime getCreatedAt() {
//////////////        return createdAt;
//////////////    }
//////////////
//////////////    public LocalDateTime getUpdatedAt() {
//////////////        return updatedAt;
//////////////    }
//////////////
//////////////    public Boolean getDeleted() {
//////////////        return deleted;
//////////////    }
//////////////
//////////////    public void setDeleted(Boolean deleted) {
//////////////        this.deleted = deleted;
//////////////    }
//////////////
//////////////    public LocalDateTime getDeletedAt() {
//////////////        return deletedAt;
//////////////    }
//////////////
//////////////    public void setDeletedAt(LocalDateTime deletedAt) {
//////////////        this.deletedAt = deletedAt;
//////////////    }
//////////////
//////////////    public String getDeletedBy() {
//////////////        return deletedBy;
//////////////    }
//////////////
//////////////    public void setDeletedBy(String deletedBy) {
//////////////        this.deletedBy = deletedBy;
//////////////    }
//////////////
//////////////    public BigDecimal getAmount() {
//////////////        return amount;
//////////////    }
//////////////
//////////////    public void setAmount(BigDecimal amount) {
//////////////        this.amount = amount;
//////////////    }
//////////////
//////////////    public LocalDateTime getPaymentDate() {
//////////////        return paymentDate;
//////////////    }
//////////////
//////////////    public void setPaymentDate(LocalDateTime paymentDate) {
//////////////        this.paymentDate = paymentDate;
//////////////    }
//////////////
//////////////    public enum PaymentStatus {
//////////////        PAID, UNPAID
//////////////    }
//////////////}
////////////package com.zawadig.myafwanii.Model;
////////////
////////////import jakarta.persistence.*;
////////////
////////////import jakarta.persistence.Entity;
////////////import java.math.BigDecimal;
////////////import java.time.LocalDateTime;
////////////
////////////@Entity
////////////@Table(name = "service_payments")
////////////public class ServicePayment {
////////////
////////////    public enum PaymentStatus {
////////////        UNPAID, PAID
////////////    }
////////////
////////////    @Id
////////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////////////    private Long id;
////////////
////////////    @Column(name = "request_id", nullable = false)
////////////    private String requestId;
////////////
////////////    @Column(name = "customer_id", nullable = false)
////////////    private Long customerId;
////////////
////////////    @Column(name = "amount_paid", nullable = false, precision = 15, scale = 2)
////////////    private BigDecimal amountPaid;
////////////
////////////    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
////////////    private BigDecimal amount; // Add this field to match DB column
////////////
////////////    @Column(name = "payment_method", nullable = false)
////////////    private String paymentMethod;
////////////
////////////    @Column(name = "control_number", unique = true, nullable = false)
////////////    private String controlNumber;
////////////
////////////    @Enumerated(EnumType.STRING)
////////////    @Column(name = "payment_status", nullable = false)
////////////    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
////////////
////////////    @Column(name = "service_type", nullable = false)
////////////    private String serviceType;
////////////
////////////    @Column(name = "phone")
////////////    private String phone;
////////////
////////////    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
////////////    private LocalDateTime createdAt;
////////////
////////////    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
////////////    private LocalDateTime updatedAt;
////////////
////////////    @Column(name = "deleted")
////////////    private Boolean deleted = false;
////////////
////////////    @Column(name = "deleted_at")
////////////    private LocalDateTime deletedAt;
////////////
////////////    @Column(name = "deleted_by")
////////////    private String deletedBy;
////////////
////////////    @Column(name = "payment_date")
////////////    private LocalDateTime paymentDate;
////////////
////////////    // Constructors, getters, and setters
////////////
////////////    public void setAmountPaid(BigDecimal amountPaid) {
////////////        this.amountPaid = amountPaid;
////////////        // Set both amount fields to the same value
////////////        this.amount = amountPaid;
////////////    }
////////////
////////////    // ... other getters and setters ...
////////////}
//////////package com.zawadig.myafwanii.Model;
//////////
//////////import jakarta.persistence.*;
//////////
//////////
//////////import java.math.BigDecimal;
//////////import java.time.LocalDateTime;
//////////
//////////@Entity
//////////@Table(name = "service_payments")
//////////public class ServicePayment {
//////////
//////////    public enum PaymentStatus {
//////////        UNPAID, PAID
//////////    }
//////////
//////////    @Id
//////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////////    private Long id;
//////////
//////////    @Column(name = "customer_id", nullable = false)
//////////    private Long customerId;
//////////
//////////    @Column(name = "service_type", nullable = false)
//////////    private String serviceType;
//////////
//////////    @Column(name = "amount_paid", nullable = false, precision = 15, scale = 2)
//////////    private BigDecimal amountPaid;
//////////
//////////    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
//////////    private BigDecimal amount;
//////////
//////////    @Enumerated(EnumType.STRING)
//////////    @Column(name = "payment_status", nullable = false)
//////////    private PaymentStatus paymentStatus;
//////////
//////////    @Column(name = "control_number", unique = true, nullable = false)
//////////    private String controlNumber;
//////////
//////////    @Column(name = "deleted", nullable = false)
//////////    private Boolean deleted = false;
//////////
//////////    @Column(name = "payment_date")
//////////    private LocalDateTime paymentDate;
//////////
//////////    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//////////    private LocalDateTime createdAt;
//////////
//////////    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//////////    private LocalDateTime updatedAt;
//////////
//////////    // Getters and Setters
//////////    public Long getId() {
//////////        return id;
//////////    }
//////////
//////////    public void setId(Long id) {
//////////        this.id = id;
//////////    }
//////////
//////////    public Long getCustomerId() {
//////////        return customerId;
//////////    }
//////////
//////////    public void setCustomerId(Long customerId) {
//////////        this.customerId = customerId;
//////////    }
//////////
//////////    public String getServiceType() {
//////////        return serviceType;
//////////    }
//////////
//////////    public void setServiceType(String serviceType) {
//////////        this.serviceType = serviceType;
//////////    }
//////////
//////////    public BigDecimal getAmountPaid() {
//////////        return amountPaid;
//////////    }
//////////
//////////    public void setAmountPaid(BigDecimal amountPaid) {
//////////        this.amountPaid = amountPaid;
//////////        this.amount = amountPaid; // Set both fields
//////////    }
//////////
//////////    public BigDecimal getAmount() {
//////////        return amount;
//////////    }
//////////
//////////    public void setAmount(BigDecimal amount) {
//////////        this.amount = amount;
//////////    }
//////////
//////////    public PaymentStatus getPaymentStatus() {
//////////        return paymentStatus;
//////////    }
//////////
//////////    public void setPaymentStatus(PaymentStatus paymentStatus) {
//////////        this.paymentStatus = paymentStatus;
//////////    }
//////////
//////////    public String getControlNumber() {
//////////        return controlNumber;
//////////    }
//////////
//////////    public void setControlNumber(String controlNumber) {
//////////        this.controlNumber = controlNumber;
//////////    }
//////////
//////////    public Boolean getDeleted() {
//////////        return deleted;
//////////    }
//////////
//////////    public void setDeleted(Boolean deleted) {
//////////        this.deleted = deleted;
//////////    }
//////////
//////////    public LocalDateTime getPaymentDate() {
//////////        return paymentDate;
//////////    }
//////////
//////////    public void setPaymentDate(LocalDateTime paymentDate) {
//////////        this.paymentDate = paymentDate;
//////////    }
//////////
//////////    public LocalDateTime getCreatedAt() {
//////////        return createdAt;
//////////    }
//////////
//////////    public void setCreatedAt(LocalDateTime createdAt) {
//////////        this.createdAt = createdAt;
//////////    }
//////////
//////////    public LocalDateTime getUpdatedAt() {
//////////        return updatedAt;
//////////    }
//////////
//////////    public void setUpdatedAt(LocalDateTime updatedAt) {
//////////        this.updatedAt = updatedAt;
//////////    }
//////////}
////////package com.zawadig.myafwanii.Model;
////////
////////import jakarta.persistence.*;
////////import lombok.*;
////////import java.math.BigDecimal;
////////import java.time.LocalDateTime;
////////
////////@Entity
////////@Table(name = "service_payments")
////////@Getter
////////@Setter
////////@NoArgsConstructor
////////@AllArgsConstructor
////////public class ServicePayment {
////////
////////    @Id
////////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////////    private Long id;
////////
////////    private String requestId;
////////
////////    private Long customerId;
////////
////////    private BigDecimal amountPaid;
////////
////////    private String paymentMethod;
////////
////////    @Column(unique = true)
////////    private String controlNumber;
////////
////////    @Enumerated(EnumType.STRING)
////////    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
////////
////////    private String serviceType;
////////
////////    private String phone;
////////
////////    private BigDecimal amount;
////////
////////    private LocalDateTime paymentDate;
////////
////////    @Column(updatable = false)
////////    private LocalDateTime createdAt = LocalDateTime.now();
////////
////////    private LocalDateTime updatedAt = LocalDateTime.now();
////////
////////    private Boolean deleted = false;
////////
////////    private LocalDateTime deletedAt;
////////
////////    private String deletedBy;
////////
////////    public enum PaymentStatus {
////////        PAID,
////////        UNPAID
////////    }
////////}
//////package com.zawadig.myafwanii.Model;
//////
//////import jakarta.persistence.*;
//////import lombok.*;
//////
//////import java.math.BigDecimal;
//////import java.sql.Timestamp;
//////
//////@Entity
//////@Table(name = "service_payments")
//////@Data
//////@NoArgsConstructor
//////@AllArgsConstructor
//////@Builder
//////public class ServicePayment {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    private String requestId;
//////
//////    @Column(name = "customer_id")
//////    private Long customerId;
//////
//////    private BigDecimal amountPaid;
//////
//////    private String paymentMethod;
//////
//////    @Column(unique = true)
//////    private String controlNumber;
//////
//////    @Enumerated(EnumType.STRING)
//////    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
//////
//////    private String serviceType;
//////
//////    private String phone;
//////
//////    private BigDecimal amount;
//////
//////    private Timestamp paymentDate;
//////
//////    private Boolean deleted = false;
//////
//////    private Timestamp deletedAt;
//////
//////    private String deletedBy;
//////
//////    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//////    private Timestamp createdAt;
//////
//////    @Column(name = "updated_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//////    private Timestamp updatedAt;
//////
//////    public enum PaymentStatus {
//////        PAID,
//////        UNPAID
//////    }
//////}
//////package com.zawadig.myafwanii.Model;
//////
//////import jakarta.persistence.*;
//////import lombok.*;
//////
//////import java.math.BigDecimal;
//////import java.sql.Timestamp;
//////
//////@Entity
//////@Table(name = "service_payments")
//////@Data
//////@NoArgsConstructor
//////@AllArgsConstructor
//////@Builder
//////public class ServicePayment {
//////
//////    public enum PaymentStatus {
//////        PAID, UNPAID
//////    }
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    private String requestId;
//////
//////    @Column(name = "customer_id")
//////    private Long customerId;
//////
////////    private BigDecimal amountPaid;
//////
//////    private String paymentMethod;
//////
//////    @Column(unique = true)
//////    private String controlNumber;
//////
//////    @Enumerated(EnumType.STRING)
//////    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
//////
//////    private String serviceType;
//////
//////    private String phone;
//////
//////    private BigDecimal amount;
//////
//////    private Timestamp paymentDate;
//////
//////    private Boolean deleted = false;
//////
//////    private Timestamp deletedAt;
//////
//////    private String deletedBy;
//////
//////    @Column(name = "created_at", insertable = false, updatable = false,
//////            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//////    private Timestamp createdAt;
//////
//////    @Column(name = "updated_at", insertable = false, updatable = false,
//////            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//////    private Timestamp updatedAt;
//////}
//////package com.zawadig.myafwanii.Model;
//////
//////import com.zawadig.myafwanii.enums.PaymentStatus;
//////import jakarta.persistence.*;
//////import lombok.*;
//////import org.hibernate.annotations.CreationTimestamp;
//////import org.hibernate.annotations.UpdateTimestamp;
//////
//////import java.math.BigDecimal;
//////import java.time.LocalDateTime;
//////
//////@Entity
//////@Table(name = "service_payments")
//////@Data
//////@NoArgsConstructor
//////@AllArgsConstructor
//////@Builder
//////public class ServicePayment {
//////
//////    public void setPaymentStatus(com.zawadig.myafwanii.enums.PaymentStatus pending) {
//////    }
//////
//////    public enum PaymentStatus {
//////        PENDING, PAID, FAILED, UNPAID
//////    }
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    @Column(name = "request_id", length = 100)
//////    private String requestId;
//////
//////    @Column(name = "customer_id", nullable = false)
//////    private Long customerId;
//////
//////    @Column(name = "amount_paid", precision = 15, scale = 2)
//////    private BigDecimal amountPaid;
//////
//////    @Column(name = "payment_method", nullable = false, length = 50)
//////    private String paymentMethod;
//////
//////    @Column(name = "control_number", unique = true, nullable = false, length = 100)
//////    private String controlNumber;
//////
//////    @Enumerated(EnumType.STRING)
//////    @Column(name = "payment_status", columnDefinition = "ENUM('PENDING','PAID','FAILED','UNPAID') default 'PENDING'")
//////    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
//////
//////    @Column(name = "service_type", nullable = false, length = 100)
//////    private String serviceType;
//////
//////    @Column(length = 20)
//////    private String phone;
//////
//////    @Column(nullable = false, precision = 15, scale = 2)
//////    private BigDecimal amount;
//////
//////    @Column(name = "payment_date")
//////    private LocalDateTime paymentDate;
//////
//////    @Column(columnDefinition = "tinyint(1) default 0")
//////    private Boolean deleted = false;
//////
//////    @Column(name = "deleted_at")
//////    private LocalDateTime deletedAt;
//////
//////    @Column(name = "deleted_by", length = 100)
//////    private String deletedBy;
//////
//////    @CreationTimestamp
//////    @Column(name = "created_at", updatable = false)
//////    private LocalDateTime createdAt;
//////
//////    @UpdateTimestamp
//////    @Column(name = "updated_at")
//////    private LocalDateTime updatedAt;
//////
//////    // Additional field for payment reference
//////    @Column(name = "payment_reference", length = 100)
//////    private String paymentReference;
//////}
//////package com.zawadig.myafwanii.Model;
//////
//////import com.zawadig.myafwanii.enums.PaymentStatus;
//////import jakarta.persistence.*;
//////import lombok.*;
//////import org.hibernate.annotations.CreationTimestamp;
//////import org.hibernate.annotations.UpdateTimestamp;
//////
//////import java.math.BigDecimal;
//////import java.time.LocalDateTime;
//////
//////@Entity
//////@Table(name = "service_payments")
//////@Data
//////@NoArgsConstructor
//////@AllArgsConstructor
//////@Builder
//////public class ServicePayment {
//////
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//////    private Long id;
//////
//////    @Column(name = "request_id", length = 100)
//////    private String requestId;
//////
//////    @Column(name = "customer_id", nullable = false)
//////    private Long customerId;
//////
//////    @Column(name = "amount_paid", precision = 15, scale = 2)
//////    private BigDecimal amountPaid;
//////
//////    @Column(name = "payment_method", nullable = false, length = 50)
//////    private String paymentMethod;
//////
//////    @Column(name = "control_number", unique = true, nullable = false, length = 100)
//////    private String controlNumber;
//////
//////    @Enumerated(EnumType.STRING)
//////    @Column(name = "payment_status", columnDefinition = "ENUM('PENDING','PAID','FAILED','VERIFIED') default 'PENDING'")
//////    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
//////
//////    @Column(name = "service_type", nullable = false, length = 100)
//////    private String serviceType;
//////
//////    @Column(length = 20)
//////    private String phone;
//////
//////    @Column(nullable = false, precision = 15, scale = 2)
//////    private BigDecimal amount;
//////
//////    @Column(name = "payment_date")
//////    private LocalDateTime paymentDate;
//////
//////    @Column(columnDefinition = "tinyint(1) default 0")
//////    private Boolean deleted = false;
//////
//////    @Column(name = "deleted_at")
//////    private LocalDateTime deletedAt;
//////
//////    @Column(name = "deleted_by", length = 100)
//////    private String deletedBy;
//////
//////    @CreationTimestamp
//////    @Column(name = "created_at", updatable = false)
//////    private LocalDateTime createdAt;
//////
//////    @UpdateTimestamp
//////    @Column(name = "updated_at")
//////    private LocalDateTime updatedAt;
//////
//////    // Additional field for payment reference
//////    @Column(name = "payment_reference", length = 100)
//////    private String paymentReference;
//////}
////
//package com.zawadig.myafwanii.Model;
//
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "service_payments")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ServicePayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // Remove requestId string and replace with @ManyToOne relation
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_id", nullable = false)
//    private RequestForm requestForm;
//
//    @Column(name = "customer_id", nullable = false)
//    private Long customerId;
//
//    @Column(name = "amount_paid", precision = 15, scale = 2)
//    private BigDecimal amountPaid;
//
//    @Column(name = "payment_method", nullable = false, length = 50)
//    private String paymentMethod;
//
//    @Column(name = "control_number", unique = true, nullable = false, length = 100)
//    private String controlNumber;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_status", columnDefinition = "ENUM('PENDING','PAID','FAILED','VERIFIED') default 'PENDING'")
//    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
//
//    @Column(name = "service_type", nullable = false, length = 100)
//    private String serviceType;
//
//    @Column(length = 20)
//    private String phone;
//
//    @Column(nullable = false, precision = 15, scale = 2)
//    private BigDecimal amount;
//
//    @Column(name = "payment_date")
//    private LocalDateTime paymentDate;
//
//    @Column(columnDefinition = "tinyint(1) default 0")
//    private Boolean deleted = false;
//
//    @Column(name = "deleted_at")
//    private LocalDateTime deletedAt;
//
//    @Column(name = "deleted_by", length = 100)
//    private String deletedBy;
//
//    @CreationTimestamp
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    // Additional field for payment reference
//    @Column(name = "payment_reference", length = 100)
//    private String paymentReference;
//
//
//}
//
////package com.zawadig.myafwanii.Model;
////
////import com.zawadig.myafwanii.enums.PaymentStatus;
////import jakarta.persistence.*;
////import lombok.*;
////import org.hibernate.annotations.CreationTimestamp;
////import org.hibernate.annotations.UpdateTimestamp;
////
////import java.math.BigDecimal;
////import java.time.LocalDateTime;
////
////@Entity
////@Table(name = "service_payments")
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////@Builder
////public class ServicePayment {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    // Relationship to request
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "request_id", nullable = false)
////    private RequestForm request;
////
////    @Column(name = "customer_id", nullable = false)
////    private Long customerId;
////
////    @Column(name = "amount_paid", precision = 15, scale = 2)
////    private BigDecimal amountPaid;
////
////    @Column(name = "payment_method", nullable = false, length = 50)
////    private String paymentMethod;
////
////    @Column(name = "control_number", unique = true, nullable = false, length = 100)
////    private String controlNumber;
////
////    @Enumerated(EnumType.STRING)
////    @Column(name = "payment_status", columnDefinition = "ENUM('PENDING','PAID','FAILED','VERIFIED') default 'PENDING'")
////    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
////
////    @Column(name = "service_type", nullable = false, length = 100)
////    private String serviceType;
////
////    @Column(length = 20)
////    private String phone;
////
////    @Column(name = "payment_date")
////    private LocalDateTime paymentDate;
////
////    @Column(columnDefinition = "tinyint(1) default 0")
////    private Boolean deleted = false;
////
////    @Column(name = "deleted_at")
////    private LocalDateTime deletedAt;
////
////    @Column(name = "deleted_by", length = 100)
////    private String deletedBy;
////
////    @CreationTimestamp
////    @Column(name = "created_at", updatable = false)
////    private LocalDateTime createdAt;
////
////    @UpdateTimestamp
////    @Column(name = "updated_at")
////    private LocalDateTime updatedAt;
////
////    @Column(name = "payment_reference", length = 100)
////    private String paymentReference;
////}
////package com.zawadig.myafwanii.Model;
////
////import com.zawadig.myafwanii.enums.PaymentStatus;
////import jakarta.persistence.*;
////
////import java.math.BigDecimal;
////import java.time.LocalDateTime;
////
////@Entity
////@Table(name = "service_payments")
////public class ServicePayment {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    private Long customerId;
////
////    private String serviceType;
////
////    private String phone;
////
////    private String paymentMethod;
////
////    private BigDecimal amountPaid;
////
////    private BigDecimal amount;
////
////    private String controlNumber;
////
////    private String paymentReference;
////
////    @Enumerated(EnumType.STRING)
////    private PaymentStatus paymentStatus;
////
////    private LocalDateTime paymentDate;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "request_id")
////    private RequestForm requestForm;
////
////    // ---------------- Getters and Setters ----------------
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public Long getCustomerId() {
////        return customerId;
////    }
////
////    public void setCustomerId(Long customerId) {
////        this.customerId = customerId;
////    }
////
////    public String getServiceType() {
////        return serviceType;
////    }
////
////    public void setServiceType(String serviceType) {
////        this.serviceType = serviceType;
////    }
////
////    public String getPhone() {
////        return phone;
////    }
////
////    public void setPhone(String phone) {
////        this.phone = phone;
////    }
////
////    public String getPaymentMethod() {
////        return paymentMethod;
////    }
////
////    public void setPaymentMethod(String paymentMethod) {
////        this.paymentMethod = paymentMethod;
////    }
////
////    public BigDecimal getAmountPaid() {
////        return amountPaid;
////    }
////
////    public void setAmountPaid(BigDecimal amountPaid) {
////        this.amountPaid = amountPaid;
////    }
////
////    public Double getAmount() {
////        return amount;
////    }
////
////    public void setAmount(BigDecimal amount) {
////        this.amount = amount;
////    }
////
////    public String getControlNumber() {
////        return controlNumber;
////    }
////
////    public void setControlNumber(String controlNumber) {
////        this.controlNumber = controlNumber;
////    }
////
////    public String getPaymentReference() {
////        return paymentReference;
////    }
////
////    public void setPaymentReference(String paymentReference) {
////        this.paymentReference = paymentReference;
////    }
////
////    public String getPaymentStatus() {
////        return paymentStatus;
////    }
////
////    public void setPaymentStatus(PaymentStatus paymentStatus) {
////        this.paymentStatus = paymentStatus;
////    }
////
////    public LocalDateTime getPaymentDate() {
////        return paymentDate;
////    }
////
////    public void setPaymentDate(LocalDateTime paymentDate) {
////        this.paymentDate = paymentDate;
////    }
////
////    public RequestForm getRequestForm() {
////        return requestForm;
////    }
////
////    public void setRequestForm(RequestForm requestForm) {
////        this.requestForm = requestForm;
////    }
////
////    public LocalDateTime getCreatedAt() {
////    }
////}
//package com.zawadig.myafwanii.Model;
//
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.persistence.*;
//import lombok.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "service_payment")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ServicePayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String controlNumber;
//
//    @Column(nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(nullable = false)
//    private String paymentMethod;
//
//    @Column(nullable = false)
//    private BigDecimal amount;
//
//    @Column(nullable = false)
//    private BigDecimal amountPaid;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private PaymentStatus paymentStatus;
//
//    @Column(nullable = false)
//    private LocalDateTime paymentDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_form_id", nullable = false)
//    private RequestForm requestForm;
//
//    @PrePersist
//    protected void onCreate() {
//        this.paymentDate = LocalDateTime.now();
//    }
//
//    public void setCustomerId(Long customerId) {
//    }
//
//    public void setRequestId(Long requestId) {
//    }
//}
//package com.zawadig.myafwanii.Model;
//
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.persistence.*;
//import lombok.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "service_payments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ServicePayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "control_number", nullable = false, unique = true)
//    private String controlNumber;
//
//    @Column(name = "service_type", nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(name = "payment_method", nullable = false)
//    private String paymentMethod;
//
//    @Column(nullable = false)
//    private BigDecimal amount;
//
//    @Column(name = "amount_paid", nullable = false)
//    private BigDecimal amountPaid;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_status", nullable = false)
//    private PaymentStatus paymentStatus;
//
//    @Column(name = "payment_date", nullable = false)
//    private LocalDateTime paymentDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_form_id", nullable = false)
//    private RequestForm requestForm;
//
//    @PrePersist
//    protected void onCreate() {
//        if (this.paymentDate == null) {
//            this.paymentDate = LocalDateTime.now();
//        }
//        if (this.paymentStatus == null) {
//            this.paymentStatus = PaymentStatus.PENDING;
//        }
//    }
//
//    public void setPaymentStatus(PaymentStatus verified) {
//    }
//}muuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu





//package com.zawadig.myafwanii.Model;
//
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.persistence.*;
//import lombok.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "service_payments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ServicePayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "control_number", nullable = false, unique = true)
//    private String controlNumber;
//
//    @Column(name = "service_type", nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(name = "payment_method", nullable = false)
//    private String paymentMethod;
//
//    @Column(nullable = false)
//    private BigDecimal amount;
//
//    @Column(name = "amount_paid", nullable = false)
//    private BigDecimal amountPaid;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_status", nullable = false)
//    @Builder.Default
//    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
//
//    @Column(name = "payment_date", nullable = false)
//    private LocalDateTime paymentDate;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @Column(name = "request_id", nullable = false) // <-- TUMIA request_id ILIYOIPO
//    private String requestId;    private RequestForm requestForm;
//
//    @PrePersist
//    protected void onCreate() {
//        if (this.paymentDate == null) {
//            this.paymentDate = LocalDateTime.now();
//        }
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    public void setPaymentStatus(PaymentStatus status) {
//        this.paymentStatus = status;
//        this.updatedAt = LocalDateTime.now();
//    }
//}nzurriii iyo ya 2











//package com.zawadig.myafwanii.Model;
//
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.persistence.*;
//import lombok.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "service_payments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ServicePayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "control_number", nullable = false, unique = true)
//    private String controlNumber;
//
//    @Column(name = "service_type", nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(name = "payment_method", nullable = false)
//    private String paymentMethod;
//
//    @Column(nullable = false)
//    private BigDecimal amount;
//
//    @Column(name = "amount_paid", nullable = false)
//    private BigDecimal amountPaid;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_status", nullable = false)
//    @Builder.Default
//    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
//
//    @Column(name = "payment_date")
//    private LocalDateTime paymentDate;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    // Uhusiano na RequestForm
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_id", nullable = false)
//    private RequestForm requestForm;
//
//    // Uhusiano mpya na Customer
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @PrePersist
//    protected void onCreate() {
//        if (this.paymentDate == null) {
//            this.paymentDate = LocalDateTime.now();
//        }
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    public void setPaymentStatus(PaymentStatus status) {
//        this.paymentStatus = status;
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    public void setCreatedAt(LocalDateTime now) {
//    }
//}















//
//
//package com.zawadig.myafwanii.Model;
//
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//@Data
//@Entity
//@Table(name = "service_payments")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class ServicePayment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "control_number", nullable = false, unique = true)
//    private String controlNumber;
//
//    @Column(name = "service_type", nullable = false)
//    private String serviceType;
//
//    @Column(nullable = false)
//    private String phone;
//
//    @Column(name = "payment_method", nullable = false)
//    private String paymentMethod;
//
//    @Column(nullable = false)
//    private BigDecimal amount;
//
//    @Column(name = "amount_paid", nullable = false)
//    private BigDecimal amountPaid;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "payment_status", nullable = false)
//    @Builder.Default
//    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
//
//    @Column(name = "payment_date")
//    private LocalDateTime paymentDate;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    // Relationship to RequestForm
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_form_id", nullable = false)
//    private RequestForm requestForm;
//
//    // Relationship to Customer
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @PrePersist
//    protected void onCreate() {
//        if (this.paymentDate == null) {
//            this.paymentDate = LocalDateTime.now();
//        }
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    public void setPaymentStatus(PaymentStatus status) {
//        this.paymentStatus = status;
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    public void setCreatedAt(LocalDateTime now) {
//    }
//
//
//}






package com.zawadig.myafwanii.Model;

import com.zawadig.myafwanii.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "service_payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "control_number", nullable = false, unique = true)
    private String controlNumber;

    @Column(name = "service_type", nullable = false)
    private String serviceType;

    @Column(nullable = false)
    private String phone;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "amount_paid", nullable = false)
    private BigDecimal amountPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    @Builder.Default
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "verification_date")
    private LocalDateTime verificationDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "pdf_reference")
    private String pdfReference;

    // Relationship to RequestForm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_form_id", nullable = false)
    private RequestForm requestForm;

    // Relationship to Customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        if (this.paymentDate == null) {
            this.paymentDate = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void verifyPayment() {
        this.paymentStatus = PaymentStatus.VERIFIED;
        this.verificationDate = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getVerificationDate() {
        return this.verificationDate;
    }

    // Helper method to check if payment is verified
    public boolean isVerified() {
        return this.paymentStatus == PaymentStatus.VERIFIED;
    }

    // Helper method to check if payment is pending
    public boolean isPending() {
        return this.paymentStatus == PaymentStatus.PENDING;
    }

    // Helper method to check if payment failed
    public boolean isFailed() {
        return this.paymentStatus == PaymentStatus.FAILED;
    }
}