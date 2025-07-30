package com.yourorg.library.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("smsNotificationService")
@Qualifier("sms")
public class SmsNotificationService implements NotificationService {
    
    @Override
    public String sendNotification(String message) {
        return "SMS notification sent: " + message;
    }
} 