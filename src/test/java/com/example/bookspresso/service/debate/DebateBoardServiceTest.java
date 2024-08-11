package com.example.bookspresso.service.debate;

import com.example.bookspresso.dto.debate.board.DebateBoardCommentDTO;
import com.example.bookspresso.mapper.debate.DebateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class DebateBoardServiceTest {
@Autowired DebateBoardService debateBoardService;
DebateMapper debateMapper;


    @Test
    void selectComment() {
        List<DebateBoardCommentDTO> commentDTOS = debateBoardService.selectComment(50L);
        System.out.println("commentDTOS = " + commentDTOS);
    }
}