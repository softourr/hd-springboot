package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 스프링 컨테이너 생성 및 실행
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Spring container has started.");

		// EmailService 빈 사용
		EmailService emailService = context.getBean(EmailService.class);
		System.out.println("EmailService bean retrieved: " + emailService);

		// 스프링 컨테이너 종료
		context.close();
		System.out.println("Spring container has been closed.");
	}
}
