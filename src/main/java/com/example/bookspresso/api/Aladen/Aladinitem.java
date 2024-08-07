package com.example.bookspresso.api.Aladen;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aladinitem {
//   api자체가 카멜 표기법이라  @JsonProperty 필요없음
   private String isbn13;
   private String title;
   private String description;
   private String author;
   private String cover;
   private String link;
   private String pubDate;
}
