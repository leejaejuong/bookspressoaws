package com.example.bookspresso.mapper.mainPage;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MainPageMapperTest {
@Autowired MainPageMapper mainPageMapper;
 DebateMainDTO debateMainDTO;
    @Test
    void selectonline() {
        List<DebateMainDTO> selectonline = mainPageMapper.selectonline();
        System.out.println("selectonline = " + selectonline);
    }

    @Test
    void selectoffline() {
        List<DebateMainDTO> selectoffline = mainPageMapper.selectoffline();
        System.out.println("selectoffline = " + selectoffline);
    }
}