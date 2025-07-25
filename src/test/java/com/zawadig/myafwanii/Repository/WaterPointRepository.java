package com.zawadig.myafwanii.Repository;

import com.zawadig.myafwanii.Model.WaterPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WaterPointRepository extends JpaRepository<WaterPoint, Long> {

    @Query("SELECT wp FROM WaterPoint wp WHERE " +
            "wp.latitude BETWEEN :minLat AND :maxLat AND " +
            "wp.longitude BETWEEN :minLng AND :maxLng")
    List<WaterPoint> findWithinBounds(
            @Param("minLat") Double minLat,
            @Param("maxLat") Double maxLat,
            @Param("minLng") Double minLng,
            @Param("maxLng") Double maxLng);
}