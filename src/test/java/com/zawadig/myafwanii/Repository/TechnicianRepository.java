package com.zawadig.myafwanii.Repository;//package com.zawadig.myafwanii.Repository;
//
//
//
//import com.zawadig.myafwanii.Model.Technician;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface TechnicianRepository extends JpaRepository<Technician, Long> {
//    Technician findByEmail(String email);
//}
//
//

import com.zawadig.myafwanii.Model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    Optional<Technician> findByEmail(String email);
}
