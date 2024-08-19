package com.example.bookspresso.dto.admin.discussion;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinishedDebateDTO {

    String title;
    String bookName;
    String meetingId;
    String debateTypeId;
    String debateStartDate;
    String debateEndDate;
    Long debateId;

//    List<String> debateMembers;

}
