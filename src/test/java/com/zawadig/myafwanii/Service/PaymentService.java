////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Payment;
////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
////
////public interface PaymentService {
////    Payment generateControlNumber(PaymentRequestDTO dto);
////    Payment confirmPayment(String controlNumber);
////}
////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.Payment;
////import com.zawadig.myafwanii.dto.PaymentDTO;
////import com.zawadig.myafwanii.dto.PaymentRequestDTO;
////
////import java.util.List;
////
////public interface PaymentService {
////    List<PaymentDTO> getAllPayments();
////    Payment generateControlNumber(PaymentRequestDTO dto);
////    Payment confirmPayment(String controlNumber);
////} izo nd muimu sana usije kufuta my dear
//
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
//    // Orodha ya malipo ambayo hayajafutwa
//    List<PaymentDTO> getAllPayments();
//
//    // Generate control number
//    Payment generateControlNumber(PaymentRequestDTO dto);
//
//    // Thibitisha malipo
//    Payment confirmPayment(String controlNumber);
//
//    // Futa (soft delete) malipo
//    boolean deletePaymentById(Long id, String deletedBy);
//
//    // Rejesha malipo yaliyofutwa
//    boolean restorePayment(Long id);
//
//    // Orodha ya malipo yaliyofutwa (recycle bin)
//    List<PaymentDTO> getDeletedPayments();
//}
//
//
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Payment;
import com.zawadig.myafwanii.dto.PaymentDTO;
import com.zawadig.myafwanii.dto.PaymentRequestDTO;

import java.util.List;

public interface PaymentService {

    List<PaymentDTO> getAllPayments();

    Payment generateControlNumber(PaymentRequestDTO dto);

    Payment confirmPayment(String controlNumber);

    boolean deletePaymentById(Long id, String deletedBy);

    boolean restorePayment(Long id);

    List<PaymentDTO> getDeletedPayments();
    boolean permanentDeletePayment(Long id);


    Payment updatePayment(Long id, Payment updatedPayment);

}
