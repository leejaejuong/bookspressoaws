package com.example.bookspresso.controller.member;

import com.example.bookspresso.service.member.MailService;
import jakarta.mail.Session;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

//    @GetMapping("/email/certified")
//    public String send(String email, HttpSession session){
//
//        String authNumber = mailService.sendEmail(email);//받는 이메일 주소 작성
//
//        session.setAttribute("authNumber", authNumber);
//
//        return "redirect:/email/certified";
//    }
//
//    @GetMapping("/check")
//    public String check(HttpSession session) {
//        String authNumber = (String) session.getAttribute("authNumber");
//        return authNumber;
//    }

}
