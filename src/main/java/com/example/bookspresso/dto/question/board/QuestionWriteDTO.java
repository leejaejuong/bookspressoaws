package com.example.bookspresso.dto.question.board;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class QuestionWriteDTO {
    private  Long memberId;
    private Long qBoardId;
    //write.html 에서 input에 작성한 내용이 밑의 변수에 저장됨
    private  String qTitle;
    private  String qContent;
//    private String nickname;
}
