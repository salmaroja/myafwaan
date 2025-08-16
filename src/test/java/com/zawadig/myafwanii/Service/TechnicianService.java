package com.zawadig.myafwanii.Service;



import com.zawadig.myafwanii.Model.Technician;
import com.zawadig.myafwanii.Repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public Technician saveTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Technician getTechnicianById(Long id) {
        return technicianRepository.findById(id).orElse(null);
    }

    public Technician updateTechnician(Long id, Technician updated) {
        Optional<Technician> optional = technicianRepository.findById(id);
        if (optional.isPresent()) {
            Technician existing = optional.get();
            existing.setName(updated.getName());
            existing.setPhone(updated.getPhone());
            existing.setSpecialization(updated.getSpecialization());
            existing.setEmail(updated.getEmail());
            existing.setUsername(updated.getUsername());
            existing.setPassword(updated.getPassword());
            existing.setEnabled(updated.isEnabled());
            // Ikiwa unataka update roles, fanya hivyo hapa
            // existing.setRoles(updated.getRoles());

            return technicianRepository.save(existing);
        }
        return null;
    }

    public void deleteTechnician(Long id) {
        technicianRepository.deleteById(id);
    }
}
