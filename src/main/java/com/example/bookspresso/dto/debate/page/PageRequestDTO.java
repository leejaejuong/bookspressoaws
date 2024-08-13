package com.example.bookspresso.dto.debate.page;

import lombok.*;

@Getter
@Setter
@ToString

public class PageRequestDTO {
   private int page;  //현재 페이지
   private int amount; //한 페이지당 게시물수
   public PageRequestDTO() {
//      기본생성자를 사용하여 쿼리스트링없이 페이징처리를함
   this.page = 1;
   this.amount = 12;
   }
}
