package unit3_date.adjuster_next;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

/*
    Predicate<LocalDate> 를 받고 조정기 adjuster 를 리턴하는 next 메서드를 구현하라.
    이 조정기는 프레디케이트를 수행하는 다음 번 날짜를 돌려줘야 한다.
    예를 들어, 다음 호출은 다음 번 평일을 계산한다.
    today.with(next(w -> getDayOfWeek().getValue() < 5))
 */
public class AdusterNext {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().with(next((d -> d.getDayOfWeek().getValue() < 5))));
    }

    static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster (w -> {
            LocalDate date = w;
            do {
                date = date.plusDays(1);
            } while (predicate.test(date));
            return date;
        });
    }
}
