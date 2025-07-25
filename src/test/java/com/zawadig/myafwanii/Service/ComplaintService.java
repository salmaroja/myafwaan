//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Complaint;
//import com.zawadig.myafwanii.Repository.ComplaintRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ComplaintService {
//
//    @Autowired
//    private ComplaintRepository complaintRepository;
//
//    // Save a new complaint
//    public Complaint saveComplaint(Complaint complaint) {
//        return complaintRepository.save(complaint);
//    }
//
//    // Get all complaints
//    public List<Complaint> getAllComplaints() {
//        return complaintRepository.findAll();
//    }
//
//    // Get one complaint by ID
//    public Complaint getComplaintById(Long id) {
//        return complaintRepository.findById(id).orElse(null);
//    }
//
//    // Get complaints by customer ID
//    public List<Complaint> getComplaintsByCustomerId(Long customerId) {
//        return complaintRepository.findByCustomerId(customerId);
//    }
//
//    // Get complaints by status
//    public List<Complaint> getComplaintsByStatus(String status) {
//        return complaintRepository.findByStatus(status);
//    }
//
//    // Update whole complaint
//    public Complaint updateComplaint(Long id, Complaint updatedComplaint) {
//        Complaint existingComplaint = complaintRepository.findById(id).orElse(null);
//        if (existingComplaint != null) {
//            existingComplaint.setTitle(updatedComplaint.getTitle());
//            existingComplaint.setDescription(updatedComplaint.getDescription());
//            existingComplaint.setStatus(updatedComplaint.getStatus());
//            return complaintRepository.save(existingComplaint);
//        }
//        return null;
//    }
//
//    // Update status only
//    public Complaint updateComplaintStatus(Long id, String status) {
//        Complaint complaint = complaintRepository.findById(id).orElse(null);
//        if (complaint != null) {
//            complaint.setStatus(status);
//            return complaintRepository.save(complaint);
//        }
//        return null;
//    }
//
//    // Delete
//    public void deleteComplaint(Long id) {
//        complaintRepository.deleteById(id);
//    }
//} muuimu izo

package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Complaint;
import com.zawadig.myafwanii.Repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    // Save new complaint
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    // Get active complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAllActive();
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElse(null);
    }

    public List<Complaint> getComplaintsByCustomerId(Long customerId) {
        return complaintRepository.findByCustomerId(customerId);
    }

    public List<Complaint> getComplaintsByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }

    public Complaint updateComplaint(Long id, Complaint updatedComplaint) {
        Complaint existingComplaint = complaintRepository.findById(id).orElse(null);
        if (existingComplaint != null && !existingComplaint.isDeleted()) {
            existingComplaint.setTitle(updatedComplaint.getTitle());
            existingComplaint.setDescription(updatedComplaint.getDescription());
            existingComplaint.setStatus(updatedComplaint.getStatus());
            return complaintRepository.save(existingComplaint);
        }
        return null;
    }

    public Complaint updateComplaintStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        if (complaint != null && !complaint.isDeleted()) {
            complaint.setStatus(status);
            return complaintRepository.save(complaint);
        }
        return null;
    }

    // 🔥 Soft delete
    public boolean softDeleteComplaint(Long id, String deletedBy) {
        return complaintRepository.findById(id).map(complaint -> {
            complaint.setDeleted(true);
            complaint.setDeletedAt(LocalDateTime.now());
            complaint.setDeletedBy(deletedBy);
            complaintRepository.save(complaint);
            return true;
        }).orElse(false);
    }

    // 🔁 Restore from bin
    public boolean restoreComplaint(Long id) {
        return complaintRepository.findById(id).map(complaint -> {
            complaint.setDeleted(false);
            complaint.setDeletedAt(null);
            complaint.setDeletedBy(null);
            complaintRepository.save(complaint);
            return true;
        }).orElse(false);
    }

    // 🗑 Get recycle bin complaints
    public List<Complaint> getDeletedComplaints() {
        return complaintRepository.findAllDeleted();
    }
}

