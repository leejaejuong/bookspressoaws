package com.example.bookspresso.api.Aladen;

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
