package com.example.bookspresso.service.admin;

import com.example.bookspresso.dto.admin.page.AdminPageRequestDTO;
import com.example.bookspresso.dto.admin.poster.PosterManageDTO;
import com.example.bookspresso.mapper.admin.PosterManageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PosterManageService {
    private final PosterManageMapper posterManageMapper;

    public List<PosterManageDTO> findPosterList(AdminPageRequestDTO adminPageRequestDTO){
        return posterManageMapper.selectPosterList(adminPageRequestDTO);
    }

    public int findPosterCount(){
        return posterManageMapper.selectPosterCount();
    }

    public List<PosterManageDTO> findSearchPosterList(String searchType, String keyword,
                                                      int page, int amount){
        return posterManageMapper.selectSearchPosterList(searchType, keyword, page, amount);
    }

    public int findSearchPosterCount(String searchType, String keyword){
        return posterManageMapper.selectSearchCount(searchType, keyword);
    }

    public void deletePoster(Long postId){
        posterManageMapper.deletePostComment(postId);
        posterManageMapper.deletePoster(postId);
    }


}
