package com.example.bookspresso.dto.api.Lib;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Libbody {

//             private String pageNo;
//             private String pageSize;
//             private String numFound;
//             private String resultNum;
             private List<Libitems> libs;

}
