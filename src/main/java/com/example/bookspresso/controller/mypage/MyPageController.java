package com.example.bookspresso.controller.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
    private final MypageService mypageService;

    @GetMapping("/setting")
    public String setting(HttpSession session, Model model) {
//        Long memberId = (Long) session.getAttribute("memberId");
        Long memberId = 3L;

//        String introduce = (String)session.getAttribute("introduce");
        SettingDTO member = mypageService.findMember(memberId);

//        model.addAttribute("introduceDto", introduce);
        model.addAttribute("memberDto", member);
        return "mypage/setting";
    }

    @GetMapping("/myDebate")
    public String myDebate(HttpSession session, Model model) {
        Long memberId = 3L;
        SettingDTO member = mypageService.findMember(memberId);

        model.addAttribute("memberDto", member);
        return "mypage/myDebate";
    }

    @GetMapping("/myBook")
    public String myBook(HttpSession session, Model model){
        Long memberId = 3L;
        SettingDTO member = mypageService.findMember(memberId);

        model.addAttribute("memberDto", member);
        return "mypage/myBook";
    }
    @GetMapping("/myPost")
    public String myPost(HttpSession session, Model model){
        Long memberId = 3L;
        SettingDTO member = mypageService.findMember(memberId);

        model.addAttribute("memberDto", member);
        return "mypage/myPost";
    }

}
