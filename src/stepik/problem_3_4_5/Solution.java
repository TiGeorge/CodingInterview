package stepik.problem_3_4_5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    public static void main(String[] args) {

    }

    ReentrantLock lockA = new ReentrantLock();
    ReentrantLock lockB = new ReentrantLock();

    AtomicInteger count = new AtomicInteger(2);

    void method1() {
        lockA.lock();
        for (int i = 0; i < 10000; i++) {
            count.compareAndSet(3, 2);
        }
        lockB.lock();
        job1();
        lockA.unlock();
        lockB.unlock();
    }

    void method2() {
        lockB.lock();
        count.compareAndSet(3, 2);
        lockA.lock();
        job2();
        lockB.unlock();
        lockA.unlock();
    }

    private void job1() {
    }

    private void job2() {

    }
}

