package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.poster.PosterManageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PosterManageServiceTest {

    @Autowired PosterManageService posterManageService;

    AdminPageRequestDTO adminPageRequestDTO;


    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();
        adminPageRequestDTO.setAmount(2);
    }


    @Test
    void findPosterList() {
        List<PosterManageDTO> list = posterManageService.findPosterList(adminPageRequestDTO);
        System.out.println("list = " + list);

    }

    @Test
    void findPosterCount() {
        int posterCount = posterManageService.findPosterCount();
    }


    @Test
    void testFindPosterList() {
        int count = posterManageService.findSearchPosterCount("postTitle", "테스트");
        System.out.println("count = " + count);
        posterManageService.findSearchPosterList("postTitle", "테",
                adminPageRequestDTO.getPage(), adminPageRequestDTO.getAmount());
    }

    @Test
    void testFindPosterCount() {
    }

    @Test
    void findSearchPosterList() {
    }

    @Test
    void findSearchPosterCount() {
    }

    @Test
    void deletePoster() {
    }
}