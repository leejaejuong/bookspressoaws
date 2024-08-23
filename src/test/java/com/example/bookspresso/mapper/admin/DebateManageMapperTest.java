package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.discussion.AttendMemberDTO;
import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.mapper.debate.DebateMapper;
import com.example.bookspresso.service.admin.ManageDebateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DebateManageMapperTest {

    @Autowired DebateManageMapper debateManageMapper;
    @Autowired
    DebateMapper debateMapper;

    ManageDebateDTO manageDebateDTO;
    AdminPageRequestDTO adminPageRequestDTO;
    DebateSearchDTO debateSearchDTO;
    DebateInpoDTO debateInpoDTO;
    @Autowired
    private ManageDebateService manageDebateService;


    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();
        adminPageRequestDTO.setAmount(4);

        debateSearchDTO = DebateSearchDTO.builder()
                .searchType("postTitle")
                .keyword("은")
                .build();

        debateInpoDTO = DebateInpoDTO.builder()
                .groupStartDate("20240820")
                .groupEndDate("20240830")
                .debateStartDate("20240901")
                .debateEndDate("20240910")
                .title("debate-delete_test")
                .debateTypeId(1L)
                .outLine("debate-delete_test")
                .meetingId(1L)
                .isbn13("9791166831515")
                .build();

    }

    @Test
    void selectDebateList() {
        List<ManageDebateDTO> list = debateManageMapper.selectDebateList(adminPageRequestDTO);
        System.out.println(list);
    }

    @Test
    void selectDebateCount(){
        int count = debateManageMapper.selectDebateCount();
        System.out.println("#### Count = " + count);
    }

    @Test
    void selectSearchDebateList() {
        List<ManageDebateDTO> list = debateManageMapper.selectSearchDebateList("bookName","불안", adminPageRequestDTO.getPage(), adminPageRequestDTO.getAmount());
        System.out.println(list);
        int total = debateManageMapper.selectSearchDebateTotal("bookName","불안", adminPageRequestDTO.getPage(), adminPageRequestDTO.getAmount());
        System.out.println("total = " + total);
    }

    @Test
    void selectEndDebateList() {
        debateManageMapper.selectEndDebateList(adminPageRequestDTO);
    }

    @Test
    void selectBookName(){
        String bookName = debateManageMapper.selectBookName(301L);
        System.out.println("bookName = " + bookName);
    }

    @Test
    void delectDebate() {

    }

    @Test
    void selectAttendMember(){
        List<AttendMemberDTO> attendMemberDTOS = debateManageMapper.selectAttendMember(195L);
        System.out.println("attendMemberDTOS = " + attendMemberDTOS);
    }

    @Test
    void selectDeleteElement(){
//        debateMapper.insertDebateInpo(debateInpoDTO);

        Optional<Long> noticeId = debateManageMapper.selectNoticeId(321L);
        System.out.println("noticeId = " + noticeId);

    }

    @Test
    void deleteBoards(){
        Optional<Long> noticeId = debateManageMapper.selectNoticeId(321L);
        System.out.println("noticeId = " + noticeId);

        // 토론 -> 토론 board -> debate-member -> 토론 comment
        //
        // debate -> debate-book
        debateManageMapper.deleteDebateBook(321L);
        // 토론 참여한 사람들만 댓글 작성 가능
        debateManageMapper.deleteMemberDebate(321L);

        debateManageMapper.deleteDebateComment(noticeId.get());

        debateManageMapper.deleteDebateBoard(321L);

        // 가장 마지막에 삭제
        debateManageMapper.deleteDebate(321L);
    }

    @Test
    void selectRecruitingCount(){
        adminPageRequestDTO.setSearchType("postTitle");
        adminPageRequestDTO.setKeyword("테스트");
        List<ManageDebateDTO> list = debateManageMapper.selectRecruitingDebate(adminPageRequestDTO);
        System.out.println("list = " + list);

        int i = debateManageMapper.selectRecruitingCount(debateSearchDTO);
        System.out.println("i = " + i);

    }





}