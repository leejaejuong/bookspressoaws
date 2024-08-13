package com.example.bookspresso.mapper.question;

import com.example.bookspresso.dto.member.MemberJoinDTO;
import com.example.bookspresso.dto.question.*;
import com.example.bookspresso.mapper.member.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class QuestionMapperTest {
@Autowired QuestionMapper questionMapper;
//@Autowired MemberMapper memberMapper;
//    QuestionWriteDTO questionWriteDTO;
//    MemberJoinDTO memberJoinDTO;
//    @BeforeEach
//    void setUp() {
//        memberJoinDTO = MemberJoinDTO.builder()
//                .memberId(1L)
//                .loginId("aaaa")
//                .password("aaaaaa")
//                .email("sfdmfse@naver.com")
//                .nickname("aaa@aa")
//                .build();
//
//        memberMapper.insertMember(memberJoinDTO);
//
//        questionWriteDTO = QuestionWriteDTO.builder()
//                .qTitle("aaaa")
//                .qContent("aaaaa")
//                .memberId(1L)
//                .build();
//
//    }

    @Test
    void insertBoard() {
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(3L);
        questionWriteDTO.setQContent("test@");
        questionWriteDTO.setQTitle("test@");

        questionMapper.insertBoard(questionWriteDTO);   // 게시물 작성

        List<QuestionListDTO> lists = questionMapper.selectList(questionWriteDTO.getMemberId());
        System.out.println("lists = " + lists);

    }

    @Test
    void selectBoard() {

    }

    @Test
    void selectTotal(){
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(3L);
        questionWriteDTO.setQContent("test");
        questionWriteDTO.setQTitle("test");

        questionMapper.insertBoard(questionWriteDTO);
        int count = questionMapper.selectTotal(4L);
        System.out.println("@@@@@@@ count = " + count);
    }

    @Test
    void selectQuestion(){

        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(3L);
        questionWriteDTO.setQContent("test");
        questionWriteDTO.setQTitle("test");

        questionMapper.insertBoard(questionWriteDTO);

        Optional<QuestionDetailDTO> questionDetailDTO = questionMapper.selectQuestion(questionWriteDTO.getQBoardId());
        System.out.println("detail = " + questionDetailDTO.isPresent());

    }

    @Test
    void updateQuestion(){
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(3L);
        questionWriteDTO.setQContent("test");
        questionWriteDTO.setQTitle("test");

        questionMapper.insertBoard(questionWriteDTO);

        QuestionModifyDTO questionModifyDTO = new QuestionModifyDTO();
        questionModifyDTO.setQBoardId(questionWriteDTO.getQBoardId());
        questionModifyDTO.setQContent("testerwerwer");
        questionModifyDTO.setQTitle("testsdfsfes");

        questionMapper.updateQuestion(questionModifyDTO);

        System.out.println(questionModifyDTO + "############");
    }

    @Test
    void deleteQuestion(){
        QuestionWriteDTO questionWriteDTO = new QuestionWriteDTO();
        questionWriteDTO.setMemberId(3L);
        questionWriteDTO.setQContent("testsfdfsd");
        questionWriteDTO.setQTitle("testsfesedfs");
        questionMapper.insertBoard(questionWriteDTO);

        List<QuestionListDTO> questionListDTO = questionMapper.selectList(questionWriteDTO.getMemberId());

        System.out.println("questionListDTO = " + questionListDTO);

        questionMapper.deleteQuestion(questionWriteDTO.getQBoardId());
        questionMapper.selectList(questionWriteDTO.getMemberId());
    }

    @Test
    public void selectQuestionList(){
        QuestionSearchDTO questionSearchDTO = new QuestionSearchDTO();
        questionSearchDTO.setMemberId(4L);
        questionSearchDTO.setSearchType("qTitle");
        questionSearchDTO.setKeyword("test");

        List<QuestionListDTO> searchListDTOS = questionMapper.searchList(questionSearchDTO);

        System.out.println(searchListDTOS);
    }



}