package com.springboot.helper.event;

import com.springboot.helper.email.EmailSender;
import com.springboot.member.entity.Member;
import com.springboot.member.service.RealMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailSendException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
//@Configuration
//@Component
@Slf4j
public class MemberRegistrationEventListener {
    private final EmailSender emailSender;
    private final RealMemberService memberService;

    public MemberRegistrationEventListener(EmailSender emailSender, RealMemberService memberService) {
        this.emailSender = emailSender;
        this.memberService = memberService;
    }

    @Async
    @EventListener
    public void listen(MemberRegistrationApplicationEvent event) throws Exception {
        try {
            // 전송할 메시지를 생성했다고 가정.
            String message = "any email message";
            emailSender.sendEmail(message);
        } catch (MailSendException e) {
            e.printStackTrace();
            log.error("MailSendException: rollback for Member Registration:");
            Member member = event.getMember();
            memberService.deleteMember(member.getMemberId());
        }
    }
}
