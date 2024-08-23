package com.example.bookspresso.service.member;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;
    private final ServletContext servletContext;

    public String sendEmail(String emailAddress){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        String authNumber = makeAuthNumber();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "utf-8");

            mimeMessageHelper.setTo(emailAddress);  //보내는 주소 설정
            mimeMessageHelper.setSubject("메일 제목입니다."); //메일 제목 설정
            mimeMessageHelper.setText(setContext("인증번호 : " + authNumber), true);  // 메일 본문 내용
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return authNumber;

    }

    //thymeleaf를 활용하여 html 만들기
    public String setContext(String content) {
        Context context = new Context(); // 타임리프에서 제공하는 객체
        context.setVariable("content", content);

        return templateEngine.process("mail-template", context);
    }

    public String makeAuthNumber() {
        Random r = new Random();
        String authNumber = "";

        for (int i = 0; i < 6; i++) {
            authNumber += r.nextInt(10);
        }

        return authNumber;
    }

}
