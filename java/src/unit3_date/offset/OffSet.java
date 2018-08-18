package unit3_date.offset;

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
    다시 스트림 연산을 이용해 오프셋이 정각이 아닌 모든 시간대를 찾아라.
 */
public class OffSet {
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
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
            String toString = String.format("%35s %10s%n", zone, offset);
            if(secondsOfHour != 0) {
                System.out.println(toString);
            }
        });
    }
}
