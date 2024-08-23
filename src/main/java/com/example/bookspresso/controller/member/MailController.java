package com.example.bookspresso.controller.member;

import com.example.bookspresso.service.member.MailService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/email/certified")
    public String send(String email){
        mailService.sendEmail(email); //받는 이메일 주소 작성

        return "메일 전송 완료!!";
    }

    @GetMapping("/check")
    public String check(HttpSession session) {
        String authNumber = (String) session.getAttribute("authNumber");
        return authNumber;
    }

}
