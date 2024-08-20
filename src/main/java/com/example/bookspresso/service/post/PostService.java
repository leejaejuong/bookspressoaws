package com.example.bookspresso.service.post;

import com.example.bookspresso.dto.post.PostWriteDTO;
import com.example.bookspresso.mapper.post.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public void addPost(PostWriteDTO postWriteDTO){
        postMapper.insertPost(postWriteDTO);
    }
}























