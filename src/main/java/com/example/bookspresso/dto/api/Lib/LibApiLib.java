package com.example.bookspresso.dto.api.Lib;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LibApiLib {
    private String libCode;
    private String libName;
    private String address;
    private String closed;
    private String homepage;
    private double latitude;
    private double longitude;
    private String tel;
}
