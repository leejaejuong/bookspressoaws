package com.example.bookspresso.controller.mypage;

import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage")
public class MyPageController {
    private final MypageService mypageService;

    @GetMapping("/setting")
    public String setting(HttpSession session, Model model) {
//        Long memberId = (Long) session.getAttribute("memberId");
        Long memberId = 1L;
        SettingDTO member = mypageService.findMember(memberId);

        model.addAttribute("memberDto", member);

        return "mypage/setting";
    }
    @GetMapping("/myDebate")
    public String myDebate() {
        return "mypage/myDebate";
    }

    @GetMapping("/myBook")
    public String myBook(){
        return "mypage/myBook";
    }
    @GetMapping("/myPost")
    public String myPost(){
        return "mypage/myPost";
    }

}
