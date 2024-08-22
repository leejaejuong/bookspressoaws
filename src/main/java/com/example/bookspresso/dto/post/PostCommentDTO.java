package com.example.bookspresso.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommentDTO {
    private Long commentId;
    private Long postId;
    private String contentComment;
    private String createDate;
    private Long memberId;
    private String nickname;
    private String profileUpload;
    private String profileUuid;
    private String profileName;
}
