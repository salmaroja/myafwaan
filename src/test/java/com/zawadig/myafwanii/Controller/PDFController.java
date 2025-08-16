package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Service.PDFGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
public class PDFController {

    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf() {
        String content = "Hello, hii ni PDF generated content.";
        ByteArrayInputStream bis = pdfGeneratorService.generatePDF(content);

        byte[] pdfBytes = bis.readAllBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=sample.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
