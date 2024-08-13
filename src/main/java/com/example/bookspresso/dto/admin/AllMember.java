package com.example.bookspresso.dto.admin;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllMember {

    String loginId;
    String nickname;
    int debateNum;
    int posterNum;
//    String createdDate; //  가입일


}
