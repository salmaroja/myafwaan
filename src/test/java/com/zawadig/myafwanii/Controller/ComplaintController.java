package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Complaint;
import com.zawadig.myafwanii.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
//@CrossOrigin(origins = "*") // Con/sider restricting origins in production
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // 🔹 1. Create new complaint
    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint savedComplaint = complaintService.saveComplaint(complaint);
        return ResponseEntity.ok(savedComplaint);
    }

    // 🔹 2. Get all complaints
    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(complaints);
    }

    // 🔹 3. Get complaint by ID
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Complaint complaint = complaintService.getComplaintById(id);
        if (complaint != null) {
            return ResponseEntity.ok(complaint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 4. Get complaints by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Complaint>> getComplaintsByCustomer(@PathVariable Long customerId) {
        List<Complaint> complaints = complaintService.getComplaintsByCustomerId(customerId);
        return ResponseEntity.ok(complaints);
    }

    // 🔹 5. Get complaints by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Complaint>> getComplaintsByStatus(@PathVariable String status) {
        List<Complaint> complaints = complaintService.getComplaintsByStatus(status);
        return ResponseEntity.ok(complaints);
    }

    // 🔹 6. Update full complaint record
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(
            @PathVariable Long id,
            @RequestBody Complaint updatedComplaint
    ) {
        Complaint complaint = complaintService.updateComplaint(id, updatedComplaint);
        if (complaint != null) {
            return ResponseEntity.ok(complaint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 7. Update only status
    @PutMapping("/{id}/status")
    public ResponseEntity<Complaint> updateComplaintStatus(
            @PathVariable Long id,
            @RequestBody Complaint updatedStatus
    ) {
        Complaint complaint = complaintService.updateComplaintStatus(id, updatedStatus.getStatus());
        if (complaint != null) {
            return ResponseEntity.ok(complaint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 8. Delete complaint
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.noContent().build();
    }
}
