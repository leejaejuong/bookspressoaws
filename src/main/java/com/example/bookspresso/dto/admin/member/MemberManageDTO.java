package com.example.bookspresso.dto.admin.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberManageDTO {

    private Long memberId;
    private String loginId;
    private String nickname;
    private String email;
    private String joinDate;
    private int debateNum;
    private int posterNum;

//    String createdDate; //  가입일


}
