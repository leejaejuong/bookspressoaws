package com.example.bookspresso.dto.post;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class PostDetailDTO {
    private String postTitle;
    private String postContent;
    private String profileUuid;
    private String profileUpload;
    private String profileName;
    private String nickname;
    private String cover;
}
