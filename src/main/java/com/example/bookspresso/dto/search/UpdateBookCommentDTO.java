package com.example.bookspresso.dto.search;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBookCommentDTO {
    private String bookComment;
    private Long commentId;
}
