package com.example.bookspresso.mapper.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.SearchBookDTO;
import com.example.bookspresso.dto.search.SearchLibDTO;
import com.example.bookspresso.dto.search.SearchbookCommentDTO;
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
        List<SearchbookCommentDTO> selectbookcomment = searchMapper.selectbookcomment("9791191056372");
        System.out.println("selectbookcomment = " + selectbookcomment);
    }
}