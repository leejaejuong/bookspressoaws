package com.example.bookspresso.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    @GetMapping("")
    public String postMain(){
        return "redirect:/post/list";
    }

    @GetMapping("/list")
    public String postList(){
        return "post/list";
    }

    @GetMapping("/write")
    public String postWrite(){
        return "post/write";
    }
}









