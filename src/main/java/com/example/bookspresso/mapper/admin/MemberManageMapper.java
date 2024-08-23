package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.member.MemberManageDTO;
import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberManageMapper {

    List<MemberManageDTO> selectMemberList(AdminPageRequestDTO adminPageRequestDTO);
    List<MemberManageDTO> selectSearchList(@Param("page") int page, @Param("amount") int amount,
                          @Param("searchType") String searchType, @Param("keyword") String keyword);

    int selectListCount();
    int selectSearchListCount(@Param("searchType") String searchType, @Param("keyword") String keyword);

    int attendDebateNum(Long memberId);
    int writePosterNum(Long memberId);

//   회원, 회원프로필 삭제 처리
    void deleteMember(Long memberId);
    void deleteProfile(Long memberId);

}
