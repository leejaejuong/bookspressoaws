package com.example.bookspresso.dto.question;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class QuestionModifyDTO {
//    private  Long memberId;
    private Long qBoardId;
    private  String qTitle;
    private  String qContent;

}
