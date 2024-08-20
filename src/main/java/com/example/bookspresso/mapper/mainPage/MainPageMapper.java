package com.example.bookspresso.mapper.mainPage;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainPageMapper {
    //    온라인
    List<DebateMainDTO> selectonline();

    //           오프라인
    List<DebateMainDTO> selectoffline();
//     포스트
    List<PostMainDTO>selectPost();
}
