package com.sample.security14.security;

import com.google.gson.Gson;
import com.sample.security14.dto.MemberDto;
import com.sample.security14.util.JWTUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess
            (HttpServletRequest request,
             HttpServletResponse response,
             Authentication authentication) throws IOException, ServletException {
        log.info("---------------------------------------------");
        log.info("-------authentication------------------------");
        log.info("---------------------------------------------");

        MemberDto memberDto = (MemberDto) authentication.getPrincipal();
        Map<String, Object> claims = memberDto.getClaims();
        String accessToken = JWTUtil.generateToken(claims, 60);
        String refreshToken = JWTUtil.generateToken(claims, 60*24);

        claims.put("acceccToken", accessToken);
        claims.put("refreshToken", refreshToken);

        Gson gson = new Gson();
        String jsonStr = gson.toJson(claims);
        response.setContentType("application/json;charset=utf-8");

        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonStr);
        printWriter.close();


    }
}
