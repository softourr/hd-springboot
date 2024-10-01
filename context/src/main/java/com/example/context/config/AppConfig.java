// src/main/java/com/example/context/config/AppConfig.java
package com.example.context.config;

import com.example.context.service.EmailService;
import com.example.context.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 스프링 설정 클래스를 나타내는 애너테이션
public class AppConfig {

    @Bean  // EmailService 빈 등록
    public EmailService emailService() {
        return new EmailService();
    }

    @Bean  // NotificationService 빈 등록
    public NotificationService notificationService() {
        return new NotificationService();
    }
}
