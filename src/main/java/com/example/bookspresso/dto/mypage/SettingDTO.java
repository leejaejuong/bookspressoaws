package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class SettingDTO {
    private Long memberId;
    private String email;
    private String nickname;
    private Long profileId;
    private String profileUuid;
    private String profileUpload;
    private String profileName;
    private String introduce;



}
