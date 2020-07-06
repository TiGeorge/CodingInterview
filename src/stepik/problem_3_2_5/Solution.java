package stepik.problem_3_2_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    interface Worker {
        String getPosition();
        double getSalary();
    }

    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        Map<String, Long> actual = workers.stream()
                .collect(
                        Collectors.groupingBy(Worker::getPosition,
                                Collectors.counting())
                );

        Map<String, Double> actual2 = workers.stream()
                .collect(
                        Collectors.groupingBy(Worker::getPosition,
                                Collectors.averagingDouble(Worker::getSalary))
                );
    }
}
