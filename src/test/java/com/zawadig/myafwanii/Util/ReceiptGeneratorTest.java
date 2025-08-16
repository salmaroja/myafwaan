//package com.zawadig.myafwanii.Util;
//
//import com.zawadig.myafwanii.Model.Customer;
//import com.zawadig.myafwanii.Model.ServicePayment;
//import com.zawadig.myafwanii.enums.PaymentStatus;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ReceiptGeneratorTest {
//
//    @Autowired
//    private com.zawadig.myafwanii.Util.ReceiptGenerator receiptGenerator;
//
//    @Test
//    void testGenerateReceipt() throws IOException {
//        // Tengeneza malipo ya jaribio
//        ServicePayment payment = new ServicePayment();
//        payment.setControlNumber("CTRL-123456");
//        payment.setAmount(BigDecimal.valueOf(50000.0));
//        payment.setPaymentMethod("M-Pesa");
//        payment.setPaymentStatus(PaymentStatus.VERIFIED);
//        payment.setPaymentDate(LocalDateTime.now());
//        payment.setServiceType("Ufungaji Mita");
//
//        // Tengeneza mteja
//        Customer customer = new Customer();
//        customer.setFullName("John Doe");
//        payment.setCustomer(customer);
//
//        // Tengeneza PDF
//        byte[] pdf = receiptGenerator.generateReceiptPdf(payment);
//
//        // Thibitisha kuwa PDF imeundwa
//        assertNotNull(pdf, "PDF haipaswi kuwa null");
//        assertTrue(pdf.length > 0, "PDF inapaswa kuwa na maudhui");
//
//        // Hifadhi kwenye faili kwa ajili ya kuona
//        Files.write(Paths.get("receipt-test.pdf"), pdf);
//        System.out.println("Risiti imehifadhiwa kama: receipt-test.pdf");
//    }
//}