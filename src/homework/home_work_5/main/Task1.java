package homework.home_work_5.main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Task1 {

    public static LocalDate createLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public static LocalDate findNewDate(LocalDate dateFrom, int numberOfMonths) {
        return dateFrom.plusMonths(numberOfMonths);
    }

    public static String reformatDate(LocalDate date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }

    public static LocalDate convertToLocalDate(String date, DateTimeFormatter formatter) {
        return LocalDate.parse(date, formatter);
    }

    public static int calculateDaysBetween(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2).getDays();
    }
}
