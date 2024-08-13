package com.example.bookspresso.service.aladen;

import com.example.bookspresso.api.Aladen.AladinBody;
import com.example.bookspresso.api.Aladen.Aladinitem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;

@Service
public class AladinService {
    @Value("${api.key}")
    private String apiKey;
    public List<Aladinitem> getApialadin(){
        WebClient wc= WebClient.builder()
                .baseUrl("http://www.aladin.co.kr")
                .build();

        int minusDay = 7;
        int flag = 7;
        LocalDate today = LocalDate.now();
        List<Aladinitem> aladinitemList = new ArrayList<>();

        // 1680
        while(flag <=  300) {
            int year = today.getYear();
            int month = today.getMonthValue();
            int week = getCurrentWeekOfMonth(today);

            AladinBody api = wc.get()
                    .uri(uriBuilder ->
                            uriBuilder.path("/ttb/api/ItemList.aspx")
                                    .queryParam("TTBKey", apiKey)
                                    .queryParam("Output", "JS")
                                    .queryParam("QueryType", "Bestseller")
                                    .queryParam("Version", "20131101")
                                    .queryParam("SearchTarget", "Book")
                                    .queryParam("Start", 40)
                                    .queryParam("MaxResults", 100)
                                    .queryParam("cover", "200px")
                                    .queryParam("YEAR", year)
                                    .queryParam("MONTH", month)
                                    .queryParam("WEEK", week)
                                    .build()
                    ).retrieve()
                    .bodyToMono(AladinBody.class)
                    .block();

            List<Aladinitem> item = api.getItem();
            aladinitemList.addAll(item);


            today = today.minusDays(minusDay);
            flag += minusDay;
        }

        return aladinitemList;
    }

    private int getCurrentWeekOfMonth(LocalDate localDate) {
        // 한 주의 시작은 월요일이고, 첫 주에 4일이 포함되어있어야 첫 주 취급 (목/금/토/일)
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 4);

        int weekOfMonth = localDate.get(weekFields.weekOfMonth());

        // 첫 주에 해당하지 않는 주의 경우 전 달 마지막 주차로 계산
        if (weekOfMonth == 0) {
            // 전 달의 마지막 날 기준
            LocalDate lastDayOfLastMonth = localDate.with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
            return getCurrentWeekOfMonth(lastDayOfLastMonth);
        }

        // 이번 달의 마지막 날 기준
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        // 마지막 주차의 경우 마지막 날이 월~수 사이이면 다음달 1주차로 계산
        if (weekOfMonth == lastDayOfMonth.get(weekFields.weekOfMonth()) && lastDayOfMonth.getDayOfWeek().compareTo(DayOfWeek.THURSDAY) < 0) {
            LocalDate firstDayOfNextMonth = lastDayOfMonth.plusDays(1); // 마지막 날 + 1일 => 다음달 1일
            return getCurrentWeekOfMonth(firstDayOfNextMonth);
        }

        return weekOfMonth;
    }

        public List<Aladinitem> getApialadinMain(){
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
                                    .queryParam("MaxResults", "20")
                                    .queryParam("cover", "200px")
                                    .build()
                    ).retrieve()
                    .bodyToMono(AladinBody.class)
                    .block();
            List<Aladinitem> item = api.getItem();
            return item;
        }
}
