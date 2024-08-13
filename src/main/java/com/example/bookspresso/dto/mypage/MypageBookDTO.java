package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MypageBookDTO {
    private Long meetingId;
    private Long debateId; // 토론 id
    private String title; // 책 제목
    private String cover; // 책 표지
}
