package com.example.bookspresso.dto.admin.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberManageDTO {

    String loginId;
    String nickname;
    int debateNum;
    int posterNum;
//    String createdDate; //  가입일


}
