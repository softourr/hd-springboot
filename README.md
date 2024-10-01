# 어노테이션을 이용한 스프링 설정
스프링의 주요 어노테이션들을 사용해 애플리케이션 구성해보기
## 주요 어노테이션 설명
1. `@Configuration`
- 스프링 컨테이너에 설정 클래스로 등록되는 것을 의미합니다. 해당 어노테이션이 붙은 클래스는 애플리케이션의 설정 정보를 담고 있으며, `@Bean`을 사용하여 빈을 정의할 수 있습니다.

2. `@Bean`
- `@Configuration` 클래스 내에서 메서드에 적용되며, 해당 메서드의 반환값을 스프링 컨테이너에 빈으로 등록합니다. 주로 외부 라이브러리나 커스텀 클래스를 빈으로 등록할 때 사용됩니다.

3. `@Component`
- 스프링이 관리할 수 있는 빈으로 등록되며, 기본적으로 클래스 단위의 객체를 생성하고 관리합니다. `@Service`, `@Repository`, `@Controller` 어노테이션은 모두 `@Component`의 확장형입니다.

4. `@ComponentScan`
- 지정된 패키지 및 하위 패키지를 스캔하여 `@Component`, `@Service`, `@Repository`, `@Controller` 어노테이션이 붙은 클래스를 자동으로 스프링 컨테이너에 빈으로 등록합니다.

5. `@Autowired`
- 스프링 컨테이너에 있는 빈을 자동으로 주입해주는 어노테이션입니다. 생성자, 필드, 메서드에 사용하여 의존성을 설정할 수 있습니다.

6. `@Service`
- `@Component`의 확장형으로, 주로 서비스 계층의 클래스에 사용됩니다. 비즈니스 로직을 담당하는 클래스임을 명시합니다.

7. `@Repository`
- `@Component`의 확장형으로, 데이터 액세스 계층 (DAO)의 클래스를 의미합니다. 데이터베이스와의 상호작용을 담당하며, 예외 처리를 데이터 계층에 맞게 변환하는 등의 기능을 제공합니다.

8. `@Controller`
- `@Component`의 확장형으로, 웹 MVC에서 컨트롤러 역할을 수행하는 클래스에 사용됩니다. HTTP 요청을 받아 서비스 계층과 상호작용하여 응답을 생성합니다.

## 출력
```plaintext
Preparing to send notification...
Sending email to user@example.com: Hello, this is a test notification!
Notification sent successfully.
```
