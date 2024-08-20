package com.example.bookspresso.mapper.post;

import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostMainDTO> mainWithpage(PageRequestDTO pageRequestDTO);
    int selectTotal();
}













