package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 스프링 컨테이너 생성 및 실행
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// NotificationService 빈 가져오기
		NotificationService notificationService = context.getBean(NotificationService.class);
		notificationService.sendNotification("user@example.com", "Hello, this is a test notification!");

		// 컨텍스트 종료
		((AnnotationConfigApplicationContext) context).close();
	}
}
