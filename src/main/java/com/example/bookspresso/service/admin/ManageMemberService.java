package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.member.MemberManageDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.mapper.admin.MemberManageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ManageMemberService {

    private final MemberManageMapper memberManageMapper;

    public List<MemberManageDTO> findMemberList(AdminPageRequestDTO adminPageRequestDTO){

        List<MemberManageDTO> memberList = memberManageMapper.selectMemberList(adminPageRequestDTO);
        memberList.forEach(member -> {

            int debateNum = memberManageMapper.attendDebateNum(member.getMemberId());
            int posterNum = memberManageMapper.writePosterNum(member.getMemberId());
            member.setDebateNum(debateNum);
            member.setPosterNum(posterNum);
        });

        return memberList;
    }

    public List<MemberManageDTO> findSearchMemberList(int page, int amount,
                                                      String searchType, String keyword){

        List<MemberManageDTO> memberList = memberManageMapper.selectSearchList(page, amount, searchType, keyword);
        memberList.forEach(member -> {

            int debateCount = memberManageMapper.attendDebateNum(member.getMemberId());
            int posterCount = memberManageMapper.writePosterNum(member.getMemberId());
            member.setDebateNum(debateCount);
            member.setPosterNum(posterCount);
        });

        return memberList;
    }

    public int findListCount(){
        return memberManageMapper.selectListCount();
    }

    public int findSearchCount(String searchType, String keyword){
        return memberManageMapper.selectSearchListCount(searchType, keyword);
    }

    //회원 삭제 처리
    public void dropMember(Long memberId){
        memberManageMapper.deleteProfile(memberId);
        memberManageMapper.deleteMember(memberId);
    }


}
