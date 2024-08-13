package com.example.bookspresso.dto.debate.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateCommentUpdateDTO {
   private String debateComment;
   private String commentDate;
   private Long memberId;
   private Long commentId;
}
