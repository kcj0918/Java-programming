package unit3_date.timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/*
    현재 시간 인스턴스에 대해 지원되는 모든 시간대에서 오늘 날짜의 오프셋을 구하라.
    이때 ZoneId.getAvailableIds 를 스트림으로 전환하고, 스트림 연산을 이용해 작업한다.
 */
public class TimeZone {
    public static void main(String[] args) {
        LocalDateTime nowTime = LocalDateTime.now();
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);
        Stream myStream = zoneList.stream();

        myStream.forEach(s -> {
            ZoneId zone = ZoneId.of(String.valueOf(s));
            ZonedDateTime zdt = nowTime.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            String toString = String.format("%35s %10s%n", zone, offset);
            System.out.println(toString);
        });
    }
}
