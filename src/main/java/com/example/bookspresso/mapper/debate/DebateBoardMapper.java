package com.example.bookspresso.mapper.debate;

import com.example.bookspresso.dto.debate.board.DebateBoardAsideDTO;
import com.example.bookspresso.dto.debate.board.DebateBoardCommentDTO;
import com.example.bookspresso.dto.debate.board.DebateBoardDTO;
import com.example.bookspresso.dto.debate.board.DebateWriteDTO;
import org.apache.ibatis.annotations.Mapper;

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




}
