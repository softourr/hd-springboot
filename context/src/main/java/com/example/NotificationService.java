package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    private final EmailService emailService;
    //autowired로 의존성 자동 주입
    @Autowired
    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotification(String to, String message) {
        System.out.println("Preparing to send notification...");
        emailService.sendEmail(to, message);
        System.out.println("Notification sent successfully.");
    }
}
