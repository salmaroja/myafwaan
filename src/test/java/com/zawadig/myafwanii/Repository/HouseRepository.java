//package com.zawadig.myafwanii.Repository;
//
//import com.zawadig.myafwanii.Model.House;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface HouseRepository extends JpaRepository<House, Long> {
//    House findByHouseNumber(String houseNumber);
//    List<House> findByConnected(boolean connected);
//
//    List<String> findDistinctWards();
//
//    List<String> findDistinctStreetsByWard(String ward);
//
//    List<House> findByStreetNameAndDeletedFalse(String street);
//}
//
package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("SELECT DISTINCT h.ward FROM House h WHERE h.deleted = false")
    List<String> findDistinctWards();

    @Query("SELECT DISTINCT h.streetName FROM House h WHERE h.ward = :ward AND h.deleted = false")
    List<String> findDistinctStreetsByWard(@Param("ward") String ward);

    List<House> findByStreetNameAndDeletedFalse(String streetName);
}
