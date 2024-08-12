package com.example.bookspresso.dto.question;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class QuestionWriteDTO {
    private  Long memberId;
    private Long qBoardId;
    private  String qTitle;
//  private String writer;
    private  String qContent;
//    private String nickname;
}
