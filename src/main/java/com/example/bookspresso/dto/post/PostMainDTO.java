package com.example.bookspresso.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMainDTO {
    Long postId;
    String isbn13;
    Long memberId;
    String postTitle;
    String postContent;
    String createDate;
    String nickName;
    String profileId;
    String profileUuid;
    String profileUpload;
    String profileName;
    String cover;
}
