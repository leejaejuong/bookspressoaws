package com.example.bookspresso.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdMainController {

    @GetMapping("/join")
    public String join(){
        return "admin/main/join";
    }

    @GetMapping("/login")
    public String login(){
        return "admin/main/login";
    }

    @GetMapping("/main")
    public String main(){
        return "admin/main/mainPage";
    }






}
