package com.neostudy.vacationpaycalculator.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HolidayDates {

    private final static Map<Year, Set<MonthDay>> holidayDates = new HashMap<>();

    static {

        // 2024
        Set<MonthDay> holidays = new HashSet<>();
        holidays.add(MonthDay.of(Month.JANUARY, 1));
        holidays.add(MonthDay.of(Month.JANUARY, 2));
        holidays.add(MonthDay.of(Month.JANUARY, 3));
        holidays.add(MonthDay.of(Month.JANUARY, 4));
        holidays.add(MonthDay.of(Month.JANUARY, 5));
        holidays.add(MonthDay.of(Month.JANUARY, 6));
        holidays.add(MonthDay.of(Month.JANUARY, 7));
        holidays.add(MonthDay.of(Month.JANUARY, 8));
        holidays.add(MonthDay.of(Month.FEBRUARY, 23));
        holidays.add(MonthDay.of(Month.MARCH, 8));
        holidays.add(MonthDay.of(Month.APRIL, 29));
        holidays.add(MonthDay.of(Month.APRIL, 30));
        holidays.add(MonthDay.of(Month.MAY, 1));
        holidays.add(MonthDay.of(Month.MAY, 9));
        holidays.add(MonthDay.of(Month.MAY, 10));
        holidays.add(MonthDay.of(Month.JUNE, 12));
        holidays.add(MonthDay.of(Month.NOVEMBER, 4));
        holidays.add(MonthDay.of(Month.DECEMBER, 30));
        holidays.add(MonthDay.of(Month.DECEMBER, 31));

        holidayDates.put(Year.of(2024), holidays);

        //Other years
        holidays = new HashSet<>();
        holidays.add(MonthDay.of(Month.JANUARY, 1));
        holidays.add(MonthDay.of(Month.JANUARY, 2));
        holidays.add(MonthDay.of(Month.JANUARY, 3));
        holidays.add(MonthDay.of(Month.JANUARY, 4));
        holidays.add(MonthDay.of(Month.JANUARY, 5));
        holidays.add(MonthDay.of(Month.JANUARY, 6));
        holidays.add(MonthDay.of(Month.JANUARY, 7));
        holidays.add(MonthDay.of(Month.JANUARY, 8));
        holidays.add(MonthDay.of(Month.FEBRUARY, 23));
        holidays.add(MonthDay.of(Month.MARCH, 8));
        holidays.add(MonthDay.of(Month.MAY, 1));
        holidays.add(MonthDay.of(Month.MAY, 9));
        holidays.add(MonthDay.of(Month.JUNE, 12));
        holidays.add(MonthDay.of(Month.NOVEMBER, 4));

        holidayDates.put(Year.of(0), holidays);
    }

    public Set<MonthDay> getHolidays(Year year) {
        Set<MonthDay> holidays = holidayDates.get(year);
        if (holidays == null) {
            return holidayDates.get(Year.of(0));
        }
        return holidays;
    }

    public MonthDay LocalDateInMonthDay(LocalDate date) {
        return MonthDay.of(date.getMonth(), date.getDayOfMonth());
    }
}
