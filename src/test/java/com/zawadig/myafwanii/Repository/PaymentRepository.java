////////////package com.zawadig.myafwanii.Repository;
////////////
////////////import com.zawadig.myafwanii.Model.Payment;
////////////import org.springframework.data.jpa.repository.JpaRepository;
////////////import org.springframework.data.jpa.repository.Query;
////////////import org.springframework.data.repository.query.Param;
////////////
////////////import java.util.Optional;
////////////
////////////public interface PaymentRepository extends JpaRepository<Payment, Long> {
////////////
////////////    // ✅ Custom query to find payment by meter number directly from Payment table
////////////    @Query("SELECT p FROM Payment p WHERE p.meterNumber = :meterNumber")
////////////    Optional<Payment> findByMeterNumber(@Param("meterNumber") String meterNumber);
////////////
////////////    // ✅ Find by control number (used during confirmation)
////////////    Optional<Payment> findByControlNumber(String controlNumber);
////////////}
//////////
//////////package com.zawadig.myafwanii.Repository;
//////////
//////////import com.zawadig.myafwanii.Model.Payment;
//////////import org.springframework.data.jpa.repository.JpaRepository;
//////////import org.springframework.data.jpa.repository.Query;
//////////import org.springframework.data.repository.query.Param;
//////////
//////////import java.util.List;
//////////import java.util.Optional;
//////////
//////////public interface PaymentRepository extends JpaRepository<Payment, Long> {
//////////
//////////    // Tafuta kwa meter number (ambazo hazijafutwa)
//////////    @Query("SELECT p FROM Payment p WHERE p.meterNumber = :meterNumber AND p.deleted = false")
//////////    Optional<Payment> findByMeterNumber(@Param("meterNumber") String meterNumber);
//////////
//////////    // Tafuta kwa control number (ambazo hazijafutwa)
//////////    @Query("SELECT p FROM Payment p WHERE p.controlNumber = :controlNumber AND p.deleted = false")
//////////    Optional<Payment> findByControlNumber(@Param("controlNumber") String controlNumber);
//////////
//////////    // ✅ Orodha ya malipo yote ambayo hayajafutwa
//////////    @Query("SELECT p FROM Payment p WHERE p.deleted = false")
//////////    List<Payment> findAllActivePayments();
//////////
//////////    // ✅ Orodha ya malipo yote ambayo yamefutwa (Recycle Bin)
//////////    @Query("SELECT p FROM Payment p WHERE p.deleted = true")
//////////    List<Payment> findAllDeletedPayments();
//////////}
////////////
////////package com.zawadig.myafwanii.Repository;
////////
////////import com.zawadig.myafwanii.Model.Payment;
////////import org.springframework.data.jpa.repository.JpaRepository;
////////import org.springframework.data.jpa.repository.Query;
////////import org.springframework.data.repository.query.Param;
////////
////////import java.util.List;
////////import java.util.Optional;
////////
////////public interface PaymentRepository extends JpaRepository<Payment, Long> {
////////
////////    // Tafuta payment kwa meter number (ambazo si deleted)
////////    @Query("SELECT p FROM Payment p WHERE p.meterNumber = :meterNumber AND p.deleted = false")
////////    Optional<Payment> findByMeterNumber(@Param("meterNumber") String meterNumber);
////////
////////    // Tafuta payment kwa control number (ambazo si deleted)
////////    @Query("SELECT p FROM Payment p WHERE p.controlNumber = :controlNumber AND p.deleted = false")
////////    Optional<Payment> findByControlNumber(@Param("controlNumber") String controlNumber);
////////
////////    // Malipo yote ambayo hayajafutwa (active)
////////    @Query("SELECT p FROM Payment p WHERE p.deleted = false")
////////    List<Payment> findAllActivePayments();
////////
////////    // Malipo yote yaliyofutwa (soft deleted)
////////    @Query("SELECT p FROM Payment p WHERE p.deleted = true")
////////    List<Payment> findAllDeletedPayments();
////////}
//////package com.zawadig.myafwanii.Repository;
//////
//////import com.zawadig.myafwanii.Model.Payment;
//////import org.springframework.data.jpa.repository.JpaRepository;
//////import org.springframework.stereotype.Repository;
//////
//////import java.util.List;
//////
//////@Repository
//////public interface PaymentRepository extends JpaRepository<Payment, Long> {
//////    Payment findByRequestId(String requestId);
//////    List<Payment> findByCustomerId(Long customerId);
//////    Payment findByControlNumber(String controlNumber);
//////}
////package com.zawadig.myafwanii.Repository;
////
////import com.zawadig.myafwanii.Model.Payment;
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.data.jpa.repository.Query;
////import org.springframework.stereotype.Repository;
////
////import java.util.List;
////import java.util.Optional;
////
////@Repository
////public interface PaymentRepository extends JpaRepository<Payment, Long> {
////
////    Optional<Payment> findByControlNumber(String controlNumber);
////
////    Payment findByRequestId(String requestId);
////
////    List<Payment> findByCustomerId(Long customerId);
////
////    // Payments that are not soft deleted
////    @Query("SELECT p FROM Payment p WHERE p.deleted = false")
////    List<Payment> findAllActivePayments();
////
////    // Payments that are soft deleted
////    @Query("SELECT p FROM Payment p WHERE p.deleted = true")
////    List<Payment> findAllDeletedPayments();
////
////}
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Payment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface PaymentRepository extends JpaRepository<Payment, Long> {
//
//    Optional<Payment> findByControlNumber(String controlNumber);
//
//    // ✅ Badala ya single payment, tumia list
//    List<Payment> findByRequestId(String requestId);
//
//    List<Payment> findByCustomerId(Long customerId);
//
//    // Payments that are not soft deleted
//    @Query("SELECT p FROM Payment p WHERE p.deleted = false")
//    List<Payment> findAllActivePayments();
//
//    // Payments that are soft deleted
//    @Query("SELECT p FROM Payment p WHERE p.deleted = true")
//    List<Payment> findAllDeletedPayments();
//}
package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Tafuta kwa control number
    Optional<Payment> findByControlNumber(String controlNumber);

    // ✅ Sahihi: Tumia List kwa requestId (kwa kuwa inaweza kurudisha zaidi ya moja)
    List<Payment> findByRequestId(String requestId);

    // Tafuta malipo ya mteja
    List<Payment> findByCustomerId(Long customerId);

    // Malipo ambayo hayajafutwa (soft delete = false)
    @Query("SELECT p FROM Payment p WHERE p.deleted = false")
    List<Payment> findAllActivePayments();

    // Malipo ambayo yamefutwa (soft delete = true)
    @Query("SELECT p FROM Payment p WHERE p.deleted = true")
    List<Payment> findAllDeletedPayments();
}
