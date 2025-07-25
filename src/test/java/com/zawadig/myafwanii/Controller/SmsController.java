package com.zawadig.myafwanii.Controller;

import com.zawadig.myafwanii.Service.BeemSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private BeemSmsService beemSmsService;

    @PostMapping("/send")
    public String sendSms(
            @RequestParam String to,
            @RequestParam String message) {
        return beemSmsService.sendSms(to, message);
    }
}
