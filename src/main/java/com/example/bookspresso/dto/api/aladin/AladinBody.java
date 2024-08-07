package com.example.bookspresso.dto.api.aladin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AladinBody {
//    String version;
//    String logo;
//    String title;
//    String link;
//    String pubDate;
//    Integer totalResults;
//    Integer startIndex;
//    Integer itemsPerPage;
//    String query;
//    Integer searchCategoryId;
//    String searchCategoryName;
    List<Aladinitem> item;
}
