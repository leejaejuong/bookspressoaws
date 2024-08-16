package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionManageMapperTest {

    @Autowired QuestionManageMapper questionManageMapper;
    AdminPageRequestDTO adminPageRequestDTO;
    QuestionAnswerDTO questionAnswerDTO;

    @BeforeEach
    void setUp() {
    adminPageRequestDTO = new AdminPageRequestDTO();

    questionAnswerDTO = QuestionAnswerDTO.builder()
            .adminId(1L)
            .qBoardId(63L)
            .aContent("test 답변입니다!! ################")
            .build();
    }

    @Test
    void selectQuestionList() {
        questionManageMapper.selectQuestionList(adminPageRequestDTO);
    }

    @Test
    void selectQuestionCount() {
        questionManageMapper.selectQuestionCount();

    }

    @Test
    void insertAnswer(){
        questionManageMapper.insertAnswer(questionAnswerDTO);
    }
}