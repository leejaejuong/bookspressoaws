package com.example.bookspresso.dto.debate.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class DebatePageRequestDTO {
   private int page;  //현재 페이지
   private int amount; //한 페이지당 게시물수
   public DebatePageRequestDTO() {
//      기본생성자를 사용하여 쿼리스트링없이 페이징처리를함
   this.page = 1;
   this.amount = 4;
   }
}
