////////////package com.zawadig.myafwanii.Service;
////////////
////////////import com.zawadig.myafwanii.Model.ServicePayment;
////////////
////////////public interface ServicePaymentService {
////////////
////////////    ServicePayment requestPayment(Long customerId, String serviceType, Double amount);
////////////
////////////    ServicePayment confirmPayment(String controlNumber);
////////////
////////////    ServicePayment getPaymentStatus(String controlNumber);
////////////
////////////}
//////////package com.zawadig.myafwanii.Service;
//////////
//////////import com.zawadig.myafwanii.Model.ServicePayment;
//////////
//////////public interface ServicePaymentService {
//////////
//////////    ServicePayment requestPayment(Long customerId, String serviceType, Double amount);
//////////
//////////    ServicePayment confirmPayment(String controlNumber);
//////////
//////////    ServicePayment getPaymentStatus(String controlNumber);
//////////
//////////}
////////package com.zawadig.myafwanii.Service;
////////
////////import com.zawadig.myafwanii.Model.ServicePayment;
////////
////////public interface ServicePaymentService {
////////
////////    ServicePayment requestPayment(Long customerId, String serviceType, Double amount);
////////
////////    ServicePayment confirmPayment(String controlNumber);
////////
////////    ServicePayment getPaymentStatus(String controlNumber);
////////
////////    ServicePayment requestPayment(Long customerId, String serviceType, Double amount, String paymentMethod, String phone);
////////
////////    ServicePayment requestPayment(Long customerId, String serviceType, Double amount, String paymentMethod, String phone, String controlNumber);
////////}
////////package com.zawadig.myafwanii.Service;
////////
////////import com.zawadig.myafwanii.dto.RequestPaymentDTO;
////////import com.zawadig.myafwanii.Model.ServicePayment;
////////
////////public interface ServicePaymentService {
////////    ServicePayment createPayment(RequestPaymentDTO request);
////////
////////    ServicePayment RequestPayment(Long customerId, String serviceType, Double amount, String paymentMethod, String phone, String controlNumber);
////////}
//////package com.zawadig.myafwanii.Service;
//////
//////import com.zawadig.myafwanii.Model.ServicePayment;
//////import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//////
//////public interface ServicePaymentService {
//////    ServicePayment createPayment(RequestPaymentDTO dto, String controlNumber);
//////    ServicePayment getPaymentByControlNumber(String controlNumber);
//////}
////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.dto.RequestPaymentDTO;
////import com.zawadig.myafwanii.dto.ServicePaymentDTO;
////
////import java.util.List;
////
////public interface ServicePaymentService {
////    ServicePaymentDTO createPayment(RequestPaymentDTO dto);
////
////    // ✅ Method ya ku-verify payment
////    ServicePaymentDTO verifyPayment(String controlNumber);
////
////    ServicePaymentDTO getPaymentByControlNumber(String controlNumber);
////
////    String generateControlNumber();
////
////    List<ServicePaymentDTO> getAllPayments();
////}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import com.zawadig.myafwanii.dto.ServicePaymentDTO;
//import java.util.List;
//
//public interface ServicePaymentService {
//    ServicePaymentDTO createPayment(RequestPaymentDTO dto);
//    ServicePayment getPaymentByControlNumber(String controlNumber);
//
//    ServicePayment createPayment(RequestPaymentDTO dto, String controlNumber);
//
//    boolean verifyPayment(String controlNumber);
//    List<ServicePaymentDTO> getAllPayments();
//
//    String generateControlNumber();
//}MUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.Repository.ServicePaymentRepository;
//import com.zawadig.myafwanii.dto.RequestPaymentDTO;
//import com.zawadig.myafwanii.enums.PaymentStatus;
//
//import java.util.List;
//
//public interface ServicePaymentService {
//    ServicePayment createPayment(RequestPaymentDTO dto);
//
//    ServicePayment getPaymentByControlNumber(String controlNumber);
//
//    boolean verifyPayment(String controlNumber);
//
//    List<ServicePayment> getAllPayments(); // usiweke logic ya findAll() hapa
//
//    public default List<ServicePayment> getVerifiedPayments() {
//        return ServicePaymentRepository.findByPaymentStatus(PaymentStatus.VERIFIED);
//    }
//
//}




























package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.ServicePayment;
import com.zawadig.myafwanii.dto.RequestPaymentDTO;

import java.util.List;

public interface ServicePaymentService {
    ServicePayment createPayment(RequestPaymentDTO dto);

    ServicePayment getPaymentByControlNumber(String controlNumber);

    ServicePayment verifyPayment(String controlNumber);

    List<ServicePayment> getAllPayments();

    List<ServicePayment> getVerifiedPayments(); // declaration tu
    List<ServicePayment> getVerifiedPaymentsByCustomerId(Long customerId);
    // ...existing code...

    ServicePayment getLatestPaymentByRequestFormAndCustomer(Long requestFormId, Long customerId);

    List<ServicePayment> getPaymentHistoryByCustomerId(Long customerId);

    ServicePayment updatePdfReference(String controlNumber, String pdfReference);

    ServicePayment savePayment(ServicePayment payment);


// ...existing code...

}
