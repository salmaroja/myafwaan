// RequestFormController.java
package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.RequestForm;
import com.zawadig.myafwanii.Service.CustomerService;
import com.zawadig.myafwanii.Service.RequestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requestsform")
@CrossOrigin
public class RequestFormController {

    @Autowired
    private RequestFormService requestFormService;

    @Autowired
    private CustomerService customerService;

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/submit")
    public ResponseEntity<?> submitRequestForm(
            @RequestParam String fullName,
            @RequestParam String nationalId,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam String paymentMethod,
            @RequestParam double amountPaid,
            @RequestParam Long customerId,
            @RequestParam("picture") MultipartFile pictureFile
    ) {
        try {
            Optional<Customer> optionalCustomer = customerService.getCustomerById(customerId);
            if (optionalCustomer.isEmpty()) {
                return ResponseEntity.badRequest().body("Invalid customer ID");
            }

            Customer customer = optionalCustomer.get();
            String customerEmail = customer.getUser().getEmail(); // ensure user exists

            String folderPath = "uploads/request-pictures/" + customerEmail;
            File directory = new File(folderPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + pictureFile.getOriginalFilename();
            File dest = new File(folderPath + "/" + fileName);
            pictureFile.transferTo(dest);

            String picturePath = folderPath + "/" + fileName;

            RequestForm requestForm = RequestForm.builder()
                    .fullName(fullName)
                    .nationalId(nationalId)
                    .address(address)
                    .phone(phone)
                    .paymentMethod(paymentMethod)
                    .amountPaid(amountPaid)
                    .picturePath(picturePath)
                    .customer(customer)
                    .build();

            return ResponseEntity.ok(requestFormService.saveRequestForm(requestForm));

        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to upload picture");
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<RequestForm>> getCustomerRequests(@PathVariable Long customerId) {
        return ResponseEntity.ok(requestFormService.getRequestsByCustomerId(customerId));
    }

    @GetMapping
    public ResponseEntity<List<RequestForm>> getAllRequests() {
        return ResponseEntity.ok(requestFormService.getAllRequests());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
        requestFormService.deleteRequest(id);
        return ResponseEntity.ok().body("Request deleted successfully.");
    }
}
