package com.example.bookspresso.mapper.question;

import com.example.bookspresso.dto.question.QuestionDetailDTO;
import com.example.bookspresso.dto.question.QuestionListDTO;
import com.example.bookspresso.dto.question.QuestionModifyDTO;
import com.example.bookspresso.dto.question.QuestionWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionMapper {

    void insertBoard(QuestionWriteDTO questionWriteDTO);

    List<QuestionListDTO> selectList();

    int selectTotal();

    Optional<QuestionDetailDTO> selectQuestion(Long qBoardId);

    void updateQuestion(QuestionModifyDTO questionModifyDTO);

    void deleteQuestion(Long qBoardId);
}
