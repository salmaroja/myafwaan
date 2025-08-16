package com.zawadig.myafwanii.Repository;//package com.zawadig.myafwanii.Repository;
//
//
//
//
//import com.zawadig.myafwanii.Model.Request;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface RequestRepository extends JpaRepository<Request, Long> {
////    List<Request> findByStatusIgnoreCase(String status);
//}
//    // Hakuna mbinu za ziada, JpaRepository inatoa findAll, findById, save, deleteById, n.k.
//
//
//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.Request;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface RequestRepository extends JpaRepository<Request, Long> {
//    // Requests ambazo hazijafutwa soft delete
//    List<Request> findByDeletedFalse();
//
//    // Requests ambazo zimesoft deleted (deleted = true)
//    List<Request> findByDeletedTrue();
//}


import com.zawadig.myafwanii.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    // This will automatically exclude deleted records
    @Query("SELECT r FROM Request r WHERE r.deleted = false")
    List<Request> findAllActive();

    // For when you need to include deleted records
    @Query("SELECT r FROM Request r WHERE r.deleted = true")
    List<Request> findAllDeleted();

    // Override default methods to include the soft delete filter
    @Override
    @Query("SELECT r FROM Request r WHERE r.id = :id AND r.deleted = false")
    Optional<Request> findById(@Param("id") Long id);

    List<Request> findByDeletedFalse();

    List<Request> findByDeletedTrue();
}
