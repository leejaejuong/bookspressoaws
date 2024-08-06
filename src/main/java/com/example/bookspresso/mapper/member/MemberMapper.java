package com.example.bookspresso.mapper.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    // 회원가입 시 회원 추가
    void insertMember(MemberJoinDTO memberJoinDTO);

    // 로그인 아이디 중복 검사
    int selectLoginIdCount(String loginId);
}
