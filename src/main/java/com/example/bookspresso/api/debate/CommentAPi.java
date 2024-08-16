package com.example.bookspresso.api.debate;

import com.example.bookspresso.dto.debate.board.DebateBoardCommentDTO;
import com.example.bookspresso.dto.debate.board.DebateCommentInsertDTO;
import com.example.bookspresso.dto.debate.board.DebateCommentUpdateDTO;
import com.example.bookspresso.service.debate.DebateBoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentAPi {
    private final DebateBoardService debateBoardService;
    @GetMapping("debate/boards/{noticeId}")
    public List<DebateBoardCommentDTO> debateBoard(@PathVariable("noticeId") Long noticeId) {

        return  debateBoardService.selectComment(noticeId);
    }
    @PostMapping("/debate/details/{noticId}")
    public void commentWrite(@PathVariable("noticId") Long noticId,
                             @RequestBody DebateCommentInsertDTO debateCommentInsertDTO,
                             @SessionAttribute("memberId") Long memberId) {
        debateCommentInsertDTO.setNoticeId(noticId);
        debateCommentInsertDTO.setMemberId(memberId);

        log.info("debateCommentDTO", debateCommentInsertDTO);
        debateBoardService.addComment(debateCommentInsertDTO);
    }
    @PatchMapping("/debate/details/{commentId}")
    public void modifyComment(@PathVariable("commentId")Long commentId,
                              @RequestBody DebateCommentUpdateDTO debateCommentUpdateDTO){
        debateCommentUpdateDTO.setCommentId(commentId);
        debateBoardService.modifyComment(debateCommentUpdateDTO);
    }
    @DeleteMapping("/debate/details/{commentId}")
    public void removeComment(@PathVariable("commentId")Long commentId){
        debateBoardService.removeComment(commentId);

    }
}
