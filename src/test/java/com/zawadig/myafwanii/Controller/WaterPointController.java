package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.WaterPoint;
import com.zawadig.myafwanii.Service.WaterPointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/water-point")
public class WaterPointController {

    private final WaterPointService service;

    public WaterPointController(WaterPointService service) {
        this.service = service;
    }

    @GetMapping("/within-bounds")
    public ResponseEntity<List<WaterPoint>> getWithinBounds(
            @RequestParam Double minLat,
            @RequestParam Double maxLat,
            @RequestParam Double minLng,
            @RequestParam Double maxLng) {
        return ResponseEntity.ok(
                service.getWithinBounds(minLat, maxLat, minLng, maxLng)
        );
    }

    @PostMapping
    public ResponseEntity<WaterPoint> create(@RequestBody WaterPoint waterPoint) {
        return ResponseEntity.ok(service.create(waterPoint));
    }
}