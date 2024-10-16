package com.sample.security14.repository;

import com.sample.security14.domain.Member;
import com.sample.security14.domain.MemberRole;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Log4j2
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Disabled
    @Test
    public void testInsertMember() {
        for(int i=0;i<10;i++) {
            Member member = Member.builder()
                    .email("user@han.com")
                    .pw(passwordEncoder.encode("1234"))
                    .nickname("user")
                    .build();

            member.addRole(MemberRole.USER);

            if(i<5){
                member.addRole(MemberRole.MEMBER);
            }
            if(i>8){
                member.addRole(MemberRole.ADMIN);
            }
            memberRepository.save(member);
        }
    }

    @Test
    public void testRead(){
        String email = "user@han.com";
        Member member = memberRepository.getWithRole(email);

        log.info("################");
        log.info(member);
        log.info(member.getMemberRoleList());
    }
}
