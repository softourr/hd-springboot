package com.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmailService implements InitializingBean, DisposableBean {

    public void init() {
        System.out.println("EmailService: Custom init method - Bean is initializing");
    }

    public void destroyMethod() {
        System.out.println("EmailService: Custom destroy method - Bean is being destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EmailService: InitializingBean - afterPropertiesSet() called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("EmailService: DisposableBean - destroy() called");
    }
}
