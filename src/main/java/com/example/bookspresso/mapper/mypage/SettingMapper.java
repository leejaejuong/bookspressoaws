package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface SettingMapper {
    Optional<SettingDTO> selectSetting(Long memberId);

    void updateIntroduce(SettingDTO settingDTO);

    void updateNickname(String nickname);

    void updateProfile(SettingDTO settingDTO);

    void updateEmail(String email);

    void deleteMember(SettingDTO settingDTO);

}
