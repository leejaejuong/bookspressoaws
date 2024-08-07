package com.example.bookspresso.service.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.mapper.mypage.SettingMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MypageServiceTest {
    @Mock
    SettingMapper settingMapper;

    @InjectMocks
    MypageService mypageService;

    @Test
    void findMember() {
        SettingDTO test = SettingDTO.builder().email("test").build();
        doReturn(Optional.of(test)).when(settingMapper).selectSetting(any());

        SettingDTO member = mypageService.findMember(1L);

        assertThat(member.getEmail()).isEqualTo("test");

    }

    @Test
    void fixedIntroduce() {
    }
}