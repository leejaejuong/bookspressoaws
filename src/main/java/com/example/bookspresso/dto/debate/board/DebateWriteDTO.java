package com.example.bookspresso.dto.debate.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateWriteDTO {
   private Long noticeId;
   private Long debateId;
   private String title;
   private String opinion;
   private String noticeDate;
}
