package com.zawadig.myafwanii.Util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PaymentNumberGenerator {

    private static final String CN_PREFIX = "CN";
    private static final String TX_PREFIX = "TX";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public String generateControlNumber() {
        return CN_PREFIX + LocalDateTime.now().format(DATE_FORMAT) +
                ThreadLocalRandom.current().nextInt(100, 999);
    }

    public String generatePaymentReference() {
        return TX_PREFIX + LocalDateTime.now().format(DATE_FORMAT) +
                ThreadLocalRandom.current().nextInt(100, 999);
    }
}