package com.example.bookspresso.service.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.*;
import com.example.bookspresso.mapper.search.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final SearchMapper searchMapper;
    //검색페이지 책검색
    public SearchBookDTO findBook(String isbn13){
        return searchMapper.selectBook(isbn13);
    }
//    검색디테일 토론
    public List<DebateMainDTO> finddebate(){return searchMapper.selectdebate();}
//    검색 디테일 도서관
    public List<SearchLibDTO> findLib(String libname){return  searchMapper.selectlib(libname);}
//    검색 디테일 댓글
    public List<SearchbookCommentDTO> findcomment(String isbn13){return searchMapper.selectbookcomment(isbn13);}
//    검색 디테일 댓글 작성
    public void addcomment(InsertBookCommentDTO commentDTO){searchMapper.insertbookcomment(commentDTO);}
//    검색 디테일 댓글 수정
    public void modifycomment(UpdateBookCommentDTO updateBookCommentDTO){searchMapper.updatebookcomment(updateBookCommentDTO);}
//    검색 디테일 댓글 삭제
    public void removecomment(Long commentId){searchMapper.deletebookcomment(commentId);}
}
