package unit3_date.day_of_live;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
    지금까지 며칠을 살아왔는지 출력하는 프로그램을 작성하라.
 */
public class DayOfLive {
    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(1992, 9, 18);
        LocalDate toDay = LocalDate.now();
        System.out.println(liveCount(birthDay, toDay));
    }

    static long liveCount(LocalDate birthDay, LocalDate toDay) {
        long result = birthDay.until(toDay, ChronoUnit.DAYS);
        return result;
    }
}
