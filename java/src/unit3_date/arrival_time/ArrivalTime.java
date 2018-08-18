package unit3_date.arrival_time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/*
    로스앤젤레스에서 프랑크푸르트로 가는 항공기가 지역 시간으로 오후 3:05에 출발하고,
    10시간 50분이 걸린다. 항공기는 언제 도착하겠는가? 이와 같은 계산을 처리할 수 있는
    프로그램을 작성하라.
 */
public class ArrivalTime {
    public static void main(String[] args) {
        ZonedDateTime startTime = ZonedDateTime.of(2018, 8, 17, 15, 5,0,0, ZoneId.of("America/Los_Angeles"));
        ZonedDateTime result = arrivalTime(startTime, ZoneId.of("Europe/Berlin"), 650);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String s = result.format(format);
        System.out.println(s);
    }
    static ZonedDateTime arrivalTime(ZonedDateTime startTime, ZoneId endId, int flyMinute) {
        ZonedDateTime result = startTime.withZoneSameInstant(endId).plusMinutes(flyMinute);
        return result;
    }
}
