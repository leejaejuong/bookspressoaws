package com.example.bookspresso.dto.search;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchBookDTO {
    String isbn13;
    String cover;
    String title;
    String description;
    String author;
    String link;
    String pubdate;

}
