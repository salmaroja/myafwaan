package com.zawadig.myafwanii.Repository;




import com.zawadig.myafwanii.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // Hakuna mbinu za ziada, JpaRepository inatoa findAll, findById, save, deleteById, n.k.
}

