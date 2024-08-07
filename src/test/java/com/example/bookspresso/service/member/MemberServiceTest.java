package com.example.bookspresso.service.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.mapper.member.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberMapper memberMapper;
    @Autowired MemberService memberService;

    MemberJoinDTO memberJoinDTO;

    @BeforeEach
    void setUp() {
        memberJoinDTO = MemberJoinDTO.builder()
                .loginId("test")
                .password("test1234")
                .nickname("test!!")
                .email("test@naver.com")
                .build();
    }

    @Test
    void addMember() {
        memberService.addMember(memberJoinDTO);
        System.out.println("#@@@@@@@@@@@ memberJoinDTO = " + memberJoinDTO);
    }
}