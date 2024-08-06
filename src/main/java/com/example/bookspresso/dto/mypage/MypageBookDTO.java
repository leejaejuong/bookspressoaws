package com.example.bookspresso.dto.mypage;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class MypageBookDTO {
    String isbn13;
    String title;
    String cover;
}
