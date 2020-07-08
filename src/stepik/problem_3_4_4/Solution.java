package stepik.problem_3_4_4;

import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    volatile int count = 0;

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    void safeIncrement() {
        // enter your code
        synchronized (atomicBoolean) {
            count++;
        }
        // enter your code
    }
}
