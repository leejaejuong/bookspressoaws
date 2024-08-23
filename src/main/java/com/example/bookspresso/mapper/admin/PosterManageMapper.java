package com.example.bookspresso.mapper.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.poster.PosterManageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PosterManageMapper {

    List<PosterManageDTO> selectPosterList(AdminPageRequestDTO adminPageRequestDTO);

    int selectPosterCount();

    List<PosterManageDTO> selectSearchPosterList(@Param("searchType") String searchType,
                                                 @Param("keyword") String keyword,
                                                 @Param("page") int page,
                                                 @Param("amount") int amount);

    int selectSearchCount(@Param("searchType") String searchType,
                          @Param("keyword") String keyword);

    void deletePoster(Long postId);
    void deletePostComment(Long postId);

}













