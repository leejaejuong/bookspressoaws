package com.example.bookspresso.api.post;

import com.example.bookspresso.dto.post.InsertPostCommentDTO;
import com.example.bookspresso.dto.post.PostCommentDTO;
import com.example.bookspresso.dto.post.UpdatePostCommentDTO;
import com.example.bookspresso.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApi {
    private final PostService postService;

    @GetMapping("/posts/details/{postId}")
    public List<PostCommentDTO> findComment(@PathVariable("postId") Long postId) {
        List<PostCommentDTO> findcomment = postService.findPostComment(postId);
        System.out.println("findcomment = " + findcomment);
        return findcomment;
    }
    @PostMapping("/posts/details/{postId}")
    public void commentWrite(@PathVariable("postId") Long postId,
                           @RequestBody InsertPostCommentDTO insertPostCommentDTO,
                           @SessionAttribute ("memberId") Long memberId) {
        insertPostCommentDTO.setPostId(postId);
        insertPostCommentDTO.setMemberId(memberId);
        System.out.println(insertPostCommentDTO);
        postService.addComment(insertPostCommentDTO);
    }
    @PatchMapping("/posts/details/{commentId}")
    public void modifyComment(@PathVariable("commentId") Long commentId,
                              @RequestBody UpdatePostCommentDTO updatePostCommentDTO){
        updatePostCommentDTO.setCommentId(commentId);
        postService.modifyComment(updatePostCommentDTO);
    }
    @DeleteMapping("posts/details/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        postService.deleteComment(commentId);
    }
}
