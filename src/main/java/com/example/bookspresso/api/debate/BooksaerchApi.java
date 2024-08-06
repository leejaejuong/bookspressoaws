package com.example.bookspresso.api.debate;

import com.example.bookspresso.service.debate.Debateservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BooksaerchApi {
    private final Debateservice debateservice;
    @GetMapping("/")
}
