package com.example.bookspresso.dto.question.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QPageSetDTO {

    private int pageCount;
    private int startPage;
    private int endPage;
    private int realPage;

    private boolean prev;
    private boolean next;

    private int total;

    private QPageRequestDTO qPageRequestDTO;

    public QPageSetDTO(QPageRequestDTO qPageRequestDTO,int total) {
        this(qPageRequestDTO, total, 5);
    }


    public QPageSetDTO(QPageRequestDTO qPageRequestDTO, int total, int pageCount) {
        this.qPageRequestDTO = qPageRequestDTO;
        this.total = total;
        this.pageCount = pageCount;

        this.endPage = (int)(Math.ceil(qPageRequestDTO.getPage()/(double)pageCount))*pageCount;
        this.startPage = endPage - pageCount + 1;

        this.realPage = (int) Math.ceil((double) total / qPageRequestDTO.getAmount());

        if (realPage < endPage){
            this.endPage = realPage == 0? 1 : realPage;
        }

        this.prev = startPage > 1;
        this.next = endPage < realPage;

    }
}
