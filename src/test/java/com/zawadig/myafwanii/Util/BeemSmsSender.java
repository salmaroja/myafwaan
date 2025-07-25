// application.properties (src/main/resources/application.properties)
//beem.api.key=3aee5eea6cbf4c65
//        beem.api.secret=ODRmOWI5NGEwMzI1YmJjNDU1YWRjYTg2MGYwOTc5YWZjZmZkMjMzOWFkZDYwYjk2YTMxNTlmYmRlY2U4YTcxZQ==
//        beem.sender.name=INFO
//
//
//// BeemSmsSender.java (src/main/java/com/zawadig/myafwanii/Util/BeemSmsSender.java)
package com.zawadig.myafwanii.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BeemSmsSender {

    @Value("${beem.api.key}")
    private String appId;

    @Value("${beem.api.secret}")
    private String appSecret;

    @Value("${beem.sender.name}")
    private String senderName;

    private static final String BASE_URL = "https://apisms.beem.africa/v1/send";

    public void sendSms(String phoneNumber, String messageText) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(appId, appSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> payload = new HashMap<>();
        payload.put("source_addr", senderName);
        payload.put("encoding", "0");
        payload.put("schedule_time", "");
        payload.put("message", messageText);
        payload.put("recipients", List.of(Map.of("recipient_id", "1", "dest_addr", phoneNumber)));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL, request, String.class);
            System.out.println("✅ SMS sent! Response: " + response.getBody());
        } catch (Exception e) {
            System.err.println("❌ Error sending SMS: " + e.getMessage());
        }
    }
}
