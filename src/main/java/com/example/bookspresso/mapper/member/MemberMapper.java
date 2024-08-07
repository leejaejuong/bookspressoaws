package com.example.bookspresso.mapper.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    // 회원가입 시 회원 추가 (테스트 통과)
    void insertMember(MemberJoinDTO memberJoinDTO);

    // 로그인 아이디 중복 검사 (테스트 통과)
    int selectLoginIdCount(String loginId);
    // 로그인 아이디를 넣었을 시 null 이 반환되면 사용가능한 아이디


}
