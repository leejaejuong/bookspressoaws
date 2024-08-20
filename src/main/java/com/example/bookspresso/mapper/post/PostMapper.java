package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.post.PostWriteDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    void insertPost(PostWriteDTO postWriteDTO);
}
