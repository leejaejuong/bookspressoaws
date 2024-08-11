package com.example.bookspresso.dto.debate.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateBoardCommentDTO {
   private Long noticeId;
   private Long commentId;
   private String debateComment;
   private String commentDate;
   private String nickname;
   private String profileUuid;
   private String profileUpload;

}


