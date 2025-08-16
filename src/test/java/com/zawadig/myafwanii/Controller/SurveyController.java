package com.zawadig.myafwanii.Controller;


import com.zawadig.myafwanii.Model.Survey;
import com.zawadig.myafwanii.Service.SurveyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.Data;

//@RestController
//@RequestMapping("/api/v1/survey")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.ok(survey);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed: " + e.getMessage());
//        }
//    }
//
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}



//@RestController
//@RequestMapping("/api/v1/survey")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.ok(survey);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed: " + e.getMessage());
//        }
//    }
//
//    @GetMapping("/with-customer")
//    public ResponseEntity<?> getSurveysWithCustomers() {
//        return ResponseEntity.ok(surveyService.getAllSurveysWithCustomer());
//    }
//
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}





//
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Service.SurveyService;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/surveys")
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    // ✅ 1. Create new survey
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.ok(survey);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to create survey: " + e.getMessage());
//        }
//    }
//
//    // ✅ 2. Get all surveys (for admin panel)
//    @GetMapping("/with-customer")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {
//        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();
//        return ResponseEntity.ok(response);
//    }
//
//    // ✅ DTO for receiving survey creation request
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}















//
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Service.SurveyService;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/surveys")
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    // 1. Create new survey
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.ok(survey);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to create survey: " + e.getMessage());
//        }
//    }
//
//    // 2. Get all surveys (for admin panel)
//    @GetMapping("/with-customer")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {
//        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();
//        return ResponseEntity.ok(response);
//    }
//
//    // 3. Get surveys for a specific technician
//    @GetMapping("/technician/{technicianId}")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByTechnician(@PathVariable Long technicianId) {
//        List<SurveyCustomerResponse> response = surveyService.getSurveysByTechnician(technicianId);
//        return ResponseEntity.ok(response);
//    }
//
//    // DTO for receiving survey creation request
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}


//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Service.SurveyService;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import com.itextpdf.text.DocumentException;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/surveys")
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    // 1. Create new survey
//    // ...existing code...
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            // Badilisha hapa: Rudisha id tu kwenye response
//            return ResponseEntity.status(HttpStatus.CREATED).body(
//                    java.util.Collections.singletonMap("id", survey.getId())
//            );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Failed to create survey: " + e.getMessage());
//        }
//    }
//    // ...existing code...
//    // 2. Get all surveys (for admin panel)
//    @GetMapping("/with-customer")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {
//        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();
//        return ResponseEntity.ok(response);
//    }
//
//    // 3. Get surveys for a specific technician
//    @GetMapping("/technician/{technicianId}")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByTechnician(@PathVariable Long technicianId) {
//        List<SurveyCustomerResponse> response = surveyService.getSurveysByTechnician(technicianId);
//        return ResponseEntity.ok(response);
//    }
//
//    // 4. Get a single survey with its customer details
//    @GetMapping("/report/{surveyId}")
//    public ResponseEntity<SurveyCustomerResponse> getSurveyReportById(@PathVariable Long surveyId) {
//        try {
//            SurveyCustomerResponse response = surveyService.getSurveyWithCustomerById(surveyId);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // 5. Download survey report as a PDF
//    @GetMapping("/report/download/{surveyId}")
//    public ResponseEntity<byte[]> downloadSurveyReport(@PathVariable Long surveyId) {
//        try {
//            byte[] pdfReport = surveyService.generateSurveyReportPdf(surveyId);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            String filename = "survey_report_" + surveyId + ".pdf";
//            headers.setContentDispositionFormData("attachment", filename);
//
//            return new ResponseEntity<>(pdfReport, headers, HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//
//    }
//    // 6. Verify survey and notify customer
//    @PutMapping("/verify/{surveyId}")
//    public ResponseEntity<?> verifySurvey(
//            @PathVariable Long surveyId,
//            @RequestParam String serviceDate // tarehe ya huduma kutoka frontend
//    ) {
//        try {
//            // Hii method itakuwa kwenye SurveyService
//            surveyService.verifySurveyAndNotifyCustomer(surveyId, serviceDate);
//            return ResponseEntity.ok("Survey verified and customer notified.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Verification failed: " + e.getMessage());
//        }
//    }
//
//
//    // DTO for receiving survey creation request
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}



//
//
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Service.SurveyService;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/surveys")
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    // Create new survey
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.status(HttpStatus.CREATED).body(
//                    Map.of("id", survey.getId())
//            );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(
//                    Map.of("error", "Failed to create survey: " + e.getMessage())
//            );
//        }
//    }
//
//    // Get all surveys with customer details
//    @GetMapping("/with-customer")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {
//        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();
//        return ResponseEntity.ok(response);
//    }
//
//    // Get surveys by technician
//    @GetMapping("/technician/{technicianId}")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByTechnician(@PathVariable Long technicianId) {
//        List<SurveyCustomerResponse> response = surveyService.getSurveysByTechnician(technicianId);
//        return ResponseEntity.ok(response);
//    }
//
//    // Get single survey report
//    @GetMapping("/report/{surveyId}")
//    public ResponseEntity<SurveyCustomerResponse> getSurveyReportById(@PathVariable Long surveyId) {
//        try {
//            SurveyCustomerResponse response = surveyService.getSurveyWithCustomerById(surveyId);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Download PDF report
//    @GetMapping("/report/download/{surveyId}")
//    public ResponseEntity<byte[]> downloadSurveyReport(@PathVariable Long surveyId) {
//        try {
//            byte[] pdfReport = surveyService.generateSurveyReportPdf(surveyId);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDispositionFormData(
//                    "attachment",
//                    "survey_report_" + surveyId + ".pdf"
//            );
//
//            return new ResponseEntity<>(pdfReport, headers, HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    // Verify survey endpoint
//    @PutMapping("/verify/{surveyId}")
//    public ResponseEntity<?> verifySurvey(
//            @PathVariable Long surveyId,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate serviceDate
//    ) {
//        try {
//            Survey verifiedSurvey = surveyService.verifySurveyAndNotifyCustomer(
//                    surveyId,
//                    serviceDate
//            );
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Survey verified successfully",
//                    "survey", verifiedSurvey
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Map.of(
//                            "success", false,
//                            "message", "Verification failed: " + e.getMessage()
//                    ));
//        }
//    }
//
//    // Request DTO
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}
//

//
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Service.SurveyService;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/surveys")
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    // Create new survey
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.status(HttpStatus.CREATED).body(
//                    Map.of("id", survey.getId())
//            );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(
//                    Map.of("error", "Failed to create survey: " + e.getMessage())
//            );
//        }
//    }
//
//    // Get all surveys with customer details
//    @GetMapping("/with-customer")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {
//        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();
//        return ResponseEntity.ok(response);
//    }
//
//    // Get surveys by technician
//    @GetMapping("/technician/{technicianId}")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByTechnician(@PathVariable Long technicianId) {
//        List<SurveyCustomerResponse> response = surveyService.getSurveysByTechnician(technicianId);
//        return ResponseEntity.ok(response);
//    }
//
//    // Get single survey report
//    @GetMapping("/report/{surveyId}")
//    public ResponseEntity<SurveyCustomerResponse> getSurveyReportById(@PathVariable Long surveyId) {
//        try {
//            SurveyCustomerResponse response = surveyService.getSurveyWithCustomerById(surveyId);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Verify survey endpoint
//    @PutMapping("/verify/{surveyId}")
//    public ResponseEntity<?> verifySurvey(
//            @PathVariable Long surveyId,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate serviceDate
//    ) {
//        try {
//            Survey verifiedSurvey = surveyService.verifySurveyAndNotifyCustomer(
//                    surveyId,
//                    serviceDate
//            );
//
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Survey verified successfully",
//                    "survey", verifiedSurvey
//            ));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of(
//                            "success", false,
//                            "message", "Verification failed: " + e.getMessage()
//                    ));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Map.of(
//                            "success", false,
//                            "message", "Verification failed: " + e.getMessage()
//                    ));
//        }
//    }
//
//    // Request DTO
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//} muimuuuuuuuuuuuuuuu









//
//
//
//
//
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Service.SurveyService;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/surveys")
//@CrossOrigin(origins = "http://localhost:3000")
//@RequiredArgsConstructor
//public class SurveyController {
//
//    private final SurveyService surveyService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {
//        try {
//            Survey survey = surveyService.createSurvey(
//                    request.getRequestFormId(),
//                    request.getTechnicianId(),
//                    request.getLocation(),
//                    request.getNotes()
//            );
//            return ResponseEntity.status(HttpStatus.CREATED).body(
//                    Map.of("id", survey.getId())
//            );
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(
//                    Map.of("error", "Failed to create survey: " + e.getMessage())
//            );
//        }
//    }
//
//    @GetMapping("/with-customer")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {
//        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/technician/{technicianId}")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByTechnician(@PathVariable Long technicianId) {
//        List<SurveyCustomerResponse> response = surveyService.getSurveysByTechnician(technicianId);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByCustomer(@PathVariable Long customerId) {
//        List<SurveyCustomerResponse> response = surveyService.getSurveysByCustomer(customerId);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/report/{surveyId}")
//    public ResponseEntity<SurveyCustomerResponse> getSurveyReportById(@PathVariable Long surveyId) {
//        try {
//            SurveyCustomerResponse response = surveyService.getSurveyWithCustomerById(surveyId);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/verify/{surveyId}")
//    public ResponseEntity<?> verifySurvey(
//            @PathVariable Long surveyId,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate serviceDate
//    ) {
//        try {
//            Survey verifiedSurvey = surveyService.verifySurveyAndNotifyCustomer(
//                    surveyId,
//                    serviceDate
//            );
//            return ResponseEntity.ok(Map.of(
//                    "success", true,
//                    "message", "Survey verified successfully",
//                    "survey", verifiedSurvey
//            ));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of(
//                            "success", false,
//                            "message", e.getMessage()
//                    ));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(Map.of(
//                            "success", false,
//                            "message", "Verification failed: " + e.getMessage()
//                    ));
//        }
//    }
//
//    @Data
//    public static class SurveyRequest {
//        private Long requestFormId;
//        private Long technicianId;
//        private String location;
//        private String notes;
//    }
//}
//

import com.zawadig.myafwanii.Model.Survey;

import com.zawadig.myafwanii.Service.SurveyService;

import com.zawadig.myafwanii.dto.SurveyCustomerResponse;

import lombok.Data;

import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



import java.io.IOException;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.List;

import java.util.Map;



@RestController

@RequestMapping("/api/v1/surveys")

@CrossOrigin(origins = "http://localhost:3000")

@RequiredArgsConstructor

public class SurveyController {



    private final SurveyService surveyService;



// Create new survey

    @PostMapping("/create")

    public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest request) {

        try {

            Survey survey = surveyService.createSurvey(

                    request.getRequestFormId(),

                    request.getTechnicianId(),

                    request.getLocation(),

                    request.getNotes()

            );

            return ResponseEntity.status(HttpStatus.CREATED).body(

                    Map.of("id", survey.getId())

            );

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(

                    Map.of("error", "Failed to create survey: " + e.getMessage())

            );

        }

    }



// Get all surveys with customer details

    @GetMapping("/with-customer")

    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysWithCustomers() {

        List<SurveyCustomerResponse> response = surveyService.getAllSurveysWithCustomer();

        return ResponseEntity.ok(response);

    }



// Get surveys by technician

    @GetMapping("/technician/{technicianId}")

    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByTechnician(@PathVariable Long technicianId) {

        List<SurveyCustomerResponse> response = surveyService.getSurveysByTechnician(technicianId);

        return ResponseEntity.ok(response);

    }



// Get single survey report

    @GetMapping("/report/{surveyId}")

    public ResponseEntity<SurveyCustomerResponse> getSurveyReportById(@PathVariable Long surveyId) {

        try {

            SurveyCustomerResponse response = surveyService.getSurveyWithCustomerById(surveyId);

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            return ResponseEntity.notFound().build();

        }

    }



// Download PDF report

    @GetMapping("/report/download/{surveyId}")

    public ResponseEntity<byte[]> downloadSurveyReport(@PathVariable Long surveyId) {

        try {

            byte[] pdfReport = surveyService.generateSurveyReportPdf(surveyId);



            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_PDF);

            headers.setContentDispositionFormData(

                    "attachment",

                    "survey_report_" + surveyId + ".pdf"

            );



            return new ResponseEntity<>(pdfReport, headers, HttpStatus.OK);

        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();

        }

    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<SurveyCustomerResponse>> getSurveysByCustomer(@PathVariable Long customerId) {
        List<SurveyCustomerResponse> response = surveyService.getSurveysByCustomer(customerId);
        return ResponseEntity.ok(response);
    }




// Verify survey endpoint

    @PutMapping("/verify/{surveyId}")

    public ResponseEntity<?> verifySurvey(

            @PathVariable Long surveyId,

            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate serviceDate

    ) {

        try {

            Survey verifiedSurvey = surveyService.verifySurveyAndNotifyCustomer(

                    surveyId,

                    serviceDate

            );



            return ResponseEntity.ok(Map.of(

                    "success", true,

                    "message", "Survey verified successfully",

                    "survey", verifiedSurvey

            ));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)

                    .body(Map.of(

                            "success", false,

                            "message", "Verification failed: " + e.getMessage()

                    ));

        }

    }



// Request DTO

    @Data

    public static class SurveyRequest {

        private Long requestFormId;

        private Long technicianId;

        private String location;

        private String notes;

    }

}