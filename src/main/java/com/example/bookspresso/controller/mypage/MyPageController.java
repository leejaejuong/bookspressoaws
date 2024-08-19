package com.example.bookspresso.controller.mypage;

import com.example.bookspresso.dto.mypage.MypageBookDTO;
import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import com.example.bookspresso.dto.mypage.MypagePostDTO;
import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
    private final MypageService mypageService;

    @GetMapping("/setting")
    public String setting(HttpSession session, Model model) {
        Long memberId = (Long) session.getAttribute("memberId");

        if (memberId == null) {
            return "redirect:/member/login";
        }

        SettingDTO member = mypageService.findMember(memberId);
        model.addAttribute("memberDto", member);
        return "mypage/setting";
    }

    @GetMapping("/myDebate")
    public String myDebate(HttpSession session, Model model) {
        Long memberId = (Long) session.getAttribute("memberId");

        SettingDTO member = mypageService.findMember(memberId);
        List<MypageDebateDTO> debateList = mypageService.findDebate(memberId);
        List<MypageDebateDTO> debateMeeting = mypageService.findMeeting(memberId);
        List<MypageDebateDTO> debateEnd = mypageService.findEndDebate(memberId);

        model.addAttribute("memberDto", member);
        model.addAttribute("debateList", debateList);
        model.addAttribute("debateMeeting", debateMeeting);
        model.addAttribute("debateEnd", debateEnd);
        return "mypage/myDebate";
    }

    @GetMapping("/myBook")
    public String myBook(HttpSession session, Model model){
        Long memberId = (Long) session.getAttribute("memberId");
        SettingDTO member = mypageService.findMember(memberId);
        List<MypageBookDTO> memberBooks = mypageService.findMemberBooks(memberId);

        model.addAttribute("memberBooks" , memberBooks);
        model.addAttribute("memberDto", member);
        return "mypage/myBook";
    }
    @GetMapping("/myPost")
    public String myPost(HttpSession session, Model model){
        Long memberId = (Long) session.getAttribute("memberId");
        SettingDTO member = mypageService.findMember(memberId);

        List<MypagePostDTO> memberPosts = mypageService.findMemberPosts(memberId);

        model.addAttribute("memberPosts" , memberPosts);
        model.addAttribute("memberDto", member);
        return "mypage/myPost";
    }

}
