package com.example.bookspresso.controller.mypage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage")
public class MyPageController {
    @GetMapping("/setting")
    public String setting() {
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
