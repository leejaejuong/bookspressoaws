package com.example.bookspresso.mapper.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.SearchBookDTO;
import com.example.bookspresso.dto.search.SearchLibDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    SearchBookDTO selectBook(String isbn13);
    List<DebateMainDTO> selectdebate();
    List<SearchLibDTO>selectlib(String libname);
}
