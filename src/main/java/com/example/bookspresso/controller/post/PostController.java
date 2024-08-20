package com.example.bookspresso.controller.post;

import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.debate.page.PageSetDTO;
import com.example.bookspresso.dto.mypage.SettingDTO;
import com.example.bookspresso.dto.post.PostDetailDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import com.example.bookspresso.dto.post.PostWriteDTO;
import com.example.bookspresso.service.mypage.MypageService;
import com.example.bookspresso.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final MypageService mypageService;

    @GetMapping("")
    public String postMain(){
        return "redirect:/post/list";
    }

    @GetMapping("/list")
    public String postList(PageRequestDTO pageRequestDTO, Model model){
        List<PostMainDTO> addmain = postService.addmain(pageRequestDTO);
        int total = postService.findTotal();
        PageSetDTO pageNum = new PageSetDTO(total,pageRequestDTO);
        model.addAttribute("addmain", addmain);
        model.addAttribute("pageNum", pageNum);

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
    public String postdetail(HttpSession session, Model model){
        Long memberId = (Long) session.getAttribute("memberId");
        SettingDTO member = mypageService.findMember(memberId);

        Long postId = (Long) session.getAttribute("postId");
        List<PostDetailDTO> postDetail = postService.findPostDetail(postId);

        if(memberId == null){
            return "redirect:/member/login";
        }
        model.addAttribute("memberDto", member);
        model.addAttribute("postDetail", postDetail);

        return "post/postdetail";
    }
}









