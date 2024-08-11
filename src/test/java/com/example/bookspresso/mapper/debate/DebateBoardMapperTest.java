package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.board.DebateBoardAsideDTO;
import com.example.bookspresso.dto.debate.board.DebateBoardDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class DebateBoardMapperTest {
 @Autowired DebateBoardMapper debateBoardMapper;
        DebateBoardAsideDTO debateBoardAsideDTO;
        DebateBoardDTO debateBoardDTO;


    @Test
    void selectboardaside() {
        DebateBoardAsideDTO aside = debateBoardMapper.selectboardaside(69L);
        System.out.println("aside = " + aside);
    }


    @Test
    void selectBoardComment() {
        debateBoardMapper.selectBoardComment(50L);
        System.out.println("debateBoardMapper = " + debateBoardMapper);
    }
}