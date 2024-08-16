package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.qa.ManageQuestionListDTO;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionManageMapper {

    List<ManageQuestionListDTO> selectQuestionList(AdminPageRequestDTO adminPageRequestDTO);

    int selectQuestionCount();

    void insertAnswer(QuestionAnswerDTO questionAnswerDTO);


}
