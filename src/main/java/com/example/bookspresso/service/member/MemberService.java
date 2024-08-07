package com.example.bookspresso.service.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void addMember(MemberJoinDTO memberJoinDTO){

//        int idCnt = memberMapper.selectLoginIdCount(memberJoinDTO.getLoginId());
//
//        if(idCnt == 1 && nicknameCnt ==1 ){
//            throw new IllegalStateException("@@@중복된 회원아이디 입니다. ");
//        }

        memberMapper.insertMember(memberJoinDTO);
    }

    public int findLoginId(String loginId){
        int loginIdCnt = memberMapper.selectLoginIdCount(loginId);
        return loginIdCnt;
    }


    public void findNickname(String nickname){
        int nicknameCnt = memberMapper.selectNicknameCount(nickname);

        if (nicknameCnt == 1 ){
            throw new IllegalStateException("@@@ 중복된 닉네임 입니다.");
        }

    }


}
