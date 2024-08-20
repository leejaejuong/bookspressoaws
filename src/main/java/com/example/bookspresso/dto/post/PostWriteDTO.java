package com.example.bookspresso.dto.post;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class PostWriteDTO {
    private Long postId;
    private String isbn13;
    private String postTitle;
    private String postContent;
    private Long memberId;
}
