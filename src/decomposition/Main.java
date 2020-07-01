package decomposition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
//        int n = new Scanner(System.in).nextInt();
        int n = 12;

        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            current.add(1);
        }
        lists.add(current);

        int start = 0;
        int next = 0;
        while (current.size() > 1) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            int ofset = 0;
            while (sum < n) {
                if (ofset == next) {
                    list.add(current.get(ofset) + 1);
                    sum += current.get(ofset) + 1;
                    next++;
                } else if (ofset < next) {
                    list.add(current.get(ofset));
                    sum += current.get(ofset);
                } else {
                    list.add(1);
                    sum++;
                }
                ofset++;
            }
            if (sum == n) {
                lists.add(list);

            }

            current = list;
            if (next >= current.size() - 1) {
                next = 0;
            } else {
                next++;
            }


        }

        lists.forEach(list -> System.out.println(list));
    }





}