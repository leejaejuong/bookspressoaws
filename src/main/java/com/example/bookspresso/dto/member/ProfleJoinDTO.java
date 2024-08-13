package com.example.bookspresso.dto.member;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfleJoinDTO {
   private Long profileId;
   private Long memberId;
}
