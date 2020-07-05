package stepik.problem_3_1_7;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<DayOfWeek, WorkingDayTime> dayTimeMap = new HashMap<>();
        dayTimeMap.put(DayOfWeek.MONDAY, new WorkingDayTimeImpl(9, 1, 20, 30));
        dayTimeMap.put(DayOfWeek.TUESDAY, new WorkingDayTimeImpl(9, 1, 20, 30));
        dayTimeMap.put(DayOfWeek.WEDNESDAY, new WorkingDayTimeImpl(9, 1, 20, 30));
        dayTimeMap.put(DayOfWeek.FRIDAY, new WorkingDayTimeImpl(7, 30, 15, 30));
        dayTimeMap.put(DayOfWeek.SATURDAY, new WorkingDayTimeImpl(7, 30, 15, 30));
        dayTimeMap.put(DayOfWeek.SUNDAY, new WorkingDayTimeImpl(7, 30, 15, 30));

        System.out.println(getOperationTime(dayTimeMap));

    }

    static String getOperationTime(Map<DayOfWeek, WorkingDayTime> dayTimeMap) {
        // enter your code
        TreeMap<DayOfWeek, WorkingDayTime> sortedDayTimeMap = new TreeMap<>();
        Arrays.stream(DayOfWeek.values()).forEach(dayOfWeek ->
                sortedDayTimeMap.put(dayOfWeek, dayTimeMap.get(dayOfWeek)));
        StringBuilder result = new StringBuilder();
        Map.Entry<DayOfWeek, WorkingDayTime> startSpan = null;
        Map.Entry<DayOfWeek, WorkingDayTime> endSpan = null;
        int span = 0;
        for (Map.Entry<DayOfWeek, WorkingDayTime> entry : sortedDayTimeMap.entrySet()) {
            if (startSpan == null) {
                startSpan = entry;
                endSpan = entry;
                span = 1;
                continue;
            }

            if (isaBoolean(startSpan, entry)) {
                span++;
                endSpan = entry;
            } else {
                result.append(spanString(startSpan, endSpan.getKey(), span)).append(", ");
                startSpan = entry;
                endSpan = entry;
                span = 1;
            }
        }
        result.append(spanString(startSpan, endSpan.getKey(), span));

        return result.toString();
    }

    private static boolean isaBoolean(Map.Entry<DayOfWeek, WorkingDayTime> startSpan, Map.Entry<DayOfWeek, WorkingDayTime> endSpan) {
        if (startSpan.getValue() == null && endSpan.getValue() == null) {
            return true;
        }
        if (startSpan.getValue() == null || endSpan.getValue() == null) {
            return false;
        }
        return endSpan.getValue().getStart().equals(startSpan.getValue().getStart())
                && endSpan.getValue().getEnd().equals(startSpan.getValue().getEnd());
    }

    private static String spanString(Map.Entry<DayOfWeek, WorkingDayTime> startSpan, DayOfWeek endSpan, int span) {

        Locale locale = new Locale("ru");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return startSpan.getKey().getDisplayName(TextStyle.SHORT, locale)
                + (span == 1 ? "" : span == 2 ? "," : "-")
                + (span > 1 ? endSpan.getDisplayName(TextStyle.SHORT, locale) : "") + " "
                + (startSpan.getValue() == null ? "выходной"
                : startSpan.getValue().getStart().format(formatter) + "-"
                + startSpan.getValue().getEnd().format(formatter));
    }

    static interface WorkingDayTime {
        LocalTime getStart();

        LocalTime getEnd();
    }

    static class WorkingDayTimeImpl implements WorkingDayTime {

        LocalTime start;
        LocalTime end;

        public WorkingDayTimeImpl(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }

        public WorkingDayTimeImpl(int startHour, int startMinute,
                                  int endHour, int endMinute) {
            this(LocalTime.of(startHour, startMinute),
                    LocalTime.of(endHour, endMinute));
        }

        @Override
        public LocalTime getStart() {
            return start;
        }

        @Override
        public LocalTime getEnd() {
            return end;
        }
    }

}
