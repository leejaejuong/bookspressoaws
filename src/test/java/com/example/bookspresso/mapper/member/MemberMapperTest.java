package com.example.bookspresso.mapper.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    void selectNicknameCount() {
        memberMapper.insertMember(memberJoinDTO);
        int count = memberMapper.selectNicknameCount("tes!");
        System.out.println(count);
    }

    //로그인
    @Test
    void selectMemberId() {
        memberMapper.insertMember(memberJoinDTO);

        Optional<Long> memberId = memberMapper.selectMemberId("test", "test1234");
        System.out.println("memberId = " + memberId.get());
// get()으로 꺼내지 않으면 Optional[87]로 반환됨
        // 매개변수가 일치하지 않을 때 예외발생
        // No value present
        //java.util.NoSuchElementException: No value present

    }   // 로그인이나 비밀번호가 일치 하지 않으면 memberId에 null이 들어감

    @Test
    void selectEmailCount() {
        memberMapper.insertMember(memberJoinDTO);
        int emailCount = memberMapper.selectEmailCount("dmsqsdsl@naver.com");
        System.out.println("emailCount = " + emailCount);
    }



}