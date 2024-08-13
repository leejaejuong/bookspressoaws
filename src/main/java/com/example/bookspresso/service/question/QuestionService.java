package com.example.bookspresso.service.question;

import com.example.bookspresso.dto.question.QuestionDetailDTO;
import com.example.bookspresso.dto.question.QuestionListDTO;
import com.example.bookspresso.dto.question.QuestionModifyDTO;
import com.example.bookspresso.dto.question.QuestionWriteDTO;
import com.example.bookspresso.mapper.question.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionMapper questionMapper;

    public void addQuestion(QuestionWriteDTO questionWriteDTO){
        questionMapper.insertBoard(questionWriteDTO);
    }

    public List<QuestionListDTO> findList(){
        return questionMapper.selectList();
    }

    public int selectTotal(){
        return questionMapper.selectTotal();
    }

    public QuestionDetailDTO findQuestion(Long qBoardId){
        return questionMapper.selectQuestion(qBoardId)
                        .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시물 번호"));
    }

    public Integer findCount(Long qBoardId){
        Optional<QuestionDetailDTO> question = questionMapper.selectQuestion(qBoardId);
        if(question.isPresent()){
            question.get().setViewCount(question.get().getViewCount()+1);
        }else {
//            throw new Exception("question 게시);
        }

        return question.get().getViewCount();
    }


    public void modifyQuestion(QuestionModifyDTO questionModifyDTO){
        questionMapper.updateQuestion(questionModifyDTO);
    }

    public void deleteQuestion(Long qBoardId){
        questionMapper.deleteQuestion(qBoardId);
    }

}
