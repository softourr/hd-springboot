package com.sample.security14.config;

import com.sample.security14.security.APILoginFailHandler;
import com.sample.security14.security.APILoginSuccessHandler;
import com.sample.security14.security.filter.JWTCheckFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration // Spring의 설정 클래스,클레스에서 Bean을 정의할 수 있습니다.
@Log4j2 // 로깅 프레임워크로 로그를 기록
@RequiredArgsConstructor // final 필드 또는 @NonNull 필드에 대한 생성자 생성
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("########### security #####################");

        http.cors(httpSecurityCorsConfigurer -> {
            httpSecurityCorsConfigurer.configurationSource(CorsConfigurationSource());
        });
        http.csrf(config -> config.disable());

        http.sessionManagement(sessionConfig
                -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.formLogin(config -> {
            config.loginPage("/api/member/login");
            config.successHandler(new APILoginSuccessHandler()); // 토큰 발행
            // 액세스, 리프레시 토큰
            config.failureHandler(new APILoginFailHandler());
        });

         http.addFilterBefore(new JWTCheckFilter(), UsernamePasswordAuthenticationFilter.class); // jwt검증, 토큰유효성검사?
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CorsConfigurationSource CorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD","GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization","Cache-Control","Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
