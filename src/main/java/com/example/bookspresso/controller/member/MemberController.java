package com.example.bookspresso.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join(){
        return "member/member/join";
    }

    @GetMapping("/login")
    public String login(){
        return "member/member/login";
    }

    @GetMapping("/findId")
    public String findId(){
        return "member/member/findId";
    }

    @GetMapping("/findPassword")
    public String findPassword(){
        return "member/member/findPassword";
    }



}
