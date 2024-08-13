package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MypageDebateMapper {
    List<MypageDebateDTO> selectDebate(Long memberId);

    List<MypageDebateDTO> selectMeeting(Long memberId);

    List<MypageDebateDTO> selectEndDebate(Long memberId);
}
