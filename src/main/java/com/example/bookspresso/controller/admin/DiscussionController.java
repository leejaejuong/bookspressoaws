package com.example.bookspresso.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/discussion")
public class DiscussionController {

    // 현재 진행 중인 토론
    @GetMapping("/onGoing")
    public String allDiscussion(){
        return "admin/discussion/onGoingDc";
    }

    @GetMapping("/finished")
    public String endDiscussion(){
        return "admin/discussion/finishedDc";
    }

    @GetMapping("/forcedOut")
    public String discussion(){
        return "admin/discussion/forcedOutDc";
    }


}
