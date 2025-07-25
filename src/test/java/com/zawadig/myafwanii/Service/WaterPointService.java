package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.WaterPoint;
import com.zawadig.myafwanii.Repository.WaterPointRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WaterPointService {

    private final WaterPointRepository repository;

    public WaterPointService(WaterPointRepository repository) {
        this.repository = repository;
    }

    public List<WaterPoint> getWithinBounds(Double minLat, Double maxLat, Double minLng, Double maxLng) {
        return repository.findWithinBounds(minLat, maxLat, minLng, maxLng);
    }

    public WaterPoint create(WaterPoint waterPoint) {
        return repository.save(waterPoint);
    }
}