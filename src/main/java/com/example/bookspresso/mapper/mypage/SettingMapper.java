package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettingMapper {
    void selectSetting(SettingDTO settingDTO);

    void updateIntroduce(SettingDTO settingDTO);


}
