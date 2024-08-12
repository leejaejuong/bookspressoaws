package com.example.bookspresso.service.question;

import com.example.bookspresso.dto.question.QuestionDetailDTO;
import com.example.bookspresso.dto.question.QuestionListDTO;
import com.example.bookspresso.dto.question.QuestionWriteDTO;
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

}
