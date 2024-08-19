package com.example.bookspresso.dto.search;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertBookCommentDTO {
    private String isbn13;
    private String bookComment;
    private Long commentId;
    private Long memberId;
}
