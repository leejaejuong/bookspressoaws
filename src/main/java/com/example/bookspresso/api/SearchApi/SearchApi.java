package com.example.bookspresso.api.SearchApi;

import com.example.bookspresso.dto.search.SearchLibDTO;
import com.example.bookspresso.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchApi {
    private final SearchService searchService;
    @GetMapping("/search/details/{libname}")
    public List<SearchLibDTO> search(@PathVariable("libname") String libname) {
        List<SearchLibDTO> lib = searchService.findLib(libname);
        System.out.println("lib = " + lib);
        return lib;
    }
}
