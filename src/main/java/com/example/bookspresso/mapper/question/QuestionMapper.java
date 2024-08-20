package com.example.bookspresso.mapper.question;

import com.example.bookspresso.dto.question.board.*;
import com.example.bookspresso.dto.question.page.QPageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionMapper {

    void insertBoard(QuestionWriteDTO questionWriteDTO);

    int selectTotal(Long memberId);

    Optional<QuestionDetailDTO> selectQuestion(Long qBoardId);

    void updateQuestion(QuestionModifyDTO questionModifyDTO);

    void deleteQuestion(Long qBoardId);

    void updateViewCount(Long qBoardId);



    List<QuestionListDTO> selectListWithPage(QPageRequestDTO qPageRequestDTO);

    List<QuestionListDTO> searchListWithPage(@Param("memberId") Long memberId,
                                             @Param("keyword") String keyword,
                                             @Param("page") int page,
                                             @Param("amount") int amount);

    int searchListTotal(@Param("memberId") Long memberId,
                        @Param("keyword") String keyword);

}
