package com.example.bookspresso.mapper.api.aladin;

import com.example.bookspresso.dto.api.aladin.Aladinitem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AladinMapper {
    void insertBook(Aladinitem aladinitem);
    //중복검사를 위한 코드
   int selectDuplication(String ISBN13);
}
