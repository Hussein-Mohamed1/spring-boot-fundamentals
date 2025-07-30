package com.yourorg.library.controller;

import com.yourorg.library.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("libraryNotificationController")
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService emailService;
    private final NotificationService smsService;

    public NotificationController(
            NotificationService emailService, // @Primary will be injected
            @Qualifier("sms") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @GetMapping("/email")
    public String sendEmailNotification(@RequestParam(defaultValue = "Hello via Email") String message) {
        return emailService.sendNotification(message);
    }

    @GetMapping("/sms")
    public String sendSmsNotification(@RequestParam(defaultValue = "Hello via SMS") String message) {
        return smsService.sendNotification(message);
    }
} 