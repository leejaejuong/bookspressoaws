package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.discussion.AttendMemberDTO;
import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.FinishedDebateDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DebateManageMapper {

    List<ManageDebateDTO> selectDebateList(AdminPageRequestDTO adminPageRequestDTO);
//                                           DebateSearchDTO debateSearchDTO);

    int selectDebateCount();

    List<ManageDebateDTO> selectSearchDebateList(@Param("searchType") String searchType,
                                                 @Param("keyword") String keyword,
                                                 @Param("page") int page,
                                                 @Param("amount") int amount);

    int selectSearchDebateTotal(@Param("searchType") String searchType,
                                @Param("keyword") String keyword,
                                @Param("page") int page,
                                @Param("amount") int amount);

    List<FinishedDebateDTO> selectSearchEndDebateList(@Param("searchType") String searchType,
                                                      @Param("keyword") String keyword,
                                                      @Param("page") int page,
                                                      @Param("amount") int amount);

    int selectSearchEndDebateTotal(@Param("searchType") String searchType,
                                @Param("keyword") String keyword,
                                @Param("page") int page,
                                @Param("amount") int amount);


    List<ManageDebateDTO> selectEndDebateList(AdminPageRequestDTO adminPageRequestDTO);

    int selectEndDebateCount();

    String selectBookName(Long debateId);

    void delectDebate(Long debateId);

//    List<ManageDebateDTO> selectSearchDebateList(AdminPageRequestDTO adminPageRequestDTO,
//                                                 DebateSearchDTO debateSearchDTO);

    List<AttendMemberDTO> selectAttendMember(Long debateId);

    // 토론 삭제 처리
    List<Long> selectDeleteElement(Long debateId);

    void deleteDebate(Long debateId);
    void deleteMemberDebate(Long debateId);
    void deleteDebateBoard(Long debateId);
    void deleteDebateBook(Long debateId);
    void deleteDebateComment(Long commentId);

}
