package com.example.bookspresso.dto.question.board;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDetailDTO {

    private Long qBoardId;
    private String qTitle;
    private String qContent;
    private String createDate;
    private String modifiedDate;
    private int viewCount;
    private boolean aStatus;
    private Long memberId;
    private String nickname;
    private Long answerId;
    private Long adminId;
    private String aContent;
    private String createdDate;
    private String answerModifiedDate;






//    private Long memberId;
//    private Long qBoardId;
//    private String qTitle;
//    private String nickname;
//    private String createDate;
//    private int viewCount;
//    private String qContent;
//    private boolean aStatus;

//    private Long adminId;
//    private String aContent;
//    private String createdDate;
}
