package com.example.bookspresso.mapper.api.Lib;

import com.example.bookspresso.dto.api.Lib.LibApiLib;
import com.example.bookspresso.dto.api.Lib.LibApiLibs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibMapper {
    void insertLib(LibApiLib libApiLib);
    int libSelectduplication(String libCode);
}
