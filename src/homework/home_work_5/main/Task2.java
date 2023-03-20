package homework.home_work_5.main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Task2 implements TemporalAdjuster {
    private final LocalDate date = LocalDate.now();

    @Override
    public LocalDate addToCurrentDate(int daysToAdd) {
        return date.plusDays(daysToAdd);
    }

    @Override
    public LocalDate findNearestFirstJan() {
        LocalDate firstDayOfCurrentYear = date.with(TemporalAdjusters.firstDayOfYear());
        LocalDate firstDayOfNextYear = date.with(TemporalAdjusters.firstDayOfNextYear());
        long daysToCurrentYear = Math.abs(ChronoUnit.DAYS.between(date, firstDayOfCurrentYear));
        long daysToNextYear = Math.abs(ChronoUnit.DAYS.between(date, firstDayOfNextYear));
        return (daysToCurrentYear < daysToNextYear ? firstDayOfCurrentYear : firstDayOfNextYear);
    }
}
