package com.example.bookspresso.controller.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qa")
public class qaController {

    @GetMapping("/list")
    public String qalist(){
        return "member/QandA/qList";
    }

    @GetMapping("/write")
    public String qaWrite(){
        return "member/QandA/writeQ";
    }

    @GetMapping("/detail")
    public String qadetail(){
        return "member/QandA/answerDetail";
    }
}
