package com.example.bookspresso.controller.post;

import com.example.bookspresso.dto.post.PostWriteDTO;
import com.example.bookspresso.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public String postMain(){
        return "redirect:/post/list";
    }

    @GetMapping("/list")
    public String postList(){
        return "post/list";
    }

    @GetMapping("/write")
    public String postWrite(@SessionAttribute(value = "memberId", required = false) Long memberId){
        if(memberId == null){
            return "redirect:/member/login";
        }
        return "post/write";
    }

    @PostMapping("/write")
    public String postWritePost(PostWriteDTO postWriteDTO,
                                @SessionAttribute("memberId") Long memberId){
//        log.info("postWriteDTO = {}", postWriteDTO);
        postWriteDTO.setMemberId(memberId);
        postService.addPost(postWriteDTO);

        return "redirect:/post/list";
    }


    @GetMapping("/detail")
    public String postdetail(){
        return "post/postdetail";
    }
}









