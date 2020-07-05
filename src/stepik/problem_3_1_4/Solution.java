package stepik.problem_3_1_4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        String zn = "Europe/Madrid";
        System.out.println(toMoscowTime(dateTime, zn));

        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

    }

    DateTimeFormatter format() {
        // enter your code
        // 2007-M5-W3-Mon:21:27
        return DateTimeFormatter.ofPattern("yyyy-'M'M-'W'w-EEE:hh:mm", Locale.US);
    }

    static LocalDateTime toMoscowTime(LocalDateTime localDateTime, String zoneName) {
        // enter your code
        String id = ZoneId.of(zoneName).getId();
        return localDateTime.atZone(ZoneId.of(zoneName))
                .toOffsetDateTime()
                .atZoneSameInstant(ZoneId.of("Europe/Moscow"))
                .toLocalDateTime();
    }

    static Date instantToDate(Instant instant) {
        // enter your code
        try {
            return Date.from(instant.minusNanos(instant.getNano()));
        } catch (IllegalArgumentException e) {
            if(instant.isAfter(Instant.EPOCH)) return new Date(Long.MAX_VALUE);
            else return new Date(Long.MIN_VALUE);
        }
    }

}
