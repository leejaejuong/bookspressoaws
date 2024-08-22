package com.example.bookspresso.dto.post;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class PostDetailDTO {
 private Long postId;
 private String isbn13;
 private Long memberId;
 private String postTitle;
 private String postContent;
 private String createDate;
 private String title;
 private String author;
 private String cover;
 private String description;
 private String pubdate;
 private String nickname;
}

