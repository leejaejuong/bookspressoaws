package com.example.bookspresso.service.search;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.search.SearchBookDTO;
import com.example.bookspresso.dto.search.SearchLibDTO;
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
    public SearchBookDTO findBook(String isbn13){
        return searchMapper.selectBook(isbn13);
    }
    public List<DebateMainDTO> finddebate(){return searchMapper.selectdebate();}
    public List<SearchLibDTO> findLib(String libname){return  searchMapper.selectlib(libname);}
}
