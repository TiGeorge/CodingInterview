package stepik.problem_3_1_4;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
}
