package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.post.PostMainDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class PostMapperTest {
@Autowired PostMapper postMapper;
    @Test
    void mainWithpage() {
        List<PostMainDTO> postMainDTOS = postMapper.mainWithpage();
        System.out.println("postMainDTOS = " + postMainDTOS);
    }
}