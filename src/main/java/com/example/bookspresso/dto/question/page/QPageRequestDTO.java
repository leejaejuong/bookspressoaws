package com.example.bookspresso.dto.question.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class QPageRequestDTO {

    private int page;
    private int amount;
    private Long memberId;

    public QPageRequestDTO() {
        this.page = 1;
        this.amount = 15;
    }
}
