package com.example.bookspresso.dto.api.Lib;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Libitem {
    private String libCode;
    private String libName;
    private String address;
    private String closed;
    private String homepage;
    private String latitude;
    private String longitude;
    private String tel;
}
