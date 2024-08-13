package com.example.bookspresso.mapper.question;

import com.example.bookspresso.dto.question.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionMapper {

    void insertBoard(QuestionWriteDTO questionWriteDTO);

    // 자기 자신의 질문만 보임 => 공개/비공개 필요 없음
    List<QuestionListDTO> selectList(Long memberId);

    int selectTotal(Long memberId);

    Optional<QuestionDetailDTO> selectQuestion(Long qBoardId);

    void updateQuestion(QuestionModifyDTO questionModifyDTO);

    void deleteQuestion(Long qBoardId);

    void updateViewCount(Long qBoardId);

//    질문방 검색
    List<QuestionListDTO> searchList(QuestionSearchDTO questionSearchDTO);


}
