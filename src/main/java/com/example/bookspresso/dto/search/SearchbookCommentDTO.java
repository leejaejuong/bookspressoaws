package com.example.bookspresso.dto.search;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchbookCommentDTO {
   private Long commentId;
   private String isbn13;
   private String bookComment;
   private String bookDate;
   private Long memberId;
   private String nickname;
   private String profileUpload;
   private String profileUuid;
   private String profileName;

}