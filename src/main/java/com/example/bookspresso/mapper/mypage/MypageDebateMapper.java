package com.example.bookspresso.mapper.mypage;

import com.example.bookspresso.dto.mypage.MypageDebateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MypageDebateMapper {
    // 진행중인 토론
    List<MypageDebateDTO> selectDebate(Long memberId);

    // 모집중인 토론
    List<MypageDebateDTO> selectMeeting(Long memberId);

    // 끝난 토론
    List<MypageDebateDTO> selectEndDebate(Long memberId);
}
