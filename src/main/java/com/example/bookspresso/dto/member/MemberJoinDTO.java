package com.example.bookspresso.dto.member;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MemberJoinDTO {
    private Long memberId;
    private String loginId;
    private String password;
    private String nickname;
    private String email;
    private String introduction;
    private String profileUuid;
    // 기본값을 넣어주는 식
}
