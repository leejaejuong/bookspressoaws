package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.qa.ManageQuestionListDTO;
import com.example.bookspresso.dto.admin.qa.ModifyAnswer;
import com.example.bookspresso.dto.admin.qa.QuestionAnswerDTO;
import com.example.bookspresso.mapper.admin.QuestionManageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ManageQuestionService {

    private final QuestionManageMapper questionManageMapper;

    public List<ManageQuestionListDTO> findQuestionList(AdminPageRequestDTO adminPageRequestDTO){
        return questionManageMapper.selectQuestionList(adminPageRequestDTO);
    }

    public int findQuestionCount(){
        return questionManageMapper.selectQuestionCount();
    }

    public List<ManageQuestionListDTO> findFinishQuestionList(AdminPageRequestDTO adminPageRequestDTO){
        return questionManageMapper.selectFinishQuestionList(adminPageRequestDTO);
    }
    public int findFinishQuestionCount(){
        return questionManageMapper.selectFinishQuestionCount();
    }

    public void addAnswer(QuestionAnswerDTO questionAnswerDTO){
        questionManageMapper.insertAnswer(questionAnswerDTO);
        questionManageMapper.updateAnswerStatus(questionAnswerDTO.getQBoardId());
    }


    public void updateAnswerContent(QuestionAnswerDTO questionAnswerDTO){
        questionManageMapper.updateAnswer(questionAnswerDTO);
    }


}
