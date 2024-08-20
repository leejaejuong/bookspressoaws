package com.example.bookspresso.dto.admin.discussion;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendMemberDTO {

    private Long debateId;
    private Long memberId;
    private String nickname;

}
