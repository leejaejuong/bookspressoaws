package com.example.bookspresso.mapper.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberMapperTest {

    @Autowired MemberMapper memberMapper;

    MemberJoinDTO memberJoinDTO;

    @BeforeEach
    void setUp() {
        memberJoinDTO = MemberJoinDTO.builder()
//                .memberId(1L)
                .loginId("test")
                .password("test1234")
                .nickname("test!!")
                .email("test@naver.com")
                .build();

    }

    @Test
    void insertMember() {

//        memberJoinDTO.setIntroduction("안녕하세요");
//        memberJoinDTO.getProfileUuid("11111111");


        memberMapper.insertMember(memberJoinDTO);
        System.out.println("@@@@memberJoinDTO = " + memberJoinDTO);


    }

    @Test
    void selectLoginIdCount() {

        memberMapper.insertMember(memberJoinDTO);

        int count = memberMapper.selectLoginIdCount("test");
        System.out.println("LoginIdCount = " + count);


    }

    @Test
    void checkLoginId() {
        memberMapper.insertMember(memberJoinDTO);
        String loginId = memberMapper.checkLoginId("tes33t");
        System.out.println(loginId +"@@@@@@@@@@@@@@ ");

    }
}