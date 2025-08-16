//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface SurveyRepository extends JpaRepository<Survey, Long> {
//
//    // Method nzuri, ina query, haitasababisha error
//    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
//            "s.id, s.location, s.notes, s.surveyDate, " +
//            "s.technician.id, rf.customer.id, rf.customer.name) " +
//            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c")
//    List<SurveyCustomerResponse> findAllWithCustomer();
//
//    // Method nzuri, ina query
//    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
//            "s.id, s.location, s.notes, s.surveyDate, " +
//            "s.technician.id, rf.customer.id, rf.customer.name) " +
//            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c " +
//            "WHERE s.technician.id = :technicianId")
//    List<SurveyCustomerResponse> findByTechnicianIdWithCustomer(@Param("technicianId") Long technicianId);
//
//    // Method nzuri, ina query
//    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
//            "s.id, s.location, s.notes, s.surveyDate, " +
//            "s.technician.id, rf.customer.id, rf.customer.name) " +
//            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c " +
//            "WHERE s.id = :surveyId")
//    Optional<SurveyCustomerResponse> findWithCustomerById(@Param("surveyId") Long surveyId);
//
//    // Method ya kawaida ya Survey (hakuna @Query, ni standard Spring Data JPA query derivation)
//    Survey findByRequestFormId(Long requestFormId);
//
//    List<SurveyCustomerResponse> findByCustomerIdWithCustomer(Long customerId);
//}
//
//
////
////import com.zawadig.myafwanii.Model.Survey;
////import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.data.jpa.repository.Query;
////import java.util.List;
////
////public interface SurveyRepository extends JpaRepository<Survey, Long> {
////
////    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
////            "s.id, s.location, s.notes, s.surveyDate, " +
////            "s.technicianId, c.id, c.name) " +
////            "FROM Survey s " +
////            "JOIN s.requestForm rf " +
////            "JOIN rf.customer c")
////    List<SurveyCustomerResponse> findAllWithCustomer();
////
////    List<SurveyCustomerResponse> findByTechnicianIdWithCustomer(Long technicianId);
////
////    <T> ScopedValue<T> findWithCustomerById(Long surveyId);
////}
//
//
////import com.zawadig.myafwanii.Model.Survey;
////import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
////import org.apache.el.stream.Optional;
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.data.jpa.repository.Query;
////import org.springframework.data.repository.query.Param;
////import org.springframework.stereotype.Repository;
////
////import java.util.List;
////
////@Repository
////public interface SurveyRepository extends JpaRepository<Survey, Long> {
////
////    // 1. Pata surveys zote na taarifa za mteja
////    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
////            "s.id, s.location, s.notes, s.surveyDate, " +
////            "s.technician.id, rf.customer.id, rf.customer.name) " + // Changed to name
////            "FROM Survey s JOIN s.requestForm rf")
////    List<SurveyCustomerResponse> findAllWithCustomer();
////
////    // 2. Pata surveys kwa fundi fulani
////    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
////            "s.id, s.location, s.notes, s.surveyDate, " +
////            "s.technician.id, rf.customer.id, rf.customer.name) " + // Changed to name
////            "FROM Survey s JOIN s.requestForm rf " +
////            "WHERE s.technician.id = :technicianId")
////    List<SurveyCustomerResponse> findByTechnicianIdWithCustomer(@Param("technicianId") Long technicianId);
////
////    // 3. Pata survey moja kwa ID yake
////    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
////            "s.id, s.location, s.notes, s.surveyDate, " +
////            "s.technician.id, rf.customer.id, rf.customer.name) " + // Changed to name
////            "FROM Survey s JOIN s.requestForm rf " +
////            "WHERE s.id = :surveyId")
////    Optional<SurveyCustomerResponse> findWithCustomerById(@Param("surveyId") Long surveyId);
////
////    // 4. Pata survey kwa requestFormId
////    Survey findByRequestFormId(Long requestFormId);
////
////    // 5. Pata surveys za mteja fulani
////    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
////            "s.id, s.location, s.notes, s.surveyDate, " +
////            "s.technician.id, rf.customer.id, rf.customer.name) " + // Changed to name
////            "FROM Survey s JOIN s.requestForm rf " +
////            "WHERE rf.customer.id = :customerId")
////    List<SurveyCustomerResponse> findByCustomerIdWithDetails(@Param("customerId") Long customerId);
////
////    // 6. Pata surveys za mteja kwa status fulani
////    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
////            "s.id, s.location, s.notes, s.surveyDate, " +
////            "s.technician.id, rf.customer.id, rf.customer.name) " + // Changed to name
////            "FROM Survey s JOIN s.requestForm rf " +
////            "WHERE rf.customer.id = :customerId AND s.surveyStatus = :status")
////    List<SurveyCustomerResponse> findByCustomerIdAndStatusWithDetails(
////            @Param("customerId") Long customerId,
////            @Param("status") String status);
////}







package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Survey;
import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
            "s.id, s.location, s.notes, s.surveyDate, " +
            "s.technician.id, rf.customer.id, rf.customer.name) " +
            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c")
    List<SurveyCustomerResponse> findAllWithCustomer();

    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
            "s.id, s.location, s.notes, s.surveyDate, " +
            "s.technician.id, rf.customer.id, rf.customer.name) " +
            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c " +
            "WHERE s.technician.id = :technicianId")
    List<SurveyCustomerResponse> findByTechnicianIdWithCustomer(@Param("technicianId") Long technicianId);

    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
            "s.id, s.location, s.notes, s.surveyDate, " +
            "s.technician.id, rf.customer.id, rf.customer.name) " +
            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c " +
            "WHERE s.id = :surveyId")
    Optional<SurveyCustomerResponse> findWithCustomerById(@Param("surveyId") Long surveyId);

    @Query("SELECT new com.zawadig.myafwanii.dto.SurveyCustomerResponse(" +
            "s.id, s.location, s.notes, s.surveyDate, " +
            "s.technician.id, rf.customer.id, rf.customer.name) " +
            "FROM Survey s JOIN s.requestForm rf JOIN rf.customer c " +
            "WHERE rf.customer.id = :customerId")
    List<SurveyCustomerResponse> findByCustomerIdWithCustomer(@Param("customerId") Long customerId);

    Survey findByRequestFormId(Long requestFormId);
    // Method ya kupata surveys zote za customer mmoja
    List<Survey> findByCustomerId(Long customerId);
}