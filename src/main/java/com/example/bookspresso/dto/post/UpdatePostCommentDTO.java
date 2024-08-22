package com.example.bookspresso.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePostCommentDTO {
    private String commentContent;
    private Long commentId;
}
