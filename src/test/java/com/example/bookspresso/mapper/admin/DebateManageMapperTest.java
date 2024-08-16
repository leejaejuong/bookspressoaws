package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DebateManageMapperTest {

    @Autowired DebateManageMapper debateManageMapper;

    ManageDebateDTO manageDebateDTO;
    AdminPageRequestDTO adminPageRequestDTO;
    DebateSearchDTO debateSearchDTO;



    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();

        debateSearchDTO = DebateSearchDTO.builder()
                .searchType("qTitle")
                .keyword("푸바오")
                .build();
    }

    @Test
    void selectDebateList() {
        debateManageMapper.selectDebateList(adminPageRequestDTO);

    }

    @Test
    void selectDebateCount(){
        int count = debateManageMapper.selectDebateCount();
        System.out.println("#### Count = " + count);
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
    void selectSearchDebateList() {

//        debateManageMapper.selectSearchDebateList(adminPageRequestDTO, debateSearchDTO);
    }
}