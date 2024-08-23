package com.example.bookspresso.dto.admin.poster;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosterSearchDTO {
    private String searchType;
    private String keyword;
}
