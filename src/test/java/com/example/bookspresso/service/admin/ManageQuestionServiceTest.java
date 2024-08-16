package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManageQuestionServiceTest {

    @Autowired
    ManageQuestionService manageQuestionService;

    AdminPageRequestDTO adminPageRequestDTO;
    QuestionAnswerDTO questionAnswerDTO;

    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();

        questionAnswerDTO = QuestionAnswerDTO.builder()
                .adminId(1L)
                .qBoardId(36L)
                .aContent("test 답변입니다!! ################")
                .build();
    }


    @Test
    void findQuestion() {
        manageQuestionService.findQuestionList(adminPageRequestDTO);
    }

    @Test
    void findQuestionCount(){
        manageQuestionService.findQuestionCount();
    }

    @Test
    void addAnswer(){
        manageQuestionService.addAnswer(questionAnswerDTO);
    }
}