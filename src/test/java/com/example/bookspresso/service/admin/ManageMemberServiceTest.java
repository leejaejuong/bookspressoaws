package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.member.MemberManageDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ManageMemberServiceTest {

    @Autowired ManageMemberService manageMemberService;
    AdminPageRequestDTO adminPageRequestDTO;
    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();
//        adminPageRequestDTO.setAmount();
    }

    @Test
    void findMemberList() {
        List<MemberManageDTO> memberList = manageMemberService.findMemberList(adminPageRequestDTO);
        System.out.println("memberList = " + memberList);


    }

    @Test
    void findSearchMemberList() {
        List<MemberManageDTO> searchMemberList = manageMemberService.findSearchMemberList(adminPageRequestDTO.getPage(), adminPageRequestDTO.getAmount(), "loginId", "d");
        System.out.println("searchMemberList = " + searchMemberList);

    }

    @Test
    void total(){
        int listCount = manageMemberService.findListCount();
        System.out.println("listCount = " + listCount);
        int searchCount = manageMemberService.findSearchCount("nickname", "d");
        System.out.println("searchCount = " + searchCount);
    }

    @Test
    void dropMember(){
        manageMemberService.dropMember(170L);
    }

}


// 예외 처리는 서비스에서 테스트 진행하면서 발생한 예외를 토대로 예외처리를 진행함