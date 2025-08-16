package com.zawadig.myafwanii.Repository;//////////package com.zawadig.myafwanii.Repository;
//////////
//////////import com.zawadig.myafwanii.Model.ServicePayment;
//////////import org.springframework.data.jpa.repository.JpaRepository;
//////////import org.springframework.stereotype.Repository;
//////////
//////////import java.util.Optional;
//////////
//////////@Repository
//////////public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
//////////    Optional<ServicePayment> findByControlNumber(String controlNumber);
//////////}
////////package com.zawadig.myafwanii.Repository;
////////
////////import com.zawadig.myafwanii.Model.ServicePayment;
////////import org.springframework.data.jpa.repository.JpaRepository;
////////
////////public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
////////    boolean existsByControlNumber(String controlNumber);
////////}
//////package com.zawadig.myafwanii.Repository;
//////
//////import com.zawadig.myafwanii.Model.ServicePayment;
//////import org.springframework.data.jpa.repository.JpaRepository;
//////
//////import java.util.Optional;
//////
//////public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
//////    Optional<ServicePayment> findByControlNumber(String controlNumber);
//////}
////package com.zawadig.myafwanii.Repository;
////
////import com.zawadig.myafwanii.Model.ServicePayment;
////import org.springframework.data.jpa.repository.JpaRepository;
////
////import java.util.Optional;
////
////public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
////    Optional<ServicePayment> findByControlNumber(String controlNumber);
////}
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
//    Optional<ServicePayment> findByControlNumber(String controlNumber);
//
//}
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.dto.RequestWithPaymentDTO;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
//
//    Optional<ServicePayment> findByControlNumber(String controlNumber);
//// Ensure column exists in DB
//
//    @Query("SELECT new com.zawadig.myafwanii.dto.RequestWithPaymentDTO(" +
//            "r.id, u.fullName, r.phone, r.serviceType, r.description, r.status, " +
//            "sp.amountPaid, sp.paymentMethod, sp.paymentStatus) " +
//            "FROM ServicePayment sp " +
//            "JOIN sp.request r " +
//            "JOIN r.customer c " +
//            "JOIN c.user u")
//    List<RequestWithPaymentDTO> getAllRequestsWithPayments();
//}
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {
//
//    List<ServicePayment> findByPaymentStatus(PaymentStatus status); // ✅ correct
//
//    Optional<ServicePayment> findByControlNumber(String controlNumber);
//
//    static List<ServicePayment> findByCustomerIdAndPaymentStatus(Long customerId, PaymentStatus status) {
//        return null;
//    }
//
//
//    @Query("SELECT p FROM ServicePayment p JOIN FETCH p.requestForm")
//    List<ServicePayment> findAllWithRequestForms();
//}


import com.zawadig.myafwanii.Model.ServicePayment;
import com.zawadig.myafwanii.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicePaymentRepository extends JpaRepository<ServicePayment, Long> {

    List<ServicePayment> findByPaymentStatus(PaymentStatus status);

    Optional<ServicePayment> findByControlNumber(String controlNumber);

    List<ServicePayment> findByCustomerIdAndPaymentStatus(Long customerId, PaymentStatus status);

    // Hii ndiyo mpya kwa ajili ya status ya malipo ya request form na customer
    Optional<ServicePayment> findTopByRequestForm_IdAndCustomer_IdOrderByPaymentDateDesc(Long requestFormId, Long customerId);



        @Query("SELECT p FROM ServicePayment p WHERE p.customer.id = :customerId ORDER BY p.paymentDate DESC")
        List<ServicePayment> findByCustomerId(@Param("customerId") Long customerId);

    List<ServicePayment> findAllByOrderByPaymentDateDesc();
}
