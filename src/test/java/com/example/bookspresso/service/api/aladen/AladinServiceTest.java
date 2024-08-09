package com.example.bookspresso.service.api.aladen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

import static org.junit.jupiter.api.Assertions.*;

class AladinServiceTest {

    @Test
    void operTest(){
        System.out.println(7 * 4 * 12 * 5); // 1680
    }

    @Test
    void localDateTest(){
        LocalDate today = LocalDate.now();

        LocalDate newDay = today.minusDays(7);
        System.out.println("newDay = " + newDay);

        int year = today.getYear();
        System.out.println("year = " + year);

        int month = today.getMonthValue();
        System.out.println("month = " + month);


        int currentWeekOfMonth = getCurrentWeekOfMonth(today);
        System.out.println("currentWeekOfMonth = " + currentWeekOfMonth);
    }

    public static int getCurrentWeekOfMonth(LocalDate localDate) {
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
}