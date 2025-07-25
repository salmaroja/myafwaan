//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Request;
//import com.zawadig.myafwanii.Repository.RequestRepository;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//@Service
//public class RequestServiceImpl implements RequestService {
//
//    private final RequestRepository requestRepository;
//
//    public RequestServiceImpl(RequestRepository requestRepository) {
//        this.requestRepository = requestRepository;
//    }
//
//    @Override
//    public List<Request> getAllRequests() {
//        return requestRepository.findAll();
//    }
//
//    @Override
//    public List<Request> getDeletedRequests() {
//        return null;
//    }
//
//    @Override
//    public Optional<Request> getRequestById(Long id) {
//        return requestRepository.findById(id);
//    }
//
//    @Override
//    public Request createRequest(Request request) {
//        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
//            throw new IllegalArgumentException("Customer name is required.");
//        }
//        if (request.getAddress() == null || request.getAddress().isBlank()) {
//            throw new IllegalArgumentException("Address is required.");
//        }
//        if (request.getRequestType() == null || request.getRequestType().isBlank()) {
//            throw new IllegalArgumentException("Request type is required.");
//        }
//
//        if (request.getStatus() == null || request.getStatus().isBlank()) {
//            request.setStatus("Pending");
//        }
//
//        if (request.getRequestDate() == null) {
//            request.setRequestDate(LocalDate.now());
//        }
//
//        return requestRepository.save(request);
//    }
//
//    @Override
//    public Request updateRequest(Long id, Request requestDetails) {
//        Request existing = requestRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Request not found with id " + id));
//
//        if (requestDetails.getCustomerName() != null && !requestDetails.getCustomerName().isBlank()) {
//            existing.setCustomerName(requestDetails.getCustomerName());
//        }
//        if (requestDetails.getAddress() != null && !requestDetails.getAddress().isBlank()) {
//            existing.setAddress(requestDetails.getAddress());
//        }
//        if (requestDetails.getRequestType() != null && !requestDetails.getRequestType().isBlank()) {
//            existing.setRequestType(requestDetails.getRequestType());
//        }
//        if (requestDetails.getDescription() != null) {
//            existing.setDescription(requestDetails.getDescription());
//        }
//        if (requestDetails.getStatus() != null && !requestDetails.getStatus().isBlank()) {
//            existing.setStatus(requestDetails.getStatus());
//        }
//
//        return requestRepository.save(existing);
//    }
//
//    @Override
//    public void softDeleteRequest(Long id, String deletedBy) {
//
//    }
//
//    @Override
//    public void restoreRequest(Long id) {
//
//    }
//
//    @Override
//    public void deleteRequest(Long id) {
//        requestRepository.deleteById(id);
//    }
//
//    @Override
//    public Request updateRequestStatus(Long id, String status) throws NoSuchElementException {
//        return null;
//    }
//}

package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Request;
import com.zawadig.myafwanii.Repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> getAllRequests() {
        // Return only requests not soft deleted
        return requestRepository.findByDeletedFalse();
    }

    @Override
    public List<Request> getDeletedRequests() {
        return requestRepository.findByDeletedTrue();
    }

    @Override
    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    @Override
    public Request createRequest(Request request) {
        if (request.getStatus() == null || request.getStatus().isBlank()) {
            request.setStatus("Pending");
        }
        if (request.getRequestDate() == null) {
            request.setRequestDate(LocalDate.now());
        }
        request.setDeleted(false);
        return requestRepository.save(request);
    }

    @Override
    public Request updateRequest(Long id, Request requestDetails) {
        Request existing = requestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found with id " + id));
        if (requestDetails.getCustomerName() != null && !requestDetails.getCustomerName().isBlank()) {
            existing.setCustomerName(requestDetails.getCustomerName());
        }
        if (requestDetails.getAddress() != null && !requestDetails.getAddress().isBlank()) {
            existing.setAddress(requestDetails.getAddress());
        }
        if (requestDetails.getRequestType() != null && !requestDetails.getRequestType().isBlank()) {
            existing.setRequestType(requestDetails.getRequestType());
        }
        if (requestDetails.getDescription() != null) {
            existing.setDescription(requestDetails.getDescription());
        }
        if (requestDetails.getStatus() != null && !requestDetails.getStatus().isBlank()) {
            existing.setStatus(requestDetails.getStatus());
        }
        return requestRepository.save(existing);
    }

    @Override
    public void deleteRequest(Long id) {

    }

    @Override
    public void softDeleteRequest(Long id, String deletedBy) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found with id " + id));
        request.setDeleted(true);
        request.setDeletedAt(LocalDate.now());
        request.setDeletedBy(deletedBy);
        requestRepository.save(request);
    }

    @Override
    public Request updateRequestStatus(Long id, String status) throws NoSuchElementException {
        return null;
    }

    @Override
    public void restoreRequest(Long id) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found with id " + id));
        request.setDeleted(false);
        request.setDeletedAt(null);
        request.setDeletedBy(null);
        requestRepository.save(request);
    }
}
