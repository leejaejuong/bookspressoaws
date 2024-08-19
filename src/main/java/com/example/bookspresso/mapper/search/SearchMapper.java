package com.example.bookspresso.mapper.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    //책검색
    SearchBookDTO selectBook(String isbn13);
    //디테일 토론검색
    List<DebateMainDTO> selectdebate();
//    디테일 도서관 검색
    List<SearchLibDTO>selectlib(String libname);
//    디테일 댓글 검색
    List<SearchbookCommentDTO>selectbookcomment(String isbn13);
//    디테일 댓글 작성
    void insertbookcomment(InsertBookCommentDTO insertBookCommentDTO);
//    디테일 댓글 수정
    void updatebookcomment(UpdateBookCommentDTO updateBookCommentDTO);
//    디테일 댓글 삭제
    void deletbookcomment(Long commentId);
}
