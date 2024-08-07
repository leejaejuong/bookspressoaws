package com.example.bookspresso.service.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.mapper.mypage.SettingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MypageService {
    private final SettingMapper settingMapper;

    public SettingDTO findMember(Long memberId) {
        return settingMapper.selectSetting(memberId)
                .orElseThrow( () -> new IllegalArgumentException("존재하지 않는 회원 번호"));
    }

    public void fixedIntroduce(SettingDTO settingDTO) {
        settingMapper.updateIntroduce(settingDTO);
    }
}
