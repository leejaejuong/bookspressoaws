package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.qa.ManageQuestionListDTO;
import com.example.bookspresso.dto.admin.qa.ModifyAnswer;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import com.example.bookspresso.mapper.admin.QuestionManageMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManageQuestionServiceTest {

    @Autowired
    ManageQuestionService manageQuestionService;

    AdminPageRequestDTO adminPageRequestDTO;
    QuestionAnswerDTO questionAnswerDTO;
    ModifyAnswer modifyAnswer;
    @Autowired
    private QuestionManageMapper questionManageMapper;

    @BeforeEach
    void setUp() {
        adminPageRequestDTO = new AdminPageRequestDTO();

        questionAnswerDTO = QuestionAnswerDTO.builder()
                .adminId(1L)
                .qBoardId(36L)
                .aContent("test 답변입니다!! ################")
                .build();

        modifyAnswer = ModifyAnswer.builder()
                .qBoardId(36L)
                .adminId(1L)
                .aContent("test####333333")
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
    void findFinishQuestionList(){
        List<ManageQuestionListDTO> finishQuestionList = manageQuestionService.findFinishQuestionList(adminPageRequestDTO);
        System.out.println("finishQuestionList = " + finishQuestionList);
        int finishQuestionCount = manageQuestionService.findFinishQuestionCount();
        System.out.println("finishQuestionCount = " + finishQuestionCount);

    }

    @Test
    void addAnswer(){
        manageQuestionService.addAnswer(questionAnswerDTO);
    }

    @Test
    void updateAnswer(){
        manageQuestionService.updateAnswer(questionAnswerDTO.getQBoardId());
    }

    @Test
    void updateAnswerContent(){
        manageQuestionService.updateAnswerContent(modifyAnswer);
    }






}