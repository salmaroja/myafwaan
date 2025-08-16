package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.TechnicianServiceReport;
import com.zawadig.myafwanii.Service.TechnicianServiceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technician-reports")
@CrossOrigin(origins = "*")
public class TechnicianServiceReportController {

    @Autowired
    private TechnicianServiceReportService technicianServiceReportService;

    // Admin: View all reports
    @GetMapping("/all")
    public ResponseEntity<List<TechnicianServiceReport>> getAllReports() {
        List<TechnicianServiceReport> reports = technicianServiceReportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // Optional: Technician can create new report (if not created yet)
    @PostMapping("/create")
    public ResponseEntity<TechnicianServiceReport> createReport(@RequestBody TechnicianServiceReport report) {
        TechnicianServiceReport created = technicianServiceReportService.saveReport(report);
        return ResponseEntity.ok(created);
    }

    // Optional: Get single report by ID
    @GetMapping("/{id}")
    public ResponseEntity<TechnicianServiceReport> getReportById(@PathVariable Long id) {
        TechnicianServiceReport report = technicianServiceReportService.getReportById(id);
        return ResponseEntity.ok(report);
    }
}
