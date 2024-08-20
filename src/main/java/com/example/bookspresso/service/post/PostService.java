package com.example.bookspresso.service.post;

import com.example.bookspresso.dto.post.PostWriteDTO;
import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.dto.mainPage.DebateMainDTO;
import com.example.bookspresso.dto.post.PostMainDTO;
import com.example.bookspresso.dto.search.*;
import com.example.bookspresso.dto.post.PostWriteDTO;
import com.example.bookspresso.mapper.post.PostMapper;
import com.example.bookspresso.mapper.search.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    public void addPost(PostWriteDTO postWriteDTO){
        postMapper.insertPost(postWriteDTO);
    }
    public List<PostMainDTO> addmain(PageRequestDTO pageRequestDTO) {
        return postMapper.mainWithpage(pageRequestDTO);
    }

    public int findTotal() {
        return postMapper.selectTotal();
    }
}
