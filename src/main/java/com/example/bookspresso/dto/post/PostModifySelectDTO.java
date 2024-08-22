package com.example.bookspresso.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModifySelectDTO {
 private Long postId;
 private String isbn13;
 private Long memberId;
 private String postTitle;
 private String postContent;
 private String title;
 private String cover;
 private String description;
 private String author;
}

