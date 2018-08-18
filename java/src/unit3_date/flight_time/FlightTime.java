package unit3_date.flight_time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/*
    돌아오는 항공기가 프랑크푸르트에서 14:05에 출발해서 16:40에 로스앤젤레스에 도착한다.
    비행하는 데 얼마나 걸렸는가? 이와 같은 계산을 처리할 수 있는 프로그램을 작성하라.
 */
public class FlightTime {
    public static void main(String[] args) {
        ZonedDateTime startTime = ZonedDateTime.of(2018, 8, 17, 14, 5, 0, 0, ZoneId.of("Europe/Berlin"));
        ZonedDateTime arrivalTime = ZonedDateTime.of(2018, 8, 17, 16, 40, 0, 0, ZoneId.of("America/Los_Angeles"));
        long result = flightTime(startTime, arrivalTime);
        System.out.println(result);
    }

    static long flightTime(ZonedDateTime startTime, ZonedDateTime arrivalTime) {
        return startTime.until(arrivalTime, ChronoUnit.MINUTES);
    }
}
