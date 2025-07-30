package com.yourorg.library.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("emailNotificationService")
@Primary
public class EmailNotificationService implements NotificationService {
    
    @Override
    public String sendNotification(String message) {
        return "Email notification sent: " + message;
    }
} 