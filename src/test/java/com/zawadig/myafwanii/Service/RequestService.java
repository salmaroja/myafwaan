package com.zawadig.myafwanii.Service;

import com.zawadig.myafwanii.Model.Request;

import java.util.List;
import java.util.Optional;

/**
 * Interface for managing service requests.
 */
public interface RequestService {

    /**
     * Get all service requests.
     *
     * @return list of all requests
     */
    List<Request> getAllRequests();

    /**
     * Get a single request by its ID.
     *
     * @param id the ID of the request
     * @return Optional containing the request if found
     */
    Optional<Request> getRequestById(Long id);

    /**
     * Create a new request.
     *
     * @param request the request to create
     * @return the saved request
     */
    Request createRequest(Request request);

    /**
     * Update an existing request by ID.
     *
     * @param id the ID of the request to update
     * @param requestDetails the new request data
     * @return the updated request
     */
    Request updateRequest(Long id, Request requestDetails);

    /**
     * Delete a request by ID.
     *
     * @param id the ID of the request to delete
     */
    void deleteRequest(Long id);
}
