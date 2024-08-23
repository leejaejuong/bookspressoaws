package com.example.bookspresso.dto.admin.poster;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosterManageDTO {

    private Long postId;
    private String postTitle;
    private String createDate;
    private Long memberId;
    private String nickname;
    private String bookName;
}
