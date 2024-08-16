package com.example.bookspresso.service.question;

import com.example.bookspresso.dto.question.board.*;
import com.example.bookspresso.dto.question.page.QPageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        List<QuestionListDTO> list = questionService.findList(1L);
        System.out.println("list = " + list);
    }

    @Test
    void findList() {
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(3L);
        questionWriteDTO.setQContent("test");
        questionWriteDTO.setQTitle("test");

        questionService.addQuestion(questionWriteDTO);

        questionService.findList(4L);

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

        int count = questionService.selectTotal(3L);
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

    @Test
    void updateQuestion() {
        QuestionWriteDTO questionWriteDTO1 = new QuestionWriteDTO();
        questionWriteDTO1.setMemberId(1L);
        questionWriteDTO1.setQContent("test");
        questionWriteDTO1.setQTitle("test");
        questionService.addQuestion(questionWriteDTO1);

        QuestionModifyDTO questionModifyDTO = new QuestionModifyDTO();
        questionModifyDTO.setQContent("testdfsefsdfs");
        questionModifyDTO.setQTitle("testsfefsefr");
        questionModifyDTO.setQBoardId(questionWriteDTO1.getQBoardId());

        questionService.modifyQuestion(questionModifyDTO);

//        questionService.findList();


    }
    @Test
    public void deleteQuestion() {
        questionService.deleteQuestion(37L);
//        questionService.findList();
    }

    @Test
    public void updateViewCount(){
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(1L);
        questionWriteDTO.setQContent("testQuestion");
        questionWriteDTO.setQTitle("testQuestion");

        questionService.addQuestion(questionWriteDTO);

        questionService.updateViewCount(questionWriteDTO.getQBoardId());
        questionService.updateViewCount(questionWriteDTO.getQBoardId());
        questionService.updateViewCount(questionWriteDTO.getQBoardId());
//        List<QuestionListDTO> list = questionService.findList();
//        System.out.println(list);
    }

    @Test
    public void findSearchList(){
        QuestionSearchDTO questionSearchDTO = new QuestionSearchDTO();
        questionSearchDTO.setMemberId(4L);
        questionSearchDTO.setSearchType("qTitle");
        questionSearchDTO.setKeyword("토론");

        List<QuestionListDTO> searchList = questionService.findSearchList(questionSearchDTO);
        System.out.println("searchList = " + searchList);
    }

    @Test
    public void findListWithPage(){
        questionService.findList(4L);

        QPageRequestDTO qPageRequestDTO = new QPageRequestDTO();
        qPageRequestDTO.setMemberId(4L);
        qPageRequestDTO.setAmount(4);

        List<QuestionListDTO> listWithPage = questionService.findListWithPage(qPageRequestDTO);
        System.out.println("listWithPage = " + listWithPage);

    }



}