package com.example.bookspresso.service.member;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class memberService {

    private final MemberMapper memberMapper;

    public void addMember(MemberJoinDTO memberJoinDTO){



        memberMapper.insertMember(memberJoinDTO);

    }


}
