package com.example.context.service;

public class EmailService {
    public void sendEmail(String recipient, String message) {
        System.out.println("Sending email to " + recipient + " with message: " + message);
    }
}