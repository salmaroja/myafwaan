//package com.zawadig.myafwanii.Repository;
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
package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // Requests ambazo hazijafutwa soft delete
    List<Request> findByDeletedFalse();

    // Requests ambazo zimesoft deleted (deleted = true)
    List<Request> findByDeletedTrue();
}
