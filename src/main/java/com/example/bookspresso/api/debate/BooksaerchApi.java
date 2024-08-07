package com.example.bookspresso.api.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import com.example.bookspresso.service.debate.Debateservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BooksaerchApi {
    private final Debateservice debateservice;

    @GetMapping("/debate/inpos/{title}")
    public List<BookinpoDTO> debate(@PathVariable("title") String title) {
        List<BookinpoDTO> bookinpoDTOS = debateservice.searchBookinpo(title);
        System.out.println("bookinpoDTOS = " + bookinpoDTOS);
        return bookinpoDTOS;
    }
}
