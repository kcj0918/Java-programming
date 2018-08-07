package unit3_date.friday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/*
20세기의 모든 13일의 금요일을 나열하라.
 */
public class FridayCount {
    public static void main(String[] args) {
        List<LocalDate> result = new ArrayList<>();
        LocalDate startDay = LocalDate.of(1901, 1, 1);
        LocalDate endDay = LocalDate.of(2000, 12, 31);
        int countMonth = (int) startDay.until(endDay, ChronoUnit.MONTHS);
        LocalDate currentDay;
        for (int i = 0; i < countMonth; i++) {
            currentDay = startDay.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
            if(currentDay.getDayOfMonth() == 13) {
                result.add(currentDay);
            }
            startDay = startDay.plusMonths(1);
        }
        for(LocalDate value : result) {
            System.out.println(value);
        }
    }
}
