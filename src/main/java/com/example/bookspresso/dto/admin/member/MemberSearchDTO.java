package com.example.bookspresso.dto.admin.member;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSearchDTO {
    private String searchType;
    private String keyword;
}
