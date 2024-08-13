package com.example.bookspresso.dto.mainPage;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateMainDTO {
    private Long debateId;
    private String meetingType;
    private String debateType;
    private String title;
    private String outLine;
    private String bookTitle;
    private String description;
    private String debateStartDate;
    private String debateEndDate;
    private Long debateBookId;
    private String isbn13;
    private String cover;
    private String author;
}
