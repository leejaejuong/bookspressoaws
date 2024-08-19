package com.example.bookspresso.dto.admin.qa;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyAnswer {

    private Long qBoardId;
    private Long adminId;
    private String aContent;
    private String answerModifiedDate;
}
