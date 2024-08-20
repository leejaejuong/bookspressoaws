package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.discussion.AttendMemberDTO;
import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.mapper.debate.DebateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();

        debateSearchDTO = DebateSearchDTO.builder()
                .searchType("qTitle")
                .keyword("푸바오")
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

        List<Long> commentIds = debateManageMapper.selectDeleteElement(321L);
        System.out.println("commentIds = " + commentIds);

    }

    @Test
    void deleteBoards(){
        debateMapper.insertDebateInpo(debateInpoDTO);

    }





}