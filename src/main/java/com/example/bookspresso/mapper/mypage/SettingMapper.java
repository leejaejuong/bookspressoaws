package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SettingMapper {
    Optional<SettingDTO> selectSetting(@Param("memberId") Long memberId);

    void updateIntroduce(@Param("memberId") Long memberId, @Param("introduce") String introduce);

    void updateNickname(@Param("memberId")Long memberId, @Param("nickname") String nickname);

    void updateEmail(@Param("memberId")Long memberId, @Param("email") String email);

    void updateProfile(SettingDTO settingDTO);

    void deleteMember(@Param("memberId") Long memberId);

}
