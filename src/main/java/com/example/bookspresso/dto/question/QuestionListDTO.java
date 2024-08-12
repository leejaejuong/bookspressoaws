package com.example.bookspresso.dto.question;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class QuestionListDTO {

    private Long memberId;
    private Long qBoardId;
    private String qTitle;
    private String createDate;
    private String aStatus;
    private int viewCount;
    private String nickname;
    private int total;

}
