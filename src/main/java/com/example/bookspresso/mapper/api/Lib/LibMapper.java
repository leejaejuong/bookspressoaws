package com.example.bookspresso.mapper.api.Lib;


import com.example.bookspresso.dto.api.Lib.Libitem;
import com.example.bookspresso.dto.api.Lib.Libitems;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LibMapper {
    void insertLib(Libitems libitems);
    String selectduplication(String libCode);
}
