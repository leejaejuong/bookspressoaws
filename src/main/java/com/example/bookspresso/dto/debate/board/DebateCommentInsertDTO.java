package com.example.bookspresso.dto.debate.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateCommentInsertDTO {
  private Long commentId;
  private Long noticeId;
  private Long memberId;
  private String debateComment;

}

