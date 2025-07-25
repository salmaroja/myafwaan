package com.zawadig.myafwanii.Controller;


import com.zawadig.myafwanii.Model.Staff;
import com.zawadig.myafwanii.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
//@CrossOrigin(origins = "*") // Ruhusu API ipatikane kwenye frontend yoyote
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Create Staff
    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.saveStaff(staff));
    }

    // Get All Staff
    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    // Get Staff by ID
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Staff staff = staffService.getStaffById(id);
        return staff != null ? ResponseEntity.ok(staff) : ResponseEntity.notFound().build();
    }

    // Update Staff
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff updatedStaff) {
        Staff staff = staffService.updateStaff(id, updatedStaff);
        return staff != null ? ResponseEntity.ok(staff) : ResponseEntity.notFound().build();
    }

    // Delete Staff
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/dashboard/summary")
    public ResponseEntity<Map<String, Object>> getDashboardSummary() {
        Map<String, Object> summary = staffService.getDashboardSummary();
        return ResponseEntity.ok(summary);
    }

}
