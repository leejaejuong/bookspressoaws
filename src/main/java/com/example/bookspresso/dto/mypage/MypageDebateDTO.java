package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MypageDebateDTO {
    private Long memberId;
    private String meetingType;
    private String title;
    private String outline;
    private String profileUuid;
    private String nickname;
    private String cover;
    private String debateStartDate;
    private String debateEndDate;
}
