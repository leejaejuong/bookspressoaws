package com.example.bookspresso.service.api.aladen;

import com.example.bookspresso.dto.api.aladin.AladinBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AladinService {
    @Value("${api.key}")
    private String apiKey;
    public AladinBody getApialadin(){
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
                                .queryParam("Start", 1)
                                .queryParam("MaxResults", 100)
                                .queryParam("cover", "200px")
                                .build()
                ).retrieve()
                .bodyToMono(AladinBody.class)
                .block();
        System.out.println("api = " + api);
        return api;
    }
}
