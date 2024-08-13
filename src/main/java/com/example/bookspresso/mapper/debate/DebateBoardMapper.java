package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.board.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DebateBoardMapper {
    //board 페이지
//    사이트 토론정보
    DebateBoardAsideDTO selectboardaside(Long debateId);
//    토론페이지
    List<DebateBoardDTO> selectboard(Long debateId);
//    토론페이지 댓글
    List<DebateBoardCommentDTO> selectBoardComment(Long noticeId);
// 게시글 디테일 페이지
    Optional<DebateBoardDTO> selectDetail(Long debateId, Long noticeId);
//    토론작성
    void insertWrite(DebateWriteDTO debateWriteDTO );
//    게시물수정
    void debateBoardUpdate(DebateBoardUpdateDTO debateBoardUpdateDTO);
//    게시물 삭제
    void debateBoardDelete(Long memberId);
//    댓글 작성
    void debateCommentInsert(DebateCommentInsertDTO debateCommentInsertDTO);
//    댓글 수정
    void debateCommentUpdate(DebateCommentUpdateDTO debateCommentUpdateDTO);
//    댓글 삭제
    void debateCommentDelete(@Param("memberId") Long memberId,
                             @Param("commentId") Long commentId);



}
