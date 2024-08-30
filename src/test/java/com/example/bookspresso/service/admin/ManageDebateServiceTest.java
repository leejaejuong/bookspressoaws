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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
@SpringBootTest
@Transactional
class ManageDebateServiceTest {

    @Autowired DebateManageMapper debateManageMapper;
    @Autowired ManageDebateService manageDebateService;


    AdminPageRequestDTO adminPageRequestDTO;
    DebateSearchDTO debateSearchDTO;

    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();
        adminPageRequestDTO.setAmount(5);


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
        assertThat(debateCount).isEqualTo(22);
    }

    @Test
    public void findBookName(){
        manageDebateService.findBookName(301L);
    }


    @Test
    public void findAttendMemberList(){
        manageDebateService.findAttendMemberList(195L);
    }

    @Test
    public void dropDebate(){

        manageDebateService.dropDebate(288L);
    }

    @Test
    public void findRecruitingDebate(){
        int recruritingDebateCount = manageDebateService.findRecruitingDebateCount();
        System.out.println(recruritingDebateCount);
        List<ManageDebateDTO> recruitingDebate = manageDebateService.findRecruitingDebate(adminPageRequestDTO);
        System.out.println(recruitingDebate);
    }


}