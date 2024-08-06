package com.example.bookspresso.dto.debate;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookinpoDTO {
   private String isbn13;
   private String title;
   private String author;
   private String description;
   private String pubdate;
   private String cover;

}
