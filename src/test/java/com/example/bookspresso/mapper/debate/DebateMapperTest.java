package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.N_N.DebateBookDTO;
import com.example.bookspresso.dto.debate.N_N.MemberdebateDTO;
import com.example.bookspresso.dto.debate.debateMain.DebateIdListDTO;
import com.example.bookspresso.dto.debate.debateMain.DebateMainPageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional

class DebateMapperTest {
@Autowired DebateMapper debateMapper;
DebateBookDTO debateBookDTO;
    DebateIdListDTO debateIdListDTO;
    @BeforeEach
    void setUp() {
        debateBookDTO=DebateBookDTO.builder()
                .debateId(1L)
                .isbn13("1234512")
                .memberId(1L)
                .build();
    }

    @Test
    void insertDebateMember() {
        // given
         debateMapper.insertDebateBook(debateBookDTO);
        System.out.println("debateMapper = " + debateMapper);
        //when
                   
        //then
    }


    @Test
    void selectDebateMainBoard() {



    // 3. 검증
     
    }

    @Test
    void selectDebateList() {
    }
}