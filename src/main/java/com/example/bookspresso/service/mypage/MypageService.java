package com.example.bookspresso.service.mypage;

import com.example.bookspresso.dto.mypage.MemberProfileDTO;
import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.mapper.member.MemberMapper;
import com.example.bookspresso.mapper.mypage.MypageDebateMapper;
import com.example.bookspresso.mapper.mypage.SettingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MypageService {
    private final SettingMapper settingMapper;
    private final MypageDebateMapper mypageDebateMapper;
    private final MultipartProperties multipartProperties;

    @Value("${file.dir.pfp}")
    private String pfpFileDir;

    // 멤버 정보 가져오기
    public SettingDTO findMember(Long memberId) {
        return settingMapper.selectSetting(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 번호"));
    }
//     토론 정보 가져오기
    public MypageDebateDTO findDebate(Long memberId){
        return mypageDebateMapper.selectDebate(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 번호"));
    }

    // 소개글 수정 서비스
    public void modifyIntroduce(Long memberId, String introduce) {
        settingMapper.updateIntroduce(memberId, introduce);
    }

    // 닉네임 변경 서비스
    public void modifyNickname(Long memberId, String nickname) {
        settingMapper.updateNickname(memberId, nickname);
    }

    // 이메일 변경 서비스
    public void modifyEmail(Long memberId, String email) {
        settingMapper.updateEmail(memberId, email);
    }

    // 회원 삭제 서비스
    public void deleteMembers(Long memberId) {
        settingMapper.deleteMember(memberId);
    }


    public MemberProfileDTO findProfileByMemberId(Long memberId) {
        return settingMapper.selectProfileByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 회원 번호"));
    }

    // 프로필 파일 변경 서비스
    public void modifyProfile(MultipartFile multipartFile, Long memberId) throws IOException {
        try {
            removeProfileFile(memberId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }


        String originalFilename = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String uploadPath = LocalDate.now().format(formatter);

        MemberProfileDTO memberProfileDTO = MemberProfileDTO.builder()
                .memberId(memberId)
                .profileUpload(uploadPath)
                .profileName(originalFilename)
                .profileUuid(uuid)
                .build();

        saveProfileFile(memberProfileDTO, multipartFile);
        settingMapper.updateProfile(memberProfileDTO);
    }

    // 새로운 프로필 파일 저장
    public void saveProfileFile(MemberProfileDTO memberProfileDTO, MultipartFile multipartFile) throws IOException {
        String childPath = memberProfileDTO.getProfileUpload() + "/" +
                memberProfileDTO.getProfileUuid() + "_" +
                memberProfileDTO.getProfileName();

        File dir = new File(pfpFileDir, memberProfileDTO.getProfileUpload());

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(pfpFileDir,childPath);

        multipartFile.transferTo(file);
    }

    // 기존 프로필 파일 삭제
    public void removeProfileFile(Long memberId){
        MemberProfileDTO memberProfileDTO = settingMapper.selectProfileByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 회원 번호"));
        String childPath = memberProfileDTO.getProfileUpload() + "/" +
                memberProfileDTO.getProfileUuid() + "_" +
                memberProfileDTO.getProfileName();

        File file = new File(pfpFileDir,childPath);

        if(file.exists()) {
            file.delete();
        }
    }

}








