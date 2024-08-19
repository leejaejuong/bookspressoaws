package com.example.bookspresso.dto.admin.qa;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManageQuestionListDTO {

    private Long memberId;
    private Long qBoardId;
    private Long adminId;
    private String nickname;
    private String qTitle;
    private String createDate;
    private boolean aStatus;
    private String createdDate;
    private String answerModifiedDate;

    private Long answerId;
    private String adminLoginId;

}
