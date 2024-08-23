package com.example.bookspresso.service.post;

import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.post.*;
import com.example.bookspresso.mapper.post.PostDetailMapper;
import com.example.bookspresso.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    private final PostDetailMapper postDetailMapper;

    public void addPost(PostWriteDTO postWriteDTO){
        postMapper.insertPost(postWriteDTO);
    }
    public List<PostMainDTO> addmain(PageRequestDTO pageRequestDTO) {
        return postMapper.mainWithpage(pageRequestDTO);
    }

    public int findTotal() {
        return postMapper.selectTotal();
    }

    public PostDetailDTO findPostDetail(Long postId){
        return postDetailMapper.selectPostDetail(postId);
    }

    public List<PostCommentDTO> findPostComment(Long postId){
        return postDetailMapper.selectPostComment(postId);
    }
    public void addComment(InsertPostCommentDTO insertPostCommentDTO){
        postDetailMapper.insertPostComment(insertPostCommentDTO);
    }
    public void modifyComment(UpdatePostCommentDTO updatePostCommentDTO){
        postDetailMapper.updatePostComment(updatePostCommentDTO);
    }
    public void deleteComment(Long commentId){
        postDetailMapper.deletePostComment(commentId);
    }

    public PostModifySelectDTO modifySelet(Long postId){return postDetailMapper.selectmodify(postId);}
    public void modify(PostWriteDTO postWriteDTO){postDetailMapper.updatemodify(postWriteDTO);}
    public void remove(Long postId){postDetailMapper.deletePost(postId);}
}
