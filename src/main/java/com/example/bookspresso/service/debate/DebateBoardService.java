package com.example.bookspresso.service.debate;

import com.example.bookspresso.dto.debate.board.*;
import com.example.bookspresso.mapper.debate.DebateBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//    토론 디테일
    public DebateBoardDTO selectDetaill(Long debateId,Long noticeId) {
        return debateBoardMapper.selectDetail(debateId, noticeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 토론 게시물"));
    }
//    토론 작성
    public void addWrite(DebateWriteDTO debateWriteDTO){debateBoardMapper.insertWrite(debateWriteDTO);}
    //    게시물수정
   public void modifyBoard(DebateBoardUpdateDTO debateBoardUpdateDTO){
        debateBoardMapper.debateBoardUpdate(debateBoardUpdateDTO);
   }
    //    게시물 삭제
   public void removeBoard(Long memberId,Long noticeId){debateBoardMapper.debateBoardDelete(memberId,noticeId);}
//    댓글 작성
    public void addComment(DebateCommentInsertDTO debateCommentInsertDTO){debateBoardMapper.debateCommentInsert(debateCommentInsertDTO);}
    //    댓글 수정
    public void modifyComment(DebateCommentUpdateDTO debateCommentUpdateDTO){
        debateBoardMapper.debateCommentUpdate(debateCommentUpdateDTO);
    }
    //    댓글 삭제
   public void removeComment(Long commentId){
        debateBoardMapper.debateCommentDelete(commentId);
   }


}
