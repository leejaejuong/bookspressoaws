package com.example.bookspresso.service.question;

import com.example.bookspresso.dto.question.QuestionDetailDTO;
import com.example.bookspresso.dto.question.QuestionListDTO;
import com.example.bookspresso.dto.question.QuestionWriteDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class QuestionServiceTest {
@Autowired QuestionService questionService;


    @Test
    void addQuestion() {
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(1L);
        questionWriteDTO.setQContent("test");
        questionWriteDTO.setQTitle("test");

        questionService.addQuestion(questionWriteDTO);

        List<QuestionListDTO> list = questionService.findList();
        System.out.println("list = " + list);
    }

    @Test
    void findList() {

    }

    @Test
    void selectTotal() {
        QuestionWriteDTO questionWriteDTO1 = new QuestionWriteDTO();
        questionWriteDTO1.setMemberId(1L);
        questionWriteDTO1.setQContent("test");
        questionWriteDTO1.setQTitle("test");

        QuestionWriteDTO questionWriteDTO2 = new QuestionWriteDTO();
        questionWriteDTO1.setMemberId(3L);
        questionWriteDTO1.setQContent("test3");
        questionWriteDTO1.setQTitle("test3");

        questionService.addQuestion(questionWriteDTO1);
        questionService.addQuestion(questionWriteDTO2);

        int count = questionService.selectTotal();
        System.out.println("##### count = " + count);

    }

    @Test
    void findQuestion(){
        QuestionWriteDTO questionWriteDTO1 = new QuestionWriteDTO();
        questionWriteDTO1.setMemberId(1L);
        questionWriteDTO1.setQContent("test");
        questionWriteDTO1.setQTitle("test");

        QuestionDetailDTO question = questionService.findQuestion(27L);
        System.out.println("question = " + question);
    }

}