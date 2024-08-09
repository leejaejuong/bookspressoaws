package com.example.bookspresso.dto.debate.N_N;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateBookDTO {
   private Long debateBookId;
   private Long debateId;
   private String isbn13;
   private Long memberId;
}
