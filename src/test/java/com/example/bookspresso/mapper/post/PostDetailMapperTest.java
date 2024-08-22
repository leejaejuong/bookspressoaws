package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.post.PostCommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PostDetailMapperTest {
@Autowired PostDetailMapper postDetailMapper;
    @Test
    void selectPostComment() {
        List<PostCommentDTO> list = postDetailMapper.selectPostComment(1L);
        System.out.println(list);
    }

}