package com.example.bookspresso.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertPostCommentDTO {
    private Long postId;
    private String commentContent;
    private Long commentId;
    private Long memberId;
}
