package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.post.PostWriteDTO;
import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(PostWriteDTO postWriteDTO);

    List<PostMainDTO> mainWithpage(PageRequestDTO pageRequestDTO);
    int selectTotal();
}
