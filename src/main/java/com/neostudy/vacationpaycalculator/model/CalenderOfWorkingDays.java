package com.neostudy.vacationpaycalculator.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;


public class CalenderOfWorkingDays {

    public static Integer getQuantityWorkingDays(LocalDate beginDate, LocalDate endDate) {

        HolidayDates holidayDates = new HolidayDates();

        int quantityVacationDays = getQuantityVacationDays(beginDate, endDate);

        LocalDate date = beginDate;
        endDate = endDate.plusDays(1);
        while (date.isBefore(endDate)) {

            Set<MonthDay> holidays = holidayDates.getHolidays(Year.of(date.getYear()));
            for (MonthDay holiday : holidays) {
                if (holiday.compareTo(holidayDates.LocalDateInMonthDay(date)) == 0) {
                    quantityVacationDays = quantityVacationDays - 1;
                }
            }
            date = date.plusDays(1);
        }

        return quantityVacationDays;
    }

    public static Integer getQuantityVacationDays(LocalDate beginDate, LocalDate endDate) {
        return (int) beginDate.until(endDate, ChronoUnit.DAYS) + 1;
    }

}
