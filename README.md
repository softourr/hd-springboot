# 스프링 컨테이너 생명주기 예제
- 스프링 컨테이너에서 빈이 어떻게 초기화되고 소멸되는지를 다양한 방법으로 보여줍니다. 이 예제에서는 InitializingBean, DisposableBean 인터페이스와 커스텀 초기화/소멸 메서드를 사용하여 스프링 빈의 생명 주기를 관리하는 방법을 다룹니다.

  
> 대체 애너테이션 사용: javax.annotation 대신 스프링 프레임워크에서 제공하는 @PostConstruct와 @PreDestroy와 동일한 기능을 하는 애너테이션을 사용할 수 있습니다. 스프링은 다음과 같은 대체 애너테이션을 제공합니다:
    * 초기화 메서드: @PostConstruct 대신 @Bean(initMethod = "init") 사용.
    * 소멸 메서드: @PreDestroy 대신 @Bean(destroyMethod = "destroy") 사용.
 
## 출력
```plaintext
EmailService: InitializingBean - afterPropertiesSet() called
EmailService: Custom init method - Bean is initializing
Spring container has started.
EmailService bean retrieved: com.example.EmailService@508dec2b
EmailService: DisposableBean - destroy() called
EmailService: Custom destroy method - Bean is being destroyed
Spring container has been closed.
```

