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

    public void modifyIntroduce(Long memberId, String introduce) {
       settingMapper.updateIntroduce(memberId, introduce);
    }

    public void modifyNickname(Long memberId, String nickname){
        settingMapper.updateNickname(memberId, nickname);
    }

    public void modifyEmail(Long memberId, String email){
        settingMapper.updateEmail(memberId, email);
    }

    public void delteMembers(Long memberId){
        settingMapper.deleteMember(memberId);
    }
}
