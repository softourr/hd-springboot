package com.example;

import org.springframework.stereotype.Component;
// @Component로 스프링 빈 등록
@Component
public class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Sending email to " + to + ": " + message);
    }
}
