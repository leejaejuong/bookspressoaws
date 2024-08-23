package com.example.bookspresso.dto.admin.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class AdminPageRequestDTO {

    private String searchType;
    private String keyword;
    private int page;
    private int amount;

    public AdminPageRequestDTO() {
        this.page = 1;
        this.amount = 15;
    }
}
