package com.example.bookspresso.controller.search;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    @GetMapping("/")
    public String search() {
        return "search/search";
    }
    @GetMapping("/search_detail")
    public String searchDetail() {
        return "search/search_detail";
    }
}
