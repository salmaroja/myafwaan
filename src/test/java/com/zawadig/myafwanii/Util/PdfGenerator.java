//package com.zawadig.myafwanii.Util;
//
//import com.zawadig.myafwanii.Model.ServicePayment;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.time.format.DateTimeFormatter;
//
//@Service
//public class ReceiptGenerator {
//
//    public byte[] generateReceiptPdf(ServicePayment payment) throws IOException {
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//                // Weka maelezo ya awali
//                contentStream.beginText();
//                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
//                contentStream.newLineAtOffset(50, 700);
//
//                // Kichwa
//                contentStream.showText("RISITI YA MALIPO - ZAMA");
//                contentStream.newLineAtOffset(0, -30);
//
//                // Maelezo ya malipo
//                contentStream.setFont(PDType1Font.HELVETICA, 12);
//
//                // Tarehe
//                String paymentDate = "N/A";
//                if (payment.getPaymentDate() != null) {
//                    paymentDate = payment.getPaymentDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//                }
//                contentStream.showText("Tarehe: " + paymentDate);
//                contentStream.newLineAtOffset(0, -25);
//
//                // Control number
//                contentStream.showText("Namba ya Udhibiti: " + payment.getControlNumber());
//                contentStream.newLineAtOffset(0, -25);
//
//                // Jina la mteja
//                if (payment.getCustomer() != null && payment.getCustomer().getFullName() != null) {
//                    contentStream.showText("Jina la Mteja: " + payment.getCustomer().getFullName());
//                    contentStream.newLineAtOffset(0, -25);
//                }
//
//                // Huduma
//                contentStream.showText("Aina ya Huduma: " + payment.getServiceType());
//                contentStream.newLineAtOffset(0, -25);
//
//                // Kiasi
//                double amount = 0.0;
//                if (payment.getAmount() != null) {
//                    amount = payment.getAmount().doubleValue();
//                }
//                contentStream.showText("Kiasi: TSh " + String.format("%,.2f", amount));
//                contentStream.newLineAtOffset(0, -25);
//
//                // Njia ya malipo
//                contentStream.showText("Njia ya Malipo: " + payment.getPaymentMethod());
//                contentStream.newLineAtOffset(0, -25);
//
//                // Hali
//                if (payment.getPaymentStatus() != null) {
//                    contentStream.showText("Hali: " + payment.getPaymentStatus().name());
//                } else {
//                    contentStream.showText("Hali: Haijulikani");
//                }
//                contentStream.newLineAtOffset(0, -40);
//
//                // Mwisho
//                contentStream.setFont(PDType1Font.HELVETICA_OBLIQUE, 10);
//                contentStream.showText("Asante kwa kutumia huduma zetu. Kwa msaada: simu +255 123 456 789");
//                contentStream.endText();
//            }
//
//            // Hifadhi kwenye byte array
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            document.save(outputStream);
//            return outputStream.toByteArray();
//        }
//    }
//}