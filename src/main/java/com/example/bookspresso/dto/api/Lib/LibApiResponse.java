package com.example.bookspresso.dto.api.Lib;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LibApiResponse {

//             private String pageNo;
//             private String pageSize;
//             private String numFound;
//             private String resultNum;
             private List<LibApiLibs> libs;

}
