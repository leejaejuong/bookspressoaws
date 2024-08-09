package com.example.bookspresso.dto.debate;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor @Builder
public class DebateInpoDTO {
   private Long debateId;
   private Long meetingId;
   private Long debateTypeId;
   private String title;
   private String outLine;
   private String groupStartDate;
   private String groupEndDate;
   private String debateStartDate;
   private String debateEndDate;
   private String isbn13;
}
