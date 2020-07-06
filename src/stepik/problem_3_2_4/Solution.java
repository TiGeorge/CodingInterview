package stepik.problem_3_2_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    interface Worker {
        String getName();
        int getPoints();
    }

    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();

        String actual = workers.stream()
                .sorted(Comparator.comparing(Worker::getPoints).reversed())
                .limit(3)
                .map(Worker::getName)
                .collect(
                    Collectors.joining(", ")
                );
    }
}
