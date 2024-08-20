package com.example.bookspresso.service.mainPage;

import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import com.example.bookspresso.mapper.mainPage.MainPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MainPageService {
    private final MainPageMapper mainPageMapper;

    public List<DebateMainDTO> addonline(){return mainPageMapper.selectonline();}
    public List<DebateMainDTO> addoffline(){return mainPageMapper.selectoffline();}
    public List<PostMainDTO> addpost(){return mainPageMapper.selectPost();}
}
