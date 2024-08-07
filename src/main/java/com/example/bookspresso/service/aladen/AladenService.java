package com.example.bookspresso.service.aladen;

import com.example.bookspresso.api.Aladen.AladinBody;
import com.example.bookspresso.api.Aladen.Aladinitem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
public class AladenService {
    @Value("${api.key}")
    private String apiKey;
    public List<Aladinitem> getApialadin(){
        WebClient wc= WebClient.builder()
                .baseUrl("http://www.aladin.co.kr")
                .build();
        AladinBody api = wc.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/ttb/api/ItemList.aspx")
                                .queryParam("TTBKey", apiKey)
                                .queryParam("Output", "JS")
                                .queryParam("QueryType", "Bestseller")
                                .queryParam("Version", "20131101")
                                .queryParam("SearchTarget", "Book")
                                .queryParam("MaxResults", "100")
                                .queryParam("cover", "200px")
                                .build()
                ).retrieve()
                .bodyToMono(AladinBody.class)
                .block();
        List<Aladinitem> item = api.getItem();
        return item;
    }
}
