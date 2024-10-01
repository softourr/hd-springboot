package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정 클래스임을 나타냄
@ComponentScan(basePackages = "com.example") // 패키지에서 컴포넌트 어노테이션 붙은 클래스 스캔
public class AppConfig {
}
