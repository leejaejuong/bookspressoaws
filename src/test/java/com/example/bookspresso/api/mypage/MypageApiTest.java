package com.example.bookspresso.api.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.mapper.mypage.SettingMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MypageApiTest {

    @Mock
    SettingMapper settingMapper;

    @InjectMocks
    MypageApi mypageApi;

    @Test
    void deleteMember() {
        SettingDTO test = SettingDTO.builder().memberId(1L).build();
        doReturn(test).when(settingMapper).deleteMember(1L);
    }
}