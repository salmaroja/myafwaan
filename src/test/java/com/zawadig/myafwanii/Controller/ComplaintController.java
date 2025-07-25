//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Complaint;
//import com.zawadig.myafwanii.Service.ComplaintService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/complaints")
////@CrossOrigin(origins = "*") // Con/sider restricting origins in production
//public class ComplaintController {
//
//    @Autowired
//    private ComplaintService complaintService;
//
//    // 🔹 1. Create new complaint
//    @PostMapping
//    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
//        Complaint savedComplaint = complaintService.saveComplaint(complaint);
//        return ResponseEntity.ok(savedComplaint);
//    }
//
//    // 🔹 2. Get all complaints
//    @GetMapping
//    public ResponseEntity<List<Complaint>> getAllComplaints() {
//        List<Complaint> complaints = complaintService.getAllComplaints();
//        return ResponseEntity.ok(complaints);
//    }
//
//    // 🔹 3. Get complaint by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
//        Complaint complaint = complaintService.getComplaintById(id);
//        if (complaint != null) {
//            return ResponseEntity.ok(complaint);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // 🔹 4. Get complaints by customer ID
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<Complaint>> getComplaintsByCustomer(@PathVariable Long customerId) {
//        List<Complaint> complaints = complaintService.getComplaintsByCustomerId(customerId);
//        return ResponseEntity.ok(complaints);
//    }
//
//    // 🔹 5. Get complaints by status
//    @GetMapping("/status/{status}")
//    public ResponseEntity<List<Complaint>> getComplaintsByStatus(@PathVariable String status) {
//        List<Complaint> complaints = complaintService.getComplaintsByStatus(status);
//        return ResponseEntity.ok(complaints);
//    }
//
//    // 🔹 6. Update full complaint record
//    @PutMapping("/{id}")
//    public ResponseEntity<Complaint> updateComplaint(
//            @PathVariable Long id,
//            @RequestBody Complaint updatedComplaint
//    ) {
//        Complaint complaint = complaintService.updateComplaint(id, updatedComplaint);
//        if (complaint != null) {
//            return ResponseEntity.ok(complaint);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // 🔹 7. Update only status
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Complaint> updateComplaintStatus(
//            @PathVariable Long id,
//            @RequestBody Complaint updatedStatus
//    ) {
//        Complaint complaint = complaintService.updateComplaintStatus(id, updatedStatus.getStatus());
//        if (complaint != null) {
//            return ResponseEntity.ok(complaint);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // 🔹 8. Delete complaint
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
//        complaintService.deleteComplaint(id);
//        return ResponseEntity.noContent().build();
//    }
//}

package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Complaint;
import com.zawadig.myafwanii.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
//@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint savedComplaint = complaintService.saveComplaint(complaint);
        return ResponseEntity.ok(savedComplaint);
    }

    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return ResponseEntity.ok(complaints);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Complaint complaint = complaintService.getComplaintById(id);
        return (complaint != null) ? ResponseEntity.ok(complaint) : ResponseEntity.notFound().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Complaint>> getComplaintsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(complaintService.getComplaintsByCustomerId(customerId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Complaint>> getComplaintsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(complaintService.getComplaintsByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(
            @PathVariable Long id,
            @RequestBody Complaint updatedComplaint
    ) {
        Complaint complaint = complaintService.updateComplaint(id, updatedComplaint);
        return (complaint != null) ? ResponseEntity.ok(complaint) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Complaint> updateComplaintStatus(
            @PathVariable Long id,
            @RequestBody Complaint updatedStatus
    ) {
        Complaint complaint = complaintService.updateComplaintStatus(id, updatedStatus.getStatus());
        return (complaint != null) ? ResponseEntity.ok(complaint) : ResponseEntity.notFound().build();
    }

    // 🔥 Soft delete endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDeleteComplaint(
            @PathVariable Long id,
            @RequestParam(defaultValue = "admin") String deletedBy
    ) {
        boolean deleted = complaintService.softDeleteComplaint(id, deletedBy);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // 🗑 Get complaints from recycle bin
    @GetMapping("/bin")
    public ResponseEntity<List<Complaint>> getDeletedComplaints() {
        return ResponseEntity.ok(complaintService.getDeletedComplaints());
    }

    // 🔁 Restore complaint
    @PutMapping("/restore/{id}")
    public ResponseEntity<?> restoreComplaint(@PathVariable Long id) {
        boolean restored = complaintService.restoreComplaint(id);
        return restored ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
