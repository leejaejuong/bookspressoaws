package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SettingMapperTest {

    @Autowired
    SettingMapper settingMapper;


    @Test
    void selectSetting() {
        SettingDTO settingDTO = settingMapper.selectSetting(1L).get();
        System.out.println("settingDTO = " + settingDTO);
        Assertions.assertThat(settingDTO.getNickname()).isEqualTo("이재정");
    }

    @Test
    void updateIntroduce() {
    }

    @Test
    void updateNickname() {
    }

    @Test
    void updateProfile() {
    }

    @Test
    void updateEmail() {
    }

    @Test
    void deleteMember() {
    }
}