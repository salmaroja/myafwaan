//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Request;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
///**
// * Interface for managing service requests.
// */
//public interface RequestService {
//    Request createRequest(Request request);
//    List<Request> getAllRequests();
//    Optional<Request> getRequestById(Long id);
//    Request updateRequest(Long id, Request request);
//    void deleteRequest(Long id);
//
//    Request updateRequestStatus(Long id, String status) throws NoSuchElementException;
//}
//


package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Request;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface RequestService {
    Request createRequest(Request request);
    List<Request> getAllRequests();

    List<Request> getDeletedRequests();

    Optional<Request> getRequestById(Long id);
    Request updateRequest(Long id, Request request);
    void deleteRequest(Long id);

    // Method mpya ya soft delete
    void softDeleteRequest(Long id, String deletedBy);

    Request updateRequestStatus(Long id, String status) throws NoSuchElementException;

    void restoreRequest(Long id);
}
