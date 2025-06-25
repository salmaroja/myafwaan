package com.zawadig.myafwanii.Service;



import com.zawadig.myafwanii.Model.Staff;
import com.zawadig.myafwanii.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    // Save staff
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    // Get all staff
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Get staff by ID
    public Staff getStaffById(Long id) {
        Optional<Staff> optional = staffRepository.findById(id);
        return optional.orElse(null);
    }

    // Update staff
    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff existing = getStaffById(id);
        if (existing != null) {
            existing.setName(updatedStaff.getName());
            existing.setEmail(updatedStaff.getEmail());
            existing.setSpecialization(updatedStaff.getSpecialization());
            existing.setPhone(updatedStaff.getPhone());
            existing.setUsername(updatedStaff.getUsername());
            existing.setPassword(updatedStaff.getPassword());
            existing.setEnabled(updatedStaff.isEnabled());
            existing.setPosition(updatedStaff.getPosition());
            return staffRepository.save(existing);
        }
        return null;
    }

    // Delete staff
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
