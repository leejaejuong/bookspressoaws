package com.example.bookspresso.service.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MailServiceTest {

    @Autowired private MailService mailService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void sendEmail() {
        mailService.sendEmail("eunbiyang74@gmail");
        System.out.println("메일 전송 성공!");
    }

    @Test
    void setContext() {
    }

    @Test
    void makeAuthNumber() {
    }
}