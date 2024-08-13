package com.example.bookspresso.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/member")
public class AdMemberController {

    // 전체 회원 관리
    @GetMapping("/allList")
    public String totalList(){



        return "admin/member/allList";
    }

    // 활동 중지 회원 관리
    @GetMapping("/stop-activity")
    public String stopActivity(){

        return "admin/member/stopActivity";
    }

    // 강제 탈퇴된 회원 명단
    @GetMapping("/forced-out")
    public String forcedOut(){
        return "admin/member/forcedOut";
    }






}
