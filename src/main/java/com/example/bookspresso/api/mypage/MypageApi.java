package com.example.bookspresso.api.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MypageApi {
    private final MypageService mypageService;

    @PatchMapping("/member-introduce")
    public void updateIntroduce(HttpSession session, @RequestBody Map<String, String> introduceMap) {
        Long memberId = 1L;

        System.out.println(" introduceMap = " + introduceMap);
        String introduce = introduceMap.get("introduce");

        mypageService.modifyIntroduce(memberId, introduce);
    }

    @PatchMapping("/members-nickname")
    public void updateNickname(HttpSession session, @RequestBody Map<String, String> nicknameMap) {
        Long memberId = 1L;
        System.out.println(" nicknameMap = " + nicknameMap);
        String nickname = nicknameMap.get("nickname");

        mypageService.modifyNickname(memberId, nickname);
    }

    @PatchMapping("/members-email")
    public void updateEmail(HttpSession session, @RequestBody Map<String, String> emailMap) {
        Long memberId = 1L;
        System.out.println(" emailMap = " + emailMap);
        String email = emailMap.get("email");

        mypageService.modifyEmail(memberId, email);
    }

    @DeleteMapping("/members-delete")
    public void deleteMember(HttpSession session, @RequestBody Long memberId) {
        Long member = 1L;

        mypageService.deleteMembers(member);
    }

    @PatchMapping("/members-pfp-file")
    public void pfpFilePatch(@RequestParam("file") MultipartFile pfpFile,
                             HttpSession session){
        System.out.println("pfpFile = " + pfpFile.getOriginalFilename());
//        Long memberId = (Long) session.getAttribute("memberId");
        Long memberId = 1L;
        try {
            mypageService.modifyProfile(pfpFile, memberId);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
