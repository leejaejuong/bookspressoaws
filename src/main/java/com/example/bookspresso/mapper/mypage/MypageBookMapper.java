package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.MypageBookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageBookMapper {
    List<MypageBookDTO> selectMemberBooks(Long memberId);
}
