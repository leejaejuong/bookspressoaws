package com.example.bookspresso.dto.search;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchLibDTO {
   String libcode;
   String libname;
   String address;
   String closed;
   String homepage;
   double latitude;
   double longitude;
   String tel;
}
