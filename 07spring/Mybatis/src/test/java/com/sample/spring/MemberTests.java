package com.sample.spring;

import com.sample.spring.domain.Member;
import com.sample.spring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class MemberTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testinsert() {
        Member member = Member.builder()
                .createDate(LocalDate.now())
                .name("test")
                .email("kkk@test.com")
                .build();
        memberRepository.save(member);
    }
}
