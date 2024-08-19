package com.example.bookspresso.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    @GetMapping("/")
    public String postmain(){

        return "post/postmain";
    }
    @GetMapping("/write")
    public String postwrite(){
        return "post/postwrite";
    }


    @GetMapping("/detail")
    public String postdetail(){
        return "post/postdetail";
    }
}
