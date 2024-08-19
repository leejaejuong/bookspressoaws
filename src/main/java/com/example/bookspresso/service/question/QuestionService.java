package com.example.bookspresso.service.question;

import com.example.bookspresso.dto.question.board.*;
import com.example.bookspresso.dto.question.page.QPageRequestDTO;
import com.example.bookspresso.mapper.question.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionMapper questionMapper;

    public void addQuestion(QuestionWriteDTO questionWriteDTO){
        questionMapper.insertBoard(questionWriteDTO);
    }


    public int selectTotal(Long memberId){
        return questionMapper.selectTotal(memberId);
    }

    public QuestionDetailDTO findQuestion(Long qBoardId){
        return questionMapper.selectQuestion(qBoardId)
                        .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시물 번호"));
    }


    public void updateViewCount(Long qBoardId){
        questionMapper.updateViewCount(qBoardId);
    }

    public void modifyQuestion(QuestionModifyDTO questionModifyDTO){
        questionMapper.updateQuestion(questionModifyDTO);
    }

    public void deleteQuestion(Long qBoardId){
        questionMapper.deleteQuestion(qBoardId);
    }



    public List<QuestionListDTO> findListWithPage(QPageRequestDTO qPageRequestDTO){
        return questionMapper.selectListWithPage(qPageRequestDTO);
    }

    public List<QuestionListDTO> findSearchListWithPage(Long memberId, String keyword, int page, int amount){
        return questionMapper.searchListWithPage(memberId, keyword, page, amount);
    }

    public int findSearchTotal(Long memberId, String keyword, int page, int amount){
        return  questionMapper.searchListTotal(memberId, keyword, page, amount);
    }

}
