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

    @Test
    void insertMember() {


        MemberJoinDTO memberJoinDTO = new MemberJoinDTO();
        memberJoinDTO.setMemberId(1L);
        memberJoinDTO.setEmail("test@example.com");
        memberJoinDTO.setPassword("password");
        memberJoinDTO.setNickname("test");
        memberJoinDTO.setLoginId("test");
        memberJoinDTO.setIntroduction("안녕하세요");
//        memberJoinDTO.getProfileUuid("11111111");


        memberMapper.insertMember(memberJoinDTO);
        System.out.println("memberJoinDTO: " + memberJoinDTO);
    }

    @Test
    void selectLoginIdCount() {
    }
}