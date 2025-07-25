// RequestFormService.java
package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.RequestForm;
import com.zawadig.myafwanii.Repository.RequestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestFormService {

    @Autowired
    private RequestFormRepository requestFormRepository;

    public RequestForm saveRequestForm(RequestForm requestForm) {
        return requestFormRepository.save(requestForm);
    }

    public List<RequestForm> getAllRequests() {
        return requestFormRepository.findAll();
    }

    public Optional<RequestForm> getRequestById(Long id) {
        return requestFormRepository.findById(id);
    }

    public List<RequestForm> getRequestsByCustomerId(Long customerId) {
        return requestFormRepository.findByCustomerId(customerId);
    }

    public void deleteRequest(Long id) {
        requestFormRepository.deleteById(id);
    }
}
