package stepik.problem_3_4_3;

import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    public static void main(String[] args) {

    }

    volatile int count = 0;

    ReentrantLock lock = new ReentrantLock();

    void safeIncrement() {
        // enter your code
        lock.lock();
        count++;
        // enter your code
        lock.unlock();
    }
}
