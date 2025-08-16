package com.zawadig.myafwanii.Service;////package com.zawadig.myafwanii.Service;
////
////import jakarta.mail.MessagingException;
////import jakarta.mail.internet.MimeMessage;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.mail.javamail.JavaMailSender;
////import org.springframework.mail.javamail.MimeMessageHelper;
////import org.springframework.stereotype.Service;
////
////@Service
////public class EmailService {
////
////    @Autowired
////    private JavaMailSender mailSender;
////
////    public void sendSimpleEmail(String toEmail, String subject, String body) throws MessagingException {
////        MimeMessage mimeMessage = mailSender.createMimeMessage();
////
////        // Tunatumia constructor yenye charset na multipart flag:
////        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
////
////        helper.setTo(toEmail);
////        helper.setSubject(subject);
////        helper.setText(body, true);  // true means HTML content
////        helper.setFrom("your.salmarajab927@gmail.com"); // Badilisha na email halisi
////
////        mailSender.send(mimeMessage);
////    }
////
////    public void sendEmailWithPdf(String email, String your_zawa_payment_receipt, String s, byte[] receiptPdf) {
////    }
//}



//
//package com.zawadig.myafwanii.Service;
//
//import jakarta.activation.DataSource;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import jakarta.mail.util.ByteArrayDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendSimpleEmail(String toEmail, String subject, String body) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//
//        helper.setTo(toEmail);
//        helper.setSubject(subject);
//        helper.setText(body, true);  // true = HTML
//        helper.setFrom("your.salmarajab927@gmail.com"); // Badilisha hii na email halisi iliyo verified
//
//        mailSender.send(mimeMessage);
//    }
//
//    public void sendEmailWithPdf(String toEmail, String subject, String body, byte[] pdfData) throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//        // true = multipart email
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//
//        helper.setTo(toEmail);
//        helper.setSubject(subject);
//        helper.setText(body, true);
//        helper.setFrom("salmarajab927@gmail.com"); // Badilisha hii kama una verified domain/email
//
//        // Attach PDF file
//        DataSource dataSource = new ByteArrayDataSource(pdfData, "application/pdf");
//        helper.addAttachment("ZAWA_Receipt.pdf", dataSource);
//
//        mailSender.send(mimeMessage);
//    }
//}






import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Tuma email rahisi yenye html support
    public void sendSimpleEmail(String toEmail, String subject, String body) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, true);  // true = HTML
        helper.setFrom("salmarajab927@gmail.com"); // Badilisha na email halali yako

        mailSender.send(mimeMessage);
    }

    // Tuma email yenye PDF kama attachment
    public void sendEmailWithPdf(String toEmail, String subject, String body, byte[] pdfData) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, true);
        helper.setFrom("salmarajab927@gmail.com"); // Badilisha na email halali yako

        // Attach PDF
        DataSource dataSource = new ByteArrayDataSource(pdfData, "application/pdf");
        helper.addAttachment("ZAWA_Receipt.pdf", dataSource);

        mailSender.send(mimeMessage);
    }

    public void sendEmailWithAttachment(String email, String subject, String body, byte[] pdfReceipt, String s) {
    }

    public void sendEmail(String email, String subject, String body) {
    }

    public void sendPasswordResetEmail(String email, String resetLink) {
    }
}









