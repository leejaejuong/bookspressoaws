package com.example.bookspresso.controller.mypage;

import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
    private final MypageService mypageService;

    @GetMapping("/setting")
    public String setting(HttpSession session, Model model) {
//        Long memberId = (Long) session.getAttribute("memberId");
        Long memberId = 1L;

//        String introduce = (String)session.getAttribute("introduce");
        SettingDTO member = mypageService.findMember(memberId);

//        model.addAttribute("introduceDto", introduce);
        model.addAttribute("memberDto", member);
        return "mypage/setting";
    }

    @GetMapping("/myDebate")
    public String myDebate(HttpSession session, Model model) {
        Long memberId = 1L;
        SettingDTO member = mypageService.findMember(memberId);
        MypageDebateDTO debate = null;
        try {
            debate = mypageService.findDebate(memberId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        System.out.println("debate = " + debate);
        model.addAttribute("memberDto", member);
        model.addAttribute("debateDto", debate);
        return "mypage/myDebate";
    }

    @GetMapping("/myBook")
    public String myBook(HttpSession session, Model model){
        Long memberId = 1L;
        SettingDTO member = mypageService.findMember(memberId);

        model.addAttribute("memberDto", member);
        return "mypage/myBook";
    }
    @GetMapping("/myPost")
    public String myPost(HttpSession session, Model model){
        Long memberId = 1L;
        SettingDTO member = mypageService.findMember(memberId);

        model.addAttribute("memberDto", member);
        return "mypage/myPost";
    }

}
