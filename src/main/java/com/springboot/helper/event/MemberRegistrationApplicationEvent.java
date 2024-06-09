package com.springboot.helper.event;

import com.springboot.member.entity.Member;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MemberRegistrationApplicationEvent extends ApplicationEvent {
    private Member member;
    public MemberRegistrationApplicationEvent(Object source) {
        super(source);
    }
}
