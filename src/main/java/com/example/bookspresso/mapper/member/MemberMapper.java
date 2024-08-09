package com.example.bookspresso.mapper.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    /**
     * @param memberJoinDTO
     * 회원가입 처리
     */
    // 회원가입 시 회원 추가 (테스트 통과)
    void insertMember(MemberJoinDTO memberJoinDTO);

    // 로그인 아이디 중복 검사 (테스트 통과)
    int selectLoginIdCount(String loginId);
    // 로그인 아이디를 넣었을 시 null 이 반환되면 사용가능한 아이디

    // 닉네임 중복 검사 (테스트 통과)
    int selectNicknameCount(String nickname);

    // 이메일 중복 검사 (테스트 통과)
    int selectEmailCount(String email);

    /**
     * 로그인 처리
     */

    Optional<Long> selectMemberId(@Param("loginId") String loginId,
                                 @Param("password") String password);
// 회원 식별번호에는 null이 절대 들어가면 안되므로 optional 사용

}
