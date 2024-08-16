package com.example.bookspresso.dto.admin.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminPageSetDTO {

    private int pageCount;
    private int startPage;
    private int endPage;
    private int realPage;

    private boolean prev;
    private boolean next;

    private int total;

    private AdminPageRequestDTO adminPageRequestDTO;

    public AdminPageSetDTO(AdminPageRequestDTO adminPageRequestDTO, int total) {
        this(adminPageRequestDTO, total, 5);
    }


    public AdminPageSetDTO(AdminPageRequestDTO adminPageRequestDTO, int total, int pageCount) {
        this.adminPageRequestDTO = adminPageRequestDTO;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(adminPageRequestDTO.getPage()/(double)pageCount))*pageCount;
        this.startPage = endPage - pageCount + 1;

        this.realPage = (int) Math.ceil((double) total / adminPageRequestDTO.getAmount());

        if (realPage < endPage){
            this.endPage = realPage == 0? 1 : realPage;
        }

        this.prev = startPage > 1;
        this.next = endPage < realPage;

    }
}
