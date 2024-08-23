package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.member.MemberManageDTO;
import com.example.bookspresso.dto.admin.member.MemberSearchDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberManageMapperTest {

    @Autowired MemberManageMapper memberManageMapper;
    AdminPageRequestDTO adminPageRequestDTO;
    MemberSearchDTO memberSearchDTO;
    MemberManageDTO memberManageDTO;

    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();
        adminPageRequestDTO.setPage(1);
        adminPageRequestDTO.setAmount(3);

        memberSearchDTO = new MemberSearchDTO();




    }

    @Test
    void selectMemberList() {
        List<MemberManageDTO> memberManageDTOS = memberManageMapper.selectMemberList(adminPageRequestDTO);
        System.out.println("memberManageDTOS = " + memberManageDTOS);

    }

    @Test
    void selectSearchList() {
        List<MemberManageDTO> memberManageDTOS = memberManageMapper.selectSearchList(
                adminPageRequestDTO.getPage(),
                adminPageRequestDTO.getAmount(),
                "nickname", "은"
        );

    }

    @Test
    void selectListCount(){
        int listCount = memberManageMapper.selectListCount();

        System.out.println("listCount = " + listCount);

    }

    @Test
    void selectSearchListCount(){
        int searchCount = memberManageMapper.selectSearchListCount("nickname", "d");
        System.out.println("searchCount = " + searchCount);
    }

    @Test
    void attendDebateNum() {
        memberManageMapper.attendDebateNum(170L);

    }

    @Test
    void writePosterNum() {
        memberManageMapper.writePosterNum(1L);
    }

    @Test
    void deleteMember(){
        memberManageMapper.deleteProfile(170L);
        memberManageMapper.deleteMember(170L);
    }

}