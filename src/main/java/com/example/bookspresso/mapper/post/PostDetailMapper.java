package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.post.PostDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostDetailMapper {
    // 포스트 데이터 가져오기
    PostDetailDTO selectPostDetail(Long postId);
}
