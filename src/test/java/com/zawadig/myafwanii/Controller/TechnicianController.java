package com.zawadig.myafwanii.Controller;




import com.zawadig.myafwanii.Model.Technician;
import com.zawadig.myafwanii.Service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
//@CrossOrigin(origins = "*")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PostMapping
    public Technician createTechnician(@RequestBody Technician technician) {
        return technicianService.saveTechnician(technician);
    }

    @GetMapping("/technician")
    public List<Technician> getAllTechnicians() {
        return technicianService.getAllTechnicians();
    }

    @GetMapping("/{id}")
    public Technician getTechnicianById(@PathVariable Long id) {
        return technicianService.getTechnicianById(id);
    }

    @PutMapping("/{id}")
    public Technician updateTechnician(@PathVariable Long id, @RequestBody Technician technician) {
        return technicianService.updateTechnician(id, technician);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnician(@PathVariable Long id) {
        technicianService.deleteTechnician(id);
    }
}
