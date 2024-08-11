package com.example.bookspresso.dto.debate.debateMain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateMainPageDTO {
   private Long debateId;
   private String meetingType;
   private String debateType;
   private String title;
   private String description;
   private String debateStartDate;
   private String debateEndDate;
   private String debateBookId;
   private String isbn13;
   private String cover;
}
