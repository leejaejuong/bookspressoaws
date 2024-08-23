package com.example.bookspresso.service.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.dto.member.ProfleJoinDTO;
import com.example.bookspresso.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    // 회원가입
    public void addMember(MemberJoinDTO memberJoinDTO){

        int idCnt = memberMapper.selectLoginIdCount(memberJoinDTO.getLoginId());
        int nicknameCnt = memberMapper.selectNicknameCount(memberJoinDTO.getNickname());
        if(idCnt != 0 || nicknameCnt !=0 ){
            throw new IllegalStateException("##### 로그인 아이디 또는 닉네임이 중복되었습니다 ##### ");
        }//IllegalStateException : 객체의 상태가 호출된 메서드를 수행하기에 적절하지 않을 때 사용

        memberMapper.insertMember(memberJoinDTO);
    }
    public void addProfle(ProfleJoinDTO profleJoinDTO){
        memberMapper.insertProfile(profleJoinDTO);
    }

    public int findLoginId(String loginId){
        int loginIdCnt = memberMapper.selectLoginIdCount(loginId);
        return loginIdCnt;
    }

    public int findNickname(String nickname){
        return memberMapper.selectNicknameCount(nickname);
    }

    public int findEmail(String email){
        return memberMapper.selectEmailCount(email);
    }

    // 로그인 처리

    public Long findMemberId(String loginId, String password){
        return memberMapper.selectMemberId(loginId, password)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회원 정보입니다."));
    }
}
