package com.example.bookspresso.dto.question.board;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerDTO {

    private Long qBoardId;
    private Long adminId;
    private Long answerId;
    private String aContent;
    private String createdDate;

}
