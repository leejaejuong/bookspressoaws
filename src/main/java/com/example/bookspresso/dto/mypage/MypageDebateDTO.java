package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MypageDebateDTO {
    private Long debateId; // 토론 id
    private Long meetingId; // 모임 id
    private String title; // 토론 제목
    private String outline; // 토론 개요
    private String debateStartDate; // 토론 시작 날짜
    private String debateEndDate;   // 토론 끝 날짜
    private String nickname; // 닉네임
    private Long profileId;
    private String profileUuid; // 프로필 uuid
    private String profileName;
    private String profileUpload;
    private String cover; // 책 표지
    private String meetingType; // 모임 종류
}
