package com.example.bookspresso.controller.post;

import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.debate.page.PageSetDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import com.example.bookspresso.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String postList(PageRequestDTO pageRequestDTO,Model model){
        List<PostMainDTO> addmain = postService.addmain(pageRequestDTO);
        int total = postService.findTotal();
        PageSetDTO pageNum = new PageSetDTO(total,pageRequestDTO);
        model.addAttribute("addmain", addmain);
        model.addAttribute("pageNum", pageNum);

        return "post/list";
    }

    @GetMapping("/write")
    public String postWrite(){
        return "post/write";
    }


    @GetMapping("/detail")
    public String postdetail(){
        return "post/postdetail";
    }
}









