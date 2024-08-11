package com.example.bookspresso.service.debate;

import com.example.bookspresso.dto.debate.debateMain.DebateIdListDTO;
import com.example.bookspresso.dto.debate.debateMain.DebateMainPageDTO;
import com.example.bookspresso.mapper.debate.DebateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DebateserviceTest {
@Autowired Debateservice debateservice;
   DebateMapper debateMapper;



    @Test
    void findMainPage() {
    }
}