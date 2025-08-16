package com.zawadig.myafwanii.Service;


import com.zawadig.myafwanii.Model.TechnicianServiceReport;
import com.zawadig.myafwanii.Repository.TechnicianServiceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianServiceReportService {

    @Autowired
    private TechnicianServiceReportRepository technicianServiceReportRepository;

    public List<TechnicianServiceReport> getAllReports() {
        return technicianServiceReportRepository.findAll();
    }

    public TechnicianServiceReport getReportById(Long id) {
        return technicianServiceReportRepository.findById(id).orElse(null);
    }

    public TechnicianServiceReport saveReport(TechnicianServiceReport report) {
        return technicianServiceReportRepository.save(report);
    }
}
