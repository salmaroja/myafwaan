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
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    @Override
    public Request createRequest(Request request) {
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name is required.");
        }
        if (request.getAddress() == null || request.getAddress().isBlank()) {
            throw new IllegalArgumentException("Address is required.");
        }
        if (request.getRequestType() == null || request.getRequestType().isBlank()) {
            throw new IllegalArgumentException("Request type is required.");
        }

        if (request.getStatus() == null || request.getStatus().isBlank()) {
            request.setStatus("Pending");
        }

        if (request.getRequestDate() == null) {
            request.setRequestDate(LocalDate.now());
        }

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
        requestRepository.deleteById(id);
    }
}
