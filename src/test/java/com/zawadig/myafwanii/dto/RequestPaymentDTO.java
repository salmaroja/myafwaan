package com.zawadig.myafwanii.dto;//////package com.zawadig.myafwanii.dto;
//////
//////import jakarta.validation.constraints.Min;
//////import jakarta.validation.constraints.NotBlank;
//////import jakarta.validation.constraints.NotNull;
//////import lombok.Data;
//////import lombok.NoArgsConstructor;
//////import lombok.AllArgsConstructor;
//////
////////import javax.validation.constraints.Min;
////////import javax.validation.constraints.NotBlank;
////////import javax.validation.constraints.NotNull;
//////
//////@Data
//////@NoArgsConstructor
//////@AllArgsConstructor
//////public class RequestPaymentDTO {
//////    @NotNull(message = "Customer ID is required")
//////    private Long customerId;
//////
//////    @NotBlank(message = "Service type is required")
//////    private String serviceType;
//////
//////    @NotNull(message = "Amount is required")
//////    @Min(value = 1, message = "Amount must be greater than 0")
//////    private Double amount;
//////
//////    @NotBlank(message = "Payment method is required")
//////    private String paymentMethod;
//////
//////    private String phone;  // Optional
//////}
////package com.zawadig.myafwanii.dto;
////
////import jakarta.validation.constraints.*;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////import lombok.AllArgsConstructor;
////
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////public class RequestPaymentDTO {
////
////    @NotNull(message = "Kitambulisho cha mteja kinahitajika")
////    @Positive(message = "Kitambulisho cha mteja kisichozidi sifuri")
////    private Long customerId;
////
////    @NotBlank(message = "Aina ya huduma inahitajika")
////    @Size(max = 100, message = "Aina ya huduma isizidi herufi 100")
////    private String serviceType;
////
////    @NotNull(message = "Kiasi kinahitajika")
////    @DecimalMin(value = "1.00", message = "Kiasi kisichozidi TZS 1.00")
////    @Digits(integer = 13, fraction = 2, message = "Kiasi kisichozidi tarakimu 13 na sehemu ya desimali 2")
////    private Double amount;
////
////    @NotBlank(message = "Njia ya malipo inahitajika")
////    @Pattern(regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$",
////            message = "Chagua njia sahihi ya malipo")
////    private String paymentMethod;
////
////    @NotBlank(message = "Namba ya simu inahitajika")
////    @Pattern(regexp = "^\\d{9,12}$",
////            message = "Namba ya simu iwe kati ya tarakimu 9 na 12")
////    private String phone;
////}
//package com.zawadig.myafwanii.dto;
//
//import jakarta.validation.constraints.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class RequestPaymentDTO {
//
//    @NotNull(message = "Kitambulisho cha mteja kinahitajika")
//    @Positive(message = "Kitambulisho cha mteja kisichozidi sifuri")
//    private Long customerId;
//
//    @NotBlank(message = "Aina ya huduma inahitajika")
//    @Size(max = 100, message = "Aina ya huduma isizidi herufi 100")
//    private String serviceType;
//
//    @NotNull(message = "Kiasi kinahitajika")
//    @DecimalMin(value = "1.00", message = "Kiasi kisichozidi TZS 1.00")
//    @Digits(integer = 13, fraction = 2, message = "Kiasi kisizidi tarakimu 13 na sehemu ya desimali 2")
//    private Double amount;
//
//    @NotBlank(message = "Njia ya malipo inahitajika")
//    @Pattern(regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$",
//            message = "Chagua njia sahihi ya malipo")
//    private String paymentMethod;
//
//    // Ikiwa optional, toa @NotBlank hapa
//    @NotBlank(message = "Namba ya simu inahitajika")
//    @Pattern(regexp = "^\\d{9,12}$",
//            message = "Namba ya simu iwe kati ya tarakimu 9 na 12")
//    private String phone;
//    @NotNull(message = "Request ID inahitajika")
//    private Long requestId;
//
//}
//package com.zawadig.myafwanii.dto;
//
//import jakarta.validation.constraints.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class RequestPaymentDTO {
//
//    @NotNull(message = "Kitambulisho cha ombi (requestId) kinahitajika")
//    private Long requestId;
//
//    @NotNull(message = "Kitambulisho cha mteja kinahitajika")
//    @Positive(message = "Kitambulisho cha mteja kisizidi sifuri")
//    private Long customerId;
//
//    @NotBlank(message = "Aina ya huduma inahitajika")
//    @Size(max = 100, message = "Aina ya huduma isizidi herufi 100")
//    private String serviceType;
//
//    @NotNull(message = "Kiasi kinahitajika")
//    @DecimalMin(value = "1.00", message = "Kiasi kisizidi TZS 1.00")
//    @Digits(integer = 13, fraction = 2, message = "Kiasi kisizidi tarakimu 13 na sehemu ya desimali 2")
//    private Double amount;
//
//    @NotBlank(message = "Njia ya malipo inahitajika")
//    @Pattern(regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$",
//            message = "Chagua njia sahihi ya malipo")
//    private String paymentMethod;
//
//    @NotBlank(message = "Namba ya simu inahitajika")
//    @Pattern(regexp = "^\\d{9,12}$",
//            message = "Namba ya simu iwe kati ya tarakimu 9 na 12")
//    private String phone;
//}UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU

//package com.zawadig.myafwanii.dto;
//
//import com.zawadig.myafwanii.Model.Customer;
//import jakarta.validation.constraints.*;
//import lombok.Data;
//import java.math.BigDecimal;
//
//@Data
//public class RequestPaymentDTO {
//
//    @NotNull(message = "Kitambulisho cha ombi (requestId) kinahitajika")
//    private Long request_form_id;
//
//    @NotNull(message = "Kitambulisho cha mteja kinahitajika")
//    @Positive(message = "Kitambulisho cha mteja kisizidi sifuri")
//    private Long customerId;
//
//    @NotBlank(message = "Aina ya huduma inahitajika")
//    @Size(max = 100, message = "Aina ya huduma isizidi herufi 100")
//    private String serviceType;
//
//    @NotNull(message = "Kiasi kinahitajika")
//    @DecimalMin(value = "1.00", message = "Kiasi kisizidi TZS 1.00")
//    @Digits(integer = 13, fraction = 2, message = "Kiasi kisizidi tarakimu 13 na sehemu ya desimali 2")
//    private BigDecimal amount;
//
//    @NotBlank(message = "Njia ya malipo inahitajika")
//    @Pattern(regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$",
//            message = "Chagua njia sahihi ya malipo")
//    private String paymentMethod;
//
//    @NotBlank(message = "Namba ya simu inahitajika")
//    @Pattern(regexp = "^\\d{9,12}$",
//            message = "Namba ya simu iwe kati ya tarakimu 9 na 12")
//    private String phone;
//
//    public Customer getCustomer() {
//        Customer customer = new Customer();
//        customer.setId(this.customerId);
//        // You might want to set other customer properties if available
//        return customer;
//    }
//
//    public Long getrequest_form_id() {
//        return request_form_id;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//






//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.validation.constraints.*;
//import lombok.Data;
//import java.math.BigDecimal;
//
//@Data
//public class RequestPaymentDTO {
//
//    @NotNull(message = "Kitambulisho cha ombi (requestId) kinahitajika")
//    @JsonProperty("request_form_id")
//    private Long requestFormId;
//
//    @NotNull(message = "Kitambulisho cha mteja kinahitajika")
//    @Positive(message = "Kitambulisho cha mteja kisizidi sifuri")
//    private Long customerId;
//
//    @NotBlank(message = "Aina ya huduma inahitajika")
//    @Size(max = 100, message = "Aina ya huduma isizidi herufi 100")
//    private String serviceType;
//
//    @NotNull(message = "Kiasi kinahitajika")
//    @DecimalMin(value = "1.00", message = "Kiasi kisizidi TZS 1.00")
//    @Digits(integer = 13, fraction = 2, message = "Kiasi kisizidi tarakimu 13 na sehemu ya desimali 2")
//    private BigDecimal amount;
//
//    @NotBlank(message = "Njia ya malipo inahitajika")
//    @Pattern(regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$",
//            message = "Chagua njia sahihi ya malipo")
//    private String paymentMethod;
//
//    @NotBlank(message = "Namba ya simu inahitajika")
//    @Pattern(regexp = "^\\d{9,12}$",
//            message = "Namba ya simu iwe kati ya tarakimu 9 na 12")
//    private String phone;
//}













//import jakarta.validation.constraints.*;
//import lombok.Data;
//import java.math.BigDecimal;
//
//@Data
//public class RequestPaymentDTO {
//
//    @NotNull(message = "Kitambulisho cha ombi (requestId) kinahitajika")
//    private Long requestFormId;
//
//    @NotNull(message = "Kitambulisho cha mteja kinahitajika")
//    @Positive(message = "Kitambulisho cha mteja kisizidi sifuri")
//    private Long customerId;
//
//    @NotBlank(message = "Aina ya huduma inahitajika")
//    @Size(max = 100, message = "Aina ya huduma isizidi herufi 100")
//    private String serviceType;
//
//    @NotNull(message = "Kiasi kinahitajika")
//    @DecimalMin(value = "1.00", message = "Kiasi kisizidi TZS 1.00")
//    @Digits(integer = 13, fraction = 2, message = "Kiasi kisizidi tarakimu 13 na sehemu ya desimali 2")
//    private BigDecimal amount;
//
//    @NotBlank(message = "Njia ya malipo inahitajika")
//    @Pattern(regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$", message = "Chagua njia sahihi ya malipo")
//    private String paymentMethod;
//
//    @NotBlank(message = "Namba ya simu inahitajika")
//    @Pattern(regexp = "^\\d{9,12}$", message = "Namba ya simu iwe kati ya tarakimu 9 na 12")
//    private String phone;
//
//    // **HAPANA getCustomer() method hapa**
//}


import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestPaymentDTO {

    @NotNull(message = "Kitambulisho cha ombi (requestFormId) kinahitajika")
    private Long requestFormId;

    @NotNull(message = "Kitambulisho cha mteja (customerId) kinahitajika")
    @Positive(message = "Kitambulisho cha mteja kisizidi sifuri")
    private Long customerId;

    @NotBlank(message = "Aina ya huduma (serviceType) inahitajika")
    @Size(max = 255, message = "Aina ya huduma isizidi herufi 255")
    private String serviceType;

    @NotNull(message = "Kiasi (amount) kinahitajika")
    @DecimalMin(value = "1.00", inclusive = true, message = "Kiasi kisizidi TZS 1.00")
    @Digits(integer = 36, fraction = 2, message = "Kiasi kisizidi tarakimu 36 na sehemu ya desimali 2")
    private BigDecimal amount;

    @NotBlank(message = "Njia ya malipo (paymentMethod) inahitajika")
    @Pattern(
            regexp = "^(M-PESA|Tigo Pesa|Airtel Money|T-Pesa|Halotel Pesa)$",
            message = "Chagua njia sahihi ya malipo: M-PESA, Tigo Pesa, Airtel Money, T-Pesa, au Halotel Pesa"
    )
    private String paymentMethod;

    @NotBlank(message = "Namba ya simu inahitajika")
    @Pattern(
            regexp = "^(\\+?\\d{9,12})$",
            message = "Namba ya simu iwe kati ya tarakimu 9 hadi 12 (inayoweza kuanza na +)"
    )
    private String phone;
}
