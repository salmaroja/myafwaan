//package com.zawadig.myafwanii.Service;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//
//@Service
//public class PDFGeneratorService {
//
//    public ByteArrayInputStream generatePDF(String content) {
//        try {
//            Document document = new Document();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//            PdfWriter.getInstance(document, out);
//            document.open();
//            document.add(new Paragraph(content));
//            document.close();
//
//            return new ByteArrayInputStream(out.toByteArray());
//
//        } catch (DocumentException e) {
//            throw new RuntimeException("PDF Creation Error: " + e.getMessage(), e);
//        }
//    }
//}







package com.zawadig.myafwanii.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.zawadig.myafwanii.Model.Customer;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PDFGeneratorService {

    public byte[] generateReceipt(String customerName, String meterNumber, String amountPaid, String paymentDate) {
        try {
            Document document = new Document();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, out);
            document.open();

            // Title
            document.add(new Paragraph("ZANZIBAR WATER AUTHORITY (ZAWA)"));
            document.add(new Paragraph("Payment Receipt"));
            document.add(new Paragraph("--------------------------------------------------"));

            // Receipt Details
            document.add(new Paragraph("Customer Name: " + customerName));
            document.add(new Paragraph("Meter Number: " + meterNumber));
            document.add(new Paragraph("Amount Paid: " + amountPaid));
            document.add(new Paragraph("Payment Date: " + paymentDate));

            document.add(new Paragraph("--------------------------------------------------"));
            document.add(new Paragraph("Thank you for your payment!"));

            document.close();

            return out.toByteArray();

        } catch (DocumentException e) {
            throw new RuntimeException("PDF Creation Error: " + e.getMessage(), e);
        }
    }

    public ByteArrayInputStream generatePDF(String content) {
        ByteArrayInputStream Customer = null;
        return Customer;
    }
}
