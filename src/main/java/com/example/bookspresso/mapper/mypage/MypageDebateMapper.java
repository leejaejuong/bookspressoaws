package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MypageDebateMapper {
    Optional<MypageDebateDTO> selectDebate(Long memberId);

}
