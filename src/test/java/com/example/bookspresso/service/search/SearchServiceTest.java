package com.example.bookspresso.service.search;

import com.example.bookspresso.dto.search.SearchbookCommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class SearchServiceTest {
 @Autowired private SearchService searchService;
    @Test
    void findcomment() {


    }
}