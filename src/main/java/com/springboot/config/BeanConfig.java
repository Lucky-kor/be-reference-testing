package com.springboot.config;

import com.springboot.member.repository.MemberRepository;
import com.springboot.member.service.MemberService;
import com.springboot.member.service.RealMemberService;
import com.springboot.member.service.StubMemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {
    private final MemberRepository memberRepository;

    public BeanConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService stubMemberService() {
        return new StubMemberService();
    }

    @Primary
    @Bean
    public MemberService realMemberService() {
        return new RealMemberService(memberRepository);
    }
}
