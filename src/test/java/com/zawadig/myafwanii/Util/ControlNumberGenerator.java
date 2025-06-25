package com.zawadig.myafwanii.Util;

import java.util.UUID;

public class ControlNumberGenerator {

    public static String generate() {
        return "ZAWA-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Method mpya ya ku-generate meter number
    public static String generateMeterNumber() {
        // Mfano: Meter number inakuwa "MTR-" + 8 chars random
        return "MTR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
