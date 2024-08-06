package com.example.bookspresso.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/poster")
public class PosterController {

    //공개된 포스터
    @GetMapping("/public")
    public String publicPoster(){
        return "admin/poster/publicPoster";
    }

    //비공개된 포스터
    @GetMapping("/private")
    public String privatePoster(){
        return "admin/poster/privatePoster";
    }


    @GetMapping("/drop")
    public String dropPoster(){
        return "admin/poster/dropPoster";
    }

}
