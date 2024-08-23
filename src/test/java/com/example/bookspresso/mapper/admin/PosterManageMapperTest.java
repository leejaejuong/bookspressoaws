package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.poster.PosterManageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PosterManageMapperTest {

    @Autowired PosterManageMapper posterManageMapper;
    AdminPageRequestDTO adminPageRequestDTO;
    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();
        adminPageRequestDTO.setAmount(2);

    }

    @Test
    void selectPosterList() {
        List<PosterManageDTO> list = posterManageMapper.selectPosterList(adminPageRequestDTO);
        System.out.println("list = " + list);
    }

    @Test
    void selectPosterCount() {
        int posterCount = posterManageMapper.selectPosterCount();
        System.out.println("posterCount = " + posterCount);
    }

    @Test
    void selectSearchPosterList() {
    }

    @Test
    void selectSearchCount() {
    }

    @Test
    void deletePoster() {
    }

    @Test
    void deletePostComment() {
    }
}