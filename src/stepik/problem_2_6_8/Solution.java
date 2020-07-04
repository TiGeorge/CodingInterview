package stepik.problem_2_6_8;

import java.util.Iterator;

public class Solution {
}

class FibonacciIterator implements Iterator<Integer> {

    int iter = 0;
    private int current = 0;
    private int next = 1;

    @Override
    public boolean hasNext() {
        // enter your code
        return next >= current;
    }

    @Override
    public Integer next() {
        // enter your code
        if (iter > 0) {
            int prev = current;
            current = next;
            next = prev + current;
        }
        iter++;
        return current;
    }

}

class FibonacciIterable implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}