package com.example.bookspresso.service.api.Lib;

import com.example.bookspresso.dto.api.Lib.LibApiBody;
import com.example.bookspresso.dto.api.Lib.LibApiLib;
import com.example.bookspresso.dto.api.Lib.LibApiLibs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibService {
    @Value("${api.key2}")
    private String apiKey2;

    public List<LibApiLibs> getLib() {
        String baseUrl = "http://data4library.kr";
        String path = "/api/libSrch";
        String format = "json";

        WebClient wc = WebClient.builder().build();
//39020
        int startRegion = 11010;
        List<LibApiLibs> libApiLibsList = new ArrayList<>();
        while (startRegion <= 11110) {
            String uri = baseUrl + path + "?authKey=" + apiKey2 + "&format=" + format + "&dtl_region=" + startRegion;


            LibApiBody libApiBody = wc.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(LibApiBody.class)
                    .block();

//            if (libApiBody == null) {
//                return null;
//            }

            List<LibApiLibs> libs = libApiBody.getResponse().getLibs();
            libApiLibsList.addAll(libs);

            startRegion += 10;
        }


        return libApiLibsList;
    }


}
