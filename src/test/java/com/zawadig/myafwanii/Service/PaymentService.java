//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Payment;
//import com.zawadig.myafwanii.dto.PaymentDTO;
//import com.zawadig.myafwanii.dto.PaymentRequestDTO;
//
//import java.util.List;
//
//public interface PaymentService {
//
//    List<PaymentDTO> getAllPayments();
//
//    Payment generateControlNumber(PaymentRequestDTO dto);
//
//    Payment confirmPayment(String controlNumber);
//
//    boolean deletePaymentById(Long id, String deletedBy);
//
//    boolean restorePayment(Long id);
//
//    List<PaymentDTO> getDeletedPayments();
//
//    boolean permanentDeletePayment(Long id);
//
//    Payment updatePayment(Long id, Payment updatedPayment);
//
//    // Hii method inabidi iwepo ili Controller iweze kuitumia
//    Payment getPaymentById(Long id);
//}
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.Model.ServicePayment;
import com.zawadig.myafwanii.dto.PaymentDTO;
import com.zawadig.myafwanii.dto.PaymentRequestDTO;
import com.zawadig.myafwanii.dto.RequestPaymentDTO;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment generateControlNumber(PaymentRequestDTO dto);

    Payment confirmPayment(String controlNumber);

    boolean deletePaymentById(Long id, String deletedBy);

    boolean restorePayment(Long id);

    List<PaymentDTO> getDeletedPayments();

    boolean permanentDeletePayment(Long id);

    Payment updatePayment(Long id, Payment updatedPayment);

    Payment getPaymentById(Long id);

    ServicePayment createPayment(RequestPaymentDTO dto);

    ServicePayment getPaymentByControlNumber(String controlNumber);

    boolean verifyPayment(String controlNumber);

    boolean deletePayment(Long id);

    Payment findByRequestId(String requestId);

    List<PaymentDTO> findByCustomerId(Long customerId);

    String generateControlNumber(String requestId);

    List<Payment> getVerifiedPaymentsPendingSurvey();
}
