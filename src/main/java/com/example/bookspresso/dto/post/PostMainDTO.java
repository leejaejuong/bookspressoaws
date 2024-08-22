package com.example.bookspresso.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMainDTO {
   private Long postId;
   private String isbn13;
   private Long memberId;
   private String postTitle;
   private String postContent;
   private String createDate;
   private String nickName;
   private String profileId;
   private String profileUuid;
   private String profileUpload;
   private String profileName;
   private String cover;
}
