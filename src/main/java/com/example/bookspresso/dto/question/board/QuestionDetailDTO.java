package com.example.bookspresso.dto.question.board;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDetailDTO {

    Long memberId;
    Long qBoardId;
    String qTitle;
    String nickname;
    String createDate;
    int viewCount;
    String qContent;
//    String aContent;
//    Long adminId;
}
