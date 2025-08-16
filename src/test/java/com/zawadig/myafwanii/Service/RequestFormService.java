//////////// RequestFormService.java
//////////package com.zawadig.myafwanii.Service;
//////////
//////////import com.zawadig.myafwanii.Model.RequestForm;
//////////import com.zawadig.myafwanii.Repository.RequestFormRepository;
//////////import org.springframework.beans.factory.annotation.Autowired;
//////////import org.springframework.stereotype.Service;
//////////
//////////import java.util.List;
//////////import java.util.Optional;
//////////
//////////@Service
//////////public class RequestFormService {
//////////
//////////    @Autowired
//////////    private RequestFormRepository requestFormRepository;
//////////
//////////    public RequestForm saveRequestForm(RequestForm requestForm) {
//////////        return requestFormRepository.save(requestForm);
//////////    }
//////////
//////////    public List<RequestForm> getAllRequests() {
//////////        return requestFormRepository.findAll();
//////////    }
//////////
//////////    public Optional<RequestForm> getRequestById(Long id) {
//////////        return requestFormRepository.findById(id);
//////////    }
//////////
//////////    public List<RequestForm> getRequestsByCustomerId(Long customerId) {
//////////        return requestFormRepository.findByCustomerId(customerId);
//////////    }
//////////
//////////    public void deleteRequest(Long id) {
//////////        requestFormRepository.deleteById(id);
//////////    }
//////////}
////////package com.zawadig.myafwanii.Service;
////////
////////import com.zawadig.myafwanii.Model.RequestForm;
////////import com.zawadig.myafwanii.Repository.RequestFormRepository;
////////import org.springframework.beans.factory.annotation.Autowired;
////////import org.springframework.stereotype.Service;
////////
////////import java.util.List;
////////import java.util.Optional;
////////
////////@Service
////////public class RequestFormService {
////////
////////    @Autowired
////////    private RequestFormRepository requestFormRepository;
////////
////////    // Rename this method to 'save' for easier calling
////////    public RequestForm save(RequestForm requestForm) {
////////        return requestFormRepository.save(requestForm);
////////    }
////////
////////    public List<RequestForm> getAllRequests() {
////////        return requestFormRepository.findAll();
////////    }
////////
////////    public Optional<RequestForm> getRequestById(Long id) {
////////        return requestFormRepository.findById(id);
////////    }
////////
////////    public List<RequestForm> getRequestsByCustomerId(Long customerId) {
////////        return requestFormRepository.findByCustomerId(customerId);
////////    }
////////
////////    public void deleteRequest(Long id) {
////////        requestFormRepository.deleteById(id);
////////    }
////////
////////}
//////package com.zawadig.myafwanii.Service;
//////
//////import com.zawadig.myafwanii.Model.RequestForm;
//////import com.zawadig.myafwanii.Repository.RequestFormRepository;
//////import com.zawadig.myafwanii.dto.RequestWithPaymentDTO;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.stereotype.Service;
//////
//////import java.util.List;
//////import java.util.Optional;
//////
//////@Service
//////public class RequestFormService {
//////
//////    @Autowired
//////    private RequestFormRepository requestFormRepository;
//////
//////    // Hifadhi request form mpya
//////    public RequestForm save(RequestForm requestForm) {
//////        return requestFormRepository.save(requestForm);
//////    }
//////
//////    // Rudisha list ya request zote
//////    public List<RequestForm> getAllRequests() {
//////        return requestFormRepository.findAll();
//////    }
//////
//////    // Rudisha request moja kwa id
//////    public Optional<RequestForm> getRequestById(Long id) {
//////        return requestFormRepository.findById(id);
//////    }
//////
//////    // Rudisha list ya requests kwa customerId
//////    public List<RequestForm> getRequestsByCustomerId(Long customerId) {
//////        return requestFormRepository.findByCustomerId(customerId);
//////    }
//////
//////    // Futa request kwa id
//////    public void deleteRequest(Long id) {
//////        requestFormRepository.deleteById(id);
//////    }
//////
//////    public List<RequestWithPaymentDTO> getAllRequestsWithPayments() {
//////        return getAllRequestsWithPayments();
//////    }
//////}
//////package com.zawadig.myafwanii.Service;
//////
//////import com.zawadig.myafwanii.Model.RequestForm;
//////import com.zawadig.myafwanii.Repository.RequestFormRepository;
//////import com.zawadig.myafwanii.dto.RequestWithPaymentDTO;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.stereotype.Service;
//////
//////import java.util.List;
//////import java.util.Optional;
//////
//////@Service
//////public class RequestFormService {
//////
//////    @Autowired
//////    private RequestFormRepository requestFormRepository;
//////
//////    // Hifadhi request form mpya
//////    public RequestForm save(RequestForm requestForm) {
//////        return requestFormRepository.save(requestForm);
//////    }
//////
//////    // Rudisha list ya request zote
//////    public List<RequestForm> getAllRequests() {
//////        return requestFormRepository.findAll();
//////    }
//////
//////    // Rudisha request moja kwa id
//////    public Optional<RequestForm> getRequestById(Long id) {
//////        return requestFormRepository.findById(id);
//////    }
//////
//////    // Rudisha list ya requests kwa customerId
//////    public List<RequestForm> getRequestsByCustomerId(Long customerId) {
//////        return requestFormRepository.findByCustomerId(customerId);
//////    }
//////
//////    // Futa request kwa id
//////    public void deleteRequest(Long id) {
//////        requestFormRepository.deleteById(id);
//////    }
//////
//////    // Hii hapa ni method iliyorekebishwa, isiite yenyewe kwa recursion
//////    public List<RequestWithPaymentDTO> getAllRequestsWithPayments() {
//////        return requestFormRepository.findAllRequestsWithPayments();
//////    }
//////}
////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.RequestForm;
////import com.zawadig.myafwanii.Repository.RequestFormRepository;
////import com.zawadig.myafwanii.dto.RequestWithPaymentDTO;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class RequestFormService {
////
////    @Autowired
////    private RequestFormRepository requestFormRepository;
////
////    public RequestForm save(RequestForm requestForm) {
////        return requestFormRepository.save(requestForm);
////    }
////
////    public List<RequestForm> getAllRequests() {
////        return requestFormRepository.findAll();
////    }
////
////    public List<RequestWithPaymentDTO> getAllRequestsWithPayments() {
////        return requestFormRepository.findAllRequestsWithPayments();
////    }
////
////    public List<RequestForm> getRequestsByCustomerId(Long customerId) {
////        return requestFormRepository.findByCustomerId(customerId);
////    }
////
////    public void deleteRequest(Long id) {
////        requestFormRepository.deleteById(id);
////    }
////}
////package com.zawadig.myafwanii.Service;
////
////import com.zawadig.myafwanii.Model.RequestForm;
////import com.zawadig.myafwanii.Repository.RequestFormRepository;
////import com.zawadig.myafwanii.dto.RequestFormDTO;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////import java.util.List;
////import java.util.stream.Collectors;
////
////@Service
////public class RequestFormService {
////
////    @Autowired
////    private RequestFormRepository requestFormRepository;
////
////    public List<RequestForm> getAllRequests() {
////        return requestFormRepository.findAllWithPayments();
////    }
////
////    public List<RequestFormDTO> getAllRequestsAsDTO() {
////        return requestFormRepository.findAllWithPayments().stream()
////                .map(this::convertToDTO)
////                .collect(Collectors.toList());
////    }
////
////    private RequestFormDTO convertToDTO(RequestForm request) {
////        RequestFormDTO dto = new RequestFormDTO();
////        dto.setId(request.getId());
////        dto.setFullName(request.getFullName());
////        dto.setNationalId(request.getNationalId());
////        dto.setAddress(request.getAddress());
////        dto.setPhone(request.getPhone());
////        dto.setServiceType(request.getServiceType());
////        dto.setMeterType(request.getMeterType());
////        dto.setPicturePath(request.getPicturePath());
////        dto.setCreatedAt(request.getCreatedAt());
////
////        if (request.getCustomer() != null) {
////            dto.setCustomerId(request.getCustomer().getId());
////            dto.setCustomerName(request.getCustomer().getName());
////        }
////
////        return dto;
////    }
////
////
////
////}
//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class RequestFormService {
//
//    @Autowired
//    private RequestFormRepository requestFormRepository;
//
//    // Save a request form
//    public RequestForm save(RequestForm form) {
//        return requestFormRepository.save(form);
//    }
//
//    // Get all requests
//    public List<RequestForm> getAllRequests() {
//        return requestFormRepository.findAll();
//    }
//
//    // Get all requests as DTOs
//    public List<RequestFormDTO> getAllRequestsAsDTO() {
//        return requestFormRepository.findAll().stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    // Get request by ID
//    public RequestFormDTO getRequestById(Long id) {
//        Optional<RequestForm> request = requestFormRepository.findById(id);
//        return request.map(this::convertToDTO).orElse(null);
//    }
//
//    // Delete a request
//    public void deleteRequest(Long id) {
//        requestFormRepository.deleteById(id);
//    }
//
//    // Convert RequestForm to DTO
//    private RequestFormDTO convertToDTO(RequestForm request) {
//        RequestFormDTO dto = new RequestFormDTO();
//        dto.setId(request.getId());
//        dto.setFullName(request.getFullName());
//        dto.setNationalId(request.getNationalId());
//        dto.setAddress(request.getAddress());
//        dto.setPhone(request.getPhone());
//        dto.setServiceType(request.getServiceType());
//        dto.setMeterType(request.getMeterType());
//        dto.setPicturePath(request.getPicturePath());
//        dto.setCreatedAt(request.getCreatedAt());
//
//        if (request.getCustomer() != null) {
//            dto.setCustomerId(request.getCustomer().getId());
//            dto.setCustomerName(request.getCustomer().getName());
//        }
//
//        return dto;
//    }
//}
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class RequestFormService {
//
//    @Autowired
//    private RequestFormRepository requestFormRepository;
//
//    @Transactional
//    public RequestForm save(RequestForm form) {
//        return requestFormRepository.save(form);
//    }
//
//    // Using standard findAll() - choose this if you don't need payment info
//    public List<RequestForm> getAllRequests() {
//        return requestFormRepository.findAll();
//    }
//
//    // Using custom query with payments - choose this if you need payment info
//    public List<RequestForm> getAllRequestsWithPayments() {
//        return requestFormRepository.findAllWithPayments();
//    }
//
//    public List<RequestFormDTO> getAllRequestsAsDTO() {
//        // Choose either findAll() or findAllWithPayments() based on your needs
//        return requestFormRepository.findAll().stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public RequestFormDTO getRequestById(Long id) {
//        Optional<RequestForm> request = requestFormRepository.findById(id);
//        return request.map(this::convertToDTO).orElse(null);
//    }
//
//    @Transactional
//    public void deleteRequest(Long id) {
//        requestFormRepository.deleteById(id);
//    }
//
//    private RequestFormDTO convertToDTO(RequestForm request) {
//        RequestFormDTO dto = new RequestFormDTO();
//        dto.setId(request.getId());
//        dto.setFullName(request.getFullName());
//        dto.setNationalId(request.getNationalId());
//        dto.setAddress(request.getAddress());
//        dto.setPhone(request.getPhone());
//        dto.setServiceType(request.getServiceType());
//        dto.setMeterType(request.getMeterType());
//        dto.setPicturePath(request.getPicturePath());
//        dto.setCreatedAt(request.getCreatedAt());
//
//        if (request.getCustomer() != null) {
//            dto.setCustomerId(request.getCustomer().getId());
//            dto.setCustomerName(request.getCustomer().getName());
//        }
//
//        return dto;
//    }
//
//    public <T> ScopedValue<T> getRequestByIdEntity(Long requestId) {
//    }
//}
//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import com.zawadig.myafwanii.enums.RequestStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class RequestFormService {
//
//    @Autowired
//    private RequestFormRepository requestFormRepository;
//
//    @Transactional
//    public RequestForm save(RequestForm form) {
//        return requestFormRepository.save(form);
//    }
//
//    public List<RequestFormDTO> getAllRequestsAsDTO() {
//        return requestFormRepository.findAll().stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public Optional<RequestForm> getRequestByIdEntity(Long id) {
//        return requestFormRepository.findById(id);
//    }
//
//    public RequestFormDTO getRequestById(Long id) {
//        Optional<RequestForm> request = requestFormRepository.findById(id);
//        return request.map(this::convertToDTO).orElse(null);
//    }
//
//    @Transactional
//    public void deleteRequest(Long id) {
//        requestFormRepository.deleteById(id);
//    }
//
//    @Transactional
//    public RequestForm verifyRequest(Long requestId) {
//        RequestForm form = requestFormRepository.findById(requestId)
//                .orElseThrow(() -> new RuntimeException("Request not found"));
//
//        if (form.getStatus() == RequestStatus.VERIFIED) {
//            throw new RuntimeException("Request already verified");
//        }
//
//        // Update status
//        form.setStatus(RequestStatus.VERIFIED);
//
//        // Generate control number
//        String controlNumber = "CTRL-" + System.currentTimeMillis();
//        form.setControlNumber(controlNumber);
//
//        // TODO: send notification to customer (optional)
//        // notificationService.notifyCustomer(form.getCustomer().getId(),
//        // "Request verified! Control Number: " + controlNumber);
//
//        return requestFormRepository.save(form);
//    }
//
//    private RequestFormDTO convertToDTO(RequestForm request) {
//        RequestFormDTO dto = new RequestFormDTO();
//        dto.setId(request.getId());
//        dto.setFullName(request.getFullName());
//        dto.setNationalId(request.getNationalId());
//        dto.setAddress(request.getAddress());
//        dto.setPhone(request.getPhone());
//        dto.setServiceType(request.getServiceType());
//        dto.setMeterType(request.getMeterType());
//        dto.setPicturePath(request.getPicturePath());
//        dto.setCreatedAt(request.getCreatedAt());
//        dto.setStatus(request.getStatus());
//        dto.setControlNumber(request.getControlNumber());
//
//        if (request.getCustomer() != null) {
//            dto.setCustomerId(request.getCustomer().getId());
//            dto.setCustomerName(request.getCustomer().getName());
//        }
//
//        return dto;
//    }
//}

//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import com.zawadig.myafwanii.enums.RequestStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class RequestFormService {
//
//    @Autowired
//    private RequestFormRepository requestFormRepository;
//
//    @Transactional
//    public RequestForm save(RequestForm form) {
//        return requestFormRepository.save(form);
//    }
//
//    public List<RequestFormDTO> getAllRequestsAsDTO() {
//        return requestFormRepository.findAll().stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    // === NEW METHOD: Get requests by customer ID ===
//    public List<RequestFormDTO> getRequestsByCustomerId(Long customerId) {
//        return requestFormRepository.findByCustomerId(customerId).stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public Optional<RequestForm> findById(Long id) {
//        return requestFormRepository.findById(id);
//    }
//
//    public RequestFormDTO getRequestById(Long id) {
//        Optional<RequestForm> request = requestFormRepository.findById(id);
//        return request.map(this::convertToDTO).orElse(null);
//    }
//
//    // === NEW METHOD: Find request by ID and customer ID ===
//    public RequestForm findByIdAndCustomerId(Long id, Long customerId) {
//        return requestFormRepository.findByIdAndCustomerId(id, customerId)
//                .orElseThrow(() -> new RuntimeException("Request not found for this customer"));
//    }
//
//    @Transactional
//    public void deleteRequest(Long id) {
//        requestFormRepository.deleteById(id);
//    }
//
//    @Transactional
//    public RequestForm verifyRequest(Long requestId) {
//        RequestForm form = requestFormRepository.findById(requestId)
//                .orElseThrow(() -> new RuntimeException("Request not found"));
//
//        if (form.getStatus() == RequestStatus.VERIFIED) {
//            throw new RuntimeException("Request already verified");
//        }
//
//        // Generate control number using ID
//        String controlNumber = "TZN-" + String.format("%06d", form.getId());
//        form.setControlNumber(controlNumber);
//        form.setStatus(RequestStatus.VERIFIED);
//
//        return requestFormRepository.save(form);
//    }
//
//    private RequestFormDTO convertToDTO(RequestForm request) {
//        RequestFormDTO dto = new RequestFormDTO();
//        dto.setId(request.getId());
//        dto.setFullName(request.getFullName());
//        dto.setNationalId(request.getNationalId());
//        dto.setAddress(request.getAddress());
//        dto.setPhone(request.getPhone());
//        dto.setServiceType(request.getServiceType());
//        dto.setMeterType(request.getMeterType());
//        dto.setPicturePath(request.getPicturePath());
//        dto.setCreatedAt(request.getCreatedAt());
//
//        // === ADD STATUS AND CONTROL NUMBER TO DTO ===
//        dto.setStatus(request.getStatus());
//        dto.setControlNumber(request.getControlNumber());
//
//        if (request.getCustomer() != null) {
//            dto.setCustomerId(request.getCustomer().getId());
//            dto.setCustomerName(request.getCustomer().getName());
//        }
//
//        return dto;
//    }
//
//}

package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.RequestForm;
import com.zawadig.myafwanii.Repository.RequestFormRepository;
import com.zawadig.myafwanii.dto.RequestFormDTO;
import com.zawadig.myafwanii.enums.RequestStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RequestFormService {

    @Autowired
    private RequestFormRepository requestFormRepository;

    @Transactional
    public RequestForm save(RequestForm form) {
        return requestFormRepository.save(form);
    }

    public List<RequestFormDTO> getAllRequestsAsDTO() {
        return requestFormRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // =================== NEW METHOD =====================
    public List<RequestFormDTO> getRequestsByCustomerId(Long customerId) {
        List<RequestForm> requests = requestFormRepository.findByCustomerId(customerId);

        return requests.stream().map(req -> {
            RequestFormDTO dto = new RequestFormDTO();
            dto.setId(req.getId());
            dto.setFullName(req.getFullName());
            dto.setNationalId(req.getNationalId());
            dto.setAddress(req.getAddress());
            dto.setPhone(req.getPhone());
            dto.setServiceType(req.getServiceType());
            dto.setMeterType(req.getMeterType());
            dto.setPicturePath(req.getPicturePath());
            dto.setStatus(req.getStatus());
            dto.setControlNumber(req.getControlNumber());
            if (req.getCustomer() != null) {
                dto.setCustomerId(req.getCustomer().getId());
                dto.setCustomerName(req.getCustomer().getName());
            }
            return dto;
        }).collect(Collectors.toList());
    }


    public Optional<RequestForm> findById(Long id) {
        return requestFormRepository.findById(id);
    }

    public RequestFormDTO getRequestById(Long id) {
        Optional<RequestForm> request = requestFormRepository.findById(id);
        return request.map(this::convertToDTO).orElse(null);
    }

    public RequestForm findByIdAndCustomerId(Long id, Long customerId) {
        return requestFormRepository.findByIdAndCustomerId(id, customerId)
                .orElseThrow(() -> new RuntimeException("Request not found for this customer"));
    }

    @Transactional
    public void deleteRequest(Long id) {
        requestFormRepository.deleteById(id);
    }

    @Transactional
    public RequestForm verifyRequest(Long requestId) {
        RequestForm form = requestFormRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Request not found"));

        // Hakikisha customer yupo
        if (form.getCustomer() == null) {
            throw new IllegalStateException("Request has no customer assigned");
        }

        if(form.getControlNumber() == null) {
            String controlNumber = "CTRL-" + UUID.randomUUID().toString().substring(0, 8);
            form.setControlNumber(controlNumber);
        }

        form.setStatus(RequestStatus.VERIFIED);
        return requestFormRepository.save(form);
    }
    private RequestFormDTO convertToDTO(RequestForm request) {
        RequestFormDTO dto = new RequestFormDTO();
        dto.setId(request.getId());
        dto.setFullName(request.getFullName());
        dto.setNationalId(request.getNationalId());
        dto.setAddress(request.getAddress());
        dto.setPhone(request.getPhone());
        dto.setServiceType(request.getServiceType());
        dto.setMeterType(request.getMeterType());
        dto.setPicturePath(request.getPicturePath());
        dto.setCreatedAt(request.getCreatedAt());

        dto.setStatus(request.getStatus());
        dto.setControlNumber(request.getControlNumber());

        if (request.getCustomer() != null) {
            dto.setCustomerId(request.getCustomer().getId());
            dto.setCustomerName(request.getCustomer().getName());
        }

        return dto;
    }
}
