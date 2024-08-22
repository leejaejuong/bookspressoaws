package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.post.InsertPostCommentDTO;
import com.example.bookspresso.dto.post.PostCommentDTO;
import com.example.bookspresso.dto.post.PostDetailDTO;
import com.example.bookspresso.dto.post.UpdatePostCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostDetailMapper {
    // 포스트 데이터 가져오기
    PostDetailDTO selectPostDetail(Long postId);

    // 포스트 댓글
    List<PostCommentDTO> selectPostComment(Long postId);

    // 포스트 댓글 작성
    void insertPostComment(InsertPostCommentDTO insertPostCommentDTO);

    // 포스트 댓글 수정
    void updatePostComment(UpdatePostCommentDTO updatePostCommentDTO);

    // 포스트 댓글 삭제
    void deletePostComment(Long commentId);

}
