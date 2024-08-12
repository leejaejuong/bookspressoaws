package com.example.bookspresso.dto.debate.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateBoardAsideDTO {
   private String isbn13;
   private String cover;
   private String title;
   private String outline;
   private String debateStartDate;
   private String debateEndDate;
   private String debateId;
}
