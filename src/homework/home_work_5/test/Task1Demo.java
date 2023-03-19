package homework.home_work_5.test;

import homework.home_work_5.main.Task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Task1Demo {

    public static void main(String[] args) {
        System.out.println(Task1.createLocalDate(2023, 3, 18));
        System.out.println(Task1.findNewDate(LocalDate.now(), 5));
        System.out.println(Task1.reformatDate(LocalDate.now(), DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(Task1.convertToLocalDate("18092023", DateTimeFormatter.ofPattern("ddMMyyyy")));
        System.out.println(Task1.calculateDaysBetween(LocalDate.now(), LocalDate.of(2023, 3, 22)));
    }
}
