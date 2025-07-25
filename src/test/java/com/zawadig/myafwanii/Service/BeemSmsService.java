package com.zawadig.myafwanii.Service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BeemSmsService {
    private final RestTemplate restTemplate;
    private static final String API_URL = "https://api.beem.africa/sms/send";

    @Value("${beem.api.key}")
    private String apiKey;

    @Value("${beem.sender.name}")
    private String senderName;

    public BeemSmsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendSms(String to, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, String> body = new HashMap<>();
        body.put("to", to);
        body.put("from", senderName);
        body.put("message", message);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(API_URL, request, String.class);
        return response.getBody();
    }
}
