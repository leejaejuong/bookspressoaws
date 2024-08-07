package com.example.bookspresso.service.api.Lib;

import com.example.bookspresso.dto.api.Lib.LibHeader;
import com.example.bookspresso.dto.api.Lib.Libitems;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class LibService {
    @Value("${api.key2}")
    private String apiKey2;

    public  LibHeader getLib(){
        WebClient wc = WebClient.builder()
                .baseUrl("http://data4library.kr")
                .build();
        LibHeader LibApi = wc.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/api/libSrch")
                                .queryParam("authKey", apiKey2)
                                .queryParam("pageNo", 2)
                                .queryParam("pageSize", 100)
                                .queryParam("format", "json")
                                .build()
                ).retrieve()
                .bodyToMono(LibHeader.class)
                .block();

        System.out.println("libs = " + LibApi);
        return LibApi;
    }


}
