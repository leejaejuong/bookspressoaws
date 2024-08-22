package com.example.bookspresso.controller.post;

import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.debate.page.PageSetDTO;
import com.example.bookspresso.dto.post.*;
import com.example.bookspresso.service.mypage.MypageService;
import com.example.bookspresso.service.post.PostService;
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
    public String postdetail(Long postId,
                             @SessionAttribute(value = "memberId", required = false)Long memberId,
                             Model model){

        if(memberId == null){
            return "redirect:/member/login";
        }
        List<PostCommentDTO> postComment = postService.findPostComment(postId);
        PostDetailDTO postDetail = postService.findPostDetail(postId);
        model.addAttribute("postDetail",postDetail);
        model.addAttribute("postComment",postComment);

        return "post/postdetail";
    }
    @GetMapping("/modify")
    public String postModify(Long postId,
                             @SessionAttribute(value = "memberId", required = false)Long memberId,
                             Model model,PostModifySelectDTO postModifySelectDTO){
        if(memberId == null){
            return "redirect:/member/login";
        }
        postModifySelectDTO.setMemberId(memberId);
        PostModifySelectDTO modify = postService.modifySelet(postId);
        model.addAttribute("modify",modify);

        return "post/modify";
    }
    @PostMapping("modify")
    public String postModify(@SessionAttribute(value = "memberId", required = false)Long memberId,
                             PostWriteDTO postWriteDTO){
        postWriteDTO.setMemberId(memberId);
        Long postId = postWriteDTO.getPostId();
        postService.modify(postWriteDTO);
        return "redirect:/post/detail?postId="+postId;
    }
    @GetMapping("/remove")
    public String remove(Long postId){
        postService.remove(postId);
        return "redirect:/post/list";
    }
}









