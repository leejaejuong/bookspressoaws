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

    private String title;
    private String bookName;
    private String meetingId;
    private String meetingType;
    private String debateTypeId;
    private String debateType;
    private String debateStartDate;
    private String debateEndDate;
    private Long debateId;

    private List<AttendMemberDTO> attendList;
//    List<String> debateMembers;

}
