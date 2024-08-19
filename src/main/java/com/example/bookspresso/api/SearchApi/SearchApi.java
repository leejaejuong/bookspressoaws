package com.example.bookspresso.api.SearchApi;

import com.example.bookspresso.dto.search.InsertBookCommentDTO;
import com.example.bookspresso.dto.search.SearchLibDTO;
import com.example.bookspresso.dto.search.SearchbookCommentDTO;
import com.example.bookspresso.dto.search.UpdateBookCommentDTO;
import com.example.bookspresso.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/searchs/details/{isbn13}")
    public List<SearchbookCommentDTO> searchbook(@PathVariable("isbn13") String isbn13) {
        List<SearchbookCommentDTO> findcomment = searchService.findcomment(isbn13);
        System.out.println("findcomment = " + findcomment);
        return findcomment;
    }
    @PostMapping("/searchs/details/{isbn13}")
    public void commentWrite(@PathVariable("isbn13")String isbn13,
                             @RequestBody InsertBookCommentDTO insertBookCommentDTO,
                             @SessionAttribute("memberId") Long memberId) {

         insertBookCommentDTO.setIsbn13(isbn13);
         insertBookCommentDTO.setMemberId(memberId);
        System.out.println(insertBookCommentDTO);
         searchService.addcomment(insertBookCommentDTO);
    }
    @PatchMapping("/searchs/details/{commentId}")
    public void modifyComment(@PathVariable("commentId")Long commentId,
                              @RequestBody UpdateBookCommentDTO updateBookCommentDTO){
        updateBookCommentDTO.setCommentId(commentId);
        searchService.modifycomment(updateBookCommentDTO);
    }
    @DeleteMapping("/searchs/details/{commentId}")
    public void removeComment(@PathVariable("commentId")Long commentId){
       searchService.removecomment(commentId);
    }
}
