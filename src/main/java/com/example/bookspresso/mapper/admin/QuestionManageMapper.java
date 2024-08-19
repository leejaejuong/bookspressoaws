package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.qa.ManageQuestionListDTO;
import com.example.bookspresso.dto.admin.qa.ModifyAnswer;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import com.example.bookspresso.dto.question.board.QuestionDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionManageMapper {

    List<ManageQuestionListDTO> selectQuestionList(AdminPageRequestDTO adminPageRequestDTO);
    int selectQuestionCount();

    List<ManageQuestionListDTO> selectFinishQuestionList(AdminPageRequestDTO adminPageRequestDTO);
    int selectFinishQuestionCount();

    void insertAnswer(QuestionAnswerDTO questionAnswerDTO);

    void updateAnswerStatus(Long qBoardId);

    void updateAnswer(ModifyAnswer modifyAnswer);
}
