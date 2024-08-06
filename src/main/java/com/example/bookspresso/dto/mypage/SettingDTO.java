package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class SettingDTO {
    private Long memberId;
    private String loginId;
    private String password;
    private String nickName;
    private String email;
    private String introduce;
    private String profileUuid;
}
