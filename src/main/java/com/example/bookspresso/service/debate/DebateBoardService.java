package com.example.bookspresso.service.debate;

import com.example.bookspresso.dto.debate.board.*;
import com.example.bookspresso.mapper.debate.DebateBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DebateBoardService {
    private final DebateBoardMapper debateBoardMapper;
//    사이드 토론정보
    public DebateBoardAsideDTO selectAside(Long debateId){
        return debateBoardMapper.selectboardaside(debateId);
    }
//    토론 페이지
    public List<DebateBoardDTO> selectcentent(Long debateId){
        return debateBoardMapper.selectboard(debateId);

    }
//    토론 페이지 댓글
    public List<DebateBoardCommentDTO> selectComment(Long noticeId){return debateBoardMapper.selectBoardComment(noticeId);}
//    토론 작성
    public void addWrite(DebateWriteDTO debateWriteDTO){debateBoardMapper.insertWrite(debateWriteDTO);}



}
