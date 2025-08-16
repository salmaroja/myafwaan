//////////// RequestFormController.java
//////////package com.zawadig.myafwanii.Controller;
//////////
//////////import com.zawadig.myafwanii.Model.Customer;
//////////import com.zawadig.myafwanii.Model.RequestForm;
//////////import com.zawadig.myafwanii.Repository.CustomerRepository;
//////////import com.zawadig.myafwanii.Repository.RequestFormRepository;
//////////import com.zawadig.myafwanii.Service.CustomerService;
//////////import com.zawadig.myafwanii.Service.RequestFormService;
//////////import org.springframework.beans.factory.annotation.Autowired;
//////////import org.springframework.http.HttpStatus;
//////////import org.springframework.http.ResponseEntity;
//////////import org.springframework.web.bind.annotation.*;
//////////import org.springframework.web.multipart.MultipartFile;
//////////
//////////import java.io.File;
//////////import java.io.IOException;
//////////import java.util.List;
//////////import java.util.Optional;
//////////import java.util.UUID;
//////////
//////////@RestController
//////////@RequestMapping("/api/requestsform")
//////////@CrossOrigin
//////////public class RequestFormController {
//////////
//////////    @Autowired
//////////    private RequestFormService requestFormService;
//////////
//////////    @Autowired
//////////    private CustomerService customerService;
//////////
//////////    private static final String UPLOAD_DIR = "uploads/";
//////////
//////////    @PostMapping("/submit")
//////////    public ResponseEntity<?> submitRequestForm(
//////////            @RequestParam("fullName") String fullName,
//////////            @RequestParam("nationalId") String nationalId,
//////////            @RequestParam("address") String address,
//////////            @RequestParam("phone") String phone,
//////////            @RequestParam("serviceType") String serviceType,
//////////            @RequestParam("meterType") String meterType,
//////////            @RequestParam("customerId") Long customerId,
//////////            @RequestParam("picture") MultipartFile picture
//////////    ) {
//////////        try {
//////////            Customer customer = CustomerRepository.findById(customerId)
//////////                    .orElseThrow(() -> new RuntimeException("Customer not found"));
//////////
//////////            // Hifadhi picha
//////////            String filename = UUID.randomUUID() + "_" + picture.getOriginalFilename();
//////////            String uploadDir = "uploads/";
//////////            File dest = new File(uploadDir + filename);
//////////            picture.transferTo(dest);
//////////
//////////            RequestForm form = RequestForm.builder()
//////////                    .fullName(fullName)
//////////                    .nationalId(nationalId)
//////////                    .address(address)
//////////                    .phone(phone)
//////////                    .serviceType(serviceType)
//////////                    .meterType(meterType)
//////////                    .picturePath("/" + uploadDir + filename)
//////////                    .customer(customer)
//////////                    .build();
//////////
//////////            RequestFormRepository.save(form);
//////////
//////////            return ResponseEntity.ok("Request submitted successfully");
//////////        } catch (Exception e) {
//////////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//////////                    .body("Failed to submit request: " + e.getMessage());
//////////        }
//////////    }
//////////
//////////
//////////
//////////    @GetMapping("/customer/{customerId}")
//////////    public ResponseEntity<List<RequestForm>> getCustomerRequests(@PathVariable Long customerId) {
//////////        return ResponseEntity.ok(requestFormService.getRequestsByCustomerId(customerId));
//////////    }
//////////
//////////    @GetMapping
//////////    public ResponseEntity<List<RequestForm>> getAllRequests() {
//////////        return ResponseEntity.ok(requestFormService.getAllRequests());
//////////    }
//////////
//////////    @DeleteMapping("/{id}")
//////////    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
//////////        requestFormService.deleteRequest(id);
//////////        return ResponseEntity.ok().body("Request deleted successfully.");
//////////    }
//////////}
////////
////////package com.zawadig.myafwanii.Controller;
////////
////////import com.zawadig.myafwanii.Model.Customer;
////////import com.zawadig.myafwanii.Model.RequestForm;
////////import com.zawadig.myafwanii.Repository.CustomerRepository;
////////import com.zawadig.myafwanii.Repository.RequestFormRepository;
////////import com.zawadig.myafwanii.Service.CustomerService;
////////import com.zawadig.myafwanii.Service.RequestFormService;
////////import org.springframework.beans.factory.annotation.Autowired;
////////import org.springframework.http.HttpStatus;
////////import org.springframework.http.ResponseEntity;
////////import org.springframework.web.bind.annotation.*;
////////import org.springframework.web.multipart.MultipartFile;
////////
////////import java.io.File;
////////import java.util.List;
////////import java.util.UUID;
////////
////////@RestController
////////@RequestMapping("/api/requestsform")
////////@CrossOrigin
////////public class RequestFormController {
////////
////////    @Autowired
////////    private RequestFormService requestFormService;
////////
////////    @Autowired
////////    private CustomerService customerService;
////////
////////    private static final String UPLOAD_DIR = "uploads/";
////////
////////    @PostMapping("/submit")
////////    public ResponseEntity<?> submitRequestForm(
////////            @RequestParam("fullName") String fullName,
////////            @RequestParam("nationalId") String nationalId,
////////            @RequestParam("address") String address,
////////            @RequestParam("phone") String phone,
////////            @RequestParam("serviceType") String serviceType,
////////            @RequestParam("meterType") String meterType,
////////            @RequestParam("customerId") Long customerId,
////////            @RequestParam("picture") MultipartFile picture
////////    ) {
////////        try {
////////            Customer customer = customerService.getCustomerById(customerId)
////////                    .orElseThrow(() -> new RuntimeException("Customer not found"));
////////
////////            // Ensure uploads folder exists
////////            File uploadDirFile = new File(UPLOAD_DIR);
////////            if (!uploadDirFile.exists()) {
////////                uploadDirFile.mkdirs();
////////            }
////////
////////            // Save image
////////            String filename = UUID.randomUUID() + "_" + picture.getOriginalFilename();
////////            File dest = new File(UPLOAD_DIR + filename);
////////            picture.transferTo(dest);
////////
////////            RequestForm form = RequestForm.builder()
////////                    .fullName(fullName)
////////                    .nationalId(nationalId)
////////                    .address(address)
////////                    .phone(phone)
////////                    .serviceType(serviceType)
////////                    .meterType(meterType)
////////                    .picturePath("/" + UPLOAD_DIR + filename)
////////                    .customer(customer)
////////                    .build();
////////
////////            requestFormService.save(form);
////////
////////            return ResponseEntity.ok("Request submitted successfully");
////////        } catch (Exception e) {
////////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////////                    .body("Failed to submit request: " + e.getMessage());
////////        }
////////    }
////////
////////    @GetMapping("/customer/{customerId}")
////////    public ResponseEntity<List<RequestForm>> getCustomerRequests(@PathVariable Long customerId) {
////////        return ResponseEntity.ok(requestFormService.getRequestsByCustomerId(customerId));
////////    }
////////
////////    @GetMapping
////////    public ResponseEntity<List<RequestForm>> getAllRequests() {
////////        return ResponseEntity.ok(requestFormService.getAllRequests());
////////    }
////////
////////    @DeleteMapping("/{id}")
////////    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
////////        requestFormService.deleteRequest(id);
////////        return ResponseEntity.ok().body("Request deleted successfully.");
////////    }
////////}
////////package com.zawadig.myafwanii.Controller;
////////
////////import com.zawadig.myafwanii.Model.Customer;
////////import com.zawadig.myafwanii.Model.RequestForm;
////////import com.zawadig.myafwanii.Service.CustomerService;
////////import com.zawadig.myafwanii.Service.RequestFormService;
////////import org.springframework.beans.factory.annotation.Autowired;
////////import org.springframework.http.HttpStatus;
////////import org.springframework.http.ResponseEntity;
////////import org.springframework.web.bind.annotation.*;
////////import org.springframework.web.multipart.MultipartFile;
////////
////////import java.io.File;
////////import java.util.List;
////////import java.util.UUID;
////////
////////@RestController
////////@RequestMapping("/api/requestsform")
////////@CrossOrigin
////////public class RequestFormController {
////////
////////    @Autowired
////////    private RequestFormService requestFormService;
////////
////////    @Autowired
////////    private CustomerService customerService;
////////
////////    private static final String UPLOAD_DIR = "uploads/";
////////
////////    @PostMapping("/submit")
////////    public ResponseEntity<?> submitRequestForm(
////////            @RequestParam("fullName") String fullName,
////////            @RequestParam("nationalId") String nationalId,
////////            @RequestParam("address") String address,
////////            @RequestParam("phone") String phone,
////////            @RequestParam("serviceType") String serviceType,
////////            @RequestParam("meterType") String meterType,
////////            @RequestParam("customerId") Long customerId,
////////            @RequestParam("picture") MultipartFile picture
////////    ) {
////////        try {
////////            Customer customer = customerService.getCustomerById(customerId)
////////                    .orElseThrow(() -> new RuntimeException("Customer not found"));
////////
////////            // Hakikisha uploads folder ipo
////////            File uploadDirFile = new File(UPLOAD_DIR);
////////            if (!uploadDirFile.exists()) {
////////                uploadDirFile.mkdirs();
////////            }
////////
////////            // Hifadhi picha
////////            String filename = UUID.randomUUID() + "_" + picture.getOriginalFilename();
////////            File dest = new File(UPLOAD_DIR + filename);
////////            picture.transferTo(dest);
////////
////////            RequestForm form = RequestForm.builder()
////////                    .fullName(fullName)
////////                    .nationalId(nationalId)
////////                    .address(address)
////////                    .phone(phone)
////////                    .serviceType(serviceType)
////////                    .meterType(meterType)
////////                    .picturePath("/" + UPLOAD_DIR + filename)
////////                    .customer(customer)
////////                    .build();
////////
////////            requestFormService.save(form);
////////
////////            return ResponseEntity.ok("Request submitted successfully");
////////        } catch (Exception e) {
////////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////////                    .body("Failed to submit request: " + e.getMessage());
////////        }
////////    }
////////
////////
////////    @GetMapping("/customer/{customerId}")
////////    public ResponseEntity<List<RequestForm>> getCustomerRequests(@PathVariable Long customerId) {
////////        return ResponseEntity.ok(requestFormService.getRequestsByCustomerId(customerId));
////////    }
////////
////////    @GetMapping
////////    public ResponseEntity<List<RequestForm>> getAllRequests() {
////////        return ResponseEntity.ok(requestFormService.getAllRequests());
////////    }
////////
////////    @DeleteMapping("/{id}")
////////    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
////////        requestFormService.deleteRequest(id);
////////        return ResponseEntity.ok().body("Request deleted successfully.");
////////    }
////////}
//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Model.Customer;
//////import com.zawadig.myafwanii.Model.RequestForm;
//////import com.zawadig.myafwanii.Service.CustomerService;
//////import com.zawadig.myafwanii.Service.RequestFormService;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.http.HttpStatus;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////import org.springframework.web.multipart.MultipartFile;
//////
//////import java.io.File;
//////import java.util.List;
//////import java.util.UUID;
//////
//////@RestController
//////@RequestMapping("/api/requestsform")
//////@CrossOrigin
//////public class RequestFormController {
//////
//////    @Autowired
//////    private RequestFormService requestFormService;
//////
//////    @Autowired
//////    private CustomerService customerService;
//////
//////    private static final String UPLOAD_DIR = "uploads/";
//////
//////    @PostMapping(value = "/submit", consumes = "multipart/form-data")
//////    public ResponseEntity<?> submitRequestForm(
//////            @RequestParam(required = true) String fullName,
//////            @RequestParam(required = true) String nationalId,
//////            @RequestParam(required = true) String address,
//////            @RequestParam(required = true) String phone,
//////            @RequestParam(required = true) String serviceType,
//////            @RequestParam(required = true) String meterType,
//////            @RequestParam(required = true) Long customerId,
//////            @RequestParam(required = true) MultipartFile picture
//////    ) {
//////        try {
//////            Customer customer = customerService.getCustomerById(customerId)
//////                    .orElseThrow(() -> new RuntimeException("Customer not found"));
//////
//////            // Hakikisha uploads folder ipo
//////            File uploadDirFile = new File(UPLOAD_DIR);
//////            if (!uploadDirFile.exists()) {
//////                uploadDirFile.mkdirs();
//////            }
//////
//////            // Hifadhi picha
//////            String filename = UUID.randomUUID() + "_" + picture.getOriginalFilename();
//////            File dest = new File(UPLOAD_DIR + filename);
//////            picture.transferTo(dest);
//////
//////            // Jenga na hifadhi request
//////            RequestForm form = RequestForm.builder()
//////                    .fullName(fullName)
//////                    .nationalId(nationalId)
//////                    .address(address)
//////                    .phone(phone)
//////                    .serviceType(serviceType)
//////                    .meterType(meterType)
//////                    .picturePath("/" + UPLOAD_DIR + filename)
//////                    .customer(customer)
//////                    .build();
//////
//////            requestFormService.save(form);
//////
//////            return ResponseEntity.ok("Request submitted successfully");
//////        } catch (Exception e) {
//////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//////                    .body("Failed to submit request: " + e.getMessage());
//////        }
//////    }
//////
//////    @GetMapping("/customer/{customerId}")
//////    public ResponseEntity<List<RequestForm>> getCustomerRequests(@PathVariable Long customerId) {
//////        return ResponseEntity.ok(requestFormService.getRequestsByCustomerId(customerId));
//////    }
//////
//////    @GetMapping
//////    public ResponseEntity<List<RequestForm>> getAllRequests() {
//////        return ResponseEntity.ok(requestFormService.getAllRequests());
//////    }
//////
//////    @DeleteMapping("/{id}")
//////    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
//////        requestFormService.deleteRequest(id);
//////        return ResponseEntity.ok().body("Request deleted successfully.");
//////    }
//////}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Model.RequestForm;
////import com.zawadig.myafwanii.Service.CustomerService;
////import com.zawadig.myafwanii.Service.RequestFormService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////import java.nio.file.StandardCopyOption;
////import java.util.List;
////import java.util.UUID;
////
////@RestController
////@RequestMapping("/api/requestsform")
////@CrossOrigin
////public class RequestFormController {
////
////    @Autowired
////    private RequestFormService requestFormService;
////
////    @Autowired
////    private CustomerService customerService;
////
////    private static final String UPLOAD_DIR = "uploads/";
////
////    @PostMapping(value = "/submit", consumes = "multipart/form-data")
////    public ResponseEntity<?> submitRequestForm(
////            @RequestParam String fullName,
////            @RequestParam String nationalId,
////            @RequestParam String address,
////            @RequestParam String phone,
////            @RequestParam String serviceType,
////            @RequestParam String meterType,
////            @RequestParam Long customerId,
////            @RequestPart("picture") MultipartFile picture) {
////
////        try {
////            // Validate required fields
////            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
////                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty() ||
////                    picture.isEmpty()) {
////                return ResponseEntity.badRequest().body("Sehemu zote za lazima lazima zjazwe");
////            }
////
////            // Find customer
////            Customer customer = customerService.getCustomerById(customerId)
////                    .orElseThrow(() -> new RuntimeException("Hakuna mteja aliyepatikana"));
////
////            // Create uploads directory if not exists
////            Path uploadPath = Paths.get(UPLOAD_DIR);
////            if (!Files.exists(uploadPath)) {
////                Files.createDirectories(uploadPath);
////            }
////
////            // Generate unique filename
////            String filename = UUID.randomUUID() + "_" + picture.getOriginalFilename();
////            Path filePath = uploadPath.resolve(filename);
////
////            // Save file
////            Files.copy(picture.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
////
////            // Create and save request
////            RequestForm form = new RequestForm();
////            form.setFullName(fullName);
////            form.setNationalId(nationalId);
////            form.setAddress(address);
////            form.setPhone(phone);
////            form.setServiceType(serviceType);
////            form.setMeterType(meterType);
////            form.setPicturePath("/" + UPLOAD_DIR + filename);
////            form.setCustomer(customer);
////
////            requestFormService.save(form);
////
////            return ResponseEntity.ok("Ombi limepokelewa kikamilifu");
////        } catch (RuntimeException e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
////        } catch (IOException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu katika uhifadhi wa picha: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu isiyotarajiwa: " + e.getMessage());
////        }
////    }
////
////    @GetMapping("/customer/{customerId}")
////    public ResponseEntity<List<RequestForm>> getCustomerRequests(@PathVariable Long customerId) {
////        return ResponseEntity.ok(requestFormService.getRequestsByCustomerId(customerId));
////    }
////
////    @GetMapping
////    public ResponseEntity<List<RequestForm>> getAllRequests() {
////        return ResponseEntity.ok(requestFormService.getAllRequests());
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
////        requestFormService.deleteRequest(id);
////        return ResponseEntity.ok().body("Ombi limefutwa kikamilifu.");
////    }
////}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Model.RequestForm;
////import com.zawadig.myafwanii.Service.CustomerService;
////import com.zawadig.myafwanii.Service.RequestFormService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////import java.nio.file.StandardCopyOption;
////import java.util.List;
////import java.util.UUID;
////
////@RestController
////@RequestMapping("/api/requestsform")
////@CrossOrigin
////public class RequestFormController {
////
////    @Autowired
////    private RequestFormService requestFormService;
////
////    @Autowired
////    private CustomerService customerService;
////
////    // Soma njia ya kuhifadhi kutoka kwenye application.properties
////    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
////    private String UPLOAD_DIR;
////
////    @PostMapping(value = "/submit", consumes = "multipart/form-data")
////    public ResponseEntity<?> submitRequestForm(
////            @RequestParam String fullName,
////            @RequestParam String nationalId,
////            @RequestParam String address,
////            @RequestParam String phone,
////            @RequestParam String serviceType,
////            @RequestParam String meterType,
////            @RequestParam Long customerId,
////            @RequestPart("picture") MultipartFile picture) {
////
////        try {
////            // 1. Thibitisha sehemu muhimu
////            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
////                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty() ||
////                    picture.isEmpty()) {
////                return ResponseEntity.badRequest().body("Sehemu zote za lazima lazima zjazwe");
////            }
////
////            // 2. Tafuta mteja
////            Customer customer = customerService.getCustomerById(customerId)
////                    .orElseThrow(() -> new RuntimeException("Hakuna mteja aliyepatikana"));
////
////            // 3. Hakikisha folda ya uploads ipo
////            Path uploadPath = Paths.get(UPLOAD_DIR);
////            if (!Files.exists(uploadPath)) {
////                Files.createDirectories(uploadPath);
////            }
////
////            // 4. Tengeneza jina la kipekee la faili
////            String filename = UUID.randomUUID() + "_" + picture.getOriginalFilename();
////            Path filePath = uploadPath.resolve(filename);
////
////            // 5. Hifadhi faili kwa usalama
////            Files.copy(picture.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
////
////            // 6. Hifadhi taarifa kwenye database
////            RequestForm form = new RequestForm();
////            form.setFullName(fullName);
////            form.setNationalId(nationalId);
////            form.setAddress(address);
////            form.setPhone(phone);
////            form.setServiceType(serviceType);
////            form.setMeterType(meterType);
////            form.setPicturePath(filePath.toString()); // Hifadhi njia kamili
////            form.setCustomer(customer);
////
////            requestFormService.save(form);
////
////            return ResponseEntity.ok("Ombi limepokelewa kikamilifu");
////        } catch (RuntimeException e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
////        } catch (IOException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu katika uhifadhi wa picha: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu isiyotarajiwa: " + e.getMessage());
////        }
////    }
////    @GetMapping("/all")
////    public ResponseEntity<List<RequestForm>> getAllRequests() {
////        List<RequestForm> requests = requestFormService.getAllRequests();
////        return ResponseEntity.ok(requests);
////    }
////
////    // ... methods zingine zisizohusiana na upload ...
////}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Model.RequestForm;
////import com.zawadig.myafwanii.Service.CustomerService;
////import com.zawadig.myafwanii.Service.RequestFormService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////import java.nio.file.StandardCopyOption;
////import java.util.List;
////import java.util.UUID;
////
////@RestController
////@RequestMapping("/api/requestsform")
////@CrossOrigin
////public class RequestFormController {
////
////    @Autowired
////    private RequestFormService requestFormService;
////
////    @Autowired
////    private CustomerService customerService;
////
////    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
////    private String UPLOAD_DIR;
////
////    @PostMapping(value = "/submit", consumes = "multipart/form-data")
////    public ResponseEntity<?> submitRequestForm(
////            @RequestParam String fullName,
////            @RequestParam String nationalId,
////            @RequestParam String address,
////            @RequestParam String phone,
////            @RequestParam String serviceType,
////            @RequestParam String meterType,
////            @RequestParam Long customerId,
////            @RequestPart("picture") MultipartFile picture) {
////
////        try {
////            // 1. Validate required fields
////            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
////                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
////                return ResponseEntity.badRequest().body("Sehemu zote za lazima lazima zjazwe");
////            }
////
////            // 2. Validate picture
////            if (picture == null || picture.isEmpty()) {
////                return ResponseEntity.badRequest().body("Picha ni lazima");
////            }
////
////            // 3. Find customer
////            Customer customer = customerService.getCustomerById(customerId)
////                    .orElseThrow(() -> new RuntimeException("Hakuna mteja aliyepatikana"));
////
////            // 4. Ensure upload directory exists
////            Path uploadPath = Paths.get(UPLOAD_DIR);
////            if (!Files.exists(uploadPath)) {
////                Files.createDirectories(uploadPath);
////            }
////
////            // 5. Generate unique filename
////            String originalFilename = picture.getOriginalFilename();
////            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
////            String filename = UUID.randomUUID().toString() + fileExtension;
////            Path filePath = uploadPath.resolve(filename);
////
////            // 6. Save the file securely
////            Files.copy(picture.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
////
////            // 7. Save form data to database
////            RequestForm form = new RequestForm();
////            form.setFullName(fullName);
////            form.setNationalId(nationalId);
////            form.setAddress(address);
////            form.setPhone(phone);
////            form.setServiceType(serviceType);
////            form.setMeterType(meterType);
////            form.setPicturePath(filename); // Store only filename, not full path
////            form.setCustomer(customer);
////
////            requestFormService.save(form);
////
////            return ResponseEntity.ok("Ombi limepokelewa kikamilifu");
////        } catch (RuntimeException e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
////        } catch (IOException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu katika uhifadhi wa picha: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu isiyotarajiwa: " + e.getMessage());
////        }
////    }
////
////    @GetMapping("/all")
////    public ResponseEntity<List<RequestForm>> getAllRequests() {
////        List<RequestForm> requests = requestFormService.getAllRequests();
////        return ResponseEntity.ok(requests);
////    }
////}
////package com.zawadig.myafwanii.Controller;
////
////import com.zawadig.myafwanii.Model.Customer;
////import com.zawadig.myafwanii.Model.RequestForm;
////import com.zawadig.myafwanii.Service.CustomerService;
////import com.zawadig.myafwanii.Service.RequestFormService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.MediaType;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////import java.nio.file.StandardCopyOption;
////import java.util.List;
////import java.util.Map;
////import java.util.UUID;
////
////@RestController
////@RequestMapping("/api/requestsform")
////@CrossOrigin(origins = "http://localhost:3000") //
////public class RequestFormController {
////
////    @Autowired
////    private RequestFormService requestFormService;
////
////    @Autowired
////    private CustomerService customerService;
////
////    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
////    private String UPLOAD_DIR;
////
////    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
////    public ResponseEntity<?> submitRequestForm(
////            @RequestParam String fullName,
////            @RequestParam String nationalId,
////            @RequestParam String address,
////            @RequestParam String phone,
////            @RequestParam String serviceType,
////            @RequestParam String meterType,
////            @RequestParam Long customerId,
////            @RequestPart("picture") MultipartFile picture) {
////
////        try {
////            // 1. Validate required fields
////            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
////                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
////                return ResponseEntity.badRequest().body("Sehemu zote za lazima lazima zjazwe");
////            }
////
////            // 2. Validate picture
////            if (picture == null || picture.isEmpty()) {
////                return ResponseEntity.badRequest().body("Picha ni lazima");
////            }
////
////            // 3. Validate file size (max 5MB)
////            if (picture.getSize() > 5 * 1024 * 1024) {
////                return ResponseEntity.badRequest().body("Picha inapaswa kuwa chini ya 5MB");
////            }
////
////            // 4. Validate file type (images only)
////            String contentType = picture.getContentType();
////            if (contentType == null || !contentType.startsWith("image/")) {
////                return ResponseEntity.badRequest().body("Tafadhali weka faili ya picha tu");
////            }
////
////            // 5. Store file and save data
////            String filename = storeFile(picture);
////            RequestForm form = saveRequestData(
////                    fullName, nationalId, address, phone,
////                    serviceType, meterType, customerId, filename
////            );
////
////            return ResponseEntity.ok().body(
////                    Map.of(
////                            "message", "Ombi limepokelewa kikamilifu",
////                            "id", form.getId(),
////                            "pictureUrl", "/api/images/" + filename
////                    )
////            );
////
////        } catch (IOException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu katika uhifadhi wa picha: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Hitilafu isiyotarajiwa: " + e.getMessage());
////        }
////    }
////
////    private String storeFile(MultipartFile file) throws IOException {
////        String originalFilename = file.getOriginalFilename();
////        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
////        String filename = UUID.randomUUID() + fileExtension;
////
////        Path uploadPath = Paths.get(UPLOAD_DIR);
////        if (!Files.exists(uploadPath)) {
////            Files.createDirectories(uploadPath);
////        }
////
////        Path filePath = uploadPath.resolve(filename);
////        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
////
////        return filename;
////    }
////
////    private RequestForm saveRequestData(
////            String fullName, String nationalId, String address,
////            String phone, String serviceType, String meterType,
////            Long customerId, String filename
////    ) {
////        Customer customer = customerService.getCustomerById(customerId)
////                .orElseThrow(() -> new RuntimeException("Hakuna mteja aliyepatikana"));
////
////        RequestForm form = new RequestForm();
////        form.setFullName(fullName);
////        form.setNationalId(nationalId);
////        form.setAddress(address);
////        form.setPhone(phone);
////        form.setServiceType(serviceType);
////        form.setMeterType(meterType);
////        form.setPicturePath(filename);
////        form.setCustomer(customer);
////
////        return requestFormService.save(form);
////    }
////
////    @GetMapping("/all")
////    public ResponseEntity<List<RequestForm>> getAllRequests() {
////        List<RequestForm> requests = requestFormService.getAllRequests();
////        return ResponseEntity.ok(requests);
////    }
////}
//////package com.zawadig.myafwanii.Controller;
//////
//////import com.zawadig.myafwanii.Model.Customer;
//////import com.zawadig.myafwanii.Model.RequestForm;
//////import com.zawadig.myafwanii.Service.CustomerService;
//////import com.zawadig.myafwanii.Service.RequestFormService;
//////import com.zawadig.myafwanii.dto.RequestWithPaymentDTO;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.beans.factory.annotation.Value;
//////import org.springframework.http.HttpStatus;
//////import org.springframework.http.MediaType;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.*;
//////import org.springframework.web.multipart.MultipartFile;
//////
//////import java.io.IOException;
//////import java.nio.file.Files;
//////import java.nio.file.Path;
//////import java.nio.file.Paths;
//////import java.nio.file.StandardCopyOption;
//////import java.util.List;
//////import java.util.Map;
//////import java.util.UUID;
//////
//////@RestController
//////@RequestMapping("/api/requestsform")
//////@CrossOrigin
//////public class RequestFormController {
//////
//////    @Autowired
//////    private RequestFormService requestFormService;
//////
//////    @Autowired
//////    private CustomerService customerService;
//////
//////    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
//////    private String UPLOAD_DIR;
//////
//////    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//////    public ResponseEntity<?> submitRequestForm(
//////            @RequestParam String fullName,
//////            @RequestParam String nationalId,
//////            @RequestParam String address,
//////            @RequestParam String phone,
//////            @RequestParam String serviceType,
//////            @RequestParam String meterType,
//////            @RequestParam Long customerId,
//////            @RequestPart("picture") MultipartFile picture) {
//////
//////        try {
//////            // 1. Validate required fields
//////            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
//////                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
//////                return ResponseEntity.badRequest().body("Sehemu zote za lazima lazima zjazwe");
//////            }
//////
//////            // 2. Validate picture
//////            if (picture == null || picture.isEmpty()) {
//////                return ResponseEntity.badRequest().body("Picha ni lazima");
//////            }
//////
//////            // 3. Validate file size (max 5MB)
//////            if (picture.getSize() > 5 * 1024 * 1024) {
//////                return ResponseEntity.badRequest().body("Picha inapaswa kuwa chini ya 5MB");
//////            }
//////
//////            // 4. Validate file type (images only)
//////            String contentType = picture.getContentType();
//////            if (contentType == null || !contentType.startsWith("image/")) {
//////                return ResponseEntity.badRequest().body("Tafadhali weka faili ya picha tu");
//////            }
//////
//////            // 5. Store file and save data
//////            String filename = storeFile(picture);
//////            RequestForm form = saveRequestData(
//////                    fullName, nationalId, address, phone,
//////                    serviceType, meterType, customerId, filename
//////            );
//////
//////            return ResponseEntity.ok().body(
//////                    Map.of(
//////                            "message", "Ombi limepokelewa kikamilifu",
//////                            "id", form.getId(),
//////                            "pictureUrl", "/api/images/" + filename
//////                    )
//////            );
//////
//////        } catch (IOException e) {
//////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//////                    .body("Hitilafu katika uhifadhi wa picha: " + e.getMessage());
//////        } catch (Exception e) {
//////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//////                    .body("Hitilafu isiyotarajiwa: " + e.getMessage());
//////        }
//////    }
//////
//////    private String storeFile(MultipartFile file) throws IOException {
//////        String originalFilename = file.getOriginalFilename();
//////        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
//////        String filename = UUID.randomUUID() + fileExtension;
//////
//////        Path uploadPath = Paths.get(UPLOAD_DIR);
//////        if (!Files.exists(uploadPath)) {
//////            Files.createDirectories(uploadPath);
//////        }
//////
//////        Path filePath = uploadPath.resolve(filename);
//////        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//////
//////        return filename;
//////    }
//////
//////    private RequestForm saveRequestData(
//////            String fullName, String nationalId, String address,
//////            String phone, String serviceType, String meterType,
//////            Long customerId, String filename
//////    ) {
//////        Customer customer = customerService.getCustomerById(customerId)
//////                .orElseThrow(() -> new RuntimeException("Hakuna mteja aliyepatikana"));
//////
//////        RequestForm form = new RequestForm();
//////        form.setFullName(fullName);
//////        form.setNationalId(nationalId);
//////        form.setAddress(address);
//////        form.setPhone(phone);
//////        form.setServiceType(serviceType);
//////        form.setMeterType(meterType);
//////        form.setPicturePath(filename);
//////        form.setCustomer(customer);
//////
//////        return requestFormService.save(form);
//////    }
//////
//////    @GetMapping("/all")
//////    public ResponseEntity<List<RequestForm>> getAllRequests() {
//////        List<RequestForm> requests = requestFormService.getAllRequests();
//////        return ResponseEntity.ok(requests);
//////    }
//////
//////    // Endpoint mpya: onyesha maombi pamoja na status za malipo
//////    @GetMapping("/with-payments")
//////    public ResponseEntity<List<RequestWithPaymentDTO>> getRequestsWithPayments() {
//////        List<RequestWithPaymentDTO> list = requestFormService.getAllRequestsWithPayments();
//////        return ResponseEntity.ok(list);
//////    }
//////}
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Service.CustomerService;
//import com.zawadig.myafwanii.Service.RequestFormService;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/requestsform")
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8081"}) // Add your React Native app URL
//public class RequestFormController {
//
//    @Autowired
//    private RequestFormService requestFormService;
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
//    private String UPLOAD_DIR;
//
//    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> submitRequestForm(
//            @RequestParam String fullName,
//            @RequestParam String nationalId,
//            @RequestParam String address,
//            @RequestParam String phone,
//            @RequestParam String serviceType,
//            @RequestParam String meterType,
//            @RequestParam Long customerId,
//            @RequestPart("picture") MultipartFile picture) {
//
//        try {
//            // Validate required fields
//            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
//                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
//                return ResponseEntity.badRequest().body("All required fields must be filled");
//            }
//
//            // Validate picture
//            if (picture == null || picture.isEmpty()) {
//                return ResponseEntity.badRequest().body("Picture is required");
//            }
//
//            if (picture.getSize() > 5 * 1024 * 1024) {
//                return ResponseEntity.badRequest().body("Picture must be less than 5MB");
//            }
//
//            String contentType = picture.getContentType();
//            if (contentType == null || !contentType.startsWith("image/")) {
//                return ResponseEntity.badRequest().body("Only image files are allowed");
//            }
//
//            // Store file and save data
//            String filename = storeFile(picture);
//            RequestForm form = saveRequestData(
//                    fullName, nationalId, address, phone,
//                    serviceType, meterType, customerId, filename
//            );
//
//            return ResponseEntity.ok().body(
//                    Map.of(
//                            "message", "Request submitted successfully",
//                            "id", form.getId(),
//                            "pictureUrl", "/api/images/" + filename
//                    )
//            );
//
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving picture: " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Unexpected error: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<RequestFormDTO>> getAllRequests() {
//        List<RequestForm> requests = requestFormService.getAllRequests();
//
//        List<RequestFormDTO> dtos = requests.stream().map(request -> {
//            RequestFormDTO dto = new RequestFormDTO();
//            dto.setId(request.getId());
//            dto.setFullName(request.getFullName());
//            dto.setNationalId(request.getNationalId());
//            dto.setAddress(request.getAddress());
//            dto.setPhone(request.getPhone());
//            dto.setServiceType(request.getServiceType());
//            dto.setMeterType(request.getMeterType());
//            dto.setPicturePath(request.getPicturePath());
//            dto.setCreatedAt(request.getCreatedAt());
//
//            if (request.getCustomer() != null) {
//                dto.setCustomerId(request.getCustomer().getId());
//                dto.setCustomerName(request.getCustomer().getName());
//            }
//
//            return dto;
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.ok(dtos);
//    }
//
//    private String storeFile(MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String filename = UUID.randomUUID() + fileExtension;
//
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        Path filePath = uploadPath.resolve(filename);
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//        return filename;
//    }
//
//    private RequestForm saveRequestData(
//            String fullName, String nationalId, String address,
//            String phone, String serviceType, String meterType,
//            Long customerId, String filename) {
//
//        Customer customer = customerService.getCustomerById(customerId)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        RequestForm form = new RequestForm();
//        form.setFullName(fullName);
//        form.setNationalId(nationalId);
//        form.setAddress(address);
//        form.setPhone(phone);
//        form.setServiceType(serviceType);
//        form.setMeterType(meterType);
//        form.setPicturePath(filename);
//        form.setCustomer(customer);
//
//        return requestFormService.save(form);
//    }
//}
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Service.CustomerService;
//import com.zawadig.myafwanii.Service.RequestFormService;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/requestsform")
//@CrossOrigin(origins = {"*"})
//public class RequestFormController {
//
//    @Autowired
//    private RequestFormService requestFormService;
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
//    private String UPLOAD_DIR;
//
//    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> submitRequestForm(
//            @RequestParam String fullName,
//            @RequestParam String nationalId,
//            @RequestParam String address,
//            @RequestParam String phone,
//            @RequestParam String serviceType,
//            @RequestParam String meterType,
//            @RequestParam Long customerId,
//            @RequestPart("picture") MultipartFile picture) {
//
//        try {
//            // Validate required fields
//            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
//                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
//                return ResponseEntity.badRequest().body("All required fields must be filled");
//            }
//
//            // Validate picture
//            if (picture == null || picture.isEmpty()) {
//                return ResponseEntity.badRequest().body("Picture is required");
//            }
//
//            if (picture.getSize() > 5 * 1024 * 1024) {
//                return ResponseEntity.badRequest().body("Picture must be less than 5MB");
//            }
//
//            String contentType = picture.getContentType();
//            if (contentType == null || !contentType.startsWith("image/")) {
//                return ResponseEntity.badRequest().body("Only image files are allowed");
//            }
//
//            // Store file and save data
//            String filename = storeFile(picture);
//            RequestForm form = saveRequestData(
//                    fullName, nationalId, address, phone,
//                    serviceType, meterType, customerId, filename
//            );
//
//            return ResponseEntity.ok().body(
//                    Map.of(
//                            "message", "Request submitted successfully",
//                            "id", form.getId(),
//                            "pictureUrl", "/api/images/" + filename
//                    )
//            );
//
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving picture: " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Unexpected error: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<RequestFormDTO>> getAllRequests() {
//        try {
//            List<RequestFormDTO> requests = requestFormService.getAllRequestsAsDTO();
//            return ResponseEntity.ok(requests);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
//        try {
//            RequestFormDTO request = requestFormService.getRequestById(id);
//            if (request != null) {
//                return ResponseEntity.ok(request);
//            }
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error fetching request: " + e.getMessage());
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
//        try {
//            requestFormService.deleteRequest(id);
//            return ResponseEntity.ok().body(Map.of("message", "Request deleted successfully"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error deleting request: " + e.getMessage());
//        }
//    }
//
//    private String storeFile(MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String filename = UUID.randomUUID() + fileExtension;
//
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        Path filePath = uploadPath.resolve(filename);
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//        return filename;
//    }
//
//    private RequestForm saveRequestData(
//            String fullName, String nationalId, String address,
//            String phone, String serviceType, String meterType,
//            Long customerId, String filename) {
//
//        Customer customer = customerService.getCustomerById(customerId)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        RequestForm form = new RequestForm();
//        form.setFullName(fullName);
//        form.setNationalId(nationalId);
//        form.setAddress(address);
//        form.setPhone(phone);
//        form.setServiceType(serviceType);
//        form.setMeterType(meterType);
//        form.setPicturePath(filename);
//        form.setCustomer(customer);
//
//        return requestFormService.save(form);
//    }
//  muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu

























//
//
//package com.zawadig.myafwanii.Controller;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Service.CustomerService;
//import com.zawadig.myafwanii.Service.RequestFormService;
//import com.zawadig.myafwanii.dto.RequestFormDTO;
//import com.zawadig.myafwanii.dto.RequestFormResponseDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/requestsform")
//@CrossOrigin(origins = "*")
//public class RequestFormController {
//
//    @Autowired
//    private RequestFormService requestFormService;
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
//    private String UPLOAD_DIR;
//
//    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> submitRequestForm(
//            @RequestParam String fullName,
//            @RequestParam String nationalId,
//            @RequestParam String address,
//            @RequestParam String phone,
//            @RequestParam String serviceType,
//            @RequestParam String meterType,
//            @RequestParam Long customerId,
//            @RequestPart("picture") MultipartFile picture) {
//
//        try {
//            // Validate required fields
//            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
//                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "All required fields must be filled"
//                ));
//            }
//
//            // Validate picture
//            if (picture == null || picture.isEmpty()) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Picture is required"
//                ));
//            }
//
//            if (picture.getSize() > 5 * 1024 * 1024) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Picture must be less than 5MB"
//                ));
//            }
//
//            String contentType = picture.getContentType();
//            if (contentType == null || !contentType.startsWith("image/")) {
//                return ResponseEntity.badRequest().body(Map.of(
//                        "success", false,
//                        "message", "Only image files are allowed"
//                ));
//            }
//
//            // Store file and save data
//            String filename = storeFile(picture);
//            RequestForm form = saveRequestData(
//                    fullName, nationalId, address, phone,
//                    serviceType, meterType, customerId, filename
//            );
//
//            // Response with DTO
//            RequestFormResponseDTO responseDTO = new RequestFormResponseDTO(
//                    "Request submitted successfully",
//                    form.getId(),
//                    "/api/images/" + filename,
//                    "Tafadhali tumia requestFormId hii kuendelea na malipo."
//            );
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
//
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "Error saving picture: " + e.getMessage()
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "Unexpected error: " + e.getMessage()
//            ));
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<RequestFormDTO>> getAllRequests() {
//        try {
//            List<RequestFormDTO> requests = requestFormService.getAllRequestsAsDTO();
//            return ResponseEntity.ok(requests);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
//        try {
//            RequestFormDTO request = requestFormService.getRequestById(id);
//            if (request != null) {
//                return ResponseEntity.ok(request);
//            }
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
//                    "success", false,
//                    "message", "Request not found"
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "Error fetching request: " + e.getMessage()
//            ));
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
//        try {
//            requestFormService.deleteRequest(id);
//            return ResponseEntity.ok().body(Map.of(
//                    "success", true,
//                    "message", "Request deleted successfully"
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
//                    "success", false,
//                    "message", "Error deleting request: " + e.getMessage()
//            ));
//        }
//    }
//
//    private String storeFile(MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String filename = UUID.randomUUID() + fileExtension;
//
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        Path filePath = uploadPath.resolve(filename);
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//        return filename;
//    }
//
//    private RequestForm saveRequestData(
//            String fullName, String nationalId, String address,
//            String phone, String serviceType, String meterType,
//            Long customerId, String filename) {
//
//        Customer customer = customerService.getCustomerById(customerId)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        RequestForm form = new RequestForm();
//        form.setFullName(fullName);
//        form.setNationalId(nationalId);
//        form.setAddress(address);
//        form.setPhone(phone);
//        form.setServiceType(serviceType);
//        form.setMeterType(meterType);
//        form.setPicturePath(filename);
//        form.setCustomer(customer);
//
//        return requestFormService.save(form);
//    }
//}


package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Model.Customer;
import com.zawadig.myafwanii.Model.RequestForm;
import com.zawadig.myafwanii.Model.ServicePayment;
import com.zawadig.myafwanii.Service.CustomerService;
import com.zawadig.myafwanii.Service.NotificationService;
import com.zawadig.myafwanii.Service.NotificationServiceImpl;
import com.zawadig.myafwanii.Service.RequestFormService;
import com.zawadig.myafwanii.dto.RequestFormDTO;
import com.zawadig.myafwanii.dto.RequestFormResponseDTO;
import com.zawadig.myafwanii.enums.RequestStatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/requestsform")
@CrossOrigin(origins = "*")
public class RequestFormController {

    @Autowired
    private RequestFormService requestFormService;
    @Autowired // ✅ HAKIKISHA UNA INJECT NOTIFICATION SERVICE
    private NotificationService notificationService;

    @Autowired
    private CustomerService customerService;

    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
    private String UPLOAD_DIR;

    // ========================= Submit Request Form =========================
    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> submitRequestForm(
            @RequestParam String fullName,
            @RequestParam String nationalId,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam String serviceType,
            @RequestParam String meterType,
            @RequestParam Long customerId,
            @RequestPart("picture") MultipartFile picture) {

        try {
            // Validate required fields
            if (fullName.isEmpty() || nationalId.isEmpty() || address.isEmpty() ||
                    phone.isEmpty() || serviceType.isEmpty() || meterType.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of(
                        "success", false,
                        "message", "All required fields must be filled"
                ));
            }

            // Validate picture
            if (picture == null || picture.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of(
                        "success", false,
                        "message", "Picture is required"
                ));
            }

            if (picture.getSize() > 5 * 1024 * 1024) {
                return ResponseEntity.badRequest().body(Map.of(
                        "success", false,
                        "message", "Picture must be less than 5MB"
                ));
            }

            String contentType = picture.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.badRequest().body(Map.of(
                        "success", false,
                        "message", "Only image files are allowed"
                ));
            }

            // Store file and save data
            String filename = storeFile(picture);
            RequestForm form = saveRequestData(
                    fullName, nationalId, address, phone,
                    serviceType, meterType, customerId, filename
            );

            // Response with DTO
            RequestFormResponseDTO responseDTO = new RequestFormResponseDTO(
                    "Request submitted successfully",
                    form.getId(),
                    "/api/images/" + filename,
                    "Tafadhali subiri admin verify request ili upate control number."
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "Error saving picture: " + e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "Unexpected error: " + e.getMessage()
            ));
        }
    }

    // ========================= Get All Requests =========================
    @GetMapping("/all")
    public ResponseEntity<List<RequestFormDTO>> getAllRequests() {
        try {
            List<RequestFormDTO> requests = requestFormService.getAllRequestsAsDTO();
            return ResponseEntity.ok(requests);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ========================= Get Single Request =========================
    @GetMapping("/{id}")
    public ResponseEntity<?> getRequestById(@PathVariable Long id) {
        try {
            RequestFormDTO request = requestFormService.getRequestById(id);
            if (request != null) {
                return ResponseEntity.ok(request);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "success", false,
                    "message", "Request not found"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "Error fetching request: " + e.getMessage()
            ));
        }
    }

    // ========================= Delete Request =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
        try {
            requestFormService.deleteRequest(id);
            return ResponseEntity.ok().body(Map.of(
                    "success", true,
                    "message", "Request deleted successfully"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "Error deleting request: " + e.getMessage()
            ));
        }
    }
    // ========================= Get Requests by Customer ID =========================
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getRequestsByCustomer(@PathVariable Long customerId) {
        try {
            List<RequestFormDTO> requests = requestFormService.getRequestsByCustomerId(customerId);

            if (requests.isEmpty()) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Huna maombi yoyote",
                        "requests", requests
                ));
            }

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "requests", requests
            ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "success", false,
                    "message", "Error fetching requests: " + e.getMessage()
            ));
        }
    }


    //
    // ========================= Verify Request Form (Admin) =========================
    // ========================= Verify Request Form (Admin) =========================
    @PutMapping("/verify/{requestId}")
    @Transactional
    public ResponseEntity<?> verifyRequestForm(@PathVariable Long requestId) {
        try {
            RequestForm verified = requestFormService.verifyRequest(requestId);

            // Thibitisha ID ya customer
            Long customerId = verified.getCustomer().getId();
            System.out.println("Customer ID from request: " + customerId);

            // Tuma notifikesheni
            String title = "Ombi Lathibitishwa";
            String message = "Namba yako ya Kudhibiti: " + verified.getControlNumber();

            notificationService.sendNotification(customerId, title, message);

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "controlNumber", verified.getControlNumber()
            ));
        } catch (Exception e) {
            System.err.println("!!! ERROR IN VERIFICATION !!!");
            e.printStackTrace();

            return ResponseEntity.status(500).body(Map.of(
                    "success", false,
                    "message", "Error: " + e.getMessage()
            ));
        }
    }
    // ========================= Helper Methods =========================
    private String storeFile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID() + fileExtension;

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(filename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

    private RequestForm saveRequestData(
            String fullName, String nationalId, String address,
            String phone, String serviceType, String meterType,
            Long customerId, String filename) {

        Customer customer = customerService.getCustomerById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        RequestForm form = new RequestForm();
        form.setFullName(fullName);
        form.setNationalId(nationalId);
        form.setAddress(address);
        form.setPhone(phone);
        form.setServiceType(serviceType);
        form.setMeterType(meterType);
        form.setPicturePath(filename);
        form.setCustomer(customer);
        form.setStatus(RequestStatus.PENDING); // default status

        return requestFormService.save(form);
    }
}
