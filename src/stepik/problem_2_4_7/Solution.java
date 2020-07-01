package stepik.problem_2_4_7;

import java.util.List;

public class Solution {

    void genConcurrentModificationException(List<Integer> integers) {
        // enter your code
        for (Integer integer : integers) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
