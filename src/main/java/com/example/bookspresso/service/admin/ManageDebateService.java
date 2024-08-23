package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.discussion.AttendMemberDTO;
import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.FinishedDebateDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.mapper.admin.DebateManageMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ManageDebateService {

    private final DebateManageMapper debateManageMapper;

    public List<ManageDebateDTO> findDebateList(AdminPageRequestDTO adminPageRequestDTO){
        return debateManageMapper.selectDebateList(adminPageRequestDTO);
    }

    public int findDebateCount(){
        return debateManageMapper.selectDebateCount();
    }

    public List<ManageDebateDTO> findSearchDebateList( String searchType,
                                                       String keyword,
                                                       int page,
                                                       int amount){
        return debateManageMapper.selectSearchDebateList(searchType, keyword, page, amount);
    }

    public int findSearchDebateTotal(String searchType,
                                     String keyword,
                                     int page,
                                     int amount){
        return debateManageMapper.selectSearchDebateTotal(searchType, keyword, page, amount);
    }

    public List<FinishedDebateDTO> findSearchEndDebateList(String searchType,
                                                           String keyword,
                                                           int page,
                                                           int amount){
        return debateManageMapper.selectSearchEndDebateList(searchType, keyword, page, amount);
    }

    public int findSearchEndDebateTotal(String searchType,
                                     String keyword,
                                     int page,
                                     int amount){
        return debateManageMapper.selectSearchEndDebateTotal(searchType, keyword, page, amount);
    }

// xxxxx
    public List<ManageDebateDTO> findEndDebateList(AdminPageRequestDTO adminPageRequestDTO){
        return debateManageMapper.selectEndDebateList(adminPageRequestDTO);
    }

    public int findEndDebateCount(){
        return debateManageMapper.selectEndDebateCount();
    }

    public String findBookName(Long debateId){
        return debateManageMapper.selectBookName(debateId);
    }


    public List<AttendMemberDTO> findAttendMemberList(Long debateId){
        return debateManageMapper.selectAttendMember(debateId);
    }

//    //토론 삭제 처리
//    public void dropDebate(Long debateId){
//        // 토론에 사용하는 책 삭제
//        debateManageMapper.deleteDebateBook(debateId);
//
//        //토론 댓글 삭제
//        List<Long> commentIds = debateManageMapper.selectDeleteElement(debateId);
//        for (Long commentId : commentIds){
//            debateManageMapper.deleteDebateComment(commentId);
//        }
//        //토론 게시글 삭제
//        debateManageMapper.deleteDebateBoard(debateId);
//        //토론 info? 삭제
//        debateManageMapper.delectDebate(debateId);
//    }

    public void dropDebate(Long debateId){

        debateManageMapper.deleteDebateBook(debateId);
        debateManageMapper.deleteMemberDebate(debateId);
        Long noticeId = debateManageMapper.selectNoticeId(debateId).get();

        debateManageMapper.deleteDebateComment(noticeId);
        debateManageMapper.deleteDebateBoard(debateId);
        debateManageMapper.deleteDebate(debateId);
    }

    // 현재 모집 중인 토론
    public List<ManageDebateDTO> findRecruitingDebate(AdminPageRequestDTO adminPageRequestDTO){
        return debateManageMapper.selectRecruitingDebate(adminPageRequestDTO);
    }

    public int findRecrutingDebateCount(DebateSearchDTO debateSearchDTO){
        return debateManageMapper.selectRecruitingCount(debateSearchDTO);
    }


}

