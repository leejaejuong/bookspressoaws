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


    public void dropDebate(Long debateId){

        debateManageMapper.deleteDebateBook(debateId);
        debateManageMapper.deleteMemberDebate(debateId);
        int debateBoardCount = debateManageMapper.selectDebateBoard(debateId);
        int noticeIdCount = debateManageMapper.selectNoticeIdCount(debateId);
        // 보드가 존재하면 댓글의 존재여부를 확인해야함
        if (debateBoardCount != 0){
            if (noticeIdCount != 0 ){
                Long noticeId = debateManageMapper.selectNoticeId(debateId).get();
                int commentCount = debateManageMapper.selectCommentCount(noticeId);
                if (commentCount != 0){
                    debateManageMapper.deleteDebateComment(noticeId);
                }
            }
            debateManageMapper.deleteDebateBoard(debateId);
        }
        debateManageMapper.deleteDebate(debateId);


//        if (noticeIdCount != 0){
//            Long noticeId = debateManageMapper.selectNoticeId(debateId).get();
//            int commentCount = debateManageMapper.selectCommentCount(noticeId);
//            if (commentCount != 0){
//                debateManageMapper.deleteDebateComment(noticeId);
//            }
//            debateManageMapper.selectDebateBoard(debateId);
//        }
//        debateManageMapper.deleteDebate(debateId);

//        int debateBoardCount = debateManageMapper.selectDebateBoard(debateId);
//        System.out.println("debateBoardCount = " + debateBoardCount);
//        if (debateBoardCount != 0){
//            Long noticeId = debateManageMapper.selectNoticeId(debateId).get();
//            System.out.println("noticeId = " + noticeId);
//            int commentCount = debateManageMapper.selectCommentCount(noticeId);
//            System.out.println("commentCount = " + commentCount);
//            if (commentCount != 0) {
//                debateManageMapper.deleteDebateComment(noticeId);
//                System.out.println("토론댓글 삭제");
//            }else { //삭제
//                System.out.println("토론 댓글 없음 ");
//            }
//            debateManageMapper.deleteDebateBoard(debateId);
//            System.out.println("토론 보드 삭제 ");
//        }else { // 삭제
//            System.out.println(" 토론 글작성 없음 ");
//        }

        debateManageMapper.deleteDebate(debateId);
    }

    // 현재 모집 중인 토론
    public List<ManageDebateDTO> findRecruitingDebate(AdminPageRequestDTO adminPageRequestDTO){
        return debateManageMapper.selectRecruitingDebate(adminPageRequestDTO);
    }

    public int findRecruitingDebateCount(){
        return debateManageMapper.selectRecruitingCount();
    }

    //현재 모집 중인 토론 검색
    public List<ManageDebateDTO> findSearchRecruitingDebate(String searchType, String keyword, int page, int amount){
        return debateManageMapper.selectSearchRecruitingDebate(searchType, keyword, page, amount);
    }
    public int findSearchRecruitingDebateTotal(String searchType, String keyword){
        return debateManageMapper.selectSearchRecruitingCount(searchType, keyword);
    }


}

