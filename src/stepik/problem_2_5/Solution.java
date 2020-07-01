package stepik.problem_2_5;

public class Solution {

    public static void main(String[] args) {
        new Solution().boxingValue(5);
    }

    Box<Integer> boxingValue(double value) {
        // enter your code
        Box box = new Box(value);
        return box;
    }


    class Box<T> {
        private final T value;

        Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

}
