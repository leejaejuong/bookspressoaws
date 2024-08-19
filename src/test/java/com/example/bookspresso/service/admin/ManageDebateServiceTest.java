package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.discussion.DebateSearchDTO;
import com.example.bookspresso.dto.admin.discussion.ManageDebateDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.mapper.admin.DebateManageMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class ManageDebateServiceTest {

    @Autowired DebateManageMapper debateManageMapper;
    @Autowired ManageDebateService manageDebateService;

    @Mock
//    DebateManageMapper debateManageMapper;
//
//    @InjectMocks
//    ManageDebateService manageDebateService;

    AdminPageRequestDTO adminPageRequestDTO;
    DebateSearchDTO debateSearchDTO;

    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();

        debateSearchDTO = DebateSearchDTO.builder()
                .searchType("bookName")
                .keyword("으")
                .build();

    }

    @Test
    void findDebateList() {
        doReturn(List.of(new ManageDebateDTO()))
                .when(debateManageMapper)
                .selectDebateList(adminPageRequestDTO);

        List<ManageDebateDTO> debateList = manageDebateService.findDebateList(adminPageRequestDTO);

        assertThat(debateList).isNotNull();

        System.out.println(debateList);
    }

    @Test
    void findSearchDebateList(){
        List<ManageDebateDTO> list = manageDebateService.findSearchDebateList(debateSearchDTO.getSearchType(),
                debateSearchDTO.getKeyword(),
                adminPageRequestDTO.getPage(),
                adminPageRequestDTO.getAmount());

        System.out.println("list = " + list);

        int total = manageDebateService.findSearchDebateTotal(debateSearchDTO.getSearchType(),
                debateSearchDTO.getKeyword(),
                adminPageRequestDTO.getPage(),
                adminPageRequestDTO.getAmount());
        System.out.println("total = " + total);

    }


    @Test
    void findEndDebateList() {

        manageDebateService.findEndDebateList(adminPageRequestDTO);


    }

    @Test
    void findDebateCount(){
        int debateCount = manageDebateService.findDebateCount();
        assertThat(debateCount).isEqualTo(1);
    }

    @Test
    public void findBookName(){
        debateManageMapper.selectBookName(301L);
    }

    @Test
    void dropDebate() {



    }
}