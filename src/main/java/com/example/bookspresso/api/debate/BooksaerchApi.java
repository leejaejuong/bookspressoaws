package com.example.bookspresso.api.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import com.example.bookspresso.dto.debate.board.DebateBoardCommentDTO;
import com.example.bookspresso.dto.debate.page.DebatePageRequestDTO;
import com.example.bookspresso.service.debate.DebateBoardService;
import com.example.bookspresso.service.debate.Debateservice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BooksaerchApi {
    private final Debateservice debateservice;
    private final DebateBoardService debateBoardService;

    @GetMapping("/debate/inpos/{title}")
    public List<BookinpoDTO> debate(@PathVariable("title") String title) {
        return  debateservice.searchBookinpo(title);
    }
    @GetMapping("debate/boards/{noticeId}")
    public List<DebateBoardCommentDTO> debateBoard(@PathVariable("noticeId") Long noticeId) {
        List<DebateBoardCommentDTO> commentDTOS = debateBoardService.selectComment(noticeId);
        System.out.println("commentDTOS = " + commentDTOS);
        return  commentDTOS;

    }
}
