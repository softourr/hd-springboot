package com.sample.spring.service;

import com.sample.spring.domain.Member;
import com.sample.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> selectAll() {

        return memberRepository.findAll(); // jpa에서 이미작성된 sql문이랄까
    }
}
