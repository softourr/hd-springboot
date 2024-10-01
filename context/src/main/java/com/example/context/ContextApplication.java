package com.example.context;

import com.example.context.config.AppConfig;
import com.example.context.service.EmailService;
import com.example.context.service.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너(ApplicationContext)를 수동으로 초기화하여 설정 클래스(AppConfig)를 기반으로 설정
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// EmailService 빈 가져오기
		EmailService emailService = context.getBean(EmailService.class);
		emailService.sendEmail("example@domain.com", "Welcome! This is your first email.");

		// NotificationService 빈 가져오기
		NotificationService notificationService = context.getBean(NotificationService.class);
		notificationService.sendNotification("User123", "You have a new message.");

		// 컨테이너 종료
		((AnnotationConfigApplicationContext) context).close();
	}

}
