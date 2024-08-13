package com.example.bookspresso.dto.question;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionSearchDTO {

//    private Long BoardId;
    private Long memberId;
    private String searchType;
    private String keyword;

}
