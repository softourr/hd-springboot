# ApplicationContext
스프링 컨테이너(`ApplicationContext`)를 사용하여 스프링 빈을 직접 관리하고, 수동으로 빈을 가져와 사용하는 방법을 학습

## 실행결과
```java
Sending email to example@domain.com with message: Welcome! This is your first email.
Sending notification to User123 with content: You have a new message.
```

## 정리

- `ApplicationContext`를 활용하여 스프링 빈 수동 생성 및 관리
- `EmailService`와 `NotificationService`를 `@Bean`으로 등록하여 서비스 클래스 활용
- 스프링 컨테이너를 사용한 서비스 호출 및 실행


## 구조
```plaintext
context
├── config
├── AppConfig.java           # 스프링 설정 클래스
├── service
├── EmailService.java        # EmailService 클래스
└── NotificationService.java # NotificationService 클래스
└── Main.java                    # 메인 클래스
```
