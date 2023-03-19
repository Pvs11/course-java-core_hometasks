package homework.home_work_5.main;

import java.time.LocalDate;

public interface TemporalAdjuster {
    public LocalDate addToCurrentDate(int daysToAdd);
    public LocalDate findNearestFirstJan();
}
