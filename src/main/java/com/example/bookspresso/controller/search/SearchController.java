package com.example.bookspresso.controller.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.SearchBookDTO;
import com.example.bookspresso.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;
    @GetMapping("/")
    public String search() {
        return "search/search";
    }
    @GetMapping("/detail")
    public String searchDetail(String isbn13
                                , Model model) {
        SearchBookDTO book = searchService.findBook(isbn13);
        List<DebateMainDTO> finddebate = searchService.finddebate();

        model.addAttribute("book", book);
        model.addAttribute("debate", finddebate);
        return "search/detail";
    }
}
