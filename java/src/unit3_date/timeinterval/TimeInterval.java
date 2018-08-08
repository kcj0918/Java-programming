package unit3_date.timeinterval;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
    캘린더 이벤트(주어진 날짜의 10:00 ~ 11:00에 잡힌 미팅 등)에 적합한 시간 간격을
    표현하는 TimeInterval 클래스를 구현하라.
    아울러 시간 간격 두 개가 겹치는지 검사하는 메서드를 제공한다.
 */
public class TimeInterval {
    public static void main(String[] args) {
        LocalDateTime startTime1 = LocalDateTime.of(2018, 8, 2, 10, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2018, 8, 2, 12, 0);
        LocalDateTime startTime2 = LocalDateTime.of(2018, 8, 2, 14, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2018, 8, 2, 16, 0);
        LocalDateTime startTime3 = LocalDateTime.of(2018, 8, 2, 11, 0);
        LocalDateTime endTime3 = LocalDateTime.of(2018, 8, 2, 13, 0);
        LocalDateTime startTime4 = LocalDateTime.of(2017, 8, 2, 11, 0);
        LocalDateTime endTime4 = LocalDateTime.of(2017, 8, 2, 13, 0);

        List<Schedule> schedules = new ArrayList<>();

        Schedule addSchedule1 = new Schedule(startTime1, endTime1);
        Schedule addSchedule2 = new Schedule(startTime2, endTime2);
        Schedule addSchedule3 = new Schedule(startTime3, endTime3);
        Schedule addSchedule4 = new Schedule(startTime4, endTime4);

        addSchedule(schedules, addSchedule1);
        addSchedule(schedules, addSchedule2);
        addSchedule(schedules, addSchedule3);
        addSchedule(schedules, addSchedule4);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String startTime;
        String endTime;

        for (Schedule schedule : schedules) {
            startTime = schedule.getStartTime().format(dateTimeFormatter);
            endTime = schedule.getEndTime().format(dateTimeFormatter);
            System.out.print("schedule : ");
            System.out.print(startTime + " ~ " + endTime);
            System.out.println();
        }
    }

    static boolean addSchedule(List<Schedule> schedules, Schedule schedule) {
        if (schedules.isEmpty()) {
            schedules.add(schedule);
            return true;
        } else {
            for (Schedule value : schedules) {
                if (value.getStartTime().getDayOfYear() == schedule.getStartTime().getDayOfYear() &&
                        value.getStartTime().getDayOfMonth() == schedule.getStartTime().getDayOfMonth() &&
                        value.getStartTime().getDayOfWeek() == schedule.getStartTime().getDayOfWeek()) {
                    if (value.getStartTime().getHour() <= schedule.getStartTime().getHour() && value.getEndTime().getHour() > schedule.getStartTime().getHour()) {
                        return false;
                    } else {
                        schedules.add(schedule);
                        return true;
                    }
                } else {
                    schedules.add(schedule);
                    return true;
                }
            }
            return true;
        }
    }
}

class Schedule {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Schedule(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
