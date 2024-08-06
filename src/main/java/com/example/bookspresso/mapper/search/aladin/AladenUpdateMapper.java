package com.example.bookspresso.mapper.search.aladin;

import com.example.bookspresso.api.Aladen.Aladinitem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AladenUpdateMapper {
    void insertBook(Aladinitem aladinitem);
    String selectBooknumber(String isbn13);


}
