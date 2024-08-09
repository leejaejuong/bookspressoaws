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


    @Test
    void findNickaname() {
        memberService.addMember(memberJoinDTO);
        int nickname = memberService.findNickname("teskjht!!");
        System.out.println("nickname = " + nickname);
    }

    @Test
    void findEmail(){
        memberService.addMember(memberJoinDTO);
        int email = memberService.findEmail("dasdasmsql@naver.com");
        System.out.println("emailCount##### = " + email);
    }

    @Test
    void findMemberId(){
        memberService.addMember(memberJoinDTO);

        Long memberId = memberService.findMemberId("test", "test1234");
        System.out.println("memberId = " + memberId);
    }




}