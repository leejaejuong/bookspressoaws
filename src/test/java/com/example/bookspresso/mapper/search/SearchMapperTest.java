package com.example.bookspresso.mapper.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.SearchBookDTO;
import com.example.bookspresso.dto.search.SearchLibDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class SearchMapperTest {
@Autowired SearchMapper searchMapper;
    @Test
    void selectBook() {
        SearchBookDTO searchBookDTO = searchMapper.selectBook("9791167552723");
        System.out.println("searchBookDTO = " + searchBookDTO);
        List<DebateMainDTO> selectdebate = searchMapper.selectdebate();
        System.out.println("selectdebate = " + selectdebate);

        List<SearchLibDTO> Lib = searchMapper.selectlib("성북");
        System.out.println("Lib = " + Lib);
    }
}