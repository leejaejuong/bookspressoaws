package com.example.bookspresso.dto.debate.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateBoardUpdateDTO {
   private String title;
   private String opinion;
   private String noticeDate;
   private Long memberId;
}
