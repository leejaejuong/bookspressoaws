package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MypagePostDTO {
    private Long memberId;
    private String isbn13;
    private String title;
    private String content;
    private String profileUuid;
    private String nickname;
    private String cover;
}
