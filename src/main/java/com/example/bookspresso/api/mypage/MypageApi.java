package com.example.bookspresso.api.mypage;

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
        Long memberId = (Long) session.getAttribute("memberId");

        System.out.println(" introduceMap = " + introduceMap);
        String introduce = introduceMap.get("introduce");

        mypageService.modifyIntroduce(memberId, introduce);
    }

    @PatchMapping("/members-nickname")
    public void updateNickname(HttpSession session, @RequestBody Map<String, String> nicknameMap) {
        Long memberId = (Long) session.getAttribute("memberId");
        System.out.println(" nicknameMap = " + nicknameMap);
        String nickname = nicknameMap.get("nickname");

        mypageService.modifyNickname(memberId, nickname);
    }

    @PatchMapping("/members-email")
    public void updateEmail(HttpSession session, @RequestBody Map<String, String> emailMap) {
        Long memberId = (Long) session.getAttribute("memberId");
        System.out.println(" emailMap = " + emailMap);
        String email = emailMap.get("email");

        mypageService.modifyEmail(memberId, email);
    }

    @DeleteMapping("/members-delete/{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId, HttpSession session) {
        mypageService.deleteMembers(memberId);
    }

    @PatchMapping("/members-pfp-file")
    public void pfpFilePatch(@RequestParam("file") MultipartFile pfpFile,
                             HttpSession session){
        System.out.println("pfpFile = " + pfpFile.getOriginalFilename());
        Long memberId = (Long) session.getAttribute("memberId");

        try {
            mypageService.modifyProfile(pfpFile, memberId);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
