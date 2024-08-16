package com.example.bookspresso.dto.admin.discussion;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateSearchDTO {
    private String searchType;
    private String keyword;
}
