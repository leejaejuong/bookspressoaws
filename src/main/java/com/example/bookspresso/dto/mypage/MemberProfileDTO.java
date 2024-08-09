package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MemberProfileDTO {
    private Long profileId;
    private Long memberId;
    private String profileUuid;
    private String profileUpload;
    private String profileName;
}
