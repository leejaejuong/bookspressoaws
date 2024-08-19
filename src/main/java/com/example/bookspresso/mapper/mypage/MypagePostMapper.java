package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.MypagePostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypagePostMapper {
    List<MypagePostDTO> selectPost(Long memberId);
}
