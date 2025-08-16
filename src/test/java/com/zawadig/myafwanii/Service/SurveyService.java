package com.zawadig.myafwanii.Service;//package com.zawadig.myafwanii.Service;
//
//
//
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Model.Technician;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import com.zawadig.myafwanii.Repository.TechnicianRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final TechnicianRepository technicianRepository;
//
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new RuntimeException("Request Form not found"));
//        Technician technician = technicianRepository.findById(technicianId)
//                .orElseThrow(() -> new RuntimeException("Technician not found"));
//
//        Survey survey = Survey.builder()
//                .requestForm(requestForm)
//                .technician((Staff) technician)
//                .location(location)
//                .notes(notes)
//                .build();
//
//        return surveyRepository.save(survey);
//    }
//}muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu

















//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        Optional<RequestForm> requestFormOpt = requestFormRepository.findById(requestFormId);
//        if (requestFormOpt.isEmpty()) throw new Exception("Request form not found");
//
//        Optional<Staff> technicianOpt = staffRepository.findById(technicianId);
//        if (technicianOpt.isEmpty()) throw new Exception("Technician not found");
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestFormOpt.get());
//        survey.setTechnician(technicianOpt.get());
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//
//        return surveyRepository.save(survey);
//    }
//}
// muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu



















//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//
//    // ✅ Method 1: Create Survey
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        Optional<RequestForm> requestFormOpt = requestFormRepository.findById(requestFormId);
//        if (requestFormOpt.isEmpty()) throw new Exception("Request form not found");
//
//        Optional<Staff> technicianOpt = staffRepository.findById(technicianId);
//        if (technicianOpt.isEmpty()) throw new Exception("Technician not found");
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestFormOpt.get());
//        survey.setTechnician(technicianOpt.get());
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//
//        return surveyRepository.save(survey);
//    }
//
//    // ✅ Method 2: Get all surveys with customer info (for Admin)
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        List<Survey> surveys = surveyRepository.findAll();
//
//        return surveys.stream().map(survey -> {
//            RequestForm form = survey.getRequestForm();
//            Customer customer = form.getCustomer();
//
//            return SurveyCustomerResponse.builder()
//                    .surveyId(survey.getId())
//                    .location(survey.getLocation())
//                    .notes(survey.getNotes())
//                    .surveyDate(survey.getSurveyDate())
//                    .technicianId(survey.getTechnician().getId())
//                    .customerId(customer.getId())
//                    .customerName(customer.getFullName())
//                    .build();
//        }).collect(Collectors.toList());
//    }
//}
//





//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//
//    // ✅ Method 1: Create a new survey
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new Exception("Request form not found"));
//
//        Staff technician = staffRepository.findById(technicianId)
//                .orElseThrow(() -> new Exception("Technician not found"));
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestForm);
//        survey.setTechnician(technician);
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//
//        return surveyRepository.save(survey);
//    }
//
//    // ✅ Method 2: Get all surveys with customer info (for Admin)
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        return surveyRepository.findAll().stream().map(survey -> {
//            RequestForm form = survey.getRequestForm();
//            Customer customer = form.getCustomer();
//
//            return SurveyCustomerResponse.builder()
//                    .surveyId(survey.getId())
//                    .location(survey.getLocation())
//                    .notes(survey.getNotes())
//                    .surveyDate(survey.getCreatedAt()) // ✅ use createdAt for surveyDate
//                    .technicianId(survey.getTechnician().getId())
//                    .customerId(customer.getId())
//                    .customerName(customer.getFullName())
//                    .build();
//        }).collect(Collectors.toList());
//    }
//}



//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//
//    // ✅ Method 1: Create a new survey
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new Exception("Request form not found"));
//
//        Staff technician = staffRepository.findById(technicianId)
//                .orElseThrow(() -> new Exception("Technician not found"));
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestForm);
//        survey.setTechnician(technician);
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//
//        return surveyRepository.save(survey);
//    }
//
//    // ✅ Method 2: Get all surveys with customer info (for Admin)
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        return surveyRepository.findAll().stream().map(survey -> {
//            RequestForm form = survey.getRequestForm();
//            Customer customer = form.getCustomer();
//
//            return SurveyCustomerResponse.builder()
//                    .surveyId(survey.getId())
//                    .location(survey.getLocation())
//                    .notes(survey.getNotes())
//                    .surveyDate(survey.getCreatedAt()) // use createdAt as surveyDate
//                    .technicianId(survey.getTechnician().getId())
//                    .customerId(customer.getId())
//                    .customerName(customer.getFullName())
//                    .build();
//        }).collect(Collectors.toList());
//    }
//
//    // ✅ Method 3: Get surveys with customers by Technician ID
//    public List<SurveyCustomerResponse> getSurveysByTechnician(Long technicianId) {
//        return surveyRepository.findByTechnicianIdWithCustomer(technicianId).stream().map(surveyResponse -> {
//            // surveyResponse is already SurveyCustomerResponse DTO from repository query
//            return surveyResponse;
//        }).collect(Collectors.toList());
//    }
//}muimuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu







import com.zawadig.myafwanii.Model.*;

import com.zawadig.myafwanii.Repository.*;

import com.zawadig.myafwanii.Service.EmailService;
import com.zawadig.myafwanii.Service.NotificationService;
import com.zawadig.myafwanii.dto.SurveyCustomerResponse;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfWriter;

import jakarta.mail.MessagingException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



import java.io.ByteArrayOutputStream;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;


@Service

@RequiredArgsConstructor

public class SurveyService {


    private final SurveyRepository surveyRepository;

    private final RequestFormRepository requestFormRepository;

    private final StaffRepository staffRepository;

    private final EmailService emailService;

    private final NotificationService notificationService;


    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {

        RequestForm requestForm = requestFormRepository.findById(requestFormId)

                .orElseThrow(() -> new Exception("Request form not found"));


        Staff technician = staffRepository.findById(technicianId)

                .orElseThrow(() -> new Exception("Technician not found"));


        Survey survey = new Survey();

        survey.setRequestForm(requestForm);

        survey.setTechnician(technician);

        survey.setLocation(location);

        survey.setNotes(notes);

        survey.setCreatedAt(LocalDateTime.now());

        survey.setSurveyStatus("PENDING");


        return surveyRepository.save(survey);

    }


    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {

        return surveyRepository.findAllWithCustomer();

    }


    public List<SurveyCustomerResponse> getSurveysByTechnician(Long technicianId) {

        return surveyRepository.findByTechnicianIdWithCustomer(technicianId);

    }


    public SurveyCustomerResponse getSurveyWithCustomerById(Long surveyId) throws Exception {

        return surveyRepository.findWithCustomerById(surveyId)

                .orElseThrow(() -> new Exception("Survey not found with ID: " + surveyId));

    }


    public byte[] generateSurveyReportPdf(Long surveyId) throws Exception {

        SurveyCustomerResponse survey = getSurveyWithCustomerById(surveyId);


        Document document = new Document();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);


        document.open();


        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(46, 117, 182));

        Font headerFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);

        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);


        document.add(new Paragraph("RIPOTI YA UKAGUZI WA HUDUMA", titleFont));

        document.add(Chunk.NEWLINE);


        document.add(new Paragraph("Taarifa za Ukaguzi", headerFont));

        document.add(new Paragraph("ID: " + survey.getSurveyId(), normalFont));

        document.add(new Paragraph("Tarehe: " + survey.getSurveyDate(), normalFont));

        document.add(new Paragraph("Mahali: " + survey.getLocation(), normalFont));

        document.add(Chunk.NEWLINE);


        document.add(new Paragraph("Taarifa za Mteja", headerFont));

        document.add(new Paragraph("Jina: " + survey.getCustomerName(), normalFont));

        document.add(Chunk.NEWLINE);


        document.add(new Paragraph("Maelezo:", headerFont));

        document.add(new Paragraph(survey.getNotes(), normalFont));


        document.close();

        return baos.toByteArray();

    }

    public Survey verifySurveyAndNotifyCustomer(Long surveyId, LocalDate serviceDate) throws Exception {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new Exception("Survey not found"));

        survey.setSurveyStatus("VERIFIED");
        survey.setServiceDate(serviceDate);
        Survey verifiedSurvey = surveyRepository.save(survey);

        // Tuma notifikesheni
        String title = "Ukaguzi Umeidhinishwa";
        String message = "Tarehe ya Huduma: " + serviceDate;

        notificationService.sendNotification(
                survey.getRequestForm().getCustomer().getId(),
                title,
                message
        );

        return verifiedSurvey;
    }

    public Survey findByRequestFormId(Long requestFormId) {

        return surveyRepository.findByRequestFormId(requestFormId);

    }


    public void updateSurveyStatus(Long surveyId, String status) throws Exception {

        Survey survey = surveyRepository.findById(surveyId)

                .orElseThrow(() -> new Exception("Survey not found"));

        survey.setSurveyStatus(status);

        surveyRepository.save(survey);

    }

    public List<SurveyCustomerResponse> getSurveysByCustomer(Long customerId) {
        return surveyRepository.findByCustomerId(customerId)
                .stream()
                .map(survey -> SurveyCustomerResponse.builder()
                        .surveyId(survey.getId())
                        .location(survey.getLocation())
                        .notes(survey.getNotes())
                        .surveyDate(survey.getSurveyDate())
                        .technicianId(survey.getTechnician().getId())
                        .customerId(survey.getCustomer().getId())
                        .customerName(survey.getCustomer().getName())
                        .build()
                )
                .toList();

    }
}







//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import jakarta.mail.MessagingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//    private final EmailService emailService; // ✅ Injected properly
//
//    // ✅ Method 1: Create a new survey
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new Exception("Request form not found"));
//
//        Staff technician = staffRepository.findById(technicianId)
//                .orElseThrow(() -> new Exception("Technician not found"));
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestForm);
//        survey.setTechnician(technician);
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//
//        return surveyRepository.save(survey);
//    }
//
//    // ✅ Method 2: Get all surveys with customer info
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        return surveyRepository.findAllWithCustomer();
//    }
//
//    // ✅ Method 3: Get surveys by technician
//    public List<SurveyCustomerResponse> getSurveysByTechnician(Long technicianId) {
//        return surveyRepository.findByTechnicianIdWithCustomer(technicianId);
//    }
//
//    // ✅ Method 4: Get single survey with customer
//    public SurveyCustomerResponse getSurveyWithCustomerById(Long surveyId) throws Exception {
//        return surveyRepository.findWithCustomerById(surveyId)
//                .orElseThrow(() -> new Exception("Survey not found with ID: " + surveyId));
//    }
//
//    // ✅ Method 5: Generate PDF report
//    public byte[] generateSurveyReportPdf(Long surveyId) throws DocumentException, IOException, Exception {
//        SurveyCustomerResponse survey = getSurveyWithCustomerById(surveyId);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document();
//        PdfWriter.getInstance(document, baos);
//
//        document.open();
//
//        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(46, 117, 182));
//        Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
//        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
//
//        document.add(new Paragraph("RIPOTI YA UKAGUZI WA HUDUMA", titleFont));
//        document.add(new Paragraph(" ", normalFont));
//
//        document.add(new Paragraph("Taarifa za Ukaguzi", subtitleFont));
//        document.add(new Paragraph("ID ya Ukaguzi: " + survey.getSurveyId(), normalFont));
//        document.add(new Paragraph("Tarehe ya Ukaguzi: " + survey.getSurveyDate(), normalFont));
//        document.add(new Paragraph("Eneo la Kazi: " + survey.getLocation(), normalFont));
//        document.add(new Paragraph(" ", normalFont));
//
//        document.add(new Paragraph("Taarifa za Mteja", subtitleFont));
//        document.add(new Paragraph("Jina la Mteja: " + survey.getCustomerName(), normalFont));
//        document.add(new Paragraph(" ", normalFont));
//
//        document.add(new Paragraph("Maelezo ya Fundi (Notes)", subtitleFont));
//        document.add(new Paragraph(survey.getNotes(), normalFont));
//
//        document.close();
//        return baos.toByteArray();
//    }
//
//    // ✅ Method 6: Verify survey and notify customer
//    public void verifySurveyAndNotifyCustomer(Long surveyId, String serviceDate) throws Exception {
//        Survey survey = surveyRepository.findById(surveyId)
//                .orElseThrow(() -> new Exception("Survey not found"));
//
//        survey.setSurveyStatus("verified");
//        survey.setServiceDate(LocalDate.parse(serviceDate));
//        surveyRepository.save(survey);
//
//        RequestForm form = survey.getRequestForm();
//        Customer customer = form.getCustomer();
//        String email = customer.getEmail();
//
//        String subject = "ZAWA - Taarifa ya Huduma";
//        String body = "<p>Habari " + customer.getFullName() + ",</p>"
//                + "<p>Survey yako imethibitishwa na huduma itafanyika tarehe <strong>" + serviceDate + "</strong>.</p>"
//                + "<p>Tafadhali hakikisha unakuwepo nyumbani siku hiyo.</p>"
//                + "<br><p>Asante kwa kutumia ZAWA.<br>Timu ya Huduma</p>";
//
//        try {
//            emailService.sendSimpleEmail(email, subject, body);
//        } catch (MessagingException e) {
//            System.out.println("Failed to send email: " + e.getMessage());
//        }
//    }
//
//    public List<SurveyCustomerResponse> getSurveysByCustomer(Long customerId) {
//        
//    }
//}

//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.*;
//import com.zawadig.myafwanii.Repository.*;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import jakarta.mail.MessagingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//    private final EmailService emailService;
//    private final NotificationService notificationService;
//
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new Exception("Request form not found"));
//
//        Staff technician = staffRepository.findById(technicianId)
//                .orElseThrow(() -> new Exception("Technician not found"));
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestForm);
//        survey.setTechnician(technician);
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//        survey.setSurveyStatus("PENDING");
//
//        return surveyRepository.save(survey);
//    }
//
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        return surveyRepository.findAllWithCustomer();
//    }
//
//    public List<SurveyCustomerResponse> getSurveysByTechnician(Long technicianId) {
//        return surveyRepository.findByTechnicianIdWithCustomer(technicianId);
//    }
//
//    public SurveyCustomerResponse getSurveyWithCustomerById(Long surveyId) throws Exception {
//        return surveyRepository.findWithCustomerById(surveyId)
//                .orElseThrow(() -> new Exception("Survey not found with ID: " + surveyId));
//    }
//
//    public byte[] generateSurveyReportPdf(Long surveyId) throws Exception {
//        SurveyCustomerResponse survey = getSurveyWithCustomerById(surveyId);
//
//        Document document = new Document();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PdfWriter.getInstance(document, baos);
//
//        document.open();
//
//        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(46, 117, 182));
//        Font headerFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
//        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
//
//        document.add(new Paragraph("RIPOTI YA UKAGUZI WA HUDUMA", titleFont));
//        document.add(Chunk.NEWLINE);
//
//        document.add(new Paragraph("Taarifa za Ukaguzi", headerFont));
//        document.add(new Paragraph("ID: " + survey.getSurveyId(), normalFont));
//        document.add(new Paragraph("Tarehe: " + survey.getSurveyDate(), normalFont));
//        document.add(new Paragraph("Mahali: " + survey.getLocation(), normalFont));
//        document.add(Chunk.NEWLINE);
//
//        document.add(new Paragraph("Taarifa za Mteja", headerFont));
//        document.add(new Paragraph("Jina: " + survey.getCustomerName(), normalFont));
//        document.add(Chunk.NEWLINE);
//
//        document.add(new Paragraph("Maelezo:", headerFont));
//        document.add(new Paragraph(survey.getNotes(), normalFont));
//
//        document.close();
//        return baos.toByteArray();
//    }
//
//    public Survey verifySurveyAndNotifyCustomer(Long surveyId, LocalDate serviceDate) throws Exception {
//        Survey survey = surveyRepository.findById(surveyId)
//                .orElseThrow(() -> new Exception("Survey not found"));
//
//        survey.setSurveyStatus("VERIFIED");
//        survey.setServiceDate(serviceDate);
//        Survey verifiedSurvey = surveyRepository.save(survey);
//
//        RequestForm form = survey.getRequestForm();
//        Customer customer = form.getCustomer();
//
//        String subject = "Ukaguzi Umeidhinishwa";
//        String message = String.format(
//                "Habari %s,\n\nUkaguzi wako umeidhinishwa.\nTarehe ya huduma: %s\n\nAsante kwa kutumia huduma zetu.",
//                customer.getFullName(),
//                serviceDate
//        );
//
//        try {
//            emailService.sendSimpleEmail(
//                    customer.getEmail(),
//                    subject,
//                    message.replace("\n", "<br>")
//            );
//            notificationService.sendNotificationToCustomer(customer, subject, message);
//        } catch (MessagingException e) {
//            System.err.println("Failed to send email: " + e.getMessage());
//        }
//
//        return verifiedSurvey;
//    }
//
//    public Survey findByRequestFormId(Long requestFormId) {
//        return surveyRepository.findByRequestFormId(requestFormId);
//    }
//
//    public void updateSurveyStatus(Long surveyId, String status) throws Exception {
//        Survey survey = surveyRepository.findById(surveyId)
//                .orElseThrow(() -> new Exception("Survey not found"));
//        survey.setSurveyStatus(status);
//        surveyRepository.save(survey);
//    }
//
//    public List<SurveyCustomerResponse> getSurveysByCustomer(Long customerId) {
//        return surveyRepository.findByCustomerIdWithCustomer(customerId);
//    }
//}


//
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.*;
//import com.zawadig.myafwanii.Repository.*;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import jakarta.mail.MessagingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//    private final EmailService emailService;
//    private final NotificationService notificationService;
//
//    // 1️⃣ Create new survey
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new Exception("Fomu ya ombi haijapatikana"));
//
//        Staff technician = staffRepository.findById(technicianId)
//                .orElseThrow(() -> new Exception("Fundi hajapatikana"));
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestForm);
//        survey.setTechnician(technician);
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setSurveyStatus("PENDING");
//        survey.setCreatedAt(LocalDateTime.now());
//        survey.setSurveyDate(LocalDateTime.now());
//
//        return surveyRepository.save(survey);
//    }
//
//    // 2️⃣ Get all surveys with customer details
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        return surveyRepository.findAllWithCustomer();
//    }
//
//    // 3️⃣ Get surveys by technician
//    public List<SurveyCustomerResponse> getSurveysByTechnician(Long technicianId) {
//        return surveyRepository.findByTechnicianIdWithCustomer(technicianId);
//    }
//
//    // 4️⃣ Get single survey with customer
//    public SurveyCustomerResponse getSurveyWithCustomerById(Long surveyId) throws Exception {
//        return surveyRepository.findWithCustomerById(surveyId)
//                .orElseThrow(() -> new Exception("Ukaguzi haujapatikana"));
//    }
//
//    // 5️⃣ Generate PDF report
//    public byte[] generateSurveyReportPdf(Long surveyId) throws Exception {
//        SurveyCustomerResponse survey = getSurveyWithCustomerById(surveyId);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document();
//        PdfWriter.getInstance(document, baos);
//
//        document.open();
//
//        // Add content to PDF
//        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(0, 0, 0));
//        Font headerFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
//        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
//
//        // Title
//        document.add(new Paragraph("RIPOTI YA UKAGUZI", titleFont));
//        document.add(Chunk.NEWLINE);
//
//        // Survey details
//        document.add(new Paragraph("TAARIFA ZA UKAGUZI", headerFont));
//        document.add(new Paragraph("Namba ya Ukaguzi: " + survey.getSurveyId(), normalFont));
//        document.add(new Paragraph("Tarehe: " + survey.getSurveyDate(), normalFont));
//        document.add(new Paragraph("Mahali: " + survey.getLocation(), normalFont));
//        document.add(Chunk.NEWLINE);
//
//        // Customer details
//        document.add(new Paragraph("TAARIFA ZA MTEJA", headerFont));
//        document.add(new Paragraph("Jina: " + survey.getCustomerName(), normalFont));
////        document.add(new Paragraph("Simu: " + survey.getCustomerPhone(), normalFont));
//        document.add(Chunk.NEWLINE);
//
//        // Notes
//        document.add(new Paragraph("MAELEZO YA FUNDI", headerFont));
//        document.add(new Paragraph(survey.getNotes(), normalFont));
//
//        document.close();
//        return baos.toByteArray();
//    }
//
//    // 6️⃣ Verify survey and notify customer
//    public Survey verifySurveyAndNotifyCustomer(Long surveyId, LocalDate serviceDate) throws Exception {
//        Survey survey = surveyRepository.findById(surveyId)
//                .orElseThrow(() -> new Exception("Ukaguzi haujapatikana"));
//
//        survey.setSurveyStatus("VERIFIED");
//        survey.setServiceDate(serviceDate);
//        Survey verifiedSurvey = surveyRepository.save(survey);
//
//        // Send email and notification
//        RequestForm form = survey.getRequestForm();
//        Customer customer = form.getCustomer();
//
//        String message = "Habari " + customer.getFullName() + ",\n\n" +
//                "Ukaguzi wako umeidhinishwa.\n" +
//                "Tarehe ya huduma: " + serviceDate + "\n\n" +
//                "Asante kwa kutumia huduma zetu.";
//
//        // Send email
//        try {
//            emailService.sendSimpleEmail(
//                    customer.getEmail(),
//                    "Ukaguzi Umeidhinishwa",
//                    message.replace("\n", "<br>")
//            );
//        } catch (MessagingException e) {
//            System.err.println("Imeshindwa kutuma barua pepe: " + e.getMessage());
//        }
//
//        // Send app notification
//        notificationService.sendNotificationToCustomer(
//                customer,
//                "Ukaguzi Umeidhinishwa",
//                message
//        );
//
//        return verifiedSurvey;
//    }
//
//    // 7️⃣ Get survey by request form ID (NEW)
//    public Survey findByRequestFormId(Long requestFormId) {
//        return surveyRepository.findByRequestFormId(requestFormId);
//    }
//
//    // 8️⃣ Get customer surveys (NEW)
//    public List<SurveyCustomerResponse> getAllCustomerSurveys(Long customerId) {
//        return surveyRepository.findByCustomerIdWithDetails(customerId);
//    }
//
//    // 9️⃣ Get customer surveys by status (NEW)
//    public List<SurveyCustomerResponse> getCustomerSurveysByStatus(Long customerId, String status) {
//        return surveyRepository.findByCustomerIdAndStatusWithDetails(customerId, status);
//    }
//
//    // 🔟 Update survey status (NEW)
//    public void updateSurveyStatus(Long surveyId, String status) throws Exception {
//        Survey survey = surveyRepository.findById(surveyId)
//                .orElseThrow(() -> new Exception("Ukaguzi haujapatikana"));
//        survey.setSurveyStatus(status);
//        surveyRepository.save(survey);
//    }
//}

//
////
//package com.zawadig.myafwanii.Service;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.RequestForm;
//import com.zawadig.myafwanii.Model.Staff;
//import com.zawadig.myafwanii.Model.Survey;
//import com.zawadig.myafwanii.Repository.RequestFormRepository;
//import com.zawadig.myafwanii.Repository.StaffRepository;
//import com.zawadig.myafwanii.Repository.SurveyRepository;
//import com.zawadig.myafwanii.dto.SurveyCustomerResponse;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import jakarta.mail.MessagingException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class SurveyService {
//
//    private final SurveyRepository surveyRepository;
//    private final RequestFormRepository requestFormRepository;
//    private final StaffRepository staffRepository;
//    private final EmailService emailService;
//    private final NotificationService notificationService;
//
//    // ✅ Method 1: Create a new survey
//    @Transactional
//    public Survey createSurvey(Long requestFormId, Long technicianId, String location, String notes) throws Exception {
//        RequestForm requestForm = requestFormRepository.findById(requestFormId)
//                .orElseThrow(() -> new Exception("Fomu ya maombi haijapatikana"));
//
//        Staff technician = staffRepository.findById(technicianId)
//                .orElseThrow(() -> new Exception("Fundi hajapatikana"));
//
//        Survey survey = new Survey();
//        survey.setRequestForm(requestForm);
//        survey.setTechnician(technician);
//        survey.setLocation(location);
//        survey.setNotes(notes);
//        survey.setCreatedAt(LocalDateTime.now());
//        survey.setSurveyStatus("pending"); // Set default status
//
//        return surveyRepository.save(survey);
//    }
//
//    // ✅ Method 2: Get all surveys with customer info
//    public List<SurveyCustomerResponse> getAllSurveysWithCustomer() {
//        return surveyRepository.findAllWithCustomer();
//    }
//
//    // ✅ Method 3: Get surveys by technician
//    public List<SurveyCustomerResponse> getSurveysByTechnician(Long technicianId) {
//        return surveyRepository.findByTechnicianIdWithCustomer(technicianId);
//    }
//
//    // ✅ Method 4: Get single survey with customer
//    public SurveyCustomerResponse getSurveyWithCustomerById(Long surveyId) throws Exception {
//        return surveyRepository.findWithCustomerById(surveyId)
//                .orElseThrow(() -> new Exception("Ukaguzi haujapatikana na ID: " + surveyId));
//    }
//
//    // ✅ Method 5: Generate PDF report
//    public byte[] generateSurveyReportPdf(Long surveyId) throws DocumentException, IOException, Exception {
//        SurveyCustomerResponse survey = getSurveyWithCustomerById(surveyId);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document();
//        PdfWriter.getInstance(document, baos);
//
//        document.open();
//
//        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(46, 117, 182));
//        Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
//        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
//
//        // Add content to PDF
//        document.add(new Paragraph("RIPOTI YA UKAGUZI WA HUDUMA", titleFont));
//        document.add(new Paragraph(" ", normalFont));
//
//        // Survey details
//        document.add(new Paragraph("Taarifa za Ukaguzi", subtitleFont));
//        document.add(new Paragraph("Namba ya Ukaguzi: " + survey.getSurveyId(), normalFont));
//        document.add(new Paragraph("Tarehe ya Ukaguzi: " + survey.getSurveyDate(), normalFont));
//        document.add(new Paragraph("Hali ya Ukaguzi: " + survey.getSurveyStatus(), normalFont));
//        document.add(new Paragraph("Eneo: " + survey.getLocation(), normalFont));
//        document.add(new Paragraph("Tarehe ya Huduma: " + survey.getServiceDate(), normalFont));
//        document.add(new Paragraph(" ", normalFont));
//
//        // Customer details
//        document.add(new Paragraph("Taarifa za Mteja", subtitleFont));
//        document.add(new Paragraph("Jina: " + survey.getCustomerName(), normalFont));
//        document.add(new Paragraph("Namba ya Simu: " + survey.getPhone(), normalFont));
//        document.add(new Paragraph("Namba ya Udhibiti: " + survey.getControlNumber(), normalFont));
//        document.add(new Paragraph(" ", normalFont));
//
//        // Technician notes
//        document.add(new Paragraph("Maelezo ya Fundi", subtitleFont));
//        document.add(new Paragraph(survey.getNotes(), normalFont));
//
//        document.close();
//        return baos.toByteArray();
//    }
//
//    // ✅ Method 6: Verify survey and notify customer (improved version)
//    @Transactional
//    public Survey verifySurveyAndNotifyCustomer(Long surveyId, LocalDate serviceDate) throws Exception {
//        // Validate service date
//        if (serviceDate.isBefore(LocalDate.now())) {
//            throw new Exception("Tarehe ya huduma lazima iwe baada ya leo");
//        }
//
//        Survey survey = surveyRepository.findById(surveyId)
//                .orElseThrow(() -> new Exception("Ukaguzi haujapatikana"));
//
//        // Update survey status and dates
//        survey.setSurveyStatus("verified");
//        survey.setServiceDate(serviceDate);
//        survey.setSurveyDate(LocalDateTime.now()); // Set verification timestamp
//        Survey verifiedSurvey = surveyRepository.save(survey);
//
//        // Get customer details
//        RequestForm form = survey.getRequestForm();
//        Customer customer = form.getCustomer();
//
//        // Prepare notification messages
//        String subject = "Ukaguzi Umehakikiwa - " + survey.getLocation();
//        Object mwenye;
//        String message = String.format(
//                "Habari %s,\n\n" +
//                        "Ukaguzi wako kwenye eneo la %s umehakikiwa.\n" +
//                        "Tarehe ya Huduma: %s\n\n" +
//                        "Tafadhali hakikisha:\n" +
//                        "- Nyumba iko tayari\n" +
//                        - Mtu mwenye mamlaka yupo\n" +
//                        - Namba ya udhibiti iko tayari\n\n" +
//                "Asante kwa kutumia huduma zetu.\n\n" +
//                        "Kwa maelezo zaidi, wasiliana nasi kupitia:\n" +
//                        "Simu: 0757628881\n" +
//                        "Barua pepe: info@zawa.go.tz",
//                customer.getFullName(),
//                survey.getLocation(),
//                serviceDate
//        );
//
//        // Send email notification
//        try {
//            emailService.sendSimpleEmail(
//                    customer.getEmail(),
//                    subject,
//                    message.replace("\n", "<br>") // Convert to HTML
//            );
//            log.info("Email notification sent to {}", customer.getEmail());
//        } catch (MessagingException e) {
//            log.error("Failed to send email to {}: {}", customer.getEmail(), e.getMessage());
//        }
//
//        // Send in-app notification
//        try {
//            notificationService.sendNotificationToCustomer(
//                    customer,
//                    subject,
//                    message
//            );
//            log.info("In-app notification sent to customer {}", customer.getId());
//        } catch (Exception e) {
//            log.error("Failed to send in-app notification: {}", e.getMessage());
//        }
//
//        return verifiedSurvey;
//    }
//}