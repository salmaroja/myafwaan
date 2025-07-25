// RequestFormRepository.java
package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.RequestForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestFormRepository extends JpaRepository<RequestForm, Long> {
    List<RequestForm> findByCustomerId(Long customerId);
}
