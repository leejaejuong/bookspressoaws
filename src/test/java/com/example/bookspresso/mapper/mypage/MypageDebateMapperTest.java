package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MypageDebateMapperTest {
    @Autowired MypageDebateMapper mypageDebateMapper;

    @Test
    void selectDebate() {
        List<MypageDebateDTO> list = mypageDebateMapper.selectDebate(3L);
        System.out.println("list = " + list);
    }
}